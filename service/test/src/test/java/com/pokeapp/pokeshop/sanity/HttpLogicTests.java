package com.pokeapp.pokeshop.sanity;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HttpLogicTests {

    String baseUrl = "https://pokeapi.co/api/v2/";

    @Test
    void getConnection() throws IOException {
        HttpLogic httpLogic = HttpLogic.createInstance(baseUrl);
        assertEquals(baseUrl, httpLogic.url);
        assertEquals(200, httpLogic.getResponseCode(), "Response from API is not 200");

    }

    @Test
    void getFirst101PokemonData() throws IOException {
        String url = baseUrl + "pokemon/?limit=151/";
        HttpLogic httpLogic = HttpLogic.createInstance(url);
        Object results = httpLogic.getPokemonData();
        assertEquals(url, httpLogic.url);

        assertNotNull(results, "Results are empty");
    }

}

