package nextBaseCRM.Jaden.UserStory4;

import org.testng.annotations.*;
import utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TC_104 {
    static WebDriver driver;
    static WebElement poll;
    static WebElement textBox;
    static WebElement titleKey;
    static WebElement title;
    static WebElement question;
    static WebElement answer1;
    static WebElement answer2;
    static WebElement checkbox;
    static WebElement button;
    static WebElement button2;

    public void selectTextBox(String s) {
        driver.switchTo().frame(0);
        textBox = driver.findElement(By.xpath("//*[@contenteditable='true']"));
        textBox.click();
        textBox.sendKeys(s);
        driver.switchTo().defaultContent();
    }

    @BeforeMethod
    public void SetupMethod() {
        driver = WebDriverFactory.getDriver("chrome");

        Objects.requireNonNull(driver).get("https://login2.nextbasecrm.com/");
        driver.findElement(By.xpath("//*[@id='login-popup']/form/div[1]/div[1]/input")).sendKeys("hr55@cybertekschool.com");
        driver.findElement(By.xpath("//*[@id='login-popup']/form/div[1]/div[2]/input")).sendKeys("UserUser" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='user-block']")).click();
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        poll = driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-vote\"]"));
        poll.click();
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        question = driver.findElement(By.xpath("//*[@id=\"question_0\"]"));
        titleKey = driver.findElement(By.xpath("//*[@id=\"lhe_button_title_blogPostForm\"]"));
        title = driver.findElement(By.name("POST_TITLE"));
        answer1 = driver.findElement(By.xpath("//input[@placeholder='Answer  1']"));
        answer2 = driver.findElement(By.xpath("//input[@placeholder='Answer  2']"));
        checkbox = driver.findElement(By.xpath("//*[@id=\"multi_0\"]"));
        button = driver.findElement(By.xpath("//*[@id=\"blog-submit-button-cancel\"]"));
        button2 = driver.findElement(By.xpath("//*[@id=\"blog-submit-button-save\"]"));

    }

    @Test
    public void T1_TitleText() throws InterruptedException {
        title.clear();
        try {
            try {
                title.clear();
                poll.click();
                Thread.sleep(3000);
                title.sendKeys("TEST");

            } catch (NoSuchElementException a) {
                title.clear();
                poll.click();
                Thread.sleep(3000);
                title.sendKeys("TEST");

            }
        } catch (ElementNotInteractableException e) {
            try {
                title.clear();
                poll.click();
                Thread.sleep(3000);
                title.sendKeys("TEST");

            } catch (NoSuchElementException a) {
                title.clear();
                poll.click();
                Thread.sleep(3000);
                title.sendKeys("TEST");
            }
        }
    }

    @Test
    public void T2_BodyText() throws InterruptedException {

        try {
            poll.click();
            Thread.sleep(3000);
            selectTextBox("TEST");
        } catch (NoSuchElementException a) {
            poll.click();
            Thread.sleep(3000);
            selectTextBox("TEST");

        }
        driver.switchTo().frame(0);
        Assert.assertEquals(textBox.getText(), "TEST");
    }

    @Test
    public void T3_QuestionText() throws InterruptedException {
        try {
            try {
                poll.click();
                Thread.sleep(3000);
                question.clear();
                question.sendKeys("Question");

            } catch (NoSuchElementException e) {

                poll.click();
                Thread.sleep(3000);
                question.clear();
                question.sendKeys("Question");

            }

        } catch (ElementNotInteractableException a) {

            try {
                poll.click();
                Thread.sleep(3000);
                question.clear();
                question.sendKeys("Question");
                Thread.sleep(3000);
            } catch (NoSuchElementException e) {

                poll.click();
                Thread.sleep(3000);
                question.clear();
                question.sendKeys("Question");
                Thread.sleep(3000);
            }
        }
    }

    @Test
    public void T4_AnswerText() throws InterruptedException {
        try {
            poll.click();
            Thread.sleep(3000);
            answer1.clear();
            answer2.clear();
            answer1.sendKeys("Answer1");
            answer2.sendKeys("Answer2");

        } catch (ElementNotInteractableException e) {

            poll.click();
            Thread.sleep(3000);
            answer1.clear();
            answer2.clear();
            answer1.sendKeys("Answer1");
            answer2.sendKeys("Answer2");

        }
    }

    @Test
    public void T5_Checkbox() throws InterruptedException {
        poll.click();
        Thread.sleep(2000);
        checkbox.click();
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected());
    }

    @Test
    public void T6_CanCancel() throws InterruptedException {
        try {
            poll.click();
            Thread.sleep(2000);
            button.click();
            poll.click();
            button.click();
        } catch (NoSuchElementException e) {
            poll.click();
            Thread.sleep(2000);
            button.click();
            poll.click();
            button.click();
        }
    }

    @Test
    public void T7_FullTest() throws InterruptedException {
        try {
            poll.click();
            Thread.sleep(2000);
            title.sendKeys("TITLE_TEST");
            selectTextBox("BODY_TEST");
            question.sendKeys("QUESTION_TEST");
            answer1.sendKeys("TEST_ANS1");
            answer2.sendKeys("TEST_ANS2");
            checkbox.click();
            button2.click();

        } catch (NoSuchElementException e) {
            poll.click();
            Thread.sleep(2000);
            title.sendKeys("TITLE_TEST");
            selectTextBox("BODY_TEST");
            question.sendKeys("QUESTION_TEST");
            answer1.sendKeys("TEST_ANS1");
            answer2.sendKeys("TEST_ANS2");
            checkbox.click();
            button2.click();
        }
    }

    @Test
    public void T8_CanDelete() throws InterruptedException {
        button.click();
        Thread.sleep(1000);
        try {
            driver.findElement(By.xpath("//span[contains(@id,'feed-post-more')][1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[contains(@class,'menu-popup-no-icon')][5]")).click();
            //WILL THROW AN ALERT//
        } catch (NoSuchElementException e) {
            driver.findElement(By.xpath("//span[contains(@id,'feed-post-more')][1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[contains(@class,'menu-popup-no-icon')][5]")).click();
        }
        driver.switchTo().alert().accept();
    }

    @AfterMethod
    public void TearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}

