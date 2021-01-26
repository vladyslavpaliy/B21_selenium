package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NextBaseCRM_Utilities {


    //login to NextBaseCRM
    public static void loginToNextBaseCRM(WebDriver driver){

        //enter username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("user_name"));
        //enter password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        //locate and click login
        WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();
    }

    //get the link
    public static void getTheLinkNextBaseCRM(WebDriver driver){

        driver.get(ConfigurationReader.getProperty("url"));

        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    //locate and click on message button
    public static void messageButton(WebDriver driver){
        WebElement messageButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButton.click();
        BrowserUtils.wait(2);
    }
}
