package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium23_OperatingMenu {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='speed-button']/span")).click();

        //获取下拉列表的所有选项
        List<WebElement> webElementsList = driver.findElements(By.xpath("//*[@id='speed-menu']/li/div"));

        //循环遍历列表
        for (WebElement element : webElementsList) {
            if (element.getText().equals("Fast")) {
                element.click();
            }
        }
    }
}
