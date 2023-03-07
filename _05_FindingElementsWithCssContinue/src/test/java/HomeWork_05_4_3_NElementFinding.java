import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_05_4_3_NElementFinding {
    private static WebDriver driver;

    private By amateurClubLocator = By.cssSelector("section.important-section-block[for='main-header-page'] > h1:first-child");
    private By loginFormRowLocator = By.cssSelector("form.form#login-form > p:last-child");
    private By footerLocator = By.cssSelector("body > *:nth-child(3)");
    private By allTheFirstRawsOfDivFooterMenuListLocator = By.cssSelector("div.footer__menuList > a:nth-of-type(1)");
    private By fromTheFeetLocator = By.cssSelector("div.footer__menu > div:nth-child(1) > a:nth-of-type(1)");


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
    public void testAmateurClubLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        Assert.assertTrue(driver.findElement(amateurClubLocator).isDisplayed());
    }

    @Test
    public void testLoginFormRowLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        Assert.assertTrue(driver.findElement(loginFormRowLocator).isDisplayed());
    }

    @Test
    public void testFooterLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        Assert.assertTrue(driver.findElement(footerLocator).isDisplayed());
    }

    @Test
    public void testAllTheFirstRawsOfDivFooterMenuListLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        Assert.assertEquals(5, driver.findElements(allTheFirstRawsOfDivFooterMenuListLocator).size());
    }

    @Test
    public void testFromTheFeetLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        Assert.assertTrue(driver.findElement(fromTheFeetLocator).isDisplayed());
    }

}
