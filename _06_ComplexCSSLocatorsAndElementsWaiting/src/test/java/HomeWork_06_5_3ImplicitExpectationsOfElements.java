import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomeWork_06_5_3ImplicitExpectationsOfElements {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private Duration waitTime = Duration.ofSeconds(5);

// Для сайта онлайн-ежедневника составьте один тест, в котором:
//
//Перейдите на страницу.
//Кликните на заметку из списка заметок по центру экрана.
//Дождитесь появления справа от заголовка выбранной записи в разделе «Все записи».
//Проверьте, что у первой записи текст и заголовок равен только что выбранной записи.
//Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
//В разделе «Все записи» выберите самую верхнюю запись (первую).
//Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
//Дождитесь исчезновения записи в разделе «Все записи».
//Проверьте, что справа в списке «Все записи» не видно записей.

    private By noteFromNotesListButtonLocator = By.cssSelector("button.articlePreview__link");
    private By noteFromAllNotesLocator = By.cssSelector("div.vb-content > div:nth-child(1) > button.articlePreview__link");
    private By notesTitleFromAllNotesLocator = By.cssSelector(
            "div.vb-content > div:nth-child(1) > div.articlePreview__content > p.articlePreview__title");
    private By notesTextFromAllNotesLocator = By.cssSelector(
            "div.vb-content > div:nth-child(1) > div.articlePreview__content > p.articlePreview__text");

    private By centralBucketLocator = By.cssSelector("div.pageArticle__buttons > button:nth-child(2) > svg");

    private By allNotesFirstNoteTitleLocator = By.cssSelector("div.vb-content > div:nth-child(1)  p.articlePreview__title");

    private By allNotesFirstNoteTextLocator = By.cssSelector("div.vb-content > div:nth-child(1)  p.articlePreview__text");

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
    public void testOnlineDairy() {
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
        driver.findElement(noteFromNotesListButtonLocator).click();
        var title = "План на следующий месяц";
        Assert.assertEquals("Не правильный текст заголовка записи",
                title, driver.findElement(notesTitleFromAllNotesLocator).getText());
        var text = "Прочитать книгу «Искусство цвета».";
        Assert.assertEquals("Не правильный текст содержимого записи",
                text, driver.findElement(notesTextFromAllNotesLocator).getText());
        driver.findElement(centralBucketLocator).click();
        driver.findElement(noteFromNotesListButtonLocator).click();
        driver.findElement(centralBucketLocator).click();
        Assert.assertEquals(0, driver.findElements(noteFromAllNotesLocator).size());
    }
}
