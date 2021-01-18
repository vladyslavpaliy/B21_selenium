package nextBaseCRM.Vlad.UserStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class loginForHelpDesk {
    WebDriver driver;

    @BeforeMethod
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

            Thread.sleep(3000);
            //=====================================================================

            ArrayList<String> usernamesPositive = new ArrayList<>(Arrays.asList("helpdesk49@cybertekschool.com",
                    "helpdesk50@cybertekschool.com",
                    "marketing49@cybertekschool.com"));
            String password = "UserUser";
            for (String each : usernamesPositive) {
                // type User name
                driver.findElement(By.name("USER_LOGIN")).sendKeys(each);
                // type Password
                driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);
                // Click login button
                driver.findElement(By.className("login-btn")).click();

            }
        }
    }
}