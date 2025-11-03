
# Test Automation Framework

This project is a Java-based Test Automation Framework.

It’s designed for scalability, maintainability, and reusability, supporting both local and cloud execution (LambdaTest) with data-driven testing and detailed reporting & logging.


## 🚀 About Me
Hi My Name is Kalpesh Patil and I have 4 years of experience in Automation Testing using technologies like Selenium Webdriver , RestAssured , Playwright with Typescript , CI CD 


## Author

- [@Kalpeshkp1995](https://github.com/Kalpeshkp1995)
- EmailAddress: patilkalpeshkp95@gmail.com

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Kalpeshkp1995)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kalpeshkp1995/)

##  Prerequisites
Before running the tests, ensure you have:
- **Java 11** or higher
- **Maven** 3.6+
- A valid LambdaTest account (if cloud execution is needed)
- Download Link : https://maven.apache.org/download.cgi


##  Key Features
Java + TestNG based test framework

- Data-driven testing using:
- OpenCSV – CSV data
- Apache POI – Excel data
- Gson – JSON data
- Fake data generation using Java Faker
- Parallel & cloud execution via LambdaTest
- Headless execution support for faster runs
- Command-line execution using Maven Surefire Plugin
- Rich HTML reporting with Extent Reports
- Detailed logging using Log4j

## Technologies Used
- Java 11
- TestNG
- OpenCSV
- Gson
- Apache POI
- Faker
- LambdaTest
- Log4j
- Extent Reports

## Setup Instructions

**Clone the Repository:**

```bash
  git clone https://github.com/Kalpeshkp1995/Test-Automation-Framework-With-Java.git

  cd Test-Automation-Framework
```

**Cloud Execution (LambdaTest)**

```bash
  mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X

 ```   

 **Local Execution (In Headless Mode)**

```bash
  mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X

 ```  

 ## Reports
 - Extent Reports generate a detailed HTML report: ./report.html

   The report contains information on test cases execution , passed , failed , and    skipped , along with screenshot for failed tests.

## Logs
 Logs are created uring the test execution and stored in the ./logs/directory

## Integrated the project Github Actions
This automation framework is generated with github actions.
The tests will be executed at 11:30PM IST every sigle day.

The reports will be archieved in gh-pages branch
You can view the html reports at :
https://kalpeshkp1995.github.io/Test-Automation-Framework-With-Java/report.html
