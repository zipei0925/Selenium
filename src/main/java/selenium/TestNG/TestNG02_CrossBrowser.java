package selenium.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestNG02_CrossBrowser {
    WebDriver driver;
    @BeforeClass

    public void beforeTest(){
        System.out.println("====启动测试====");
        System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    //将外部参数"Browser"引入当前的脚本,使其成为一个被共享的变量
    @Parameters("Browser")
    public void OpenBaidu(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver.get("https://www.baidu.com");
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(By.id("kw")).sendKeys("Selenium");
            driver.findElement(By.id("su")).click();
        }else {
            System.out.println("浏览器不存在");
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
