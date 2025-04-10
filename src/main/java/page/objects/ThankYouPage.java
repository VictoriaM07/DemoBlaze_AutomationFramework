package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouPage extends BasePage{
    Logger log = LogManager.getLogger(ThankYouPage.class);

    @FindBy(css = ".sweet-alert.showSweetAlert.visible")
    WebElement thankYouMessage;

    public ThankYouPage(WebDriver driver) {
        super(driver);
    }

    public String getThankYouMessage(){
        String message = thankYouMessage.getText();
        log.info("Retriving thank you message");
        return message;
    }
}
