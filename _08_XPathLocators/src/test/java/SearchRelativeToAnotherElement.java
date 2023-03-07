import org.openqa.selenium.By;

public class SearchRelativeToAnotherElement {
    private By page1Locator = By.xpath("//section/div/a");
    private By page2Locator = By.xpath("//ul[3]/preceding-sibling::*/li[@important]/a");
    private By page3Locator = By.xpath("//form/p[3]/input//preceding-sibling::*");
    private By page4Locator = By.xpath("//form/p[1]/following-sibling::p");
    private By page5Locator = By.xpath("//form/p[1]/following-sibling::p/label");
}
