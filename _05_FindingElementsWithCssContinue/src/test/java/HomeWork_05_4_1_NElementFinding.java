import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_05_4_1_NElementFinding {
    private static WebDriver driver;

    private By aboutUsLocator = By.cssSelector("[test-info='about-us']");
    private By footerLinksLocator = By.cssSelector("a[href='']");
    private By optionSelectedElementsLocator = By.cssSelector("option[selected]");
    private By BookPriceElementsLocator = By.cssSelector("div.book-price");
    private By elementsButtonBeginsBookLocator = By.cssSelector("button[class^='book']");
    private By classEndsMainLocator = By.cssSelector("[class$='main']");
    private By classHaveMenuElementsLocator = By.cssSelector("a[class*='menu']");


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
    public void testAboutUsLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        Assert.assertTrue(driver.findElement(aboutUsLocator).isDisplayed());
    }

    @Test
    public void testAHrefEmptyLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        Assert.assertEquals(3, driver.findElements(footerLinksLocator).size());
    }

    @Test
    public void testOptionSelectedLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        Assert.assertEquals(2, driver.findElements(optionSelectedElementsLocator).size());
    }

    @Test
    public void testDivBookPriceLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        Assert.assertEquals(15, driver.findElements(BookPriceElementsLocator).size());
    }

    @Test
    public void testButtonBeginsBookLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        Assert.assertEquals(15, driver.findElements(elementsButtonBeginsBookLocator).size());
    }

    @Test
    public void testClassEndsMainLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        Assert.assertTrue(driver.findElement(classEndsMainLocator).isDisplayed());
    }

    @Test
    public void testAClassHaveMenuLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        Assert.assertEquals(8, driver.findElements(classHaveMenuElementsLocator).size());
    }
}
