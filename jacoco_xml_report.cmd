@echo off
set "reportDir=C:\Users\boubouthiam.niang\workspace\bl\JSF-JBehave-Selenium-Jacoco\xmlReport"


:: Check if the xmlReport directory exists, and create it if not
if not exist "%reportDir%" (
    mkdir "%reportDir%"
)

:: Run the Jacoco command
java -jar "C:\Users\boubouthiam.niang\dev-libs\jacoco\jacococli.jar" report "C:\Users\boubouthiam.niang\dev-libs\jacoco\output\jacoco.exec" --classfiles "C:\Users\boubouthiam.niang\workspace\bl\JSF-JBehave-Selenium-Jacoco\build\classes" --sourcefiles "C:\Users\boubouthiam.niang\workspace\bl\JSF-JBehave-Selenium-Jacoco\src\main\java" --xml "%reportDir%\jacoco-report.xml"
