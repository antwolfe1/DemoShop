package com.pokeapp.pokeshop.it;


import com.pokeapp.pokeshop.inventory.product.ApiService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SanityTests {

    String baseUrl = "https://pokeapi.co/api/v2/";

    @Test
    void getConnection() throws IOException {
        ApiService apiService = ApiService.createInstance(baseUrl);
        assertEquals(baseUrl, apiService.url);
        assertEquals(200, apiService.getResponseCode(), "Response from API is not 200");

    }

    @Test
    void getFirst101PokemonData() throws IOException {
        String url = baseUrl + "pokemon/?limit=151/";
        ApiService apiService = ApiService.createInstance(url);
        Object results = apiService.getPokemonData();
        assertEquals(url, apiService.url);
        assertNotNull(results, "Results are empty");
    }

}

