package nextBaseCRM.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NextBaseCRM_Utilities {


    //login to NextBaseCRM
    public static void loginToNextBaseCRM(WebDriver driver){

        //enter username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk49@cybertekschool.com");
        //enter password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");
        //locate and click login
        WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();
    }

    //get the link
    public static void getTheLinkNextBaseCRM(WebDriver driver){

        driver.get("https://login2.nextbasecrm.com/");

        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
