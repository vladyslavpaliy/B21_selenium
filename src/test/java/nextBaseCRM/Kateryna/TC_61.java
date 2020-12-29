package nextBaseCRM.Kateryna;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_61 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://login2.nextbasecrm.com/stream/?login=yes");

        // log in
     driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("marketing49@cybertekschool.com");
     driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser");
     driver.findElement(By.xpath("//*[@type='submit']")).click();

     // search box verification with valid employee name
        WebElement searchBoxElement=driver.findElement(By.xpath("//input[@id='search-textbox-input']"));
      searchBoxElement.sendKeys("Asiya");
      Thread.sleep(3000);
      searchBoxElement.sendKeys(Keys.ENTER);

        // expected URL:https://login2.nextbasecrm.com/company/personal/user/483/

        String expectedResult="/company/personal/user/483/";
        String actualResult=driver.getCurrentUrl();

        System.out.println(actualResult);

        if(actualResult.contains(expectedResult)){
            System.out.println("Verification PASS");
        }else{
            System.out.println("Verification FAIL");
        }












    }
}
