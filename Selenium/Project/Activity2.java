package FST_Selenium_Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Activity2 {
    WebDriver driver;
    @Test
    public void VerifyHeader() {
        WebElement header = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']"));
        Assert.assertEquals(header.getText(), "Learn from Industry Experts");
    }
    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        WebDriverManager.firefoxdriver().setup();
        System.out.println("Launching Firefox browser..");
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }
    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.close();
    }

}