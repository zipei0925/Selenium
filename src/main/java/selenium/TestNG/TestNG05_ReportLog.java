package selenium.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNG05_ReportLog {

    @Test
    private void reportLog() {
        System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Reporter.log("launch chrome driver");

        driver.manage().window().maximize();
        Reporter.log("maximize window");

        driver.get("https://www.baidu.com");
        Reporter.log("get bai du");

        driver.quit();
        Reporter.log("退出浏览器");
    }
}
