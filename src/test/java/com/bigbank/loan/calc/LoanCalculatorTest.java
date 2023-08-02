package com.bigbank.loan.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_objects.ClientDetailsAndConfirmationPage;
import page_objects.LoanCalculatorPage;


/**
 * LoanCalculatorTest is a test class to test the functionality of the loan calculator page.
 */
public class LoanCalculatorTest extends BaseTestCase {
    private final LoanCalculatorPage loanCalculatorPage = new LoanCalculatorPage();
    private final ClientDetailsAndConfirmationPage clientDetailsAndConfirmationPage = new ClientDetailsAndConfirmationPage();

    /**
     * Open the loan calculator page before each test.
     */
    @BeforeEach
    public void openCalculatorPage() {
        loanCalculatorPage.open();
    }

    /**
     * The calculator should recalculate and display the new monthly payment amount if the loan amount or period is changed.
     */
    @Test
    public void shouldRecalculateMonthlyPaymentIfAmountOrPeriodChanged() {
        // Set initial loan amount and period and get the monthly payment
        loanCalculatorPage.setLoanAmountAndPeriod(getData("LoanAmount"), getData("LoanPeriod"));
        float monthlyPayment = transformStringToNumber(loanCalculatorPage.getMonthlyPayment());

        // Set new loan amount and period and get the updated monthly payment
        loanCalculatorPage.setLoanAmountAndPeriod(getData("NewLoanAmount"), getData("NewLoanPeriod"));
        float updatedMonthlyPayment = transformStringToNumber(loanCalculatorPage.getMonthlyPayment());

        // Assert that the updated monthly payment is not equal to the initial monthly payment
        Assertions.assertNotEquals(monthlyPayment, updatedMonthlyPayment);
    }

    /**
     * The changes made without saving should not be reflected. The previous saved values should be retained.
     */
    @Test
    public void shouldRetainPreviousValuesOnClosureWithoutSave() {
        // Get the loan amount, loan period, and monthly payment before closing the calculator
        float loanAmountBeforeClose = transformStringToNumber(loanCalculatorPage.getLoanAmount());
        float loanPeriodBeforeClose = transformStringToNumber(loanCalculatorPage.getLoanPeriod());
        float monthlyPaymentBeforeClose = transformStringToNumber(loanCalculatorPage.getMonthlyPayment());

        // Set new loan amount, loan period, and close the calculator without saving
        loanCalculatorPage.setLoanAmountAndPeriod(getData("LoanAmount"), getData("LoanPeriod"));
        loanCalculatorPage.closeWithoutSave();

        // Reopen the calculator and assert that previous values are retained
        clientDetailsAndConfirmationPage.editLoanAmount();

        Assertions.assertEquals(loanAmountBeforeClose, transformStringToNumber(loanCalculatorPage.getLoanAmount()));
        Assertions.assertEquals(loanPeriodBeforeClose, transformStringToNumber(loanCalculatorPage.getLoanPeriod()));
        Assertions.assertEquals(monthlyPaymentBeforeClose, transformStringToNumber(loanCalculatorPage.getMonthlyPayment()));
    }

    /**
     * The changes made with saving should be available and used in the application process.
     */
    @Test
    public void shouldRetainSavedValuesOnClosureWithSave() {
        // Set new loan amount, new period, save, and close the calculator
        loanCalculatorPage.setLoanAmountAndPeriod(getData("LoanAmount"), getData("LoanPeriod"));
        float monthlyPaymentBeforeClose = transformStringToNumber(loanCalculatorPage.getMonthlyPayment());
        loanCalculatorPage.closeAndSave();

        // Reopen the calculator and assert that the saved values are retained
        clientDetailsAndConfirmationPage.editLoanAmount();

        Assertions.assertEquals(transformStringToNumber(getData("LoanAmount")), transformStringToNumber(loanCalculatorPage.getLoanAmount()));
        Assertions.assertEquals(transformStringToNumber(getData("LoanPeriod")), transformStringToNumber(loanCalculatorPage.getLoanPeriod()));
        Assertions.assertEquals(monthlyPaymentBeforeClose, transformStringToNumber(loanCalculatorPage.getMonthlyPayment()));
    }
}
