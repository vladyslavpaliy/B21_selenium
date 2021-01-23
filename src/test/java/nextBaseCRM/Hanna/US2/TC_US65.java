package nextBaseCRM.Hanna.US2;

import com.github.javafaker.Faker;
import nextBaseCRM.Utility.NextBaseCRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class TC_US65 {

    WebDriver driver;
    Faker faker = new Faker();
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("Chrome");
        NextBaseCRM_Utilities.getTheLinkNextBaseCRM(driver);
        NextBaseCRM_Utilities.loginToNextBaseCRM(driver);
    }




    @Test
    public void testMessageButtonWithRecipient() throws InterruptedException {
        //locate and click on Message tab
        WebElement messageButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButton.click();
        Thread.sleep(3000);

        //creating a faker to send message

        String msg = faker.lorem().fixedString(8);
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        driver.findElement(By.xpath("//body[@contenteditable='true']")).clear();
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys(msg);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        //locate the recipient box
        WebElement recipientBox = driver.findElement(By.xpath("//a[@class='feed-add-destination-link']"));
        recipientBox.click();

        WebElement allEmployee = driver.findElement(By.xpath(" //span[starts-with(text(),'All')]"));
        Assert.assertEquals(allEmployee.getText(), "All employees","Test failed");

        //close recipient window
        WebElement closeWindow = driver.findElement(By.xpath("//span[@class='popup-window-close-icon']"));
        closeWindow.click();
        Thread.sleep(3000);

        //send message
        Thread.sleep(3000);
        WebElement send = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        send.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+msg+"']")).isDisplayed(),"Test failed");

    }

    @Test
    public void testTxtLink() throws InterruptedException {
        WebElement messageButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButton.click();
        Thread.sleep(3000);
        //locate link attachment and click
        WebElement link = driver.findElement(By.xpath("//span[@id='bx-b-link-blogPostForm']//i"));
        link.click();
        Thread.sleep(3000);
        //locate text
        String txt = faker.internet().url();
        WebElement txtBox = driver.findElement(By.xpath("//td//input[@id='linkidPostFormLHE_blogPostForm-text']"));
        txtBox.sendKeys(txt);
        Thread.sleep(3000);

        WebElement save = driver.findElement(By.xpath("//input[@class='adm-btn-save']"));
        save.click();
        Thread.sleep(3000);

        WebElement send = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        send.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+txt+"']")).isDisplayed());

    }
    @Test
    public void testUrlLink() throws InterruptedException {
        WebElement messageButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButton.click();
        Thread.sleep(3000);
        WebElement link = driver.findElement(By.xpath("//span[@id='bx-b-link-blogPostForm']//i"));
        link.click();
        Thread.sleep(3000);

        //locate URL box and type the link
        String webSite= faker.internet().url();
        WebElement URLbox = driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href']"));
        URLbox.sendKeys(webSite);

        WebElement save = driver.findElement(By.xpath("//input[@class='adm-btn-save']"));
        save.click();
        WebElement send = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        send.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+webSite+"']")).isDisplayed());
    }


    @Test
    public void cancelButton() throws InterruptedException {
        //locate and click on Message tab
        WebElement messageButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButton.click();
        Thread.sleep(3000);

        //creating a faker to send message

        String msg = faker.lorem().fixedString(8);
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        driver.findElement(By.xpath("//body[@contenteditable='true']")).clear();
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys(msg);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        WebElement cancelButton = driver.findElement(By.id("blog-submit-button-cancel"));
        cancelButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Send message …']")).isDisplayed());

    }

    @Test
    public void testMessageButtonWithNoTxt() throws InterruptedException {
        //locate and click on Message tab
        WebElement messageButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButton.click();
        Thread.sleep(3000);

        //creating a faker to send message

       // String msg = faker.lorem().fixedString(8);
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        driver.findElement(By.xpath("//body[@contenteditable='true']")).clear();
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys("");
        driver.switchTo().defaultContent();
        Thread.sleep(3000);


        WebElement send = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        send.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='The message title is not specified']")).isDisplayed());
    }

    @Test
    public void testSendMessageWithNoRecipient() throws InterruptedException {
        //locate and click on Message tab
        WebElement messageButton = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']"));
        messageButton.click();
        Thread.sleep(3000);

        //creating a faker to send message

        String msg = faker.lorem().fixedString(8);
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        driver.findElement(By.xpath("//body[@contenteditable='true']")).clear();
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys(msg);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        WebElement cancelRecipient = driver.findElement(By.className("feed-add-post-del-but"));
        cancelRecipient.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Add persons, groups or department']")).isDisplayed());

        WebElement send = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        send.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Please specify at least one person.']")).isDisplayed());


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
       driver.quit();
    }
}
