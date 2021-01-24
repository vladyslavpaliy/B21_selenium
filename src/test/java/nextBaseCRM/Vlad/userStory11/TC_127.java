package nextBaseCRM.Vlad.userStory11;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import nextBaseCRM.Utility.NextBaseCRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC_127 {

    WebDriver driver;

    @BeforeMethod
    public void openDriver() throws InterruptedException {
        //  Open Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://login2.nextbasecrm.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // 1 seconds wait before type data
        Thread.sleep(1000);
    }

    @Test
    public void negativeTest() throws InterruptedException {
      // AC_2: Helpdesk cannot access to time and report module. (Negative)

        // 1. Data for login
        String helpDesklogin = "helpdesk50@cybertekschool.com";
        // Data for password
        String password = "UserUser";
        // type User name
        driver.findElement(By.name("USER_LOGIN")).sendKeys(helpDesklogin);
        // type Password
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);
        // Click login button
        driver.findElement(By.className("login-btn")).click();
        // Login is passed
        // So now we are on main page of nextbasecrm.com
        // Find om Module Time and Reports and click
        driver.findElement(By.xpath("(//span[@class='menu-item-link-text'])[9]")).click();
        // HR able to access Time and Reports, go logout now
        Thread.sleep(1000);
        // Found bug, "helpdesk" can access to time and report module.


    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
