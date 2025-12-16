# Jenkins Multi-Stage Freestyle Job Design
Stage 1: Source Code Checkout

    SCM: Git

    Repository: https://github.com/your-org/java-webapp.git

Stage 2: Build

Build Step: Execute Shell

    mvn clean compile

Stage 3: Test

Build Step: Execute Shell

    mvn test

Stage 4: Package

Build Step: Execute Shell

    mvn package

Post-build Action:

Archive Artifacts

    target/*.war

Stage 5: Deploy

Build Step: Execute Shell

    chmod +x deploy/deploy.sh
    ./deploy/deploy.sh
