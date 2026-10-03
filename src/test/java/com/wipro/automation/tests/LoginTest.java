package com.wipro.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wipro.automation.base.BaseTest;
import com.wipro.automation.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
            driver.getCurrentUrl().contains("inventory.html"),
            "Login failed"
        );
    }

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrong_user", "wrong_password");

        Assert.assertTrue(
            loginPage.isErrorDisplayed(),
            "Error message was not displayed"
        );
    }
}