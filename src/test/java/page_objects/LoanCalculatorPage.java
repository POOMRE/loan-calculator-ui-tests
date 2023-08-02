package page_objects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class LoanCalculatorPage {

    private SelenideElement loanAmountInput = $(By.name("header-calculator-amount"));
    private SelenideElement loanPeriodInput = $(By.name("header-calculator-period"));
    private SelenideElement proceedButton = $(By.cssSelector(".bb-calculator-modal__submit-button > .bb-button__label"));
    private SelenideElement monthlyPaymentValue = $(By.cssSelector(".bb-labeled-value__value"));
    private SelenideElement closeCalculator = $(By.cssSelector(".bb-button__icon"));
    private String calculatorUrl = "https://laenutaotlus.bigbank.ee/";

    public LoanCalculatorPage open() {
        Selenide.open(calculatorUrl);
        return this;
    }

    public LoanCalculatorPage setLoanAmountAndPeriod(String amount, String period) {
        setLoanAmount(amount);
        setLoanPeriod(period);
        sleep(1000);
        return this;
    }

    public String getMonthlyPayment() {
        return monthlyPaymentValue.shouldHave(Condition.text("€")).getText();
    }

    public void closeAndSave() {
        clickProceed();
    }

    public void closeWithoutSave() {
        closeCalculator.click();
    }

    public String getLoanAmount() {
        return loanAmountInput.getValue();
    }

    public String getLoanPeriod() {
        return loanPeriodInput.getValue();
    }

    private void setLoanAmount(String amount) {
        loanAmountInput.doubleClick().sendKeys(Keys.BACK_SPACE);
        loanAmountInput.setValue(amount);
    }

    private void setLoanPeriod(String period) {
        loanPeriodInput.doubleClick().sendKeys(Keys.BACK_SPACE);
        loanPeriodInput.setValue(period);
        monthlyPaymentValue.click();
    }

    private void clickProceed() {
        proceedButton.click();

    }
}