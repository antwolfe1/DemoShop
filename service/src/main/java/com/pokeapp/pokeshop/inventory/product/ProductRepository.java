package com.pokeapp.pokeshop.inventory.product;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pokeapp.pokeshop.inventory.InventoryRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    // Repository
    private InventoryRepository inventoryRepository = InventoryRepository.createInstance();

    private ProductRepository() {
    }

    public static ProductRepository createInstance() {
        return new ProductRepository();
    }


    public List<Product> getAll() throws IOException, URISyntaxException {
        // retrieve all products from repo/api
        JsonObject productList = this.inventoryRepository.getAll();
        List<Product> products = new ArrayList<>(List.of());
        JsonArray results = productList.getAsJsonArray("results");
//        System.out.println(new GsonBuilder().create().fromJson(results.toString(), Product.class));

        for (int ele = 0; ele < results.size(); ele++) {
            Product product = new GsonBuilder().create().fromJson(results.get(ele), Product.class);
            products.add(product);
        }
//        System.out.println(products);
//        System.out.println(products.getClass());
        return products;
    }


}
