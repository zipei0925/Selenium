package selenium.WebDriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Selenium11_RadioButton {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.sojump.com/m/2792226.aspx/");

        Thread.sleep(1000);

        //set类型强制转换为list类型
        List<WebElement> buttonList = (ArrayList<WebElement>)
                driver.findElements(By.xpath("//*[@id='divQuestion']//span/a"));

        //遍历集合点击按钮
        for (WebElement button : buttonList){
            button.click();
            Thread.sleep(1000);
        }

        //根据选项的文字描述点击 following-sibling当前节点之后的兄弟节点 preceding-sibling:当前节点之前的兄弟节点
        driver.findElement(By.xpath("//*[@id='q3_1']/following-sibling::a")).click();
    }
}
