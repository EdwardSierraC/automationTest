import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class Demo {

  @Test
  public void testGetUsers () {
    RestAssured.baseURI = "https://reqres.in/api";
    String body = RestAssured
            .given()
            .when().
              get("/users").
            then()
              .statusCode(200)
              .body("data[1].first_name", equalTo("Janet"))
              .extract().body().asString();
    System.out.println(body);
  }

  @Test
  public void testPostUser () {
    RestAssured.baseURI = "https://reqres.in/api";
    Map<String, Object> map = new HashMap<String,Object>();
    map.put("name","Elver");
    map.put("job","Galarga");

    String body = RestAssured
            .given()
              .log().all()
              .body(map.toString())
            .when()
              .post("/users")
            .then()
              .log().all()
              .statusCode(201).toString();
  }
}
