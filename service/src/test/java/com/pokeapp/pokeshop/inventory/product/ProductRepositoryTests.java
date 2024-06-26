package com.pokeapp.pokeshop.inventory.product;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryTests {

    @Test
    void getAllShouldReturnListOfProducts() throws IOException, URISyntaxException {
        int expectedProductLength = 151;
        String expectedProductName = "bulbasaur";
        ProductRepository productRepository = ProductRepository.createInstance();
        List<Product> actualProducts = productRepository.getAll();
        String actualName = actualProducts.get(0).getName();
        assertEquals(actualProducts.size(), expectedProductLength);
        assertEquals(actualName, expectedProductName);

    }
}
