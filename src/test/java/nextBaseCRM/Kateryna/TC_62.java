package nextBaseCRM.Kateryna;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class TC_62 {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("https://login2.nextbasecrm.com/stream/?login=yes");

        // log in
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("marketing49@cybertekschool.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //search box verification with valid document name

        WebElement searchBoxElement=driver.findElement(By.xpath("//*[@name='q']"));
       searchBoxElement.sendKeys("marketing and advertising");
        Thread.sleep(3000);
        searchBoxElement.sendKeys(Keys.ENTER);

        // verification if element displayed on the page
    // WebElement actualWebElement=   driver.findElement(By.xpath("//input[@name='FIND']"));
        WebElement actualWebElement=   driver.findElement(By.linkText("Marketing and advertising"));

     if(actualWebElement.isDisplayed()){
         System.out.println("Verification PASS");
     }else{
         System.out.println("Verification FAIL");
     }



    }
}
