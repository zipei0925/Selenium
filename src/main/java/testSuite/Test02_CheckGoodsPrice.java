package testSuite;

import framework.BrowserEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.GoodsDetailsPage;
import pageObject.HomePage;
import pageObject.SearchResultPage;

import java.io.IOException;

public class Test02_CheckGoodsPrice {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws IOException {
        // 加载浏览器
        BrowserEngine browserEngine = new BrowserEngine();
        browserEngine.loadConfig();
        driver = browserEngine.getBrowser();
        browserEngine.implicitlyWait(5);
    }

    @Test
    public void checkPrice() throws InterruptedException {
        //新建HomePage实例化对象,执行搜索方法
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.searchResultListPage("iphone");

        //进入搜索结果列表页面
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        searchResultPage.implicitlyWait(10);
//        Thread.sleep(2000);
        //获取商品价格
        String price1 = searchResultPage.getFirstGoodsPrice();
        System.out.println(price1);
        //点击商品
        searchResultPage.goodsDetailsPage();
        //切换窗口
        searchResultPage.switchWindow();

        //进入商品详情页
        GoodsDetailsPage goodsDetailsPage = PageFactory.initElements(driver, GoodsDetailsPage.class);
        Thread.sleep(1000);
        String price2 = goodsDetailsPage.getPriceOnDetailsPage();
        System.out.println(price2);

        //断言:价格是否一致
        Assert.assertEquals(price1, price2);
        goodsDetailsPage.addToCart();
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
