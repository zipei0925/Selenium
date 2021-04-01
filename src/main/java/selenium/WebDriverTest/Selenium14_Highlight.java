package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Selenium14_Highlight {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://117.29.161.242:30050/#/login");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement username =  driver.findElement(By.name("username"));
        username.click();
        username.sendKeys("admin");

        //在标签内添加style元素
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','background:pink; border:2px solid red;');", username);

        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("123456");

        //在标签内添加style元素
//        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background:pink; border:2px solid red')",password);


        
//        Thread.sleep(2000);
//        driver.findElement(By.className("el-button--medium")).click();
//        Thread.sleep(500);


    }
}
