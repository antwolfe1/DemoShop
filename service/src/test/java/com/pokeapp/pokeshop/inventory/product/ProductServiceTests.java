package com.pokeapp.pokeshop.inventory.product;

import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTests {

    @Test
    void transformDataToJSON(){
        String testJsonString = "{\"test\": \"words\", \"case\": \"options\"}";
        ProductService productService = ProductService.createInstance();
        assertEquals(JsonObject.class, productService.stringToJson(testJsonString).getClass());
        assertEquals("options", productService.stringToJson(testJsonString).get("case").getAsString());
    }
}
