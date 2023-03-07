import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_06_5_1ImplicitExpectationsOfElements {
    private static WebDriver driver;
    private By header_P_ElementsLocator = By.cssSelector(".header p");
    private By divText_A_ElementsLocator = By.cssSelector(".text > a");
    private By onThisYear_A_ElementLocator = By.cssSelector("div:nth-child(3) > a");

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testHeader_P_ElementsLocator() {
        driver.navigate().to("C:\\Users\\SAKar\\Desktop\\Тестирование\\Selenium_Project\\_06_ComplexCSSLocatorsAndElementsWaiting\\src\\test\\htmiPages\\a.html");
        Assert.assertEquals(3, driver.findElements(header_P_ElementsLocator).size());
    }

    @Test
    public void testDivText_A_ElementsLocator() {
        driver.navigate().to("C:\\Users\\SAKar\\Desktop\\Тестирование\\Selenium_Project\\_06_ComplexCSSLocatorsAndElementsWaiting\\src\\test\\htmiPages\\b.html");
        Assert.assertEquals(2, driver.findElements(divText_A_ElementsLocator).size());
    }

    @Test
    public void testOnThisYear_A_ElementLocator() {
        driver.navigate().to("C:\\Users\\SAKar\\Desktop\\Тестирование\\Selenium_Project\\_06_ComplexCSSLocatorsAndElementsWaiting\\src\\test\\htmiPages\\c.html");
        Assert.assertEquals(1, driver.findElements(onThisYear_A_ElementLocator).size());
    }
}
