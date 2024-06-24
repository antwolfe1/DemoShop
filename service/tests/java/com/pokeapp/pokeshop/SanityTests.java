package java.com.pokeapp.pokeshop;

import com.pokeapp.pokeshop.services.ApiService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SanityTests {

    String baseUrl = "https://pokeapi.co/api/v2";

    @Test
    void getConnection() throws IOException {
        ApiService apiService = ApiService.createInstance();
        assertEquals(baseUrl, apiService.baseUrl);
        assertEquals(200, apiService.getResponseCode(), "Response from API is not 200");

    }

    @Test
    void getFirst101PokemonData() throws IOException {
        String url = baseUrl + "/pokemon/?limit=151/";
        ApiService apiService = ApiService.createInstance(url);
        Object results = apiService.getPokemonData();
        assertEquals(url, apiService.baseUrl);

        assertNotNull(results, "Results are empty");
    }
}

