package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.*;
import utils.Utils;

import static org.testng.AssertJUnit.*;

public class TestAutomation extends BaseTest {
    HomePage homePage = new HomePage();
    CareersPage careersPage = new CareersPage();
    QualityAssurancePage qualityAssurancePage = new QualityAssurancePage();
    OpenPositionsPage openPositionsPage = new OpenPositionsPage();
    String expectedQaPageUrl = "https://useinsider.com/careers/quality-assurance/";
    String expectedHomePageTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
    @FindBy(xpath = "//label[@for='filter-by-department']/..//span[@title='Quality Assurance']")
    public WebElement txt_selectedDepartment;
    String expectedLeverUrl = "https://jobs.lever.co/useinsider";

    @Test
    public void UITestAutomation() {
        assertEquals(driver.getTitle(), expectedHomePageTitle);
        homePage.acceptCookies();
        homePage.dropdownMenuSelect("Company","Careers");
        assertTrue(careersPage.txt_Location.isDisplayed());
        careersPage.selectQualityAssurance();

        assertEquals(expectedQaPageUrl, driver.getCurrentUrl());
        qualityAssurancePage.clickSeeAllButton("See all QA jobs");

        txt_selectedDepartment = Utils.waitForVisibility(By.xpath("//label[@for='filter-by-department']/..//span[@title='Quality Assurance']"));

        openPositionsPage.selectDepartment("Quality Assurance");
        openPositionsPage.selectLocation("Istanbul, Turkiye");

        openPositionsPage.selectRole();

        openPositionsPage.switchToNewTab();
        assertTrue(driver.getCurrentUrl().contains(expectedLeverUrl));
    }
}
