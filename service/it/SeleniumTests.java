import com.google.gson.JsonObject;
import com.pokeapp.pokeshop.inventory.InventoryRepository;
import com.pokeapp.pokeshop.inventory.product.ProductController;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTests {


    @Test
    void getProductsPageTitle() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/products");
        WebElement title = driver.findElement(By.className("products-page"));
        assertEquals("Products", title.getText());
        driver.close();
    }

    @Test
    void getProductsOnInventoryPage() throws IOException, URISyntaxException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/products");
        ProductController productController = ProductController.createInstance();
        List<JsonObject> expectedList = productController.getAll();
        List<WebElement> pageProducts = driver.findElements(By.className("products"));
        assertEquals(expectedList, pageProducts);
        driver.close();



//        InventoryView inventoryView = driver.goTo();
//        List<Product> actualProducts = inventoryView.getProductList();
    }
}
