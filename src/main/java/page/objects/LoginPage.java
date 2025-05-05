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
    WebElement usernameField;

    @FindBy(css = "#loginpassword")
    WebElement passwordField;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameField));
            usernameField.sendKeys(name);
            log.info("Insert username {} in the username field", name);
        } catch (Exception e) {
            log.error("Error: Username cannot be inserted");
            throw new RuntimeException(e);
        }
    }

    public void inputPassword() {
        passwordField.sendKeys(Constants.PASSWORD);
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
