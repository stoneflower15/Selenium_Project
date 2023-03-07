import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SkilboxLogoAndSubmitButtonTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private Duration waitTime = Duration.ofSeconds(5);


    private By SkillboxLogoLocator = By.xpath("//header/div[1]/img");
    private By SubmitButtonLocator = By.xpath("//*[@id=\"submit\"]");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, waitTime);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLocators() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");

        Assert.assertTrue( driver.findElement(SkillboxLogoLocator).isDisplayed());
        Assert.assertTrue( driver.findElement(SubmitButtonLocator).isDisplayed());
    }

}
