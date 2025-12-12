# General

    Select GitHub Project: Add Project URL

# Source Code Management

    Select Git: Add Repository URL, Add Credentials if not Public Repo.

    Set Branch Specifier : */main or */master

# Trigger

    Select Poll SCM: Set According to preferences = H/5 * * * *

# Build Steps

    1.Invoke top-level Maven Target
    Maven_Version: Maven
    Goals: clean compile
    Advanced POM: day-1/challenge/demo-maven-app/pom.xml
    2.Invoke top-level Maven Target
    Maven_Version: Maven
    Goals: clean install
    Advanced POM: day-1/challenge/demo-maven-app/pom.xml
    2.Invoke top-level Maven Target
    Maven_Version: Maven
    Goals: clean test
    Advanced POM: day-1/challenge/demo-maven-app/pom.xml
    2.Invoke top-level Maven Target
    Maven_Version: Maven
    Goals: clean package
    Advanced POM: day-1/challenge/demo-maven-app/pom.xml

# Post-build Actions

    1.Archive the artifacts
    File_to_Archive: day-1/challenge/demo-maven-app/target/*.jar
    2.Publish JUnit test result report
    day-1/challenge/demo-maven-app/target/surefire-reports/*.xml
