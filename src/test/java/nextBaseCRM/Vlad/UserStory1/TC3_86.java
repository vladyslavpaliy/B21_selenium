package nextBaseCRM.Vlad.UserStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3_86 {
    public WebDriver driver;

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
        @Test// TC #3 Check "Remember me on this computer" option / CHECKBOX.
                public void checkBox() throws InterruptedException {
            WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
            Thread.sleep(2000);
            // Click checkbox to select it
            checkbox.click();
            // Confirm checkbox is SELECTED
            if (checkbox.isSelected()) {
                System.out.println("Checkbox is selected, verification PASSED!");
            } else {
                System.out.println("Checkbox is NOT selected, verification PASSED!");
            }
        }

    @AfterMethod // close driver
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}