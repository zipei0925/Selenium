package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.concurrent.TimeUnit;


public class Selenium15_Actions_ClickAndHold {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //Actions动作1-clickAndHold:左键点击
        driver.get("https://www.baidu.com/duty/");

        //定义第一段文字
        WebElement str1 = driver.findElement(By.xpath("//*[@id='aboutToShow']//p"));
        System.out.println(str1.getText());

        //定义第二段文字
        WebElement str2 = driver.findElement(By.xpath("//*/div[@id='aboutToShow']//li[1]"));
        System.out.println(str2.getText());

        Actions ac = new Actions(driver);
        ac.clickAndHold(str1).moveToElement(str2).perform();

        ac.release();

        //Actions动作2-clickAndHold: 鼠标悬停
        driver.get("https://www.baidu.com");

        WebElement setting = driver.findElement(By.id("s-usersetting-top"));

        Actions action = new Actions(driver);
        action.moveToElement(setting).perform();

        driver.findElement(By.linkText("关闭热榜")).click();
        ac.release();



        //关闭浏览器退出
//        driver.quit();
    }
}
