package com.pokeapp.pokeshop.inventory.product;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ProductController {

    private ProductDAL productDAL = ProductDAL.createInstance();

    private ProductController(){}

    public static ProductController createInstance() {
        return new ProductController();
    }


    public List<JsonObject> getAll() throws IOException, URISyntaxException {
        return this.productDAL.getAll();
    }
}
