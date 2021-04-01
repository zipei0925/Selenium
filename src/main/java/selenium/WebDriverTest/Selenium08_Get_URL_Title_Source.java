package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Selenium08_Get_URL_Title_Source {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://baidu.com");
        driver.findElement(By.linkText("新闻")).click();
        //获取句柄
        Set<String> handles = driver.getWindowHandles();
        List<String> handleList = new ArrayList<>(handles);
        String newTab = handleList.get(handleList.size()-1);
        //切换窗口
        driver.switchTo().window(newTab);
        //获取当前页面title,并做断言
        String title = driver.getTitle();
        assert  title.equals("百度新闻——海量中文资讯平台");
        System.out.println(title);
        //获取当前页面URL,并做断言
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals("http://news.baidu.com/");
        System.out.println(currentUrl);
        //获取当前页面的源码
        System.out.println(driver.getPageSource());
    }
}
