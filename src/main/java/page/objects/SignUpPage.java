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

public class SignUpPage extends BasePage {
    Logger log = LogManager.getLogger(SignUpPage.class);

    @FindBy(css = "#sign-username")
    WebElement username;

    @FindBy(css = "#sign-password")
    WebElement password;

    @FindBy(xpath = "//button[@onclick='register()']")
    WebElement registerButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(Constants.NEW_USERNAME);
    }

    public void inputPassword() {
        password.sendKeys(Constants.PASSWORD);
    }

    public void clickRegisterButton() {
        try {
            registerButton.click();
            log.info("Click on register button");
        } catch (Exception e) {
            log.error("Error: Register button cannot be clicked");
        }
    }
}
