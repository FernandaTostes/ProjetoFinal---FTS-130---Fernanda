package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Pet_old2 {


    // Padrão
    // Given = Dado
    // .When = Quando
    // .Then = Então

    // Funções de Apoio
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirPet() throws IOException { // Create - Post

        String jsonBody = lerJson("src/test/resources/data/pet.json");
     String teste1 = "Vermifugado" ;
     String tags1 = "tags.name";
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post("https://petstore.swagger.io/v2/pet")
        .then()
                .log().all()
                .statusCode(200)
               // .body("code", ii(200))
                .body("id", is(1007))
                .body("name", is("Cocada"))
                .body( "tags.name[0]", stringContainsInOrder("Cocada esta Vermifugad"))
        ;




    }
    @Test
    public void consultarPet(){
        String petId = "1107"; // Id do animal

        given()
                .contentType("application/json")
                .log().all()
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + petId) // Get == Consultar
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Cocada"))
                .body("status", is("available"))
        ;
    }


}