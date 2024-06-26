package com.pokeapp.pokeshop.inventory.product;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pokeapp.pokeshop.inventory.InventoryRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAL {
    // Repository
    private InventoryRepository inventoryRepository = InventoryRepository.createInstance();

    private ProductDAL() {
    }

    public static ProductDAL createInstance() {
        return new ProductDAL();
    }


    public List<JsonObject> getAll() throws IOException, URISyntaxException {
        // retrieve all products from repo/api
        JsonObject productList = this.inventoryRepository.getAll();
        List<JsonObject> products = new ArrayList<>(List.of());
        JsonArray results = productList.getAsJsonArray("results");

        for (int ele = 0; ele < results.size(); ele++) {
            JsonObject product = results.get(ele).getAsJsonObject();
            products.add(product);
        }

        return products;
    }


}
