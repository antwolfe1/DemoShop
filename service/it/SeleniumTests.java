import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

//    @Test
//    void getProductsOnInventoryPage() {
//        driver = PokeshopClient().getWebDriver();
//        InventoryRepository
//        InventoryView inventoryView = driver.goTo();
//        List<Product> actualProducts = inventoryView.getProductList();
//        assertEqual();
//    }
}
