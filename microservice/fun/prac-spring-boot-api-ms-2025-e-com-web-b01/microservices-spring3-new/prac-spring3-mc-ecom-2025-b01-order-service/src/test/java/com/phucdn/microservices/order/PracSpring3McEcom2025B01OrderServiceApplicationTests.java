package com.phucdn.microservices.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;

import com.phucdn.microservices.order.stubs.InventoryClientStub;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class PracSpring3McEcom2025B01OrderServiceApplicationTests {

	@LocalServerPort
    private Integer port;

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
        RestAssured.defaultParser = Parser.JSON;
    }

    static {
        mySQLContainer.start();
    }
    
    @Test
    void shouldSubmitOrder() {
    	String submitOrderJson = """
                {
                     "skuCode": "iphone_15",
                     "price": 1000,
                     "quantity": 1
                }
                """;

        InventoryClientStub.stubInventory("iphone_15", 1);
    	
    	var responseBodyString = RestAssured.given()
    			.contentType("application/json")
    			.body(submitOrderJson)
    			.when()
    			.post("/api/order")
    			.then()
    			.log()
    			.all()
    			.statusCode(201)
    			.extract()
    			.body()
    			.asString();
    	
    	assertThat(responseBodyString, Matchers.is("Order Placed Successfully"));
    }
}
