package com.phucdn.microservices.product;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import com.phucdn.microservices.product.dto.ProductRequest;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PracSpring3McEcom2025B01ProductServiceApplicationTests {

    @LocalServerPort
    private Integer port;
    
    @DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", () -> "mongodb+srv://phucdn:PhucdnP@cluster0.htx3e.mongodb.net/pracspring2025EcProductService?retryWrites=true&w=majority");
	}

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
        RestAssured.defaultParser = Parser.JSON;
    }

    @Test
    void shouldCreateProduct() {
        ProductRequest productRequest = getProductRequest();

        RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(productRequest)
                .when()
                .post("/api/product")
                .then()
                .log().all()
                .statusCode(201);
    }

    private ProductRequest getProductRequest() {
        return new ProductRequest("iPhone 13", "Test iPhone 13 from JUnit", BigDecimal.valueOf(1200));
    }
}
