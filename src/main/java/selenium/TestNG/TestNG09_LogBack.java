package selenium.TestNG;
/*
    logger.trace("Trace Level.");

    logger.info("Info Level.");

    logger.warn("Warn Level.");

    logger.error("Error Level.");*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

public class TestNG09_LogBack {
    final static Logger logger = LoggerFactory.getLogger(TestNG09_LogBack.class);
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        logger.info("启动谷歌浏览器");

        driver.manage().window().maximize();
        logger.info("最大化窗口");

        driver.get("https://www.baidu.com");
        logger.info("打开百度首页");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        logger.info("隐式等待2秒");

        driver.findElement(By.id("kw")).sendKeys("Selenium");
        logger.info("在搜索框输入Selenium");

        driver.findElement(By.id("su")).click();
        logger.info("点击搜索按钮");

    }
}
