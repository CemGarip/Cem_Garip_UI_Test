package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

public class CareersPage extends BasePage {
    @FindBy(id = "career-our-location")
    public WebElement txt_Location;
    @FindBy(xpath = "//a[text()='See all teams']")
    public WebElement btn_seeAllTeamsButton;
    @FindBy(xpath = "//*[text()='Quality Assurance']")
    public WebElement btn_qualityAssuranceButton;


    public void selectQualityAssurance() {
        Utils.clickWithJS(btn_seeAllTeamsButton);
        Utils.clickWithJS(btn_qualityAssuranceButton);
    }
}
