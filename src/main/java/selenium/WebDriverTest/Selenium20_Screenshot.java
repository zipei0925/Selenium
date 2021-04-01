package selenium.WebDriverTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Selenium20_Screenshot {
    public static void main(String[] args) throws AWTException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.baidu.com");

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        TakeScreenshot(driver);

        robotScreenshot(driver);

        driver.quit();

    }
    //使用TakeScreenshout类，获取浏览器窗体内的截图
    public static void TakeScreenshot (WebDriver driver) {
        //调用截图方法
        File pic = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            //拷贝截图到指定的文件夹
            FileUtils.copyFile(pic, new File(".\\screenshot\\screen.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //使用Robot类,获取整个电脑屏幕的截图(Robot类还可以模拟鼠标和键盘的操作)
    public static void robotScreenshot(WebDriver driver) throws AWTException {
        //调用截图方法
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        try {
            ImageIO.write(image, "png", new File(".\\screenshot\\robotScreen.png"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
