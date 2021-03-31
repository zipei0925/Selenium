package selenium.WebDriverTest;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Selenium09_VerticalScrollBar {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://blog.csdn.net/u011541946");

        Thread.sleep(1000);

        //定义一个滚动位置点的目标实例:底部的公司简介
        WebElement element = driver.findElement(By.className("footer-column-b"));

        //创建一个JavaScript执行器实例,执行滚动
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //执行js语句,拖拽滚动条,直到设置的元素位置
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(2000);
        //上拉到页面顶端
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");

        Thread.sleep(2000);
        //下拉到页面底部
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

        Thread.sleep(2000);
        //上拉到页面顶端 0,0位置
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");

        Thread.sleep(2000);
        //下拉到页面1000位置
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,1000)");

        //使用发送PAGE_DOWN、END等键盘事件
        WebElement webElement = driver.findElement(By.cssSelector("body"));
        //webElement.click();        // 有的时候必须点击一下，下拉才能生效（有的网站是这样，原因未找到）
        Thread.sleep(2000);
        //小幅度下拉
        webElement.sendKeys(Keys.PAGE_DOWN);

        Thread.sleep(2000);
        //或者直接下拉到底
        webElement.sendKeys(Keys.END);

        Thread.sleep(2000);
        //上拉到页面顶部
        webElement.sendKeys(Keys.HOME);


    }
}
