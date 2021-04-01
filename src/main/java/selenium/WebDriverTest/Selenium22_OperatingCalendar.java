package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium22_OperatingCalendar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://jqueryui.com/resources/demos/datepicker/default.html");

        Thread.sleep(2000);

        //方法一:日历的控件是input标签
        driver.findElement(By.id("datepicker")).sendKeys("03/31/2021");

        //方法二:日历的控件时readonly(只读)标签,使用JS remove readonly attribute，然后sendKeys
//        JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
//        removeAttribute.executeScript(
//                "var setDate=document.getElementsById(\"datepicker\")[0];setDate.removeAttribute('readonly');");
//
//        stationManagePage.I_establishTime().sendKeys(I_establishTime);
    }
}
