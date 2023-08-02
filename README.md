# loan-calculator-ui-tests

This test project focuses on UI testing for Loan calculator

## Test Classes

1. `LoanCalculatorBoundaryTest`:
   - LoanCalculatorBoundaryTest is a test class to test the loan calculator functionality with boundary values.

2. `LoanCalculatorTest`:
   - LoanCalculatorTest is a test class to test the functionality of the loan calculator page.

## Setting up project and running tests
Clone project
To run the tests using Gradle, you can use the following commands:
- Run all tests: `./gradlew test`
- You can filter tests by using option --tests
- Giving values can be TestPackage, TestClass, TestMethod
- Run tests from a specific test class: `./gradlew clean test --tests LoanCalculatorBoundaryTest`
- Run a specific test method: `./gradlew test --tests com.banking.BankingTestCreateUser.testCreateUser`


Test report can be seen build/reports/tests/test directory.

## Dependencies
- The project uses gRPC for communication between client and server.
- JUnit Jupiter and are used for writing unit tests.
- Project SDK used 17
