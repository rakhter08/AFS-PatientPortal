package com.Amgen.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amgen.qa.base.TestBase;

public class CardInformationPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='col-a']//label[@for='toggle-off-1']")
	WebElement radioBtnPg2Q1;

	@FindBy(xpath = "//input[@id='subnewtopic']")
	WebElement continuePge2;

	public CardInformationPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnpg2RadioBtn() {
		radioBtnPg2Q1.click();
	}

	public PatientInformationPage continuePge2Btm() {
		continuePge2.click();
		return new PatientInformationPage();

	}


}
