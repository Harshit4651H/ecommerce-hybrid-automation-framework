package com.wipro.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By completeMessage = By.className("complete-header");
    private By checkoutError = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterCustomerDetails(
            String firstNameText,
            String lastNameText,
            String postalCodeText) {

        WebElement firstNameField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        WebElement lastNameField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));

        WebElement postalCodeField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode));

        firstNameField.clear();
        firstNameField.sendKeys(firstNameText);

        lastNameField.clear();
        lastNameField.sendKeys(lastNameText);

        postalCodeField.clear();
        postalCodeField.sendKeys(postalCodeText);
    }

    public void clickContinue() {

        WebElement button =
                wait.until(ExpectedConditions.elementToBeClickable(continueButton));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", button);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", button);

        try {
            wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
        } catch (Exception e) {

            if (driver.findElements(checkoutError).size() > 0) {
                throw new RuntimeException(
                        "Checkout validation error: "
                        + driver.findElement(checkoutError).getText());
            }

            throw new RuntimeException(
                    "Continue button was clicked, but checkout did not move to step two. "
                    + "Current URL: " + driver.getCurrentUrl());
        }
    }

    public void clickFinish() {

        wait.until(ExpectedConditions.elementToBeClickable(finishButton))
                .click();
    }

    public boolean isOrderCompleted() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(completeMessage)
        ).isDisplayed();
    }
}