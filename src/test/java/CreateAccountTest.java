import data.SuccessMessages;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.SignUpPage;
import utils.AlertBox;

public class CreateAccountTest extends BaseTest{

    @Test
    public void createAccountTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpButton();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.inputUsername();
        signUpPage.inputPassword();
        signUpPage.clickRegisterButton();
        String actualMessage = AlertBox.getText(driver);
        String expectedMessage = SuccessMessages.SIGN_UP_SUCCESS;
        Assert.assertEquals(actualMessage, expectedMessage);
        AlertBox.accept(driver);
    }
}
