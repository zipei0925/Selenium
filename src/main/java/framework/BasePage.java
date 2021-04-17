package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    final static Logger logger = LoggerFactory.getLogger(BasePage.class);

    public static WebDriver driver;

    public static String pageTitle;

    public static String pageUrl;

    /*
    * 构造方法
    */
    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    /*
    * 在文本中输入字符
    * */
    public void sendKeys(WebElement element, String text) {
        try {
            if (element.isEnabled()){
                //点击输入框
                element.click();
                logger.info("click" + element.toString() +"input box");
                //清除输入框
                element.clear();
                logger.info("Clean the value if any in "+ element.toString()+".");
                //输入内容
                element.sendKeys(text);
                logger.info("The value is" + text + ".");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    /*
    * 使用鼠标左键点击
    * */
    public void click(WebElement element) {
        try {
            if (element.isEnabled()) {
                element.click();
                logger.info("The Element " + element.toString() + "was clicked");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    /*
    * 清除文本框的内容
    * */
    public void clear(WebElement element) {
        try {
            if (element.isEnabled()) {
                element.clear();
                logger.info("The Element " + element.toString() + "was cleared");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    /*
     * 判断元素是否在当前页显示
     * */
    public void isDisplay(WebElement element) {
        try {
            if (element.isDisplayed()) {
                logger.info("The Element " + element.toString() + "is display");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    /*
    * 获取当前页面的标题
    * */

    public String getPageTitle(WebElement element) {
        pageTitle = driver.getTitle();
        logger.info("Current page title is " + pageTitle);
        return pageTitle;
    }

    /*
    * 获取当前页面的URL
    * */

    public String getPageUrl(WebElement element) {
        pageUrl = driver.getCurrentUrl();
        logger.info("Current page url is " + pageUrl);
        return pageUrl;
    }

    /*
    * 切换窗口
    * */
    public void switchWindow() {
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        logger.info("Window size is " + handles.size());
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            if (currentHandle == it.next()) {
                continue;
            }
            try {
                driver.close(); //关闭旧窗口
                WebDriver newDriver = driver.switchTo().window(it.next()); //切换到新的窗口
                logger.info("switch to " + newDriver.getTitle() + "window. ");
            }catch (Exception e) {
                logger.error("Unable to switch to a new window" + e.getMessage());
            }
        }

    }

    /*
     *隐式等待
     */

    public void implicitlyWait (int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        logger.info("wait for "+ time + " second.");
    }
}
