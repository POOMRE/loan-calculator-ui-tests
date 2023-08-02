package page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;

public class ClientDetailsAndConfirmationPage {

    private SelenideElement buttonEditLoan =    $(By.cssSelector(".bb-edit-amount__amount"));


    public void editLoanAmount(){
        buttonEditLoan.click();
        sleep(1000);
    }
}
