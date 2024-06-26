package com.pokeapp.pokeshop.inventory;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URISyntaxException;

public class InventoryRepository {

    
    private InventoryRepository() {}
    
    public static InventoryRepository createInstance() { return new InventoryRepository();}

    public JsonObject getAll() throws IOException, URISyntaxException {
        ApiService apiService = ApiService.createInstance();
        return apiService.getData();
    }
}
