import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_03_2_RemoveCodeDuplication {
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
    public void testHelloComplicatedNormal() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Пупкин Василий Алибабаевич");
        driver.findElement(By.name("email")).sendKeys("pupkin@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("+71234567890");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Пупкин Василий Алибабаевич.\n" +
                "На вашу почту (pupkin@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +71234567890.";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testHelloComplicatedOnlyNameField() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Пупкин Василий Алибабаевич");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Пупкин Василий Алибабаевич.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testHelloComplicatedOnlyEmailField() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("pupkin@mail.ru");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту (pupkin@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testHelloComplicatedOnlyPhoneField() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("phone")).sendKeys("+71234567890");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +71234567890.";
        Assert.assertEquals(expectedResult, actualResult);

    }


    @Test
    public void testHelloComplicatedAllTypesOfSymbols() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("qwe#$%123");
        driver.findElement(By.name("email")).sendKeys("qwe#$%123");
        driver.findElement(By.name("phone")).sendKeys("qwe#$%123");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, qwe#$%123.\n" +
                "На вашу почту (qwe#$%123) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: qwe#$%123.";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testOnlineCinemaNormal() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.name("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.name("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-result")).getText();
        var expectedResult = "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testOnlineCinemaEmptyFields() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-error")).getText();
        var expectedResult = "Введите имя";
        Assert.assertEquals(expectedResult, actualResult);

    }

}
