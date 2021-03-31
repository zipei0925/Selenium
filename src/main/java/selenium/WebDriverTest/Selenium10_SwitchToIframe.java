package selenium.WebDriverTest;

/*
driver.switchTo().frame(0)  # 1.用frame的index来定位，第一个是0
driver.switchTo().frame("frame1");   # 2.用id来定位
driver.switchTo().frame("myframe");  # 3.用name来定位
driver.switchTo().frame(WebElement);  # 4.用定位方法来定位:如xpath

//frame多层嵌套时,需一层层的切换进去
driver.switchTo().frame("frame1");
driver.switchTo().frame("frame2");
//进入嵌套frame时,切换到上一层的frame
driver.switchTo().parentFrame();

//从frame中切回主文档
driver.switchTo().defaultContent();
*
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Selenium10_SwitchToIframe {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //将窗口最大化
        driver.manage().window().maximize();

        driver.get("https://www.douban.com/");

        System.out.println("测试网页是: " + driver.getTitle());

        //1.根据frame的索引进行定位
        driver.switchTo().frame(0);

        //使用账号密码登陆
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/ul[1]/li[2]")).click();

        //切换回主文档
        driver.switchTo().defaultContent();
        driver.findElement(By.name("q")).sendKeys("已切换回主文档");
        Thread.sleep(2000);

        //2.根据frame的定位方法进行定位,注意:定位时,起始元素应当是主文档的元素
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='anony-reg-new']/div/div[1]/iframe")));

        //设置等待时间10秒
        //WebDriverWait wait = new WebDriverWait(driver,10);
        //等待直到符合元素的文本出现
        //WebElement element =  driver.findElement(By.className("account-tab-account on"));
        //wait.until(ExpectedConditions.textToBePresentInElement(element,"加载成功"));
        //获取网页的title

        //选中账号密码输入框并输入对应的账号密码
        driver.findElement(By.id("username")).sendKeys("18046293437");
        driver.findElement(By.id("password")).sendKeys("a425898860");
        //点击登录按钮
//        driver.findElement(By.xpath("//div[@class='account-form-field-submit ']")).click();
        driver.findElement(By.className("btn-account")).click();

    }
}
