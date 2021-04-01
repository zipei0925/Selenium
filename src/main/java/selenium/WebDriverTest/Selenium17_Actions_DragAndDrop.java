package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class Selenium17_Actions_DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");

        //Actions动作3-dragAndDrop: 鼠标悬停
        Actions ac = new Actions(driver);

        //源元素
        WebElement source = driver.findElement(By.id("draggable"));

        //目标元素
        WebElement target = driver.findElement(By.id("droppable"));

        ac.dragAndDrop(source, target).perform();

        assert(driver.findElement(By.xpath("//*[@id='droppable']/p[text()='Dropped!']")).isDisplayed()==true);

        ac.release();




        //关闭浏览器退出
//        driver.quit();
    }
}
