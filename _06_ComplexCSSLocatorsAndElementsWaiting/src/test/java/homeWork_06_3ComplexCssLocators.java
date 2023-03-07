import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homeWork_06_3ComplexCssLocators {
    private static WebDriver driver;

//Для сайта онлайн-института составьте локаторы, для них:
//
//Найдите все теги span на странице, у которых нет класса baseCard__title. Подсказка для самоконтроля: их 1.
    private By allSpanNotBaseCard__TitleLocator = By.cssSelector("span:not(.baseCard__title)");

//Найдите все теги button, у которых нет атрибута disabled. Подсказка для самоконтроля: их всего 8.
    private By allButtonNotDisabledLocator = By.cssSelector("button:not(disabled)");

//У четвёртого по счёту курса (то есть четвёртого элемента типа <div class="baseCard pageCreate__card">)
// найдите все дочерние элементы любого уровня с классом baseButton и без класса baseButton--noBorder одновременно.
// Подсказка для самоконтроля: всего 1 такой элемент.
    private By baseButtonNotNoBorderLocator = By.cssSelector("div.pageCreate__cards>div:nth-of-type(4) .baseButton:not(.baseButton--noBorder)");



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
    public void testAllSpanNotBaseCard__TitleLocator() {
        driver.navigate().to("http://qa.skillbox.ru/module16/16_2/");
        Assert.assertEquals(1, driver.findElements(allSpanNotBaseCard__TitleLocator).size());
    }

    @Test
    public void testAllButtonNotDisabledLocator() {
        driver.navigate().to("http://qa.skillbox.ru/module16/16_2/");
        Assert.assertEquals(8, driver.findElements(allButtonNotDisabledLocator).size());
    }

    @Test
    public void testBaseButtonNotNoBorderLocator() {
        driver.navigate().to("http://qa.skillbox.ru/module16/16_2/");
        Assert.assertEquals(1, driver.findElements(baseButtonNotNoBorderLocator).size());
    }



}
