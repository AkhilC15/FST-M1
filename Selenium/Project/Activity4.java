package FST_Selenium_Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Activity4 {
    WebDriver driver;
    @Test
    public void VerifyPopularCourses() {
        WebElement PopularCourses=driver.findElement(By.xpath("(//div//h3[@class='entry-title'])[2]"));
        Assert.assertEquals(PopularCourses.getText(), "Email Marketing Strategies");
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