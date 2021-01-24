package nextBaseCRM.Vlad.userStory11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class TC_126 {
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
    public void positiveDataTest() throws InterruptedException {
        // AC_1: users (hr, marketing only ) access to time and report module.

        // 1. Data for login
        String hrlogin = "hr50@cybertekschool.com";
        // Data for password
        String password = "UserUser";
        // type User name
        driver.findElement(By.name("USER_LOGIN")).sendKeys(hrlogin);
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
        driver.findElement(By.xpath("//span[@class='user-img user-default-avatar']")).click();
        driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[5]")).click();

        Thread.sleep(1000);

        // Clear all previous data
        driver.findElement(By.name("USER_LOGIN")).clear();
        driver.findElement(By.name("USER_PASSWORD")).clear();

        // 2. Login with Marketing Data
        String marketingLogIn = "marketing50@cybertekschool.com";
        driver.findElement(By.name("USER_LOGIN")).sendKeys(marketingLogIn);
        // type Password
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);
        // Click login button
        driver.findElement(By.className("login-btn")).click();
        // Login is passed
        Thread.sleep(3000);
        // So now we are on main page of nextbasecrm.com
        // Find om Module Time and Reports and click
        driver.findElement(By.xpath("(//span[@class='menu-item-link-text'])[9]")).click();
        // HR able to access Time and Reports, go logout now
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='user-img user-default-avatar']")).click();
        driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[5]")).click();
        // Test is Passed
    }
    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
