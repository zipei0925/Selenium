package selenium.TestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    //1.元素定位

    //输入账号
    @FindBy(name="username")
    WebElement username;

    //输入密码
    @FindBy(name="password")
    WebElement password;

    //点击滑块
    @FindBy(className = "handler_bg")
    WebElement handler;

    //验证通过
    @FindBy(className = "drag_text")
    WebElement pass;

    //点击登录
    @FindBy(className = "el-button")
    WebElement login;

    //2.业务逻辑操作方法

    //登录方法
    public void loginAction(String un, String pw, Actions actions) throws InterruptedException {
        //点击账号输入框,并输入账号
        username.click();
        username.sendKeys(un);

        //点击密码输入框,并输入密码
        password.click();
        password.sendKeys(pw);

        //点击滑块,并拖动验证
        actions.dragAndDropBy(handler, 380, 0).perform();
        actions.release();
        assert (pass.getText().equals("验证通过") == true);

        //点击登录按钮
        login.click();


    }




}
