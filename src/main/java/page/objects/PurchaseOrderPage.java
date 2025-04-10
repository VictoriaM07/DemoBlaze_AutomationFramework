package page.objects;

import data.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseOrderPage extends BasePage {
    Logger log = LogManager.getLogger(PurchaseOrderPage.class);

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement card;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy(css = "button[onclick='purchaseOrder()']")
    WebElement purchaseOrderButton;

    public PurchaseOrderPage(WebDriver driver) {
        super(driver);
    }

    public void inputName() {
        name.sendKeys(Constants.NAME);
    }

    public void inputCountry() {
        country.sendKeys(Constants.COUNTRY);
    }

    public void inputCity() {
        city.sendKeys(Constants.CITY);
    }

    public void inputCardNumber() {
        card.sendKeys(Constants.CARD_NR);
    }

    public void inputCardExpireMonth() {
        month.sendKeys(Constants.CARD_MONTH);
    }

    public void inputCardExpireYear() {
        year.sendKeys(Constants.CARD_YEAR);
    }

    public void clickPurchaseOrderButton() {
        try {
            purchaseOrderButton.click();
            log.info("Click on purchase order button");
        } catch (Exception e){
            log.error("Error: Purchase order button cannot be clicked");
            throw new RuntimeException(e);
        }
    }
}
