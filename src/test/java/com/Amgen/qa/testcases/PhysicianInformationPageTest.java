package com.Amgen.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Amgen.qa.base.TestBase;
import com.Amgen.qa.pages.CardInformationPage;
import com.Amgen.qa.pages.EligibilityPage;
import com.Amgen.qa.pages.PatientInformationPage;
import com.Amgen.qa.pages.PhysicianInformationPage;
import com.Amgen.qa.pages.StandAlonePage;
import com.Amgen.qa.util.TestUtil;

public class PhysicianInformationPageTest extends TestBase{
	
	StandAlonePage standAlonePage;
	EligibilityPage eligibilityPage;
	CardInformationPage cardInformationPage;
	PatientInformationPage patientInformationPage;
	PhysicianInformationPage physicianInformationPage;

	String sheetName = "PATIENT-DOCTOR-INFO";

	public PhysicianInformationPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		eligibilityPage = new EligibilityPage();
		standAlonePage = new StandAlonePage();
		cardInformationPage = new CardInformationPage();
		patientInformationPage = new PatientInformationPage();
		physicianInformationPage = new PhysicianInformationPage();
		Thread.sleep(3000);
		eligibilityPage = standAlonePage.clickOnGetStarted();
		cardInformationPage = eligibilityPage.filloutEligebilityQuestions();
		cardInformationPage.clickOnpg2RadioBtn();
		patientInformationPage = cardInformationPage.continuePge2Btm();

	}

	@DataProvider
	public Object[][] getPhysicianTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getPhysicianTestData")
	public void physicianInformationPageTest(String firstname, String lastname, String socialnumber,
			String streetaddress, String city, String zipcode, String phonenumber, String email,
			String DoctorsFirstName, String DoctorsLastName, String PracticeName, String DoctorStreetAddress,
			String City, String PhoneNumber, String ZipCode) throws InterruptedException {

		patientInformationPage.clickongenderBtn();
		patientInformationPage.clickbirthdayfield();
		patientInformationPage.fillOutPatientInformation(firstname, lastname, socialnumber, streetaddress, city,
				zipcode, phonenumber, email);
		patientInformationPage.clickOnSSNBoxToActivate();
		Thread.sleep(4000);
		patientInformationPage.clickstateDropDown();
		patientInformationPage.clickOnConcentBtn();
		patientInformationPage.clickOnContinuePIpage();

		// PHYSIXIAN PAGE TEST STARTS HERE
		physicianInformationPage.fillOutDoctorInformation(DoctorsFirstName, DoctorsLastName, PracticeName,
				DoctorStreetAddress, City, PhoneNumber, ZipCode);

		physicianInformationPage.physicianMonthDropDown();
		physicianInformationPage.physicianContinueBtn();

		// PRESCRIPTION PAGE
		physicianInformationPage.selectPrescriptionInformation();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
