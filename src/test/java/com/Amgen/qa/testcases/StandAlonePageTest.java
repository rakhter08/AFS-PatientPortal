package com.Amgen.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amgen.qa.base.TestBase;
import com.Amgen.qa.pages.EligibilityPage;
import com.Amgen.qa.pages.StandAlonePage;

public class StandAlonePageTest extends TestBase{
	
	StandAlonePage standAlonePage;
	EligibilityPage eligibilityPage;

	public StandAlonePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		standAlonePage = new StandAlonePage();
		eligibilityPage = new EligibilityPage();

	}

	@Test(priority = 1)
	public void verifyStandalonePageTitle() {
		String standAlonePageTitle = standAlonePage.verifyPageTitle();
		Assert.assertEquals(standAlonePageTitle, "Amgen FIRST STEP™ Program");
	}

	@Test(priority = 2)
	public void clickOnGetStartedLinkTest() throws InterruptedException {
		Thread.sleep(3000);
		eligibilityPage=standAlonePage.clickOnGetStarted();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
