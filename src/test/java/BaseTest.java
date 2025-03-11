import data.Constants;
import data.SuccessMessages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.AlertBox;
import utils.Wait;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(Constants.URL);
    }


    @Test(priority = 1)
    public void goToWebSiteTest() {
        driver.close();
    }

    @Test(priority = 2)
    public void createAccountTest() {
        driver.findElement(By.cssSelector("#signin2")).click();
        Wait.waitInSeconds(1);
        driver.findElement(By.cssSelector("#sign-username")).sendKeys(Constants.NEW_USERNAME);
        driver.findElement(By.cssSelector("#sign-password")).sendKeys(Constants.PASSWORD);
        driver.findElement(By.xpath("//button[@onclick='register()']")).click();
        Wait.waitInSeconds(1);
        String actualMessage = driver.switchTo().alert().getText();
        String expectedMessage = SuccessMessages.SIGN_UP_SUCCESS;
        Assert.assertEquals(actualMessage, expectedMessage);
        AlertBox.accept(driver);
    }

    @Test(priority = 3)
    public void loginTest() {
        driver.findElement(By.cssSelector("#login2")).click();
        Wait.waitInSeconds(1);
        driver.findElement(By.cssSelector("#loginusername")).sendKeys(Constants.USERNAME);
        driver.findElement(By.cssSelector("#loginpassword")).sendKeys(Constants.PASSWORD);
        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
        Wait.waitInSeconds(2);
        String actualMessage = driver.findElement(By.cssSelector("#nameofuser")).getText();
        Assert.assertTrue(actualMessage.contains(SuccessMessages.WELCOME));
    }

    @Test(priority = 4)
    public void endToEndTest() {
        driver.findElement(By.cssSelector("#login2")).click();
        Wait.waitInSeconds(1);
        driver.findElement(By.cssSelector("#loginusername")).sendKeys(Constants.USERNAME);
        driver.findElement(By.cssSelector("#loginpassword")).sendKeys(Constants.PASSWORD);
        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
        Wait.waitInSeconds(1);
        //#itemc:nth-child(2) css pt (//a[@id='itemc'])[1]")
        driver.findElement(By.xpath("(//a[@id='itemc'])[1]")).click();
        Wait.waitInSeconds(1);
        driver.findElement(By.xpath("(//div[@class='card h-100'])[1]")).click();
        Wait.waitInSeconds(1);
        driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
        Wait.waitInSeconds(2);
        AlertBox.accept(driver);
        driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();
        driver.findElement(By.xpath("(//a[@id='itemc'])[2]")).click();
        Wait.waitInSeconds(1);
        driver.findElement(By.xpath("(//div[@class='card h-100'])[3]")).click();
        Wait.waitInSeconds(2);
        driver.findElement(By.xpath("//a[@onclick='addToCart(11)']")).click();
        Wait.waitInSeconds(1);
        AlertBox.accept(driver);
        driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();
        driver.findElement(By.xpath("(//a[@id='itemc'])[3]")).click();
        Wait.waitInSeconds(2);
        driver.findElement(By.xpath("(//div[@class='card h-100'])[1]")).click();
        Wait.waitInSeconds(1);
        driver.findElement(By.xpath("//a[@onclick='addToCart(10)']")).click();
        Wait.waitInSeconds(1);
        AlertBox.accept(driver);
        Wait.waitInSeconds(2);
        driver.findElement(By.cssSelector("#cartur")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();
        Wait.waitInSeconds(1);
        driver.findElement(By.cssSelector("#name")).sendKeys(Constants.NAME);
        driver.findElement(By.cssSelector("#country")).sendKeys(Constants.COUNTRY);
        driver.findElement(By.cssSelector("#city")).sendKeys(Constants.CITY);
        driver.findElement(By.cssSelector("#card")).sendKeys(Constants.CARD_NR);
        driver.findElement(By.cssSelector("#month")).sendKeys(Constants.CARD_MONTH);
        driver.findElement(By.cssSelector("#year")).sendKeys(Constants.CARD_YEAR);
        driver.findElement(By.cssSelector("button[onclick='purchaseOrder()']")).click();
        Wait.waitInSeconds(1);
        String actualMessage = driver.findElement(By.cssSelector
                (".sweet-alert.showSweetAlert.visible")).getText();
        Assert.assertTrue(actualMessage.contains(SuccessMessages.SUCCESS_PURCHASE));
        driver.findElement(By.cssSelector("button[class='confirm btn btn-lg btn-primary']")).click();
    }
}
