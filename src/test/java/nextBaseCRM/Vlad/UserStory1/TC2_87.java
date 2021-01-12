package nextBaseCRM.Vlad.UserStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TC2_87 {

   WebDriver driver;

   @BeforeMethod
   public void netBaseLoginPage(){
      //  Open Chrome browser
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      driver.get("http://login2.nextbasecrm.com/");
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
   }

   // TC #2. Enter negative user name and negative user password.
   @Test
   public void negativeDataTest() throws InterruptedException {

      ArrayList<String> usernamesNegative = new ArrayList<String>(Arrays.asList(
              "helpdesk4555@cybertekschool.com",
              "aaaaaabbbbcccc@gmail.com",
              "marketing1000@cybertekschool.com"));
      String passwordNegative = "cyberttek";
      for (String each1 : usernamesNegative) {
         // type User name
         driver.findElement(By.name("USER_LOGIN")).sendKeys(each1);
         // type Password
         driver.findElement(By.name("USER_PASSWORD")).sendKeys(passwordNegative);
         //  Click login button
         driver.findElement(By.className("login-btn")).click();
         Thread.sleep(2000);
         // clear user id
         driver.findElement(By.name("USER_LOGIN")).clear();
         String expectedText = "Incorrect login or password";
         String actualText = driver.findElement(By.className("errortext")).getText();
         if (expectedText.equals(actualText)) {
            System.out.println("Text verification PASSED!");
         } else {
            System.err.println("Text verification FAILED!!!");
            System.out.println("ExpectedText = " + expectedText);
            System.out.println("ActualText = " + actualText);
         }
      }
   }

   @AfterMethod // close driver
   public void closeDriver(){
      driver.close();
   }

}


