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
  
./gradlew test
- Filter tests using the `--tests` option followed by TestPackage, TestClass, or TestMethod. For example:

  - Run tests from a specific TestPackage: 
./gradlew clean test --tests LoanCalculatorBoundaryTest

./gradlew clean test --tests LoanCalculatorBoundaryTest
