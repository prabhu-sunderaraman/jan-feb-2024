package com.herbalife;

import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.mockito.Mockito;


@QuarkusTest
@TestHTTPEndpoint(CalculatorResource.class)
public class CalculatorResourceTest {

    @InjectMock
    CalculatorService calculatorService;

    @Test
    public void testSumOfNumbers() {
        Mockito.when(calculatorService.sum(1, 2)).thenReturn(3);
        when()
                .get("/sum/1/2")
                .then()
                .statusCode(200)
                .body(is("3"));
        Mockito.verify(calculatorService, Mockito.times(1)).sum(1, 2);
    }

    @Test
    public void testProductOfNumbers() {
        Mockito.when(calculatorService.product(1, 2)).thenReturn(2);
        given()
                .pathParam("a", 1)
                .pathParam("b", 2)
                .post("/product/{a}/{b}")
                .then()
                .statusCode(200)
                .body(is("2"));
        Mockito.verify(calculatorService, Mockito.times(1)).product(1, 2);
    }
}
