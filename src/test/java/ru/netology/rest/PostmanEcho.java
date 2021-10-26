package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEcho {
    @Test
    void shouldSendPostToPostmanEcho() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("postmanecho") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("postmanecho"))
                .header("Content-Type", "application/json; charset=utf-8");
    }
    @Test
    void shouldSendPostToPostmanEcho2() {

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("postmanecho2")
                .header("Content-Type", "application/json; charset=UTF-8")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("postmanecho2"));
    }
}
