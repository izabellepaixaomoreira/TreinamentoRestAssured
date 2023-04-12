package org.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TreinamentoRestAssured {
    @Test
    public void pesquisarPetPorId() {
        given()
                .baseUri("http://petstore.swagger.io/v2")
                .basePath("/pet/{petId}")
                .header("content-type","aplication/json")
                .pathParam("petId", 1);
        when()
                .get().
        then().
                statusCode(200)
                .body("id", not(emptyString()));
    }

    @Test
    public void pesquisarPetInexistente() {
        given()
                .baseUri("http://petstore.swagger.io/v2")
                .basePath("/pet/{petId}")
                .pathParam("petId", 635).
        when()
                .get().
        then()
                .statusCode(404)
                .body("message", equalTo("Pet not found"));
    }

    @Test
    public void atualizarPetFormatoInvalido() {
        given()
                .baseUri("http://petstore.swagger.io/v2")
                .basePath("/pet/")
                .pathParam("petId", "teste").
        when()
                .put().
        then()
                .statusCode(500)
                .body("message", equalTo("something bad happened"));
    }

    @Test
    public void cadastrarPetMetodoNaoPermitido() {
        given()
                .baseUri("http://petstore.swagger.io/v2")
                .basePath("/pet")
                .header("content-type","aplication/json");
        when()
                .head().
        then()
                .statusCode(405);
    }

    @Test
    public void cadastrarpedidoPet() {
        Pet pet = new Pet();
        pet.setId(643342);
        pet.setPetId(64354);
        pet.setQuantity(1);
        pet.setShipDate("2023-04-11T16:41:03.623Z");
        pet.setStatus("available");
        pet.setComplete(true);

        given()
                .baseUri("http://petstore.swagger.io/v2")
                .basePath("/store/order")
                .header("content-type","application/json")
                .body(pet).
        when()
                .post().
        then()
                .statusCode(200)
                .body("id", not(empty()))
                .body("quantity", not(equalTo(0)));
    }
}