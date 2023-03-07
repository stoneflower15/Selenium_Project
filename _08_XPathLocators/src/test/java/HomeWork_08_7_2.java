import org.openqa.selenium.By;

public class HomeWork_08_7_2 {

    private By fifthCourseTitle = By.xpath("//div[@class='pageCreate__cards']/div[5]//span");
    private By lastCourseDate = By.xpath("//div[@class='pageCreate__cards']/div[last()]//div[@class='baseCard__label']");
    private By divParents = By.xpath("//*[@href='#']//parent::div");
    private By fifthDivElement = By.xpath("//div[5]//a[@href='#']//parent::div");
    private By allParentsOfAllCoursesTitle = By.xpath("//div[@class='pageCreate__title']/ancestor::*");

}
