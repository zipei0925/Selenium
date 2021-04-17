package testSuite;


import framework.BrowserEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test01_LaunchBrowser {
    public WebDriver driver;
    BrowserEngine browserEngine = new BrowserEngine();

    @BeforeClass
    public void setUp() throws IOException {
        browserEngine.loadConfig();
        driver = browserEngine.getBrowser();
    }

    @Test
    public void login() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.findElement(By.name("username")).sendKeys("yedfeng");
        driver.findElement(By.name("password")).sendKeys("yedfeng");
        Thread.sleep(1000);
        WebElement handler =  driver.findElement(By.className("handler_bg"));
        actions.dragAndDropBy(handler, 350, 0).perform();
        Thread.sleep(1000);
        driver.findElement(By.className("el-button")).click();
        browserEngine.implicitlyWait(10);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
