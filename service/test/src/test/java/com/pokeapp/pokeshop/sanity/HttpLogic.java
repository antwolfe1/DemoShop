package com.pokeapp.pokeshop.sanity;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpLogic {
    @Value("${api.url}")
    String url;

    private HttpLogic(String url) {
        this.url = url;
    }

    public static HttpLogic createInstance(String url) {
        return new HttpLogic(url);
    }

    public int getResponseCode() throws IOException {
        int response;
        URL url;
        HttpURLConnection conn;
        url = new URL(this.url);
        conn = (HttpURLConnection) url.openConnection();
        response = conn.getResponseCode();
        return response;
    }
}
