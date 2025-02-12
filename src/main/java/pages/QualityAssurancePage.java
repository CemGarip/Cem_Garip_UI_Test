package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class QualityAssurancePage extends BasePage{
    protected WebDriver driver = Driver.get();
    public void clickSeeAllButton(String firstText){
        WebElement firstElement = driver.findElement(By.xpath("//div[contains(@class, 'button')]//a[text()='" + firstText + "']"));
        firstElement.click();
    }
}

