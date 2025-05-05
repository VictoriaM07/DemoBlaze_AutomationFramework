package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Wait;

import java.time.Duration;

public class HomePage extends BasePage {
    Logger log = LogManager.getLogger(HomePage.class);

    @FindBy(css = "#signin2")
    WebElement signUpButton;

    //WebElement loginButton = driver.findElement(By.cssSelector("#login2"));
    @FindBy(css = "#login2")
    WebElement loginButton;

    @FindBy(css = "#logout2")
    WebElement logoutButton;

    @FindBy(css = "a[onclick=\"byCat('phone')\"]")
    WebElement phoneCategory;

    @FindBy(xpath = "(//h4[@class=\"card-title\"])[1]")
    WebElement samsungS6Phone;

    @FindBy(xpath = "(//a[@id='itemc'])[2]")
    WebElement laptopsCategory;

    @FindBy(xpath = "(//h4[@class='card-title'])[3]")
    WebElement macBookAirLaptop;

    @FindBy(xpath = "(//a[@id='itemc'])[3]")
    WebElement monitorCategory;

    @FindBy(xpath = "(//h4[@class='card-title'])[1]")
    WebElement appleMonitor24;

    @FindBy(css = "#nameofuser")
    WebElement nameOfUser;

    @FindBy(xpath = "(//a[@class=\"hrefch\"])[1]")
    WebElement samsungGalaxyS6TitleColor;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignUpButton() {
        try {
            signUpButton.click();
            log.info("Click on SignUp button");
        } catch (Exception e) {
            log.error("Error: SignUp button cannot be clicked");
            throw new RuntimeException(e);
        }
    }

    public void clickLoginButton() {
        try {
            loginButton.click();
            log.info("Click on Login button");
        } catch (Exception e) {
            log.error("Error: Login button cannot be clicked ");
            throw new RuntimeException(e);
        }
    }

    public void checkWelcomeMessage() {
        String actualMessage = getNameOfUser();
        try {
            assert actualMessage.contains("Welcome");
            log.info("User succesfully log in");
        } catch (Exception e) {
            log.error("Error: Invalid username");
        }
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void selectPhonesCategory() {
        //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //   wait.until(ExpectedConditions.visibilityOf(phoneCategory));
        Wait.waitInSeconds(1);
        try {
            phoneCategory.click();
            log.info("Select phone category");
        } catch (Exception e) {
            log.error("Error: Phone category cannot be selected");
            throw new RuntimeException(e);
        }
    }

    public void selectSamsungS6Phone() {
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //  wait.until(ExpectedConditions.visibilityOfElementLocated
        //        (By.xpath("(//div[@class='card h-100'])[1]")));
        Wait.waitInSeconds(2);
        try {
            samsungS6Phone.click();
            log.info("Click on Samsung S6 phone");
        } catch (Exception e) {
            log.error("Error: Samsung S6 phone cannot be selected");
            throw new RuntimeException(e);
        }
    }

    public void selectLaptopsCategory() {
        try {
            laptopsCategory.click();
            log.info("Select laptop category");
        } catch (Exception e) {
            log.error("Error: Laptop category cannot be selected");
            throw new RuntimeException(e);
        }
    }

    public void selectMacBookAirLaptop() {
        try {
            macBookAirLaptop.click();
            log.info("Click on Mac Book Air laptop");
        } catch (Exception e) {
            log.error("Error: MacBookAir Laptop cannot be selected");
            throw new RuntimeException(e);
        }
    }

    public void selectMonitorsCategory() {
        try {
            monitorCategory.click();
            log.info("Select monitors category");
        } catch (Exception e) {
            log.error("Error: Monitors category cannot be selected");
            throw new RuntimeException(e);
        }
    }

    public void selectAppleMonitor24() {
        try {
            appleMonitor24.click();
            log.info("Click on Apple Monitor24");
        } catch (Exception e) {
            log.error("Error: Apple Monitor24 cannot be selected");
            throw new RuntimeException(e);
        }
    }

    public String getNameOfUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(nameOfUser));
        return nameOfUser.getText();
    }

    public String getSamsungGalaxyS6TitleColor() {
        String color;
        try {
            color = samsungGalaxyS6TitleColor.getCssValue("color");
            log.info("Retrieving title color for Samsung Galaxy S6");
        } catch (Exception e) {
            log.error("Error: Title color cannot be retrieved");
            throw new RuntimeException(e);
        }
        return color;
    }
}
