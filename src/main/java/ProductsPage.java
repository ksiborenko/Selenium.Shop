import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsPage {

    private final WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void productsSelection() {
        this.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> products = this.driver.findElements(By.xpath("//h4[@class='product-name']"));
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().contains("Brocolli") ||
                    products.get(i).getText().contains("Tomato") ||
                    products.get(i).getText().contains("Brinjal") ||
                    products.get(i).getText().contains("Onion") ||
                    products.get(i).getText().contains("Walnuts")) {
                this.driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
            }
        }
    }

    public void cart() {
        this.driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        this.driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
    }
    public void discountCode() {
        this.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        this.driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
    }
}
