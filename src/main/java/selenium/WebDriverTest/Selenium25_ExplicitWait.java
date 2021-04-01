package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Selenium25_ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.icloud.com/");

        //设置等待时间10秒
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Thread.sleep(5000);

        //等待直到符合元素文本的内容出现
        driver.switchTo().frame("aid-auth-widget");
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                   By.id("account_name_text_field")));
        boolean status = element.isDisplayed();

        if (status){
            System.out.println("=====元素可见=====");
        }else{
            System.out.println("=====元素不可见=====");

        }
    }
}
