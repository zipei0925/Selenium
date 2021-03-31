package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Selenium12_IsDisplayed {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://117.29.161.242:30050/#/login");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.findElement(By.className("username")).click();
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.className("el-button--medium")).click();
        Thread.sleep(500);

//        WebElement uErrorMessage = driver.findElement(By.className("el-form-item__error"));
        //xpath中class元素不能写成className
        WebElement uErrorMessage = driver.findElement(By.xpath("//div[@class='el-form-item__error']"));
        WebElement errorMessage = driver.findElement(
                By.xpath("//*[@class='el-message__content' and text()='账号或密码不能为空']"));


        //方法一:验证提示语是否显示
        assert uErrorMessage.isDisplayed();
        assert errorMessage.isDisplayed();

        //方法二:比对提示语是否一致
        String message = uErrorMessage.getText();
        System.out.println(message);
        assert message.equals("用户名不能为空");
        String message2 = errorMessage.getText();
        System.out.println(message2);
        assert message2.equals("账号或密码不能为空");
    }
}
