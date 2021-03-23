package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Selenium01_OpenDouBan {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //将窗口最大化
        driver.manage().window().maximize();

        driver.get("https://www.douban.com/");

        //重点1要先切换到子框架
        driver.switchTo().frame(0);
        //设置等待时间10秒
        //WebDriverWait wait = new WebDriverWait(driver,10);
        //等待直到符合元素的文本出现
        //WebElement element =  driver.findElement(By.className("account-tab-account on"));
        //wait.until(ExpectedConditions.textToBePresentInElement(element,"加载成功"));
        //获取网页的title
        System.out.println("测试网页是: " + driver.getTitle());
        //使用账号密码登陆
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/ul[1]/li[2]")).click();
        //选中账号密码输入框并输入对应的账号密码
        driver.findElement(By.id("username")).sendKeys("18046293437");
        driver.findElement(By.id("password")).sendKeys("a425898860");
        //点击登录按钮
//        driver.findElement(By.xpath("//div[@class='account-form-field-submit ']")).click();
        driver.findElement(By.className("account-form-field-submit.")).click();

    }
}
