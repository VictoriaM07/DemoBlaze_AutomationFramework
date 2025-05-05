package selenium_tests;

import data.Colors;
import data.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.LoginPage;
import page.objects.ProductPage;
import utils.Wait;

public class ColorTest extends BaseTest {

    @Test
    public void checkAddToCartButtonColorTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(Constants.USERNAME);
        loginPage.inputPassword();
        loginPage.clickLoginButton();
        homePage.selectPhonesCategory();
        homePage.selectSamsungS6Phone();
        Wait.waitInSeconds(1);
        ProductPage productPage = new ProductPage(driver);
        String actualColor = productPage.getAddToCartButtonColor();
        Assert.assertEquals(actualColor, Colors.GREEN);
    }

    @Test
    public void checkSamsungGalaxyS6TitleColorTest(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(Constants.USERNAME);
        loginPage.inputPassword();
        loginPage.clickLoginButton();
        homePage.selectPhonesCategory();
        String actualColor = homePage.getSamsungGalaxyS6TitleColor();
        Assert.assertEquals(actualColor, Colors.BLUE);
    }

    @Test
    public void checkAddToCartButtonTextColorTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(Constants.USERNAME);
        loginPage.inputPassword();
        loginPage.clickLoginButton();
        Wait.waitInSeconds(1);
        homePage.selectPhonesCategory();
        homePage.selectSamsungS6Phone();
        Wait.waitInSeconds(1);
        ProductPage productPage = new ProductPage(driver);
        String actualColor = productPage.getAddToCartButtonTextColor();
        Assert.assertEquals(actualColor, Colors.WHITE);
    }
}
