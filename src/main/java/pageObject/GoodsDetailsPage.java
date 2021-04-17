package pageObject;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoodsDetailsPage extends BasePage {
    /*
    * 商品详情页:获取商品价格, 加入购物车
    * */
    @FindBy (className="price")
    WebElement productPrice;

    @FindBy(id="InitCartUrl")
    WebElement addCart;

    public GoodsDetailsPage(WebDriver driver) {
        super(driver);
    }

    /*
    * 获取当前商品价格
    * */
    public String getPriceOnDetailsPage() {
       return productPrice.getText();
    }

    /*
    * 点击添加购物车按钮
    * */
    public void addToCart(){
        click(addCart);
    }

}
