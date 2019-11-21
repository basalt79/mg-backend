package com.mg.backend;

import io.quarkus.test.junit.QuarkusTest;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


// https://github.com/quarkusio/quarkus/pull/5276

//@QuarkusTest
@Ignore
public class PlayerResourceTest {

//    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/player")
          .then()
             .statusCode(200)
             ;
    }

}