package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    Logger log = LogManager.getLogger(CartPage.class);

    @FindBy(css = ".btn.btn-success")
    WebElement placeOrderButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickPlaceOrderButton() {
        try {
            placeOrderButton.click();
            log.info("Click on Place Order button");
        } catch (Exception e) {
            log.error("Error: Place Order button cannot be clicked");
            throw new RuntimeException(e);
        }
    }
}
