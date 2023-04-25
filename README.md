# Sauce Demo Automation

## Pre Requisite
- Install [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi) should be installed along with the environment variables
- Install any IDE [IntelliJ IDEA](https://www.jetbrains.com/idea/download) is preferred

## Installation [using terminal]
- Clone the repository to your local machine by using 
> git clone https://github.com/prasannamus/SauceDemo.git
- Navigate to project directory using 
> cd SauceDemo
- build Project directory using 
> mvn build or mvn compile

## Installation [using IntelliJ IDEA]
- Connect IDE with your Git Account using Git Token (preferred) / git Login
- Open IDE and Clone the repository [File -> New -> Project from Version Control]
- Open pom.xml and load dependencies [Right Click on pom.xml -> Maven -> Reload Project]



## Run Tests
- GUI Mode: Right click on `testng.xml` and click on the Run Button
- Terminal Mode: Go to project directory in terminal and run the command
> mvn test

## Reports
- Open HTML report from `reports/report.html`
- See Traces by running below command
> mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace reports\trace.zip"

### Notes:
- Traces and Videos are not handled as real time framework
- Test Data Handling and Few other comments are not implemented completely.
- Added Reports folder for the quick reference. 