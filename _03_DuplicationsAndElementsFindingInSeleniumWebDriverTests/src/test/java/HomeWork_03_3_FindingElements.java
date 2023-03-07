import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_03_3_FindingElements {

    private WebDriver driver;

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
    public void testOnlinCinemaFindingFields() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var passwordElement = driver.findElement(By.id("password"));
        var passwordConfirmElement = driver.findElement(By.name("confirm_password"));
    }

    @Test
    public void testShoeShopPositiveScriptHighBound() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("44");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.className("error")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testShoeShopPositiveScriptLowBound() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("34");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.className("error")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals(expectedResult, actualResult);

    }

}
