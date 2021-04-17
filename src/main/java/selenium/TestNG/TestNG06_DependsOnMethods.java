package selenium.TestNG;
/*
* 如果不用dependsOnMethods,testNG会自动根据@Test方法名称的首字母排序来执行测试方法。
* */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG06_DependsOnMethods {

    WebDriver driver;
    @BeforeClass
    public void before() {
        System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void getBaidu() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
    }

    //输入账号密码
    @Test(dependsOnMethods = {"clickLogin"})    //设置依赖的方法
    public void sendKeys(){
        //输入账号密码
        driver.findElement(By.id("TANGRAM__PSP_11__userName")).clear();
        driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("username");
        driver.findElement(By.id("TANGRAM__PSP_11__password")).clear();
        driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("password");
    }

    //进入账号密码页面
    @Test(dependsOnMethods = {"getBaidu"})
    public void clickLogin() throws InterruptedException {
        //点击登录按钮
        driver.findElement(By.id("s-top-loginbtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn")).click();
        Thread.sleep(1000);
    }


    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
