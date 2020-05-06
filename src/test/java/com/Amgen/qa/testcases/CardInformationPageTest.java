package com.Amgen.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amgen.qa.base.TestBase;
import com.Amgen.qa.pages.CardInformationPage;
import com.Amgen.qa.pages.EligibilityPage;
import com.Amgen.qa.pages.PatientInformationPage;
import com.Amgen.qa.pages.StandAlonePage;

public class CardInformationPageTest extends TestBase{
	
	StandAlonePage standAlonePage;
	EligibilityPage eligibilityPage;
	CardInformationPage cardInformationPage;
	PatientInformationPage patientInformationPage;

	public CardInformationPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		eligibilityPage = new EligibilityPage();
		standAlonePage = new StandAlonePage();
		cardInformationPage = new CardInformationPage();
		patientInformationPage = new PatientInformationPage();
		Thread.sleep(3000);
		eligibilityPage = standAlonePage.clickOnGetStarted();
		cardInformationPage = eligibilityPage.filloutEligebilityQuestions();

	}

	@Test
	public void clickContinuePge2BtnTest() throws InterruptedException {
		cardInformationPage.clickOnpg2RadioBtn();
		Thread.sleep(5000);
		patientInformationPage = cardInformationPage.continuePge2Btm();
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	

}
