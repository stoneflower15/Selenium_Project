import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_06_5_2ImplicitExpectationsOfElements {
    private static WebDriver driver;
    private By inputNotIdLocator = By.cssSelector("input:not([id])");
    private By pBeginsFormNotEndsErrorLocator = By.cssSelector("p[class^='form']:not([class$='error'])");
    private By onThisYear_A_ElementLocator = By.cssSelector("div.form-inner p.form-row:nth-of-type(1)");

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
    public void testInputNotIdLocator() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
        Assert.assertTrue(driver.findElement(inputNotIdLocator).isDisplayed());
    }

    @Test
    public void testPBeginsFormNotEndsErrorLocator() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
        Assert.assertEquals(3, driver.findElements(pBeginsFormNotEndsErrorLocator).size());
    }

    @Test
    public void testOnThisYear_A_ElementLocator() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
        Assert.assertTrue(driver.findElement(onThisYear_A_ElementLocator).isDisplayed());
    }
}
