package com.wipro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String usernameText) {
        driver.findElement(username).sendKeys(usernameText);
    }

    public void enterPassword(String passwordText) {
        driver.findElement(password).sendKeys(passwordText);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public void login(String usernameText, String passwordText) {
        enterUsername(usernameText);
        enterPassword(passwordText);
        clickLogin();
    }
}