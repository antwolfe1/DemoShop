package com.pokeapp.pokeshop.inventory.product;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ProductDAL {
    // Repository
    private ProductController productController;

    private ProductDAL() {
    }

    public static ProductDAL createInstance() {
        return new ProductDAL();
    }
    

    public List<String> getAll() throws IOException, URISyntaxException {
        // retrieve all products from repo
        List<String> products = List.of();
        ProductService productService = ProductService.createInstance();
        return products;
    }



}
