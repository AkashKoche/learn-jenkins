#!/bin/bash


APP_NAME=java-webapp.war
TOMCAT_HOME=/opt/tomcat


cp target/$APP_NAME $TOMCAT_HOME/webapps/


$TOMCAT_HOME/bin/shutdown.sh
sleep 5
$TOMCAT_HOME/bin/startup.sh


echo "Deployment completed successfully"
