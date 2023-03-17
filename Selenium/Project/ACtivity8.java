package FST_Selenium_Project1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class ACtivity8 {
    WebDriver driver;

    @Test
    // @Parameters({"name", "email", "subject", "msg"})
    public void fnContactUs() {

        WebElement Contact = driver.findElement(By.xpath("//a[contains(text(),'Contact')]"));
        Contact.click();
        //String title = driver.getTitle();
        //System.out.println(title);

        String ExpPageTitle = "Contact – Alchemy LMS";

        boolean flag = false;

        if (driver.getTitle().equalsIgnoreCase(ExpPageTitle)) {
            flag = true;

            System.out.println("Yeah page title Matched ");

            WebElement Fullname = driver.findElement(By.name("wpforms[fields][0]"));
            Fullname.sendKeys("Akhil");

            Actions a = new Actions(driver);
            a.moveToElement(Fullname);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            WebElement Email = driver.findElement(By.id("wpforms-8-field_1"));
            Email.sendKeys("HelloWorld@gmail.com");

            a.moveToElement(Email);

            WebElement Subject = driver.findElement(By.id("wpforms-8-field_3"));
            Subject.sendKeys("Subject Will be Subject Only ");

            a.moveToElement(Subject);

            WebElement Comment = driver.findElement(By.id("wpforms-8-field_2"));
            Comment.sendKeys("I am IronMan");

            a.moveToElement(Subject);

            WebElement Submit = driver.findElement(By.xpath("//button[text()='Send Message']"));
            Submit.click();

            a.moveToElement(Submit);




            // String title = driver.getTitle();
            //System.out.println(title);



            String ExpPageTitle3 = "Contact – Alchemy LMS";

            boolean flag3 = false;

            if (driver.getTitle().equalsIgnoreCase(ExpPageTitle3)) {
                flag3 = true;

                String text = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']//p[1]")).getText();
                System.out.println(text);

            }

            else {
                System.out.println("We are Not in Correct Browser");
            }


            // System.out.println("Akhil Hii");

            // driver.close();

        }

        else {
            System.out.println("We are not in Correct Browser,Please check your Script");
        }

    }

            @BeforeClass
            public void beforeClass () {
                WebDriverManager.firefoxdriver().setup();
                System.out.println("Launching Firefox browser..");
                driver = new FirefoxDriver();
                driver.get("https://alchemy.hguy.co/lms");
            }

            @AfterClass
            public void afterClass () {
                driver.close();
            }
        }


