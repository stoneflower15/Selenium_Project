import org.openqa.selenium.By;

public class HomeWork_08_7_3 {
    private By linkAboutUs = By.xpath("//a[@test-info='about-us']");
    private By titleBestsellers = By.xpath("//li/a[text()='Бестселлеры']");
    private By searchInputForm = By.xpath("//*[@id=\"search-input\"]");
    private By totalAmount = By.xpath("//*[@id=\"total\"]");
    private By titleYourOrder = By.xpath("//*[@id=\"order-info\"]/div[1]");
    private By cancelButton = By.xpath("//button[text()='Отменить']");
}
