@echo off
REM Set the path to your Tomcat installation
set CATALINA_HOME=C:\Program Files\apache-tomcat-11.0.1

REM Set the path to your JDK installation
set JAVA_HOME=C:\Program Files\Java\jdk-21.0.5

REM Set the CATALINA_BASE directory
set CATALINA_BASE=C:\Users\boubouthiam.niang\.SmartTomcat\JSF-JBehave-Selenium-Jacoco\JSF-JBehave-Selenium-Jacoco.main

REM Navigate to the Tomcat bin directory
cd %CATALINA_HOME%\bin

REM Start the Tomcat server
call startup.bat

REM Wait for the server to start
timeout /t 10

REM Open the browser to your web application (optional)
start http://localhost:8080/JSF-JBehave-Selenium-Jacoco

@echo on
