package selenium.WebDriverTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Selenium13_Alert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //将窗口最大化
        driver.manage().window().maximize();

        driver.get("http://news.cyol.com/node_60799.htm");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        String message = driver.switchTo().alert().getText();
        System.out.println(message);

        driver.switchTo().alert().accept(); //点击alert框上面的确认按钮

//        driver.switchTo().alert().dismiss();  //点击alert框上面的取消按钮
//
//        driver.switchTo().alert().sendKeys("输入弹窗中指定内容"); //方法就像文章开头提到的输入邮件预定内容一样

        driver.quit();
    }
}

