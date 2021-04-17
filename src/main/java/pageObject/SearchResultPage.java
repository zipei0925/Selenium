package pageObject;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    /*
     * 商品查找结果页:点击列表中第一个商品进入详情页,并获取其价格
     * */

    //定位列表中第一个商品
    @FindBy(xpath = "//*[@id='J_goodsList']/ul/li[1]//a")
    WebElement firstSearchGoodsImg;

    //定位列表中第二个商品
    @FindBy(xpath = "//*[@id='J_goodsList']/ul/li[2]//a")
    WebElement secondSearchGoodsImg;

    //定位列表中第一个商品价格
    @FindBy(xpath = "//*[@id='J_goodsList']/ul/li[1]//strong/i")
    WebElement firstSearchGoodsPrice;

    public SearchResultPage (WebDriver driver) {
        super(driver);
    }

    /*
    * 点击商品,进入商品详情页
    * */

    public GoodsDetailsPage goodsDetailsPage () {
        click(firstSearchGoodsImg);
        implicitlyWait(5);
        return new GoodsDetailsPage(driver);
    }

    /*
    * 获取第一个商品的价格
    * */
    public String getFirstGoodsPrice() {
        return firstSearchGoodsPrice.getText();
    }

}
