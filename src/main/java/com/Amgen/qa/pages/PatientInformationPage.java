package com.Amgen.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Amgen.qa.base.TestBase;

public class PatientInformationPage extends TestBase{
	
	@FindBy(xpath = "//input[@name='first_name']")
	public WebElement firstName;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lasttName;

	@FindBy(xpath = "//label[contains(text(),'Male')]")
	WebElement gender;

	@FindBy(xpath = "//input[@id='password_SocialSecurityNumber']")
	WebElement socialNumber;

	@FindBy(xpath = "//input[@name='address_1']")
	WebElement StreetAddress;

	@FindBy(xpath = "//input[@name='city']")
	WebElement cityname;

	@FindBy(xpath = "//input[@name='zip']")
	WebElement zipCode;

	@FindBy(xpath = "//input[@name='phone']")
	WebElement phoneNumber;

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailAddress;

	@FindBy(xpath = "//span[@class='checkmark']")
	WebElement concentCheckBox;

	@FindBy(xpath = "//input[@id='subnewtopic']")
	WebElement continueTabPIpage;

	@FindBy(xpath = "//div[@class='custom-select']")
	WebElement mnthSelectBox;

	@FindBy(xpath = "//div[contains(text(),'New York')]")
	WebElement mnthDropDwn;

	@FindBy(xpath = "//input[@id='password_SocialSecurityNumber']")
	WebElement clickOnSSNBoxToActivate;

	public PatientInformationPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickbirthdayfield() {
		Select sel = new Select(driver.findElement(By.xpath("//select[@name='dob_month']")));
		sel.selectByValue("12");

		Select sel2 = new Select(driver.findElement(By.xpath("//select[@name='dob_day']")));
		sel2.selectByValue("26");

		Select sel3 = new Select(driver.findElement(By.xpath("//select[@name='dob_year']")));
		sel3.selectByValue("1986");

	}

	public void clickstateDropDown() {
		mnthSelectBox.click();
		mnthDropDwn.click();

	}

	public void clickongenderBtn() {
		gender.click();
	}

	public void clickOnConcentBtn() {
		concentCheckBox.click();
	}

	public  void fillOutPatientInformation(String fName, String lName, String SSNNUM, String Address, String city,
			String zipCde, String phoneNum, String email) {
		firstName.sendKeys(fName);
		lasttName.sendKeys(lName);
		socialNumber.sendKeys(SSNNUM);
		StreetAddress.sendKeys(Address);
		cityname.sendKeys(city);
		zipCode.sendKeys(zipCde);
		phoneNumber.sendKeys(phoneNum);
		emailAddress.sendKeys(email);
	}

	public void clickOnSSNBoxToActivate() {
		clickOnSSNBoxToActivate.click();
	}

	public PhysicianInformationPage clickOnContinuePIpage() {
		continueTabPIpage.click();
		return new PhysicianInformationPage();
	}
	

}
