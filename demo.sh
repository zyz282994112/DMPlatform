#!/bin/bash


TOMCAT_HOME="/usr/local/tomcat7"
${TOMCAT_HOME}/bin/shutdown.sh

sudo rm -rf ${TOMCAT_HOME}/webapps/platform
sudo rm -rf ${TOMCAT_HOME}/webapps/platform.war

ant clean
ant platform.war 

sudo cp ./AntBuild/war/platform.war ${TOMCAT_HOME}/webapps/
${TOMCAT_HOME}/bin/startup.sh

sleep 5 

sudo chmod 777  ${TOMCAT_HOME}/webapps/platform/scripts/*
sudo chmod 777  ${TOMCAT_HOME}/webapps/platform/dataset/*
sudo chmod 777  ${TOMCAT_HOME}/webapps/platform/configs/*
sudo chmod 777  ${TOMCAT_HOME}/webapps/platform/WEB-INF/lib/*

sudo chmod 777  ${TOMCAT_HOME}/webapps/platform/public/images/result/*

sudo chmod 777  ${TOMCAT_HOME}/webapps/platform/TaskM
sudo chmod 777  ${TOMCAT_HOME}/webapps/platform/TaskM/

