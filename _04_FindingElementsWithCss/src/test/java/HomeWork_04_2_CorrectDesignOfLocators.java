import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_04_2_CorrectDesignOfLocators {
    private WebDriver driver;
    private By emailLocator = By.className("email");
    private By writeToMeLocator = By.id("write-to-me");
    private By resultEmailLocator = By.className("result-email");
    private By dogsMaleLocator = By.id("boy");
    private By dogsFemaleLocator = By.id("girl");
    private By dogsResultEmailLocator = By.className("your-email");
    private By dogsChooseNameLocator = By.id("sendMe");
    private By dogsEmailLocator = By.name("email");

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
    public void testKittens() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");

        var email = "test@test.ru";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(writeToMeLocator).click();
        Assert.assertTrue("Не отобразится текст про email",driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("Не правильный текст про email",email,driver.findElement(resultEmailLocator).getText());
    }

    @Test
    public void testKittensEmptyEmail() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(writeToMeLocator).click();
        Assert.assertEquals("Не правильный текст про email","",driver.findElement(resultEmailLocator).getText());
    }

    @Test
    public void testDogsNamesForMale() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");

        var email = "test@test.ru";
        driver.findElement(dogsMaleLocator).click();
        driver.findElement(dogsEmailLocator).sendKeys(email);
        driver.findElement(dogsChooseNameLocator).click();

        Assert.assertTrue("Не отобразится текст про email",driver.findElement(dogsResultEmailLocator).isDisplayed());
        Assert.assertEquals("Не правильный текст про email",email,driver.findElement(dogsResultEmailLocator).getText());
    }

    @Test
    public void testDogsNamesForFemale() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");

        var email = "test@test.ru";
        driver.findElement(dogsFemaleLocator).click();
        driver.findElement(dogsEmailLocator).sendKeys(email);
        driver.findElement(dogsChooseNameLocator).click();

        Assert.assertTrue("Не отобразится текст про email",driver.findElement(dogsResultEmailLocator).isDisplayed());
        Assert.assertEquals("Не правильный текст про email",email,driver.findElement(dogsResultEmailLocator).getText());
    }
}
