package com.Amgen.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amgen.qa.base.TestBase;

public class PhysicianInformationPage extends TestBase{
	
	// PHYSICIAN PAGE FACTORY LOCATORS
		@FindBy(xpath = "//input[@id='doc_first_name']")
		WebElement doctorfirstName;

		@FindBy(xpath = "//input[@id='doc_last_name']")
		WebElement doctorlasttName;

		@FindBy(xpath = "//input[@id='doc_practice_name']")
		WebElement doctorPracticeName;

		@FindBy(xpath = "//input[@id='doc_street']")
		WebElement doctorStreetAddress;

		@FindBy(xpath = "//input[@id='doc_city']")
		WebElement doctorcityname;

		@FindBy(xpath = "//input[@id='doc_phone']")
		WebElement doctorphoneNumber;

		@FindBy(xpath = "//input[@id='doc_zip']")
		WebElement doctorzipCode;

		@FindBy(xpath = "//div[@id='display_doc_state']")
		WebElement docmnthSelectBox;

		@FindBy(xpath = "//div[@id='doc_state_NC']")
		WebElement docMnthDropDwn;

		@FindBy(xpath = "//input[@id='subnewtopic']")
		WebElement docPageContinueBtn;

		// PRESCRIPTION INFORMATION PAGE
		@FindBy(xpath = "//a[@class='Nplate']")
		WebElement NplatePrescriptionLink;

		@FindBy(xpath = "//a[@class='Kanjinti']")
		WebElement kanjinitiPrescriptionLink;

		@FindBy(xpath = "//a[@class='Mvasi']")
		WebElement mVasiPrescriptionLink;

		@FindBy(xpath = "//input[@id='subnewtopic']")
		WebElement prescriptionPageContinueBtn;

		public PhysicianInformationPage() {
			PageFactory.initElements(driver, this);
		}

		// PHYSICIAN PAGE METHODS
		public void fillOutDoctorInformation(String docFName, String docLName, String docPracticeName,
				String docStreetAddrss, String docCity, String docPhoneNum, String docZipCode) {
			doctorfirstName.sendKeys(docFName);
			doctorlasttName.sendKeys(docLName);
			doctorPracticeName.sendKeys(docPracticeName);
			doctorStreetAddress.sendKeys(docStreetAddrss);
			doctorcityname.sendKeys(docCity);
			doctorphoneNumber.sendKeys(docPhoneNum);
			doctorzipCode.sendKeys(docZipCode);

		}

		public void physicianMonthDropDown() {
			docmnthSelectBox.click();
			docMnthDropDwn.click();

		}

		public void physicianContinueBtn() {
			docPageContinueBtn.click();

		}

		// PRESCRIPTION INFORMATION PAGE
		public void selectPrescriptionInformation() {
			mVasiPrescriptionLink.click();
			NplatePrescriptionLink.click();
			kanjinitiPrescriptionLink.click();
			prescriptionPageContinueBtn.click();
		}
	

}
