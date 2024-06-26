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

    @GetMapping("/")
    public String home() {
        return "Helloo?";
    }

    @GetMapping("/products")
    public List<Product> getProducts() throws IOException, URISyntaxException {
//        Product product = new Product();
//        product.setName("anthony");
//        product.setUrl("http://hahaha.org");
//        return List.of(product);
//        return "Helloo?";
        return ProductController.createInstance().getAll();
    }

}
