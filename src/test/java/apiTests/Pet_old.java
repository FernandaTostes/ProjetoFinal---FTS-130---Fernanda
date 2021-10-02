package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public abstract class Pet_old {
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test
    public void incluirPet(){

        String jsonBody;
        //Padrão]
        //Given
        //.When
        //.Then
        given()
                .contentType("application/json")
                //.body( "{ \"id\": 100007, \"category\": { \"id\": 1, \"name\": \"dog\" }, \"name\": \"Cocada\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"string\" } ], \"status\": \"available\" }"  )
                .log().all()
        .when()
                .post("https://petstore.swagger.io/v2/pet")
        .then()
                .log().all()
        ;


    }

    @Test
    public void consultaPet(){

        //Padrão]
        //Given
        //.When
        //.Then
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get("https://petstore.swagger.io/v2/pet/9223127596080623000")
        .then()
                .log().all()
        ;


    }

}
