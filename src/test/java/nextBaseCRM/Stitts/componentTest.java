package nextBaseCRM.Stitts;

import nextBaseCRM.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class componentTest {
    WebDriver driver;

@BeforeMethod
        public void setupMethod(){
            driver=WebDriverFactory.getDriver("chrome");
            assert driver != null;
            driver.get("https://login2.nextbasecrm.com/");
            driver.findElement(By.xpath("//*[@id='login-popup']/form/div[1]/div[1]/input")).sendKeys("hr55@cybertekschool.com");
            driver.findElement(By.xpath("//*[@id='login-popup']/form/div[1]/div[2]/input")).sendKeys("UserUser" + Keys.ENTER);
            driver.findElement(By.xpath("//*[@id='user-block']")).click();
        }
       @Test
               public void test1_bodyText()throws InterruptedException{
                driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
           Thread.sleep(3000);
           driver.switchTo().frame(0);
           try{
               driver.findElement(By.xpath("//*[@contenteditable]")).clear();
               Thread.sleep(500);
               driver.findElement(By.xpath("//*[@contenteditable]"))
                       .sendKeys("Test");
           }catch (NoSuchElementException e){
               System.err.println("CAUGHTCAUGHTCAUGHT");
              try{
                  driver.switchTo().frame(0).findElement(By.xpath("//*[contenteditable]")).sendKeys("Test");
              } catch (NoSuchElementException elementException){
                  System.err.println("CAUGHTCAUGHTCAUGHT");System.err.println("CAUGHTCAUGHTCAUGHT");
                  driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
                  driver.findElement(By.xpath("//*[@contenteditable]")).clear();
                  Thread.sleep(500);
                  driver.findElement(By.xpath("//*[@contenteditable]"))
                          .sendKeys("Test");driver.findElement(By.xpath("//*[@contenteditable]")).clear();
                  Thread.sleep(500);
                  driver.findElement(By.xpath("//*[@contenteditable]"))
                          .sendKeys("Test");
              }

           }

       }
    @Test
              public void test2_titleText()throws InterruptedException{
        try{
            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
            Thread.sleep(3000);
            try{
                driver.findElement(By.xpath("//input[@id='POST_TITLE']")).clear();
            }catch (NoSuchElementException e){
                System.err.println("CAUGHTCAUGHTCAUGHT");
                driver.findElement(By.xpath("//*[@id=\"lhe_button_title_blogPostForm\"]")).click();
                System.err.println("Error caught");
            }
            driver.findElement(By.xpath("//input[@id='POST_TITLE']"))
                    .sendKeys("Test");

        }catch (ElementNotInteractableException e){
            System.err.println("CAUGHTCAUGHTCAUGHT");
            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
            Thread.sleep(3000);
            try{
                driver.findElement(By.xpath("//input[@id='POST_TITLE']")).clear();
            }catch (NoSuchElementException d){
                System.err.println("CAUGHTCAUGHTCAUGHT");
                driver.findElement(By.xpath("//*[@id=\"lhe_button_title_blogPostForm\"]")).click();
                System.err.println("Error caught");
            }
            driver.findElement(By.xpath("//input[@id='POST_TITLE']"))
                    .sendKeys("Test");

        }
    }
    @Test
    public void test3_questionText()throws InterruptedException {
        try {
            try {
                driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
                Thread.sleep(3000);
                WebElement question = driver.findElement(By.xpath("//*[@id=\"question_0\"]"));
                question.clear();
                question.sendKeys("Question");
            } catch (NoSuchElementException e) {
                System.err.println("CAUGHTCAUGHTCAUGHT");
                driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
                Thread.sleep(3000);
                WebElement question = driver.findElement(By.xpath("//*[@id=\"question_0\"]"));
                question.clear();
                question.sendKeys("Question");
            }

        } catch (ElementNotInteractableException a) {
            System.err.println("CAUGHTCAUGHTCAUGHT");
            try {
                driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
                Thread.sleep(3000);
                WebElement question = driver.findElement(By.xpath("//*[@id=\"question_0\"]"));
                question.clear();
                question.sendKeys("Question");
            } catch (NoSuchElementException e) {
                System.err.println("CAUGHTCAUGHTCAUGHT");
                driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
                Thread.sleep(3000);
                WebElement question = driver.findElement(By.xpath("//*[@id=\"question_0\"]"));
                question.clear();
                question.sendKeys("Question");
            }
        }
    }

    @Test
    public void test4_answerText()throws InterruptedException{
try{
    driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@placeholder='Answer  1']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='Answer  2']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='Answer  1']"))
            .sendKeys("Answer1");
    driver.findElement(By.xpath("//input[@placeholder='Answer  2']"))
            .sendKeys("Answer2"); driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@placeholder='Answer  1']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='Answer  2']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='Answer  1']"))
            .sendKeys("Answer1");
    driver.findElement(By.xpath("//input[@placeholder='Answer  2']"))
            .sendKeys("Answer2");
}catch (ElementNotInteractableException e){
    System.err.println("CAUGHTCAUGHTCAUGHT");

    driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@placeholder='Answer  1']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='Answer  2']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='Answer  1']"))
            .sendKeys("Answer1");
    driver.findElement(By.xpath("//input[@placeholder='Answer  2']"))
            .sendKeys("Answer2"); driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@placeholder='Answer  1']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='Answer  2']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='Answer  1']"))
            .sendKeys("Answer1");
    driver.findElement(By.xpath("//input[@placeholder='Answer  2']"))
            .sendKeys("Answer2");
}

    }

    @Test
    public void test5_checkbox()throws InterruptedException{

        driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
        Thread.sleep(2000);
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"multi_0\"]"));
        checkbox.click();
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected());
    }
    @Test
    public void test6_canCancel()throws InterruptedException {

        try {
            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
            Thread.sleep(2000);
            WebElement button = driver.findElement(By.xpath("//*[@id=\"blog-submit-button-cancel\"]"));
            button.click();
            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
            Thread.sleep(2000);
            button.click();
        } catch (NoSuchElementException e) {
            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
            Thread.sleep(2000);
            WebElement button = driver.findElement(By.xpath("//*[@id=\"blog-submit-button-cancel\"]"));
            button.click();
            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
            Thread.sleep(2000);
            button.click();
        }
    }
   @AfterMethod
        public void tearDownMethod(){
driver.close();
        }

    }

