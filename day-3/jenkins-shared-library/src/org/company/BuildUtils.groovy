package org.company

class BuildUtils implements Serializable {
    def steps
    def env
    
    BuildUtils(steps, env) {
        this.steps = steps
        this.env = env
    }
    
    def analyzeCodeQuality() {
        steps.echo "Analyzing code quality for branch: ${env.BRANCH_NAME}"
        
        def qualityGate = [
            'coverage': 80,
            'bugs': 0,
            'vulnerabilities': 0
        ]
        
        // Simulate quality analysis
        def actualCoverage = 85
        def actualBugs = 1
        
        steps.echo "Code Coverage: ${actualCoverage}% (Required: ${qualityGate.coverage}%)"
        
        if (actualCoverage < qualityGate.coverage) {
            steps.error "Code coverage too low: ${actualCoverage}% < ${qualityGate.coverage}%"
        }
        
        if (actualBugs > qualityGate.bugs) {
            steps.echo "WARNING: ${actualBugs} bugs found (Allowed: ${qualityGate.bugs})"
        }
        
        return [coverage: actualCoverage, bugs: actualBugs, passed: true]
    }
    
    def generateBuildReport(Map results) {
        def report = """
        BUILD REPORT
        ============
        Branch: ${env.BRANCH_NAME}
        Build: ${env.BUILD_NUMBER}
        Status: ${results.passed ? 'PASSED' : 'FAILED'}
        Code Coverage: ${results.coverage}%
        Bugs Found: ${results.bugs}
        Timestamp: ${new Date()}
        """
        
        steps.writeFile file: 'build-report.txt', text: report
        steps.archiveArtifacts artifacts: 'build-report.txt'
        
        return report
    }
}
