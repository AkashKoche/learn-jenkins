# Jenkins Architecture

Jenkins Master:
  - Web Server (Jetty)
  - Pipeline Execution Engine
  - Plugin Manager
  - Security Realm
  - Build Queue Manager
  - Artifact Storage
  
Jenkins Agent/Node:
  - JVM Process
  - Executor Slots
  - Workspace Management
  - Tool Installations


# Key Configuration Files

JENKINS_HOME Structure:
├── config.xml           # Global Jenkins configuration
├── credentials.xml      # Encrypted credentials storage
├── nodes/               # Agent configurations
├── plugins/             # Installed plugins
├── jobs/               # Job configurations
├── userContent/        # Static files served by Jenkins
└── secrets/            # Master encryption keys
