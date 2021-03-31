package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Selenium06_FindElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://baidu.com");
        //添加页面加载时间
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //进入新闻页面
        driver.findElement(By.linkText("新闻")).click();
        //添加页面加载时间
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //切换句柄
        Set<String> handles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(handles);
        //获取最后一个tab页的句柄
        String newTab = handlesList.get(handlesList.size()-1);
        //切换到最后一个Windows tab页
        driver.switchTo().window(newTab);
        driver.getTitle();
        //获取一组新闻信息
        List<WebElement> elementList = driver.findElements(By.xpath("//*[@id='pane-news']/ul[1]/li/a"));
        for (WebElement element : elementList){
            System.out.println(element.getText());
        }
        WebElement link = driver.findElement(By.xpath("//*[@id='pane-news']/ul[1]/li/a"));
        System.out.println(link.getText());
        Thread.sleep(2000);
//        driver.quit();

    }
}
