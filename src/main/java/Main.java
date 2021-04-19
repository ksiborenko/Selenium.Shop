import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {

    private WebDriver driver;
    private Shop shop;

    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.shop = new Shop(this.driver);
    }

    @Test
    public void shop() {
        this.shop.productsSelection();
        this.shop.cart();
        this.shop.discountCode();
        this.shop.proceed();
    }
}
