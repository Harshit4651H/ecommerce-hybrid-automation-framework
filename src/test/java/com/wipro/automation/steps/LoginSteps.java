package com.wipro.automation.steps;

import org.testng.Assert;

import com.wipro.automation.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(CucumberHooks.driver);
    }

    @When("the user enters valid username and password")
    public void userEntersValidCredentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("the user clicks the login button")
    public void userClicksLoginButton() {
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the inventory page")
    public void userShouldBeRedirectedToInventoryPage() {
        Assert.assertTrue(
            CucumberHooks.driver.getCurrentUrl().contains("inventory.html"),
            "User was not redirected to inventory page"
        );
    }
}