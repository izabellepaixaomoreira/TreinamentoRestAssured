package api.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class petStoreTests {

    @Test
    public void cadastrarPet() {
        given().
                baseUri("http://petstore.swagger.io/v2").
                basePath("/store/order").
                //  body(pet);
                        when()
                .post().
                then()
                .statusCode(200);
               // .body(“id”, not(empty()));
    }

    @Test
    public void pesquisarPetInexistente() {
        given().
                baseUri("http://petstore.swagger.io/v2").
                basePath("/pet/{petId}").
                pathParam("petId", 635).
                when().
                get().
                then()
                .statusCode(404)
                .body("message", is("Pet not found"));
    }

    @Test
    public void atualizarPet() {
        given().
                baseUri("http://petstore.swagger.io/v2").
                basePath("/pet/").
                pathParam("petId", "9223372036854774884").
                when().
                put().
                then()
                .statusCode(200);
            //  .body(“id”, not(empty()));
    }

    @Test
    public void atualizarPetFormatoInvalido() {
        given().
                baseUri("http://petstore.swagger.io/v2").
                basePath("/pet/").
                pathParam("petId", "teste").
                when().
                put().
                then()
                .statusCode(500);
                .body("message", is("something bad happened"));
    }

    @Test
    public void pesquisarPetPorStatus() {
        given().
                baseUri("http://petstore.swagger.io/v2").
                basePath("/pet/findByStatus").
                queryParam("status", "pending").
                when().
                get().
                then()
                .statusCode(200);
        //  .body(“id”, not(empty()));
    }

    @Test
    public void cadastrarPetMetodoNaoPermitido() {
        given().
                baseUri("http://petstore.swagger.io/v2").
                basePath("/pet").
                when().
                head().
                then()
                .statusCode(405);
    }
}