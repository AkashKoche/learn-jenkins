#!/bin/bash

docker run \
	--name jenkins-lts \
	-d \
	-p 8080:8080 \
	-p 50000:50000 \
	-v jenkins-data:/var/jenkins_home \
	--restart unless-stopped \
	jenkins/jenkins:lts
