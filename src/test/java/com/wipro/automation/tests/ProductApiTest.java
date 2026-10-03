package com.wipro.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wipro.automation.api.ProductApi;

import io.restassured.response.Response;

public class ProductApiTest {

    ProductApi productApi = new ProductApi();

    @Test
    public void getAllProductsTest() {

        Response response = productApi.getAllProducts();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(
                response.jsonPath().getList("products").size() > 0
        );
    }

    @Test
    public void getProductByIdTest() {

        Response response = productApi.getProductById(1);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(
                response.jsonPath().getInt("id"),
                1
        );
    }

    @Test
    public void searchProductsTest() {

        Response response = productApi.searchProducts("phone");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(
                response.jsonPath().getList("products").size() > 0
        );
    }

    @Test
    public void addProductTest() {

        Response response =
                productApi.addProduct("Automation Test Product");

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertNotNull(
                response.jsonPath().get("id")
        );
    }

    @Test
    public void updateProductTest() {

        Response response =
                productApi.updateProduct(1, "Updated Automation Product");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(
                response.jsonPath().getString("title"),
                "Updated Automation Product"
        );
    }

    @Test
    public void deleteProductTest() {

        Response response =
                productApi.deleteProduct(1);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(
                response.jsonPath().getBoolean("isDeleted")
        );
    }
}