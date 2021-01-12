package nextBaseCRM.Vlad.UserStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC4_88 {

    WebDriver driver;
    @BeforeMethod
    public void netBaseLoginPage() throws InterruptedException {
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
        }
    }
        //=======================================================================================
        @Test// TC #4 Access to "FORGOT YOUR PASSWORD?" link page.
                public void passwordLinkPage(){
        driver.findElement(By.xpath("//a[@class = 'login-link-forgot-pass']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //  Verify title equals:
        // Expected: Get Password
        String expectedTitle1 = "Get Password";
        String actualTitle1 = driver.getTitle();
        if (actualTitle1.equals(expectedTitle1)) {
            System.out.println("Page \"Get Password\" title verification PASSED!");
        } else {
            System.err.println("Page \"Get Password\" title verification FAILED!");
            System.out.println("Expected title = " + expectedTitle1);
            System.out.println("Actual title = " + actualTitle1);
        }
    }

    @AfterMethod // close driver
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}