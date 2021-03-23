package selenium.WebDriverTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium03_WindowsApi {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // 注意: targetPoint是一个点对象,把一个点作为参数传入,不能直接写(300, 500)
        Point targetPoint = new Point(300, 600);
        // 设置窗口位置坐标
        driver.manage().window().setPosition(targetPoint);
        // 获取窗口位置坐标
        System.out.println(driver.manage().window().getPosition());
        // 注意: targetSize是一个对象传入,也不可以直接写成1024*768
        Dimension dimension = new Dimension(1080, 720);
        // 设置窗口尺寸
        driver.manage().window().setSize(dimension);
        // 获取窗口尺寸
        System.out.println(driver.manage().window().getSize());
        //窗口全屏显示
        driver.manage().window().fullscreen();

        // 使用 F11 快捷键
        driver.findElement(By.tagName("body")).sendKeys(Keys.F11);

        // 关闭浏览器
        driver.quit();
    }
}
