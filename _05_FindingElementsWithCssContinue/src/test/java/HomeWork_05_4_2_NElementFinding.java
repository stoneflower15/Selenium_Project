import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_05_4_2_NElementFinding {
    private static WebDriver driver;

    private By footersDivChildLocator = By.cssSelector("footer#footer > div");
    private By liIdGenresFirstChildLocator = By.cssSelector("li#genres > :first-child");
    private By divClassFilterContainerSecondChildLocator = By.cssSelector("div.filter-container > *:nth-child(2)");


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
    public void testFootersDivChildLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        Assert.assertEquals(3, driver.findElements(footersDivChildLocator).size());
    }

    @Test
    public void testLiIdGenresFirstChildLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        Assert.assertTrue(driver.findElement(liIdGenresFirstChildLocator).isDisplayed());
    }

    @Test
    public void testDivClassFilterContainerNthChildLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        Assert.assertTrue(driver.findElement(divClassFilterContainerSecondChildLocator).isDisplayed());
    }

}
