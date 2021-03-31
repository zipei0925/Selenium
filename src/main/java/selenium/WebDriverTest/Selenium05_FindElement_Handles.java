package selenium.WebDriverTest;
/*
* 1、通过窗口的标题去跳转新窗口

String parentWin=this.getWindowHandle();//获取当前窗口的句柄
Set<String> allWindowsId = driver.getWindowHandles();//获取所有窗口句柄
for(String windowId :allWindowsId){
    if(driver.switchTo().window(windowId).getTitle().contains("市场")){
        driver.switchTo().window(windowId);
        break;
    }
}
Assert.assertEquals("国云数据市场", driver.getTitle());
System.out.println("New page title is:" + driver.getTitle());

* 2、通过tab的id，跳到最后一个tab页
Set<String> winSet = this.driver.getWindowHandles();//获取所有句柄
    List<String> winList = new ArrayList<String>(winSet);//转成list列表
    String newTab = winList.get(winList.size() - 2);//定义新的tab页是倒数第二个页面
    driver.close(); // close the original tab 关闭最后一个
    driver.switchTo().window(newTab); // switch to new tab  跳到原来的倒数第二个
    Thread.sleep(1000);
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Selenium05_FindElement_Handles {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://baidu.com");
        //设置页面加载超时
        driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
        driver.findElement(By.linkText("贴吧")).click();
        //获取当前页面的标题
        System.out.println(driver.getTitle());
        //设置页面加载超时
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //获取所有窗口的句柄(WindowsId)
        Set<String> handles = driver.getWindowHandles();
        //转换为list集合,因为Set集合:无序,没有索引,不能重复
        List<String> handlesList = new ArrayList<String>(handles);
        //获取最后一个tab页的句柄
        String newTab = handlesList.get(handlesList.size()-1);
        //切换到最后一个Windows tab页
        driver.switchTo().window(newTab);
        //获取当前页面的标题
        System.out.println(driver.getTitle());
//        driver.findElement(By.xpath("//p[@id=TANGRAM__PSP_4__footerULoginBtn]")).click();
        driver.findElement(By.id("TANGRAM__PSP_4__footerULoginBtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("userName")).sendKeys("18046293437");
        driver.findElement(By.name("password")).sendKeys("a425898860");
        Thread.sleep(1000);
        driver.findElement(By.id("TANGRAM__PSP_4__submit")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("kw1")).sendKeys("曼联");
        Thread.sleep(2000);
        driver.findElement(By.className("search_btn")).click();
        Thread.sleep(1000);
        //partial_link_text是对超链接载体的模糊匹配
        driver.findElement(By.partialLinkText("莱斯特城3:1曼联")).click();
        Thread.sleep(2000);
        //获取所有tab页的句柄
        Set<String> winIds = driver.getWindowHandles();
        //遍历集合
        for(String winId : winIds){
            if (driver.switchTo().window(winId).getTitle().contains("莱斯特城3:1曼联_曼联吧_百度贴吧")){
                driver.switchTo().window(winId);
                break;
            }
        }
        System.out.println(driver.getTitle());
        driver.findElement(By.id("quick_reply")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ueditor_replace']")).sendKeys("曼联牛逼");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".poster_submit")).click();
        Thread.sleep(2000);
        driver.findElement(By.tagName("body")).sendKeys("F11");
        //退出浏览器
        driver.quit();

    }
}
