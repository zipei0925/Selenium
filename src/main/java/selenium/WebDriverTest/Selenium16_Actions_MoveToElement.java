package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class Selenium16_Actions_MoveToElement {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://www.baidu.com");

        Actions ac = new Actions(driver);

        //Actions动作2-clickAndHold: 鼠标悬停
        WebElement setting = driver.findElement(By.id("s-usersetting-top"));

        Actions action = new Actions(driver);
        action.moveToElement(setting).perform();

        driver.findElement(By.linkText("关闭热榜")).click();
        ac.release();



        //关闭浏览器退出
//        driver.quit();
    }
}
