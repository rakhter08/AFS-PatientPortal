package com.Amgen.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amgen.qa.base.TestBase;

public class EligibilityPage extends TestBase{

	@FindBy(xpath = "//div[@class='col-a']//label[@for='toggle-on-1']")
	WebElement radioyesBtnQ1;

	@FindBy(xpath = "//div[@class='col-a']//label[@for='toggle-on-2']")
	WebElement radioYesBtnQ2;

	@FindBy(xpath = "//div[@class='col-a']//label[@for='toggle-off-3']")
	WebElement radioNoBtnQ3;

	@FindBy(xpath = "//div[@class='col-a']//label[@for='toggle-off-6']")
	WebElement radioNoBtnQ4;

	@FindBy(xpath = "//div[@class='col-a']//label[@for='toggle-on-7']")
	WebElement radioNoBtnQ5;

	@FindBy(xpath = "//input[@id='subnewtopic']")
	WebElement verifySubmitBtn;
	
	public EligibilityPage() {
		PageFactory.initElements(driver, this);
	}

	public CardInformationPage filloutEligebilityQuestions() {
		radioyesBtnQ1.click();
		radioYesBtnQ2.click();
		radioNoBtnQ3.click();
		radioNoBtnQ4.click();
		radioNoBtnQ5.click();
		verifySubmitBtn.click();
		return new CardInformationPage();
	}
	
	
	
	
}
