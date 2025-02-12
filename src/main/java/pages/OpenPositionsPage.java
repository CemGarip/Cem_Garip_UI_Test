package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;
import utils.Driver;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class OpenPositionsPage extends BasePage {
    @FindBy(xpath = "//*[text()='View Role']")
    public List<WebElement> btn_viewRoleButtons;

    @FindBy(xpath = "//label[@for='filter-by-location']/..//span[@role='presentation']")
    public WebElement dd_locationFilter;

    @FindBy(xpath = "//label[@for='filter-by-department']/..//span[@role='presentation']")
    public WebElement dd_departmentFilter;

    @FindBy(xpath = "//*[@data-team='qualityassurance']")
    public List<WebElement> txt_qualityAssuranceRole;

    protected WebDriver driver = Driver.get();

    public void selectLocation(String firstText) {
        Utils.waitForClickability(dd_locationFilter);
        dd_locationFilter.click();
        // Location Selection
        WebElement firstElement = driver.findElement(By.xpath("//span[@class='select2-results']//li[text()='" + firstText + "']"));
        firstElement.click();
    }

    public void selectDepartment(String firstText) {
        Utils.waitForClickability(dd_departmentFilter);
        dd_departmentFilter.click();
        // Department Selection
        WebElement firstElement = driver.findElement(By.xpath("//span[@class='select2-results']//li[text()='" + firstText + "']"));
        firstElement.click();
    }
    public void selectRole() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        Utils.scrollToElement(txt_qualityAssuranceRole.get(randomNumber));
        Utils.clickWithJS(btn_viewRoleButtons.get(randomNumber));
    }

    public void switchToNewTab() {
        Set<String> windowHandles = Driver.get().getWindowHandles();
        Driver.get().switchTo().window(windowHandles.toArray()[1].toString());
    }


}
