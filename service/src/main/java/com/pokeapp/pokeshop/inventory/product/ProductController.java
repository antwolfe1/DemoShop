package com.pokeapp.pokeshop.inventory.product;

import com.google.gson.JsonObject;
import com.pokeapp.pokeshop.inventory.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ProductController {

    private ProductRepository productRepository = ProductRepository.createInstance();

    private ProductController(){}

    public static ProductController createInstance() {
        return new ProductController();
    }


    public List<Product> getAll() throws IOException, URISyntaxException {
        System.out.println(this.productRepository.getAll().getClass());
        return this.productRepository.getAll();
//        ResponseEntity<JsonObject> responseEntity = new RestTemplate().getForEntity(ApiService.createInstance().getProductsUrl(), JsonObject.class);
//        JsonObject object = responseEntity.getBody();
//        MediaType conType = responseEntity.getHeaders().getContentType();
//        HttpStatus status = (HttpStatus) responseEntity.getStatusCode();
    }
}
