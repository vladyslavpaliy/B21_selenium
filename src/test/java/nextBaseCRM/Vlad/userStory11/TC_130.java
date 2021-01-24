package nextBaseCRM.Vlad.userStory11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_130 {

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
    public void hrCheckStatistic() throws InterruptedException {
        //AC_4: hr can check statistics under worktime

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
        // find a Worktime and click
        driver.findElement(By.xpath("(//span[@class='main-buttons-item-text-title'])[2]")).click();
        // For checkbox create new WebElement and find "statistic" and click to update
        WebElement checkbox2 = driver.findElement(By.cssSelector("input[name='additional']"));
        // IF statement to check if clickable
        if(checkbox2.isEnabled()){
            System.out.println("Hr checkbox 'Show start and end times' clickable");
        }else{
            System.out.println("Hr checkbox 'Show start and end times' NOT clickable");
        }
        Thread.sleep(2000);
        checkbox2.click();
        Thread.sleep(2000);
        checkbox2.click();
    }

    @Test
    public void marketingCheckStatistic() throws InterruptedException {
        //AC_4: marketing can check statistics under worktime

        // 1. Data for login
        String hrlogin = "marketing50@cybertekschool.com";
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
        // marketing able to access Time and Reports

        Thread.sleep(1000);
        // find a Worktime and click
        driver.findElement(By.xpath("(//span[@class='main-buttons-item-text-title'])[2]")).click();
        // For checkbox create new WebElement and find "statistic" and click to update
        WebElement checkbox2 = driver.findElement(By.cssSelector("input[name='additional']"));
        //
        if(checkbox2.isEnabled()){
            System.out.println("Marketing checkbox 'Show start and end times' clickable");
        }else{
            System.out.println("Marketing checkbox 'Show start and end times' NOT clickable");
        }
        Thread.sleep(2000);
        checkbox2.click();
        Thread.sleep(2000);
        checkbox2.click();
    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
