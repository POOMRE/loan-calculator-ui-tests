# Loan Calculator UI Tests

This project provides UI testing for a Loan Calculator application. 

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) - Project SDK version 17 is used in this project.
- ChromeDriver - use version 114 if running tests on Mac OS due to a bug in the 115 version for mac_arm64.
- Allure - for generating detailed test reports.
- Gradle - handles the project's other dependencies, specified in the project's Gradle file.

### Running Tests

This project uses Gradle for running tests. Here are some useful commands:

- Run all tests:
`./gradlew test`

- Filter tests using the `--tests` option followed by TestPackage, TestClass, or TestMethod.

  - Run tests from a specific TestPackage: `./gradlew clean test --tests "com.bigbank.loan.calc.*"`
  - Run a specific TestClass: `./gradlew clean test --tests LoanCalculatorBoundaryTest `
  - Run a specific TestMethod: `./gradlew clean test --tests LoanCalculatorTest.shouldRetainSavedValuesOnClosureWithSave`


  
### Generating Test Reports

By default, the test report is generated in `build/reports/index.html`. However, the project also supports generating more detailed and robust Allure reports. After running tests, you can generate an Allure report using one of the following commands:

- For a temporary live server (server will stop after closing terminal)
`./gradlew allureServe`

- For a static html report (report will be saved in `build/reports/allure-report/`)
`./gradlew allureReport`
You can then view the Allure report by opening `build/reports/allure-report/index.html` in your web browser or within IntelliJ IDEA.
