import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Post {

  @Before
  public void setUp () {
    RestAssured.baseURI = "https://reqres.in";
    RestAssured.basePath = "/api";
    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    RestAssured.requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .build();
  }


  @Test
  public void loginTest () {
    given()
            .log().all()
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "    \"email\": \"eve.holt@reqres.in\",\n" +
                    "    \"password\": \"cityslicka\"\n" +
                    "}")
            .post("https://reqres.in/api/login")
            .then()
            .log().all()
            .statusCode(200)
            .body("token", notNullValue());
  }

  @Test
  public void deleteTest () {
    given()
            .delete("users/2")
            .then()
            .statusCode(HttpStatus.SC_NO_CONTENT);
  }
}
