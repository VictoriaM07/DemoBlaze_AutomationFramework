package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    Logger log = LogManager.getLogger(ProductPage.class);

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    WebElement addToCart;

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    WebElement homePageLink;

    @FindBy(css = "#cartur")
    WebElement cartPageLink;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    WebElement addToCartButtonColor;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        try {
            addToCart.click();
            log.info("Click on Add to Cart button");
        } catch (Exception e) {
            log.error("Error: Add to cart button cannot be clicked");
            throw new RuntimeException(e);
        }
    }

    public void clickHomePageLink() {
        try {
            homePageLink.click();
            log.info("Click on Home Page Link");
        } catch (Exception e) {
            log.error("Error: Home page link cannot be clicked");
            throw new RuntimeException(e);
        }
    }

    public void clickCartPageLink() {
        try {
            cartPageLink.click();
            log.info("Click on Cart Page link");
        } catch (Exception e) {
            log.error("Error: Cart page link cannot be clicked ");
            throw new RuntimeException(e);
        }
    }

    public String getAddToCartButtonColor() {
        String color = null;
        try {
            color = addToCartButtonColor.getCssValue("background-color");
            log.info("Retrieving add to cart button background-color");
        } catch (Exception e) {
            log.error("Error: Add to cart button background-color cannot be retrieved");
        }
        return color;
    }

    public String getAddToCartButtonTextColor() {
        String color = null;
        try {
            color = addToCartButtonColor.getCssValue("color");
            log.info("Retrieving add to cart button color");
        } catch (Exception e) {
            log.error("Error: Add to cart button color cannot be retrieved");
        }
        return color;
    }
}
