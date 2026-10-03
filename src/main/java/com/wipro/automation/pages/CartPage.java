package com.wipro.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By checkoutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");
    private By cartItem = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isProductPresent() {

        return !driver.findElements(cartItem).isEmpty();
    }

    public void clickCheckout() {
        wait.until(driver ->
                driver.findElements(checkoutButton).size() > 0
        );

        driver.findElement(checkoutButton).click();
    }

    public void continueShopping() {
        wait.until(driver ->
                driver.findElements(continueShoppingButton).size() > 0
        );

        driver.findElement(continueShoppingButton).click();
    }
}