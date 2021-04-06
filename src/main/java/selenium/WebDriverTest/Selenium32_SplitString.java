package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Selenium32_SplitString {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.baidu.com");

        driver.findElement(By.id("kw")).sendKeys("曼联");
        driver.findElement(By.id("su")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String text =  driver.findElement(By.className("nums_text")).getText();
        String s1 =  text.split("约")[1];

        String s2 = s1.split("个")[0];
        System.out.println(s2);

    }
}
