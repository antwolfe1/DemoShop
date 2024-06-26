package com.pokeapp.pokeshop.inventory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class ApiService {

    @Value("${api.baseUrl}")
    @Getter
    private String baseUrl = "https://pokeapi.co/api/v2";
    private String productsUrl = "/pokemon/?limit=151/";

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
        System.out.println(this.getRequestedUrl());
        URL requestedUrl = new URI(this.getRequestedUrl()).toURL();
        conn = (HttpURLConnection) requestedUrl.openConnection();
        conn.setRequestMethod("GET");
        return conn;
    }


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
