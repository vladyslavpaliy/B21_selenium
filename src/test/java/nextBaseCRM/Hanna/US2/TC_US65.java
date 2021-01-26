package nextBaseCRM.Hanna.US2;

import com.github.javafaker.Faker;
import utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_US65 {
    WebDriver driver;
    Faker faker = new Faker();

    @BeforeMethod
    public void setUpMethod(){
        //Driver.get()-->webDriver object
        //get() we call webDriver object
        Driver.get().get(ConfigurationReader.getProperty("url"));
        NextBaseCRM_Utilities.loginToNextBaseCRM(driver);
    }


    @Test(priority = 1 , description = "sending the message")
    public void testMessageButtonWithRecipient() {
        //locate and click on Message tab
        NextBaseCRM_Utilities.messageButton(driver);

        //creating a faker to send message

        String msg = faker.lorem().fixedString(8);
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        driver.findElement(By.xpath("//body[@contenteditable='true']")).clear();
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys(msg);
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);

        //locate the recipient box
        WebElement recipientBox = driver.findElement(By.xpath("//a[@class='feed-add-destination-link']"));
        recipientBox.click();

        WebElement allEmployee = driver.findElement(By.xpath(" //span[starts-with(text(),'All')]"));
        Assert.assertEquals(allEmployee.getText(), "All employees","Test failed");

        //close recipient window
        WebElement closeWindow = driver.findElement(By.xpath("//span[@class='popup-window-close-icon']"));
        closeWindow.click();
        BrowserUtils.wait(2);

        //send message

        WebElement send = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        send.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+msg+"']")).isDisplayed(),"Test failed");

    }

    @Test(priority = 2 , description = "sending the message with txt link")
    public void testTxtLink()  {
        NextBaseCRM_Utilities.messageButton(driver);
        //locate link attachment and click
        WebElement link = driver.findElement(By.xpath("//span[@id='bx-b-link-blogPostForm']//i"));
        link.click();
        BrowserUtils.wait(2);
        //locate text
        String txt = faker.internet().url();
        WebElement txtBox = driver.findElement(By.xpath("//td//input[@id='linkidPostFormLHE_blogPostForm-text']"));
        txtBox.sendKeys(txt);
        BrowserUtils.wait(2);

        WebElement save = driver.findElement(By.xpath("//input[@class='adm-btn-save']"));
        save.click();
        BrowserUtils.wait(2);

        WebElement send = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        send.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+txt+"']")).isDisplayed());

    }
    @Test(priority = 3 , description = "sending the message with URL link")
    public void testUrlLink()  {
        NextBaseCRM_Utilities.messageButton(driver);
        BrowserUtils.wait(2);
        WebElement link = driver.findElement(By.xpath("//span[@id='bx-b-link-blogPostForm']//i"));
        link.click();
        BrowserUtils.wait(2);

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

    @Test(priority = 4 , description = "canceling the message")
    public void cancelButton()  {
        NextBaseCRM_Utilities.messageButton(driver);

        //creating a faker to send message

        String msg = faker.lorem().fixedString(8);
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        driver.findElement(By.xpath("//body[@contenteditable='true']")).clear();
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys(msg);
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);

        WebElement cancelButton = driver.findElement(By.id("blog-submit-button-cancel"));
        cancelButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Send message …']")).isDisplayed());

    }

    @Test(priority = 5 ,description = "negative path , message with no txt")
    public void testMessageButtonWithNoTxt()  {
       NextBaseCRM_Utilities.messageButton(driver);

        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        driver.findElement(By.xpath("//body[@contenteditable='true']")).clear();
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys("");
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);

        WebElement send = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        send.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='The message title is not specified']")).isDisplayed());
    }

    @Test(priority = 6 , description = "negative path , sending message with no recipient ")
    public void testSendMessageWithNoRecipient()  {
        NextBaseCRM_Utilities.messageButton(driver);

        //creating a faker to send message

        String msg = faker.lorem().fixedString(8);
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        driver.findElement(By.xpath("//body[@contenteditable='true']")).clear();
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys(msg);
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);

        WebElement cancelRecipient = driver.findElement(By.className("feed-add-post-del-but"));
        cancelRecipient.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Add persons, groups or department']")).isDisplayed());

        WebElement send = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        send.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Please specify at least one person.']")).isDisplayed());


    }

    @AfterMethod
    public void tearDownMethod()  {
       Driver.close();
    }
}
