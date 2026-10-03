package com.wipro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    private By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartButton = By.className("shopping_cart_link");
    private By sortDropdown = By.className("product_sort_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpack() {
        driver.findElement(backpack).click();
    }

    public void addBikeLight() {
        driver.findElement(bikeLight).click();
    }

    public void openCart() {
        driver.findElement(cartButton).click();
    }

    public boolean isSortDropdownDisplayed() {
        return driver.findElement(sortDropdown).isDisplayed();
    }
}