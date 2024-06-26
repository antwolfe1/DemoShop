package com.pokeapp.pokeshop.inventory;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URISyntaxException;

public class InventoryRepository {

    private ApiService apiService = ApiService.createInstance();
    
    private InventoryRepository() {}
    
    public static InventoryRepository createInstance() { return new InventoryRepository();}

    public JsonObject getAll() throws IOException, URISyntaxException {
        return apiService.getData();
    }
}
