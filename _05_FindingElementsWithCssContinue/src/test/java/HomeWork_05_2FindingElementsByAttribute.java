import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_05_2FindingElementsByAttribute {
    private WebDriver driver;
    private By emailLocator = By.cssSelector("[data='email']");
    private By passwordLocator = By.cssSelector("[data*='password']");
    private By submitButtonLocator = By.cssSelector(".form-submit[id='submit']");
    private By messageErrorLocator = By.cssSelector("[id=error][class^=form-error]");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFunnySocksClubAuthErrorMessage() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");

        driver.findElement(emailLocator).sendKeys("@");
        driver.findElement(passwordLocator).sendKeys("123");
        driver.findElement(submitButtonLocator).click();
        Assert.assertTrue("Не отобразится текст про ошибку", driver.findElement(messageErrorLocator).isDisplayed());
    }
}
