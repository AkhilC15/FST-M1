package FST_Selenium_Project1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
public class Activity7 {
    WebDriver driver;
    @Test
    public void NumberOfCourses() {
        WebElement AllCourses = driver.findElement(By.xpath("//a[contains(text(),'All Courses')]"));
        AllCourses.click();
        // String title = driver.getTitle();
        //  System.out.println(title);

        String ExpPageTitle = "All Courses – Alchemy LMS";

        boolean flag = false;

        if (driver.getTitle().equalsIgnoreCase(ExpPageTitle)) {
            flag = true;

            System.out.println("Yeah page title Matched ");

            List<WebElement> ListCourses = driver.findElements(By.xpath("//div[@class='ld-course-list-items row']//a/img"));

            System.out.println("No . of Courses : "+ListCourses.size());

        }

        else {
            System.out.println(("Page Title not Matched, Hence Failed"));
        }
    }
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.firefoxdriver().setup();
        System.out.println("Launching Firefox browser..");
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }
    @AfterClass
    public void afterClass() {
        driver.close();
    }
}