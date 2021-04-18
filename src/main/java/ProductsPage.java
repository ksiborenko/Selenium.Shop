import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    private final WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void productsSelection() {
        this.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> products = this.driver.findElements(By.cssSelector("h4.product-name"));
        for (int x = 0; x < products.size(); x++) {
            String name = products.get(x).getText();
            if (name.contains("Cucumber") || name.contains("Carrot") || name.contains("Tomato") || name.contains("Beans")) {
                this.driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(x).click();
            }
        }
    }
}
