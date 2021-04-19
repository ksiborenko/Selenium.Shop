import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Implicit {

    private WebDriver driver;

    public Implicit(WebDriver driver) {
        this.driver = driver;
    }

    public void test() throws InterruptedException {
        this.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> products = this.driver.findElements(By.xpath("//h4[@class='product-name']"));
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().contains("Brocolli") ||
                    products.get(i).getText().contains("Tomato") ||
                    products.get(i).getText().contains("Brinjal") ||
                    products.get(i).getText().contains("Onion") ||
                    products.get(i).getText().contains("Walnuts")) {
                this.driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
            }
        }
    }
}
