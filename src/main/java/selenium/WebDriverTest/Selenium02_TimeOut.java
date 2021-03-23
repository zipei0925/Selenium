package selenium.WebDriverTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Selenium02_TimeOut {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",".\\tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 隐式时间等待: 设置一个最大时间值，如果在最大时间内，还是没有找到元素，抛出没有找到元素的异常
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        // 设置脚本超时:在设置规定的时间内，等待异步脚本的执行结束，而不是里面抛出错误
        driver.manage().timeouts().setScriptTimeout(3,TimeUnit.SECONDS);
        // 页面加载超时:在设置规定时间内，等待网页完整加载完成，而不是里面抛出错误
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        driver.get("https://www.iCloud.com");
    }
}
