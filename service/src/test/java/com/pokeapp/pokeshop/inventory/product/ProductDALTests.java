package com.pokeapp.pokeshop.inventory.product;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductDALTests {

    @Test
    void getAllShouldReturnListOfProducts() throws IOException, URISyntaxException {
        int expectedProductLength = 151;
        String expectedProductName = "bulbasaur";
        ProductDAL productDAL = ProductDAL.createInstance();
        List<String> actualProducts = productDAL.getAll();
        assertEquals(actualProducts.size(), expectedProductLength);
        assertEquals(actualProducts.get(0), expectedProductName);

    }
}
