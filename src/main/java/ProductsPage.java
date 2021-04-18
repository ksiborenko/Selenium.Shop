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
            if (products.get(x).getText().contains("Cucumber") || products.get(x).getText().contains("Apple") ||
                    products.get(x).getText().contains("Musk Melon") || products.get(x).getText().contains("Almonds")) {
                this.driver.findElements(By.xpath("//div[@class='product-action']")).get(x).click();
            }
        }
    }
}
