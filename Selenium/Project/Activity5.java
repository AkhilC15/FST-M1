package FST_Selenium_Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;
    @Test
    public void NavigateMyAccount() {
        WebElement Account = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
        Account.click();

        // String title = driver.getTitle();
        //   System.out.println(title);

        String ExpPageTitle = "My Account – Alchemy LMS" ;

        boolean flag = false ;

        if (driver.getTitle().equalsIgnoreCase(ExpPageTitle)){
            flag = true ;

            System.out.println("Yeah page title Matched ");
        }

        else {
            System.out.println(("Page Title not Matched"));
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