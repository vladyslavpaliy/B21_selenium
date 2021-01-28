package nextBaseCRM.Vlad.UserStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TC1_85 {

    WebDriver driver;
    @BeforeMethod
    public void netBaseLoginPage() throws InterruptedException {
        ///  Open Chrome browser
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

            Thread.sleep(3000);
        }
    }
    //=======================================================================================
        // TC #1. Enter positive user name and positive user password.

    /*  //
Usernames: helpdesk49@cybertekschool.com
           helpdesk50@cybertekschool.com
           marketing49@cybertekschool.com
           marketing50@cybertekschool.com
           hr49@cybertekschool.com
           hr50@cybertekschool.com

Password:  UserUser
     */
    @Test
    public void positiveDataTest() throws InterruptedException {
        ArrayList<String> usernamesPositive = new ArrayList<>(Arrays.asList("helpdesk49@cybertekschool.com",
                "helpdesk50@cybertekschool.com",
                "marketing49@cybertekschool.com",
                "marketing50@cybertekschool.com",
                "hr49@cybertekschool.com",
                "hr50@cybertekschool.com"));
        String password = "UserUser";
        for (String each : usernamesPositive) {
            // type User name
            driver.findElement(By.name("USER_LOGIN")).sendKeys(each);
            // type Password
            driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);
            //====================================================================================
            // TC #4 Click login button
            driver.findElement(By.className("login-btn")).click();
            // do log out
            driver.findElement(By.className("user-name")).click();
            // click log out button
            driver.findElement(By.linkText("Log out")).click();
            // clear user id
            driver.findElement(By.name("USER_LOGIN")).clear();
        }

            }



    @AfterMethod // close driver
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}





