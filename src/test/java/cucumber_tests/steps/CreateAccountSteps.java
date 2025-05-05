package cucumber_tests.steps;

import data.Constants;
import data.SuccessMessages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import page.objects.HomePage;
import page.objects.SignUpPage;
import utils.AlertBox;


public class CreateAccountSteps {
    WebDriver driver = new ChromeDriver();

    @Given("User navigate to home page for sign up")
    public void navigateToHomePageForSignUp() {
        driver.get(Constants.URL);
        driver.manage().window().maximize();
    }

    @When("User clicks on Sign up button in home page")
    public void userClicksOnSignUpButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpButton();
    }

    @And("User create credentials")
    public void userCreateCredentials() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.inputUsername();
        signUpPage.inputPassword();
    }

    @And("User clicks on Sign up button in signUp page")
    public void userClicksOnSignUpButtonInSignUpPage() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickRegisterButton();
    }

    @Then("User sees the Sign up success message")
    public void userSeesTheSignUpSuccessMessage() {
        String actualMessage = AlertBox.getText(driver);
        String expectedMessage = SuccessMessages.SIGN_UP_SUCCESS;
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @And("User close the alert box")
    public void userCloseAlertBox(){
        AlertBox.accept(driver);
    }
}

