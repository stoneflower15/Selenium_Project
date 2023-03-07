import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_04_5_5_FindingElementsByTagAndId {
    private WebDriver driver;
    private By emailLocator = By.cssSelector("input.form-input.input-data#email");
    private By passwordLocator = By.cssSelector("input.form-input.password#password");
    private By submitButtonLocator = By.cssSelector("button.form-submit#submit");
    private By messageErrorLocator = By.cssSelector("pre.form-error-password-email#error");

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
    public void testMasterCalling() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");

        driver.findElement(emailLocator).sendKeys("@");
        driver.findElement(passwordLocator).sendKeys("123");
        driver.findElement(submitButtonLocator).click();
        Assert.assertTrue("Не отобразится текст про ошибку", driver.findElement(messageErrorLocator).isDisplayed());
    }
}
