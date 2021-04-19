import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {

    private WebDriver driver;
    private ProductsPage productsPage;
    private Implicit implicit;

    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.productsPage = new ProductsPage(this.driver);
        this.implicit = new Implicit(this.driver);
    }

    @Test
    public void shop() {
        this.productsPage.productsSelection();
        this.productsPage.cart();
    }
    @Test
    public void implicit() throws InterruptedException {
        this.implicit.test();
    }

}
