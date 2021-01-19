package nextBaseCRM.Jaden.UserStory4;

import utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TC_104 {
   static WebDriver driver;

    
    @BeforeMethod
    public void SetupMethod() {
        driver = WebDriverFactory.getDriver("chrome");

        Objects.requireNonNull(driver).get("https://login2.nextbasecrm.com/");
        driver.findElement(By.xpath("//*[@id='login-popup']/form/div[1]/div[1]/input")).sendKeys("hr55@cybertekschool.com");
        driver.findElement(By.xpath("//*[@id='login-popup']/form/div[1]/div[2]/input")).sendKeys("UserUser" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='user-block']")).click();
    }

    @Test
    public void T1_BodyText() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();

        Thread.sleep(3000);
       WebElement textBox = driver.switchTo().frame(0).findElement(By.xpath("//*[@contenteditable='true']"));
        
        try {
            textBox.clear();
            Thread.sleep(500);
            textBox.sendKeys("TEST");
            driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        } catch (NoSuchElementException e) {
            System.out.println("asdasd"+ e);

            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();

           textBox.clear();
            Thread.sleep(500);
            textBox.sendKeys("Test");
            Thread.sleep(500);
          textBox.clear();
            Thread.sleep(500);
            textBox.sendKeys("TEST");
        }
Assert.assertEquals(textBox.getText(),"TEST");
    }

    @Test
    public void T2_TitleText()throws InterruptedException{
       WebElement poll = driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")) ;
       poll.click();
       driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
       WebElement title = driver.findElement(By.xpath("//input[@id='POST_TITLE']"));
       WebElement titleKey = driver.findElement(By.xpath("//*[@id=\"lhe_button_title_blogPostForm\"]"));
        try{
            driver.switchTo().defaultContent();
            poll.click();
            Thread.sleep(3000);
            try{
                title.clear();
            }catch (NoSuchElementException e){
                titleKey.click();
            }
                title.sendKeys("TEST");

        }catch (ElementNotInteractableException e){

            driver.switchTo().defaultContent();
          poll.click();
            Thread.sleep(3000);
            try{
               title.clear();
            }catch (NoSuchElementException d){

                titleKey.click();

            }
            title.sendKeys("TEST");
        }

    }

    @Test
    public void T3_QuestionText() throws InterruptedException {
        try {
            try {
                driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
                Thread.sleep(3000);
                WebElement question = driver.findElement(By.xpath("//*[@id=\"question_0\"]"));
                question.clear();
                question.sendKeys("Question");
            } catch (NoSuchElementException e) {

                driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
                Thread.sleep(3000);
                WebElement question = driver.findElement(By.xpath("//*[@id=\"question_0\"]"));
                question.clear();
                question.sendKeys("Question");
            }

        } catch (ElementNotInteractableException a) {

            try {
                driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
                Thread.sleep(3000);
                WebElement question = driver.findElement(By.xpath("//*[@id=\"question_0\"]"));
                question.clear();

            } catch (NoSuchElementException e) {

                driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
                Thread.sleep(3000);
                WebElement question = driver.findElement(By.xpath("//*[@id=\"question_0\"]"));
                question.clear();
                question.sendKeys("Question");
            }
        }
    }

    @Test
    public void T4_AnswerText() throws InterruptedException {
        try {
            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='Answer  1']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Answer  2']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Answer  1']"))
                    .sendKeys("Answer1");
            driver.findElement(By.xpath("//input[@placeholder='Answer  2']"))
                    .sendKeys("Answer2");
            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='Answer  1']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Answer  2']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Answer  1']"))
                    .sendKeys("Answer1");
            driver.findElement(By.xpath("//input[@placeholder='Answer  2']"))
                    .sendKeys("Answer2");
        } catch (ElementNotInteractableException e) {


            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='Answer  1']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Answer  2']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Answer  1']"))
                    .sendKeys("Answer1");
            driver.findElement(By.xpath("//input[@placeholder='Answer  2']"))
                    .sendKeys("Answer2");
            driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
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
    public void T5_Checkbox() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]")).click();
        Thread.sleep(2000);
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"multi_0\"]"));
        checkbox.click();
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected());
    }

    @Test
     public void T6_CanCancel() throws InterruptedException {
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
    public void TearDownMethod() {
        driver.close();
    }



}

