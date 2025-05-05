package cucumber_tests.steps;

import data.Constants;
import data.SuccessMessages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import page.objects.HomePage;
import page.objects.LoginPage;
import utils.Wait;

import java.util.List;

public class LoginSteps {
    WebDriver driver = new ChromeDriver();

    @Given("User navigate to home page for login")
    public void navigateToHomePageForLogin() {
        driver.get(Constants.URL);
        driver.manage().window().maximize();
    }

    @When("User clicks on Log in button in home page")
    public void userClicksOnLogInButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
    }

    @And("User inputs {string} and password")
    public void userInputsValidCredentials(String name) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(name);
        loginPage.inputPassword();
    }

    @And("User clicks on Log in button in login page")
    public void userClicksOnLogInButtonInLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @Then("User sees the Welcome message")
    public void userSeesTheWelcomeMessage() {
        HomePage homePage = new HomePage(driver);
        String name = homePage.getNameOfUser();
        Assert.assertTrue(name.contains(SuccessMessages.WELCOME));
    }

    @And("User attemps to sign in with the following usernames:")
    public void userAttempsToSignInWithTheFollowingUsernames(DataTable table) {
        List<String> names = table.asList();
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);
        for (String n : names) {
            loginPage.inputUsername(n);
            loginPage.inputPassword();
            loginPage.clickLoginButton();
            Wait.waitInSeconds(1);
            homePage.checkWelcomeMessage();
            homePage.clickLogoutButton();
            homePage.clickLoginButton();
        }
    }
}
