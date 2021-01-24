package nextBaseCRM.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class login_helpDesk_hr_market {
    WebDriver driver;

    @Test
    public void positiveDataTest() throws InterruptedException {
        //  Open Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://login2.nextbasecrm.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //  Verify title equals
        //  Expected: Authorization
        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Landing page title verification PASSED!");
        } else {
            System.err.println("Landing page title verification FAILED!");
            System.out.println("Expected title = " + expectedTitle);
            System.out.println("Actual title = " + actualTitle);
        }
        Thread.sleep(3000);
        //=====================================================================
        // Data for login
        // OR
        // Usernames: helpdesk49@cybertekschool.com
        //           helpdesk50@cybertekschool.com
        //           marketing49@cybertekschool.com
        //           marketing50@cybertekschool.com
        //           hr49@cybertekschool.com
        //           hr50@cybertekschool.com
        String login = "helpdesk50@cybertekschool.com";
        // Data for password
        String password = "UserUser";
        // type User name
        driver.findElement(By.name("USER_LOGIN")).sendKeys(login);
        // type Password
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);
        // Click login button
        driver.findElement(By.className("login-btn")).click();
    }
}
