package selenium.WebDriverTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class OpenBaiDu {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://www.baidu.com");
        try {
            String baiDuTitle = "百度,知道";
            assert baiDuTitle == driver.getTitle();
            System.out.println("Test Pass");

        }catch (Exception e) {
            e.printStackTrace();
        }

        //关闭浏览器退出
        driver.quit();
    }
}
