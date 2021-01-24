package nextBaseCRM.Vlad.userStory11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_128 {
    WebDriver driver;

    @BeforeMethod
    public void openDriver() throws InterruptedException {
        // users (hr, marketing ) can filter absence chart by day / week / month

        // Open Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://login2.nextbasecrm.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // 1 seconds wait before type data
        Thread.sleep(1000);
    }
    @Test
    public void positiveHrTest() throws InterruptedException {
        //AC_3: hr can filter absence chart by day / week / month

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
        // HR able to access Time and Reports

        Thread.sleep(1000);
        // HR can filter absence chart by day
        driver.findElement(By.xpath("(//span[@class='bx-c'])[3]")).click();
        Thread.sleep(1000);
        // HR can filter absence chart by week
        driver.findElement(By.xpath("(//span[@class='bx-c'])[2]")).click();
        Thread.sleep(1000);
        // HR can filter absence chart by month
        driver.findElement(By.xpath("(//span[@class='bx-c'])[1]")).click();

        // All date gonna be erased cuz of AfterMethod
    }
    @Test
    public void positiveMarketingTest() throws InterruptedException {
        //AC_3: marketing can filter absence chart by day / week / month

        // 1. Data for login
        String marketinglogin = "marketing50@cybertekschool.com";
        // Data for password
        String password = "UserUser";
        // type User name
        driver.findElement(By.name("USER_LOGIN")).sendKeys(marketinglogin);
        // type Password
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);
        // Click login button
        driver.findElement(By.className("login-btn")).click();
        // Login is passed
        // So now we are on main page of nextbasecrm.com
        // Find om Module Time and Reports and click
        driver.findElement(By.xpath("(//span[@class='menu-item-link-text'])[9]")).click();
        // HR able to access Time and Reports

        Thread.sleep(1000);
        // HR can filter absence chart by day
        driver.findElement(By.xpath("(//span[@class='bx-c'])[3]")).click();
        Thread.sleep(1000);
        // HR can filter absence chart by week
        driver.findElement(By.xpath("(//span[@class='bx-c'])[2]")).click();
        Thread.sleep(1000);
        // HR can filter absence chart by month
        driver.findElement(By.xpath("(//span[@class='bx-c'])[1]")).click();

    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
