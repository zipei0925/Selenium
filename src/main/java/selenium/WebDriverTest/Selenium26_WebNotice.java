package selenium.WebDriverTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Selenium26_WebNotice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Google\\Chrome\\Application\\chromedriver.exe");

        //创建一个HashMap对象
        Map<String, Object> prefs = new HashMap<String, Object>();

        //设置网页通知(1:allow, 2:block)
        prefs.put("profile.default_content_setting_values.notifications", 1);

        //创建Chrome选项设置对象
        ChromeOptions chromeOptions = new ChromeOptions();

        //修改选项设置
        chromeOptions.setExperimentalOption("prefs", prefs);

        //将修改后的设置传入ChromeDriver
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();

        driver.get("https://blog.csdn.net");
    }
}
