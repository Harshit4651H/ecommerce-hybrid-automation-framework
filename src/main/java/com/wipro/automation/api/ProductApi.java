package com.wipro.automation.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductApi {

    private static final String BASE_URL = "https://dummyjson.com";

    public Response getAllProducts() {

        return given()
                .baseUri(BASE_URL)
                .when()
                .get("/products");
    }

    public Response getProductById(int productId) {

        return given()
                .baseUri(BASE_URL)
                .when()
                .get("/products/" + productId);
    }

    public Response searchProducts(String query) {

        return given()
                .baseUri(BASE_URL)
                .queryParam("q", query)
                .when()
                .get("/products/search");
    }

    public Response addProduct(String title) {

        String requestBody = """
                {
                    "title": "%s"
                }
                """.formatted(title);

        return given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/products/add");
    }

    public Response updateProduct(int productId, String title) {

        String requestBody = """
                {
                    "title": "%s"
                }
                """.formatted(title);

        return given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/products/" + productId);
    }

    public Response deleteProduct(int productId) {

        return given()
                .baseUri(BASE_URL)
                .when()
                .delete("/products/" + productId);
    }
}