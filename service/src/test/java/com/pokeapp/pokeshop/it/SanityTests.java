package com.pokeapp.pokeshop.it;


import com.pokeapp.pokeshop.inventory.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class SanityTests {

    @Test
    void get200ResponseFromAPI() throws IOException, URISyntaxException {
        ProductService productService = ProductService.createInstance();
        assertEquals(200, productService.get().getResponseCode(), "Response from API is not 200");
    }

    @Test
    void checkDataReturnedFromAPI() throws IOException, URISyntaxException {
        String url = "/pokemon/?limit=151/";
        ProductService productService = ProductService.createInstance();
        String results = productService.getData(url);
        assertEquals(productService.getBaseUrl() + url, productService.getRequestedUrl());
        assertNotNull(results, "Results are empty");
    }

}

