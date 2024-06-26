package com.pokeapp.pokeshop.inventory.product;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProductService {

    @GetMapping("/products")
    public List<JsonObject> getProducts() throws IOException, URISyntaxException {
        return ProductController.createInstance().getAll();
    }

}
