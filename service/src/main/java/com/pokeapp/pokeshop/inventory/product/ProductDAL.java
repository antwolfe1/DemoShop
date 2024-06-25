package com.pokeapp.pokeshop.inventory.product;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDAL {
    // Repository
    private ProductController productController;

    private ProductDAL() {
    }

    public static ProductDAL createInstance() {
        return new ProductDAL();
    }
    

    public List<JsonObject> getAll() throws IOException, URISyntaxException {
        // retrieve all products from repo
        ProductService productService = ProductService.createInstance();
        JsonObject productList = productService.getData();
        System.out.println(productList);
        System.out.println(productList.get("results"));
        List<JsonObject> products = new ArrayList<>(List.of());
        JsonArray results = productList.getAsJsonArray("results");

        for (int ele = 0; ele < results.size(); ele++){
            JsonObject product = results.get(ele).getAsJsonObject();
            products.add(product);
        }

        return products;
    }



}
