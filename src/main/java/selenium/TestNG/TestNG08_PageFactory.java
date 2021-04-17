package selenium.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG08_PageFactory {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://117.29.161.242:30050");
        Thread.sleep(2000);
    }

    @Test
    public void login() throws InterruptedException {
        Actions actions = new Actions(driver);
        LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.loginAction("yedfeng", "yedfeng", actions);
    }

}
