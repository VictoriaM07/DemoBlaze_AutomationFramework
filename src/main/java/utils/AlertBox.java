package utils;

import org.openqa.selenium.WebDriver;

public class AlertBox {

    public static void accept(WebDriver driver){
        driver.switchTo().alert().accept();
    }
}

