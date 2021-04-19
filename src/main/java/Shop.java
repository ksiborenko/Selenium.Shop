import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Shop {

    private final WebDriver driver;

    public Shop(WebDriver driver) {
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
        this.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        this.driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        this.driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        assertTrue(this.driver.findElement(By.xpath("//span[@class='promoInfo']")).isDisplayed());
        this.driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
    }

    public void proceed() {
        WebElement element = this.driver.findElement(By.xpath("//div[@class='products']//select"));
        Select list = new Select(element);
        list.selectByVisibleText("Poland");
        this.driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
        assertTrue(this.driver.findElement(By.xpath("//b[contains(text(),'Please accept Terms & Conditions - Required')]")).isDisplayed());
        this.driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        this.driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
        String url = this.driver.getCurrentUrl();
        assertEquals("https://rahulshettyacademy.com/seleniumPractise/#/country", url);
    }
}
