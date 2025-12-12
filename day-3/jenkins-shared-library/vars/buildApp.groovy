// vars/buildApp.groovy
def call(Map config = [:]) {
    def defaults = [
        buildTool: 'maven',
        jdkVersion: '11',
        testType: 'unit'
    ]
    config = defaults + config
    
    pipeline {
        agent any
        tools {
            jdk config.jdkVersion
            "${config.buildTool}" config.buildTool.capitalize()
        }
        stages {
            stage('Build') {
                steps {
                    script {
                        echo "Building with ${config.buildTool} using JDK ${config.jdkVersion}"
                        if (config.buildTool == 'maven') {
                            sh 'mvn clean compile'
                        } else if (config.buildTool == 'ant') {
                            sh 'ant compile'
                        }
                    }
                }
            }
            stage('Test') {
                steps {
                    script {
                        runTests(config.testType)
                    }
                }
            }
        }
    }
}

def runTests(String testType) {
    switch(testType) {
        case 'unit':
            sh 'mvn test'
            break
        case 'integration':
            sh 'mvn verify -Dtest=**/*IT'
            break
        case 'all':
            sh 'mvn test verify'
            break
    }
    junit '**/target/surefire-reports/*.xml'
}
