package selenium_tests;

import data.Constants;
import data.SuccessMessages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.LoginPage;

public class LoginTest extends BaseTest{
Logger log = LogManager.getLogger(LoginTest.class);

    @Test
    public void loginTest() {
        log.info("Test is started");
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(Constants.USERNAME);
        loginPage.inputPassword();
        loginPage.clickLoginButton();
        String actualMessage = homePage.getNameOfUser();
        Assert.assertTrue(actualMessage.contains(SuccessMessages.WELCOME));
    }
}
