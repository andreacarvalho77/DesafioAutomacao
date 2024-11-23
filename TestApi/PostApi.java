import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class PostApi {

    // Configuração base para a API
    static {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetPosts() {
        // Realiza a chamada GET e valida o status e o corpo da resposta
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200) // Valida o código de status HTTP
                .body("$", hasSize(100)) // Valida que há 100 postagens na resposta
                .body("[0].userId", equalTo(1)) // Valida que o primeiro post tem userId = 1
                .body("[0].id", equalTo(1)) // Valida que o ID do primeiro post é 1
                .body("[0].title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")); // Valida o título do primeiro post
    }

    @Test
    public void testCreatePost() {
        // Dados para criar um novo post
        String newPost= "{\n" +
                " \"title\": \"foo\",\n" +
                " \"body\": \"bar\",\n" +
                " \"userId\": \"1\"\n" + "}";

        // Realiza a chamada POST e valida a resposta
        Response response = given()
                .header("Content-type", "application/json")
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(201) // Valida que o código HTTP é 201 (Created)
                .extract()
                .response();

        // Valida o corpo da resposta do POST
        response.then().body("title", equalTo("foo"));
        response.then().body("body", equalTo("bar"));
        response.then().body("userId", equalTo("1"));
    }
}
