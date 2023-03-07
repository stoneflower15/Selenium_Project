import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_03_4_1_FindingElementsContinue {

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
//Задание 3.4.1
    @Test
    public void testShoeShopPositive() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("34");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.className("error")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testShoeShopNegative() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("33");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.className("error")).getText();
        var expectedResult = "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals("Неверный текст при проверке наличия обуви по введенному размеру",
                expectedResult, actualResult);

    }

//Задание 3.4.2
    @Test
    public void testBookShopFindElementsByLocators() {

        driver.navigate().to("http://qajava.skillbox.ru/");
        var feedbackLink = driver.findElements(By.tagName("a")).get(0);
        var preorderLink = driver.findElements(By.tagName("a")).get(1);
        var addToCart = driver.findElement(By.className("book-add"));
        var cartCount = driver.findElement(By.id("cart_count"));
        var genres = driver.findElement(By.id("genres"));
        var searchField = driver.findElement(By.id("search-input"));

    }


//Задание 3.4.3
    @Test
    public void testBookShopFind15FromBookInfo() {

        driver.navigate().to("http://qajava.skillbox.ru/");
        var books = driver.findElements(By.className("book-info"));
        Assert.assertEquals("неверное количество элементов <div class=\"book-info\">", 15, books.size());


    }

}
