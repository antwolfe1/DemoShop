package com.pokeapp.pokeshop.sanity;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HttpLogic {
    @Value("${api.baseUrl}")
    String url;


    private HttpLogic(String url) {
        this.url = url;
    }

    public static HttpLogic createInstance(String url) {
        return new HttpLogic(url);
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