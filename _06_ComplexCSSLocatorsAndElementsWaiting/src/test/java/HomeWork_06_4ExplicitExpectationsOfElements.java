import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeWork_06_4ExplicitExpectationsOfElements {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private Duration waitTime = Duration.ofSeconds(1);

// Для сайта онлайн-ежедневника составьте один тест, в котором:
//
//Перейдите на страницу.
//Кликните по значку + справа от текста «Все записи».
//Дождитесь отображения лайтбокса и введите:
//заголовок новой записи;
//текст новой записи.
//Кликните «Добавить заметку».
//Проверьте, что лайтбокс теперь невидимый.
//Проверьте, что справа в списке «Все записи» у самой первой записи заголовок равен тому, который вы только что вводили.
//Проверьте, что справа в списке «Все записи» у самой первой записи текст равен тому, который вы только что вводили.
// Для самопроверки запустите реализованный тест: прошёл ли он успешно?


    private By plusButtonLocator = By.cssSelector("button.pageCreate__sidebarHeaderAdd > svg > use");
    private By lightBoxLocator = By.cssSelector("div.popup__wrapper");
    private By titleOfNewNoteLocator = By.cssSelector("div.baseInput.popup__baseInput > input.baseInput__field");
    private By textOfNewNoteLocator = By.cssSelector("div.baseTextarea.popup__textarea textarea.baseTextarea__text");
    private By addNoteLocator = By.cssSelector("div.popup__content > button.baseButton.popup__baseButton");
    private By allNotesFirstNoteTitleLocator = By.cssSelector("div.vb-content > div:nth-child(1)  p.articlePreview__title");
    private By allNotesFirstNoteTextLocator = By.cssSelector("div.vb-content > div:nth-child(1)  p.articlePreview__text");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,waitTime);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testOnlineDairy() {
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/");
        driver.findElement(plusButtonLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(lightBoxLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(titleOfNewNoteLocator));
        var title = "новая";
        driver.findElement(titleOfNewNoteLocator).sendKeys(title);
        wait.until(ExpectedConditions.presenceOfElementLocated(textOfNewNoteLocator));
        var text = "текст новой";
        driver.findElement(textOfNewNoteLocator).sendKeys(text);
        wait.until(ExpectedConditions.presenceOfElementLocated(addNoteLocator));
        driver.findElement(addNoteLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lightBoxLocator));
        Assert.assertEquals("Не правильный текст заголовка записи",title,driver.findElement(allNotesFirstNoteTitleLocator).getText());
        Assert.assertEquals("Не правильный текст содержимого записи",text,driver.findElement(allNotesFirstNoteTextLocator).getText());

    }

}
