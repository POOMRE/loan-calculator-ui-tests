# Loan Calculator UI Tests

This project provides UI testing for a Loan Calculator application. 

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) - Project SDK version 17 is used in this project.
- ChromeDriver installed on your machine.
- All other project dependencies are handled through Gradle and are listed in the project's Gradle file.

### Running Tests

This project uses Gradle for running tests. Here are some useful commands:

- Run all tests:
`./gradlew test`

- Filter tests using the `--tests` option followed by TestPackage, TestClass, or TestMethod. For example:

  - Run tests from a specific TestPackage: 
`./gradlew clean test --tests LoanCalculatorBoundaryTest`
- Run a specific TestMethod:
  `./gradlew test --tests com.banking.BankingTestCreateUser.testCreateUser`

  
### Test Reports

By default, the test report is generated in `build/reports/index.html`. However, the project also supports generating more detailed and robust Allure reports. After running tests, you can generate an Allure report using one of the following commands:

- For a temporary live server (server will stop after closing terminal)
`./gradlew allureServe`

- For a static html report (report will be saved in `build/reports/allure-report/`)
`./gradlew allureReport`
You can then view the Allure report by opening `build/reports/allure-report/index.html` in your web browser or within IntelliJ IDEA.
