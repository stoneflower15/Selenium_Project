import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FindingWithAttributeValue {

    private By page1Locator = By.xpath("//p[2]");
    private By page2Locator = By.xpath("//section/p");
    private By page3Locator = By.xpath("//div[contains(@class, 'text')]/a");
    private By page4Locator = By.xpath("//*[contains(@class, 'b-header-b-personal')]");
    private By page5Locator = By.xpath("//input[3]");

}
