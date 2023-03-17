package FST_Selenium_Project1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
public class Activity9 {
    WebDriver driver;

    @Test
   // @Parameters({"username", "password"})
    public void NavigateMyAccount() {
        WebElement Account = driver.findElement(By.xpath("//a[contains(text(),'All Courses')]"));
        Account.click();

        WebElement SelectAnyCourse = driver.findElement(By.xpath("(//a[@role='button'])[1]"));
        SelectAnyCourse.click();
        String ExpPageTitle4 = "Social Media Marketing – Alchemy LMS";

        boolean flag4 = false;

        if (driver.getTitle().equalsIgnoreCase(ExpPageTitle4)) {
            flag4 = true;

            String text = driver.findElement(By.tagName("h1")).getText();
            System.out.println(text);

        }

        else {
            System.out.println("We are Not in Correct Browser");
        }

        Boolean isPresent = driver.findElement(By.cssSelector("input[type='submit']")).isDisplayed();
        if(isPresent){
            driver.findElement(By.cssSelector("input[type='submit']")).click();
        }


        // String title = driver.getTitle();
        //System.out.println(title);
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