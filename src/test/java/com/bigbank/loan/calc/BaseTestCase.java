package com.bigbank.loan.calc;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.ConfigProperties;

/**
 * BaseTestCase is an abstract class containing common setup and utility methods for loan calculation tests.
 */
@ExtendWith({TextReportExtension.class})
@ExtendWith({ScreenShooterExtension.class})
abstract class BaseTestCase {

    /**
     * Setup Allure logging with SelenideLogger for capturing test steps and screenshots.
     */
    @BeforeAll
    public static void setupAllure() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .includeSelenideSteps(true)
                        .screenshots(true));
    }

    /**
     * Get test data value from ConfigProperties.
     *
     * @param value The key to look up in the test properties.
     * @return The corresponding value from the test properties.
     */
    public String getData(String value) {
        return ConfigProperties.getTestProperty(value);
    }

    /**
     * Clean text content by removing non-ASCII characters, replacing commas with dots, and removing spaces.
     *
     * @param text The input text to be cleaned.
     * @return The cleaned text.
     */
    public static String cleanTextContent(String text) {
        // Strips off all non-ASCII characters
        text = text.replaceAll("[^\\x00-\\x7F]", "");

        // Replaces commas with dots
        String cleanText = text.replaceAll(",", ".");

        // Removes spaces
        String cleanTextAgain = cleanText.replaceAll(" ", "");

        return cleanTextAgain.trim();
    }

    /**
     * Transform a string value to a floating-point number.
     *
     * @param value The input string value to be transformed.
     * @return The floating-point number representation of the input value.
     * @throws NumberFormatException if the input value is not a valid float.
     */
    public float transformStringToNumber(String value) throws NumberFormatException {
        float number = Float.parseFloat(cleanTextContent(value));
        return number;
    }
}
