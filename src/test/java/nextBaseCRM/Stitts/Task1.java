package nextBaseCRM.Stitts;

import nextBaseCRM.Utility.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com/");
    }
}
