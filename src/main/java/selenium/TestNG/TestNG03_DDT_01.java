package selenium.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG03_DDT_01 {

    @Test(dataProvider = "testData")

    public void TestLogin (String username, String password) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");

        //点击登录按钮
        driver.findElement(By.id("s-top-loginbtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn")).click();
        Thread.sleep(1000);

        //输入账号密码
        driver.findElement(By.id("TANGRAM__PSP_11__userName")).clear();
        driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys(username);
        driver.findElement(By.id("TANGRAM__PSP_11__password")).clear();
        driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys(password);
    }

    @DataProvider(name = "testData")
    public Object[][] data() {
        return new Object[][] {
                new Object[] {"user1", "123456" },
                new Object[] { "user2", "123321" }
        };
    }


//    @DataProvider(name = "testData")
//    public Object[][] TstDataFeed(){
//        //创建一个二维数组对象
//        Object [][] data = new Object[2][2];
//
//        //设置第一个用户的用户名, 密码
//        data[0][0] = "425898860@qq.com";
//        data[0][1] = "a425898860";
//
//        //设置第二用户的用户名,密码
//        data[1][0] = "123456@qq.com";
//        data[1][01] = "123456";
//
//        //返回数据给脚本
//        return data;
//    }
}
