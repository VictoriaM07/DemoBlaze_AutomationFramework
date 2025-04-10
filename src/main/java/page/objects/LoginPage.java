package page.objects;

import data.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    Logger log = LogManager.getLogger(LoginPage.class);

    @FindBy(css = "#loginusername")
    WebElement username;

    @FindBy(css = "#loginpassword")
    WebElement password;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOf(username));
            username.sendKeys(Constants.USERNAME);
            log.info("Insert username in the username field");
        } catch (Exception e) {
            log.error("Error: Username cannot be inserted");
            throw new RuntimeException(e);
        }
    }

    public void inputPassword() {
        password.sendKeys(Constants.PASSWORD);
    }

    public void clickLoginButton() {
        try {
            loginButton.click();
            log.info("Click on login button");
        } catch (Exception e) {
            log.error("Error: Login button cannot be clicked");
            throw new RuntimeException(e);
        }
    }
}
