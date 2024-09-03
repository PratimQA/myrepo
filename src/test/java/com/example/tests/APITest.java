package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetMethod() {
        given()
            .when()
            .get("/posts/1")
            .then()
            .statusCode(200)
            .body("userId", equalTo(1))
            .body("id", equalTo(1))
            .body("title", notNullValue());
    }

    @Test
    public void testPostMethod() {
        String requestBody = "{\n" +
                             "  \"title\": \"foo\",\n" +
                             "  \"body\": \"bar\",\n" +
                             "  \"userId\": \"1\"\n" +
                             "}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .post("/posts")
            .then()
            .statusCode(201)
            .body("title", equalTo("foo"))
            .body("body", equalTo("bar"))
            .body("userId", equalTo("1"));
    }

    @Test
    public void testPutMethod() {
        String requestBody = "{\n" +
                             "  \"id\": \"1\",\n" +
                             "  \"title\": \"updated title\",\n" +
                             "  \"body\": \"updated body\",\n" +
                             "  \"userId\": \"1\"\n" +
                             "}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .put("/posts/1")
            .then()
            .statusCode(200)
            .body("title", equalTo("updated title"))
            .body("body", equalTo("updated body"))
            .body("userId", equalTo("1"));
    }

    @Test
    public void testDeleteMethod() {
        when()
            .delete("/posts/1")
            .then()
            .statusCode(200);
    }
}
