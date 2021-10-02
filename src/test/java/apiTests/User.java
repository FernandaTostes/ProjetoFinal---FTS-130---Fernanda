package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class User {
    int userId = 6666;
    String username = "Pumuchio";
    String password = "12345678";
    String uri = "https://petstore.swagger.io/v2/user";
    String endpoint_login = "/login?username=" + username + "&password=" + password;
    String token = "";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test(priority = 0)
    public void incluirUser() throws IOException { // Create - Post

        String jsonBody = lerJson("src/test/resources/data/user.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
         .when()
                .log().all()
                .post(uri)
         .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(Integer.toString(userId)))
        ;
    }

    @Test(priority = 1 , dependsOnMethods = {"incluirUser"})
    public void consultarUser(){


        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("username", is(username))
                .body("firstName", is("Pumuchio"))
                .body("lastName", is("Rede"))
                .body("email", is("destruosuared@rede.com"))
                .body("password", is("123456"))
                .body("phone", is("1234567890"))
                .body("userStatus", is(0))
        ;
    }

    @Test(priority = 2, dependsOnMethods = {"consultarUser"})
    public void alterarUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/newuser.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                .put(uri + "/" + username)
                .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(Integer.toString(userId)))
        ;
    }

    @Test(priority = 1, dependsOnMethods = {"alterarUser"})
    public void apagarUser(){

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + username) // Get == Consultar
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(username))
        ;
    }
    @Test
    public void login(){

        String mensagem =
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + endpoint_login)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", stringContainsInOrder("logged in user session:"))
                .extract()
                .path("message")
        ;

        System.out.println("A mensagem é: " + mensagem);
        token = mensagem.substring(23);
        System.out.println("O token é : " + token);
    }

}
