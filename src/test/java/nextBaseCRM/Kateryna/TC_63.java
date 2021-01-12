package nextBaseCRM.Kateryna;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_63 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("https://login2.nextbasecrm.com/stream/?login=yes");

        // log in
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("marketing49@cybertekschool.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //search box suggested modules verification

        WebElement searchBoxElement=driver.findElement(By.xpath("//*[@name='q']"));
        searchBoxElement.sendKeys("document");

        if(driver.getPageSource().contains("Menu items") && driver.getPageSource().contains("Conversations") && driver.getPageSource().contains("Other") && driver.getPageSource().contains("Search") ){
            System.out.println("Verification PASS");
        }else{
            System.out.println("Verification FAIL");
        }

    }
}
