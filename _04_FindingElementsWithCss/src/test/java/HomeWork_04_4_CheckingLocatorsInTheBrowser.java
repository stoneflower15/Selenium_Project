import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_04_4_CheckingLocatorsInTheBrowser {
    private WebDriver driver;
    private By nameLocator = By.cssSelector(".form-input.fio");
    private By streetLocator = By.cssSelector(".data.form-input.street");
    private By houseLocator = By.cssSelector(".form-input.house");
    private By flatLocator = By.cssSelector(".form-input.flat");
    private By masterComingDayLocator = By.cssSelector(".form-input.date");
    private By submitButtonLocator = By.className("form-submit");
    private By formResultLocator = By.className("form-result-data");

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
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");

        driver.findElement(nameLocator).sendKeys("Вася");
        driver.findElement(streetLocator).sendKeys("Южная");
        driver.findElement(houseLocator).sendKeys("1");
        driver.findElement(flatLocator).sendKeys("5");
        driver.findElement(masterComingDayLocator).sendKeys("Сегодня");
        driver.findElement(submitButtonLocator).click();
        Assert.assertTrue("Не отобразится текст про введенные данные", driver.findElement(formResultLocator).isDisplayed());
    }
}
