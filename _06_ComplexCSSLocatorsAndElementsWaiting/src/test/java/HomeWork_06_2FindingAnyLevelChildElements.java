import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_06_2FindingAnyLevelChildElements {
    private static WebDriver driver;

//    Для сайта онлайн-института составьте локаторы, для них:
//    Найдите все теги div, которые являются дочерними элементами любого уровня для элемента <div class="pageCreate__cards">.
//    Подсказка для самоконтроля: их 72.
    private By anyLevelChildElementLocator = By.cssSelector("div.pageCreate__cards div");

//    Найдите все элементы, которые находятся на первом уровне вложенности для элемента <div class="baseFooter">.
//    Подсказка для самоконтроля: их 2.
    private By allFirstLevelChildLocator = By.cssSelector("div.baseFooter > *");

//    Сначала укажите, что ищете <div class="pageCreate">,
//    внутри которого на первом уровне вложенности ищете <div class="pageCreate__cards">,
//    внутри которого ищете на любом уровне вложенности теги <img>. Подсказка для самоконтроля: их 8.
    private By anyLevelImgLocator = By.cssSelector("div.pageCreate > div.pageCreate__cards img");

//    Найдите первый <div class="baseCard pageCreate__card">,
//    внутри которого на любом уровне вложенности найдите теги <p>. Подсказка для самоконтроля: их 3.
    private By anyLevelPLocator = By.cssSelector("div.pageCreate__cards>div:first-child p");



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
    public void testAnyLevelChildElementLocator() {
        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");
        Assert.assertEquals(72, driver.findElements(anyLevelChildElementLocator).size());
    }

    @Test
    public void testAllFirstLevelChildLocator() {
        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");
        Assert.assertEquals(2, driver.findElements(allFirstLevelChildLocator).size());
    }

    @Test
    public void testAnyLevelImgLocator() {
        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");
        Assert.assertEquals(8, driver.findElements(anyLevelImgLocator).size());
    }

    @Test
    public void testAnyLevelPLocator() {
        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");
        Assert.assertEquals(3, driver.findElements(anyLevelPLocator).size());
    }


}
