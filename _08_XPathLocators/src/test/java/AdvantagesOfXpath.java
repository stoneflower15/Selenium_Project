import org.openqa.selenium.By;

public class AdvantagesOfXpath {
    private By page1Locator = By.xpath("//label[@for='street']/ancestor::*");
    private By page2Locator = By.xpath("//label[@for='door']/ancestor::p");
    private By page3Locator = By.xpath("//input[@id='street']/ancestor::form");
    private By page4Locator = By.xpath("//label[text()='Номер дома']");
}
