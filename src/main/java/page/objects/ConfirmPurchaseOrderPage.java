package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmPurchaseOrderPage extends BasePage {
    Logger log = LogManager.getLogger(ConfirmPurchaseOrderPage.class);

    @FindBy(css = "button[class='confirm btn btn-lg btn-primary']")
    WebElement closeConfirmationPage;

    public ConfirmPurchaseOrderPage(WebDriver driver) {
        super(driver);
    }

    public void clickToCloseConfirmationPage() {
        try {
            closeConfirmationPage.click();
            log.info("Click to close confirmation page");
        } catch (Exception e) {
            log.error("Error: Confirmation page cannot be closed");
            throw new RuntimeException(e);
        }
    }
}
