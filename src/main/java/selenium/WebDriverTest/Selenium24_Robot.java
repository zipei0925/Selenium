package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Selenium24_Robot {
    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.baidu.com");


        //指定图片的路径
        StringSelection sel = new StringSelection("E:\\Selenium\\screenshot\\screen.png");

        //把图片文件路径复制到剪贴板
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
        System.out.println("selection" + sel);

        //点击图片搜索按钮
        driver.findElement(By.className("soutu-btn")).click();
        Thread.sleep(1000);

        //点击选择文件按钮
//        driver.findElement(By.xpath("//input[@class='upload-pic']")).click();  //(683, 359)

        //声明Robot类对象
        Robot robot = new Robot();
        Thread.sleep(1000);

        //鼠标移动到(683, 359)坐标点
        robot.mouseMove(683, 480);

        //鼠标按下左键(BUTTON2_MASK:按下滚轴键,BUTTON3_MASK:按下右键)
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        //鼠标释放左键
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(2000);

        //按下组合键: Ctrl+v
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        //释放组合键: Ctrl+v
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        //点击回车键
        robot.keyPress(KeyEvent.VK_ENTER);

        //释放回车键
        robot.keyRelease(KeyEvent.VK_ENTER);





    }
}
