package com.pokeapp.pokeshop.inventory;

import com.google.gson.*;
import com.pokeapp.pokeshop.inventory.product.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class ApiService {

    @Value("${api.baseUrl}")
    @Getter
    private String baseUrl = "https://pokeapi.co/api/v2";
    @Getter private String productsUrl = "/pokemon/?limit=151/";

    @Getter
    @Setter
    private String requestedUrl;

    private ApiService() {}

    public static ApiService createInstance() {
        return new ApiService();
    }


    public HttpURLConnection get() throws URISyntaxException, IOException {
        HttpURLConnection conn;
        this.setRequestedUrl(this.baseUrl);
        URL url = new URI(this.baseUrl).toURL();
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        return conn;
    }


    public HttpURLConnection get(String url) throws IOException, URISyntaxException {
        HttpURLConnection conn;
        String combinedUrl = this.baseUrl + url;
        this.setRequestedUrl(combinedUrl);
//        System.out.println("getOverloadedFunction: " + this.getRequestedUrl());
        URL requestedUrl = new URI(this.getRequestedUrl()).toURL();
        conn = (HttpURLConnection) requestedUrl.openConnection();
        conn.setRequestMethod("GET");
        return conn;
    }


//    public JsonObject getData() {
//        String url = this.getBaseUrl() + this.getProductsUrl();
//        ResponseEntity<Product> responseEntity = new RestTemplate().getForEntity(url, Product.class);
//        System.out.println(responseEntity.);
//        Product object = responseEntity.getBody();
//        System.out.println(object);
////        MediaType conType = responseEntity.getHeaders().getContentType();
////        HttpStatus status = (HttpStatus) responseEntity.getStatusCode();
//        return new JsonObject();
////        return object;
//    }


    public JsonObject getData() throws IOException, URISyntaxException {
        String inputLine;
        HttpURLConnection conn = this.get(this.productsUrl);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder content = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            content.append(inputLine);
        }

        return JsonParser.parseString(content.toString()).getAsJsonObject();
    }



}
