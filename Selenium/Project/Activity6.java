package FST_Selenium_Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    @Test
   // @Parameters({"username", "password"})
    public void NavigateMyAccount( ) {
        WebElement Account = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
        Account.click();

        //Verifying Page Title To - Click Account option or not

        String ExpPageTitle = "My Account – Alchemy LMS" ;

        boolean flag = false ;

        if (driver.getTitle().equalsIgnoreCase(ExpPageTitle)){
            flag = true ;

            System.out.println("Yeah page title Matched ");

            WebElement LoginButton = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
            LoginButton.click();

            WebElement username = driver.findElement(By.id("user_login"));
            username.sendKeys("root");

            WebElement Password = driver.findElement(By.id("user_pass"));
            Password.sendKeys("pa$$w0rd");

            WebElement Login = driver.findElement(By.id("wp-submit"));

            Login.click();

            //Verifying Page Title to Logged in Successfully or not

            String ExpPage2Title = "My Account – Alchemy LMS" ;

            boolean flag2 = false ;

            if (driver.getTitle().equalsIgnoreCase(ExpPage2Title)){
                flag2 = true ;

                System.out.println("Yeah page title Matched and Logged in Successfully ");
            }

            else {
                System.out.println(("Page Title not Matched, So Not logged in Succesfully"));
            }


        }

        else {
            System.out.println(("Page Title not Matched"));
        }

        // String title = driver.getTitle();
        //   System.out.println(title);











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