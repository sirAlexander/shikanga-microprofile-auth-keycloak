package uk.co.shikanga.microprofile.secure;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ProtectedResourceTest {

    @Test
    public void testMessageEndpoint() {
        given()
          .when().get("/resources/secure")
          .then()
             .statusCode(401);
    }

}