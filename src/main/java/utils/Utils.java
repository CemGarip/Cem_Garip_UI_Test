package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static WebDriverWait getWaiter(long seconds) {
        return new WebDriverWait(Driver.get(), Duration.ofSeconds(seconds));
    }
    public static WebElement waitForVisibility(By locator) {
        return getWaiter(10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }
    public static void scrollToElement(WebElement element) {

        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView({ block: 'center' });", element);
    }

    public static void waitForClickability(WebElement element) {

        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
