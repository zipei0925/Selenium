package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import framework.BasePage;

public class HomePage extends BasePage{
    /*
    * 京东首页-输入查询内容-点击搜索按钮
    * */

    //定位到搜索框
    @FindBy (id="key")
    WebElement searchInputBox;

    //点击搜索按钮
    @FindBy (className="button")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    // 输入关键字,点击搜索按钮
    public SearchResultPage searchResultListPage (String keyword){
        //创建BasePage对象,调用BasePage类中的方法
        sendKeys(searchInputBox, keyword);
        click(searchButton);

        return new SearchResultPage(driver);
    }

}
