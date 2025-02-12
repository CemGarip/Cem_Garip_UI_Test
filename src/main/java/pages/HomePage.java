package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;
import utils.Driver;

public class HomePage extends BasePage {

    protected WebDriver driver = Driver.get();
    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement btn_acceptCookieButton;

    public void dropdownMenuSelect(String firstText, String secondText) {
        // Navigation Bar Selection
        WebElement firstElement = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']//a[contains(text(), '" + firstText + "')]"));
        firstElement.click();

        // Dropdown Menu Selection
        WebElement secondElement = driver.findElement(By.xpath("//div[@aria-labelledby='navbarDropdownMenuLink']//a[contains(text(), '" + secondText + "')]"));
        secondElement.click();
    }

    public void acceptCookies() {
        Utils.waitForClickability(btn_acceptCookieButton);
        btn_acceptCookieButton.click();
    }
}
