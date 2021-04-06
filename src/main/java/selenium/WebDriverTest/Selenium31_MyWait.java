package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Selenium31_MyWait {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.icloud.com");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.switchTo().frame("aid-auth-widget-iFrame");

        WebElement element = myWait(driver, By.id("account_name_text_field"), 1);

        element.click();

        element.sendKeys("123456789");

    }

    public static WebElement myWait(WebDriver driver, By location, Integer time) throws InterruptedException {
        WebElement element = null;
        for (int i = 0; i < time; i++) {
            try {
                element = driver.findElement(location);
                break;
            } catch (Exception e1) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e2) {
                    System.out.println("无法定位到元素: " + location);
                }
            }
        }
        return element;
    }
}


