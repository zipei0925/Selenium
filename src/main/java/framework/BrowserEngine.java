package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BrowserEngine {
    final static Logger logger = LoggerFactory.getLogger(BrowserEngine.class);

    public String browserName;
    public String serverURL;
    public WebDriver driver;

    public  void loadConfig() throws IOException {

        Properties ppt = new Properties();

        //加载配置文件
        InputStream ips = new FileInputStream(".\\testConfig\\config.properties");
        ppt.load(ips);

        //选择浏览器
        logger.info("Start to select browser name from properties file");
        browserName = ppt.getProperty("browserName");
        System.out.println(browserName);
        logger.info("Your had select test browser type is: " + browserName);

        //选择URL
        logger.info("Start to select server URL from properties file");
        serverURL = ppt.getProperty("serverURL");
        logger.info("Your had select test browser type is: " + serverURL);
        ips.close();
    }

    public WebDriver getBrowser() {
        // 选择Firefox Driver
        if (browserName.equalsIgnoreCase("FireFox")) {
           System.setProperty("webdriver.gecko.driver", ".\\tools\\geckodriver.exe");
           driver = new FirefoxDriver();

           logger.info("Launching FireFox....");
           // 选择Chrome Driver
        } else if(browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
            driver = new ChromeDriver();

            logger.info("Launching Chrome....");
        }

        //访问URL
        driver.get(serverURL);
        logger.info("Open URL: " + serverURL);

        //窗口最大化
        driver.manage().window().maximize();
        logger.info("Maximize browser...");

        implicitlyWait(5);
        return driver;
    }

    /*
    * 关闭浏览器并退出
    */
    public void tearDown() throws InterruptedException {
        driver.quit();
        logger.info("Closing browser...");
        Thread.sleep(3000);
    }

    /*
    *隐式等待
    */

    public void implicitlyWait (int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        logger.info("wait for "+ time + " second.");
    }
}
