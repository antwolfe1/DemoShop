package com.pokeapp.pokeshop.inventory.product;

import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {
    @Value("${api.baseUrl}")
    public String url;


    private ApiService(String url) {
        this.url = url;
    }

    public static ApiService createInstance(String url) {
        return new ApiService(url);
    }

    public int getResponseCode() throws IOException {
        int status;
        URL url;
        HttpURLConnection conn;
        url = new URL(this.url);
        conn = (HttpURLConnection) url.openConnection();
        status = conn.getResponseCode();
        return status;
    }


    public String getPokemonData() throws IOException {
        String inputLine;
        URL url;
        HttpURLConnection conn;
        url = new URL(this.url);
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder content = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            content.append(inputLine);
        }

        return content.toString();
    }


}