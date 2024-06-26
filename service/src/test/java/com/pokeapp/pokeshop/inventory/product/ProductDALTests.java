package com.pokeapp.pokeshop.inventory.product;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
        List<JsonObject> actualProducts = productDAL.getAll();
        String actualName = actualProducts.get(0).get("name").getAsString();
        assertEquals(actualProducts.size(), expectedProductLength);
        assertEquals(actualName, expectedProductName);

    }
}
