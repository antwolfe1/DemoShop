import com.google.gson.JsonObject;
import com.pokeapp.pokeshop.inventory.ApiService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class SanityTests {

    @Test
    void get200ResponseFromAPI() throws IOException, URISyntaxException {
        ApiService apiService = ApiService.createInstance();
        assertEquals(200, apiService.get().getResponseCode(), "Response from API is not 200");
    }

    @Test
    void checkDataReturnedFromAPI() throws IOException, URISyntaxException {
        String url = "/pokemon/?limit=151/";
        ApiService apiService = ApiService.createInstance();
        // TODO : need to have good place to call URL
        JsonObject results = apiService.getData();
        assertEquals(apiService.getBaseUrl() + url, apiService.getRequestedUrl());
        assertNotNull(results, "Results are empty");
    }

}

