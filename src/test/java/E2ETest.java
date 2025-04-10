import data.SuccessMessages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.*;
import utils.AlertBox;
import utils.Wait;

public class E2ETest extends BaseTest {
    Logger log = LogManager.getLogger(E2ETest.class);

    @Test
    public void endToEndTest() {
        log.info("Test is started");
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickLoginButton();
        //#itemc:nth-child(2) css pt (//a[@id='itemc'])[1]")
        homePage.selectPhonesCategory();
        homePage.selectSamsungS6Phone();
        Wait.waitInSeconds(1);
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        Wait.waitInSeconds(2);
        AlertBox.accept(driver);
        productPage.clickHomePageLink();
        homePage.selectLaptopsCategory();
        Wait.waitInSeconds(1);
        homePage.selectMacBookAirLaptop();
        Wait.waitInSeconds(2);
        productPage.clickAddToCart();
        Wait.waitInSeconds(1);
        AlertBox.accept(driver);
        productPage.clickHomePageLink();
        homePage.selectMonitorsCategory();
        Wait.waitInSeconds(2);
        homePage.selectAppleMonitor24();
        Wait.waitInSeconds(1);
        productPage.clickAddToCart();
        Wait.waitInSeconds(1);
        AlertBox.accept(driver);
        Wait.waitInSeconds(2);
        productPage.clickCartPageLink();
        Wait.waitInSeconds(1);
        CartPage cartPage = new CartPage(driver);
        cartPage.clickPlaceOrderButton();
        Wait.waitInSeconds(1);
        PurchaseOrderPage purchaseOrderPage = new PurchaseOrderPage(driver);
        purchaseOrderPage.inputName();
        purchaseOrderPage.inputCountry();
        purchaseOrderPage.inputCity();
        purchaseOrderPage.inputCardNumber();
        purchaseOrderPage.inputCardExpireMonth();
        purchaseOrderPage.inputCardExpireYear();
        purchaseOrderPage.clickPurchaseOrderButton();
        Wait.waitInSeconds(1);
        ThankYouPage thankYouPage = new ThankYouPage(driver);
        String actualMessage = thankYouPage.getThankYouMessage();
        Assert.assertTrue(actualMessage.contains(SuccessMessages.SUCCESS_PURCHASE));
        ConfirmPurchaseOrderPage confirmPurchaseOrderPage = new ConfirmPurchaseOrderPage(driver);
        confirmPurchaseOrderPage.clickToCloseConfirmationPage();
    }
}
