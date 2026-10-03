package com.wipro.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wipro.automation.base.BaseTest;
import com.wipro.automation.pages.CartPage;
import com.wipro.automation.pages.CheckoutPage;
import com.wipro.automation.pages.LoginPage;
import com.wipro.automation.pages.ProductsPage;

public class CheckoutTest extends BaseTest {

	@Test
	public void completePurchaseTest() {

	    LoginPage loginPage = new LoginPage(driver);

	    loginPage.login("standard_user", "secret_sauce");

	    pause(2);

	    ProductsPage productsPage = new ProductsPage(driver);

	    productsPage.addBackpack();

	    pause(2);

	    productsPage.openCart();

	    pause(3);

	    CartPage cartPage = new CartPage(driver);

	    Assert.assertTrue(
	            cartPage.isProductPresent(),
	            "Product was not added to cart"
	    );

	    pause(2);

	    cartPage.clickCheckout();

	    pause(3);

	    CheckoutPage checkoutPage = new CheckoutPage(driver);

	    checkoutPage.enterCustomerDetails(
	            "Harshit",
	            "Tyagi",
	            "250001"
	    );

	    pause(2);

	    checkoutPage.clickContinue();

	    pause(3);

	    checkoutPage.clickFinish();

	    pause(5);

	    Assert.assertTrue(
	            checkoutPage.isOrderCompleted(),
	            "Order was not completed"
	    );
	}
}