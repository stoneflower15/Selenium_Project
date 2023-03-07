import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_04_3_FindingElementsWithCSS {
    private WebDriver driver;
    private By nameLocator = By.cssSelector(".data.text");
    private By emailLocator = By.cssSelector(".data.field");
    private By textCommentLocator = By.cssSelector(".field.text");
    private By buttonLocator = By.id("comment");
    private By messageLocator = By.className("message-header");


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
    public void testFeedbackAllFields() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");

        var email = "test@test.ru";
        driver.findElement(nameLocator).sendKeys("Вася");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(textCommentLocator).sendKeys("Всё отлично!");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Не отобразится текст про спасибо", driver.findElement(messageLocator).isDisplayed());
    }
}
