package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium07_Clear {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://baidu.com");
        WebElement element =  driver.findElement(By.id("kw"));
        element.sendKeys("篮球");
        Thread.sleep(2000);
        element.clear(); // 清空输入框
        Thread.sleep(2000);
        element.sendKeys("足球");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        //退出浏览器
        driver.quit();

    }
}
