package com.pokeapp.pokeshop.sanity;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpLogicTests {

    @Test
    void getConnection() throws IOException {
        String url = "https://pokeapi.co/api/v2/pokemon/";
        HttpLogic httpLogic = HttpLogic.createInstance(url);
        assertEquals(url, httpLogic.url);
        assertEquals(200, httpLogic.getResponseCode());

    }

}

