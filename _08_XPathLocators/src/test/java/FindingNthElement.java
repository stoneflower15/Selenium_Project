import org.openqa.selenium.By;

public class FindingNthElement {
    private By page1Locator = By.xpath("//form/p[3]");
    private By page2Locator = By.xpath("(//form/p)[last()]");
    private By page3Locator = By.xpath("//form/p[2]/label");
}
