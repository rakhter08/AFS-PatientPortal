package com.Amgen.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amgen.qa.base.TestBase;

public class StandAlonePage extends TestBase{
	
	@FindBy(xpath = "//a[contains(text(),'Get')]")
	WebElement getStartedLink;

	@FindBy(xpath = "//*[@id=\"CybotCookiebotDialogBodyButtonAccept\"]")
	WebElement alertPopUp;

	public StandAlonePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public EligibilityPage clickOnGetStarted() {
		alertPopUp.click();
		getStartedLink.click();
		return new EligibilityPage();
	}

}
