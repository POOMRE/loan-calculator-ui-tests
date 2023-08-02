package com.bigbank.loan.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_objects.LoanCalculatorPage;

/**
 * LoanCalculatorBoundaryTest is a test class to test the loan calculator functionality with boundary values.
 */
public class LoanCalculatorBoundaryTest extends BaseTestCase {

    private final LoanCalculatorPage loanCalculatorPage = new LoanCalculatorPage();

    /**
     * Open the loan calculator page before each test.
     */
    @BeforeEach
    public void openCalculatorPage() {
        loanCalculatorPage.open();
    }

    /**
     * This test validates that the calculator accepts the minimum loan amount and period allowed by the system.
     */
    @Test
    public void shouldHandleMinValues() {
        // Set the loan amount and period to the minimum values
        loanCalculatorPage.setLoanAmountAndPeriod(getData("LoanAmountMin"), getData("LoanPeriodMin"));
        loanCalculatorPage.closeAndSave();

        // Retrieve the loan amount and period from the calculator page
        double getLoanAmount = transformStringToNumber(loanCalculatorPage.getLoanAmount());
        double getLoanPeriod = transformStringToNumber(loanCalculatorPage.getLoanPeriod());

        // Assert that the retrieved values match the expected minimum values
        Assertions.assertEquals(transformStringToNumber(getData("LoanAmountMin")), getLoanAmount);
        Assertions.assertEquals(transformStringToNumber(getData("LoanPeriodMin")), getLoanPeriod);
    }

    /**
     * This test validates that the calculator accepts the maximum loan amount and period allowed by the system.
     */
    @Test
    public void shouldHandleMaxValues() {
        // Set the loan amount and period to the maximum values
        loanCalculatorPage.setLoanAmountAndPeriod(getData("LoanAmountMax"), getData("LoanPeriodMax"));
        loanCalculatorPage.closeAndSave();

        // Retrieve the loan amount and period from the calculator page
        double getLoanAmount = transformStringToNumber(loanCalculatorPage.getLoanAmount());
        double getLoanPeriod = transformStringToNumber(loanCalculatorPage.getLoanPeriod());

        // Assert that the retrieved values match the expected maximum values
        Assertions.assertEquals(transformStringToNumber(getData("LoanAmountMax")), getLoanAmount);
        Assertions.assertEquals(transformStringToNumber(getData("LoanPeriodMax")), getLoanPeriod);
    }

    /**
     * This test validates the calculator handling when providing a bigger loan amount and period.
     */
    @Test
    public void shouldHandleBiggerValues() {
        // Set the loan amount and period to values exceeding the maximum allowed
        loanCalculatorPage.setLoanAmountAndPeriod(getData("ExceededLoanAmount"), getData("ExceededLoanPeriod"));

        // Retrieve the loan amount and period from the calculator page
        double getLoanAmount = transformStringToNumber(loanCalculatorPage.getLoanAmount());
        double getLoanPeriod = transformStringToNumber(loanCalculatorPage.getLoanPeriod());

        // Assert that the retrieved values are capped at the maximum allowed values
        Assertions.assertEquals(transformStringToNumber(getData("LoanAmountMax")), getLoanAmount);
        Assertions.assertEquals(transformStringToNumber(getData("LoanPeriodMax")), getLoanPeriod);
    }

    /**
     * This test validates the calculator handling when providing a smaller loan amount and period.
     */
    @Test
    public void shouldHandleSmallerValues() {
        // Set the loan amount and period to values smaller than the minimum allowed
        loanCalculatorPage.setLoanAmountAndPeriod(getData("SmallerLoanAmount"), getData("SmallerLoanPeriod"));

        // Retrieve the loan amount and period from the calculator page
        double getLoanAmount = transformStringToNumber(loanCalculatorPage.getLoanAmount());
        double getLoanPeriod = transformStringToNumber(loanCalculatorPage.getLoanPeriod());

        // Assert that the retrieved values are capped at the minimum allowed values
        Assertions.assertEquals(transformStringToNumber(getData("LoanAmountMin")), getLoanAmount);
        Assertions.assertEquals(transformStringToNumber(getData("LoanPeriodMin")), getLoanPeriod);
    }
}
