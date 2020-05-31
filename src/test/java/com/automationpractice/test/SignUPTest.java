package com.automationpractice.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.base.TestBase;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.SignUp;

public class SignUPTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	SignUp signUp;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		loginPage = new LoginPage();
		signUp = new SignUp();
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginBtn();

		signUp = loginPage.createaccount();

		Thread.sleep(5000);
	}

	@Test
	public void productDeatils() throws InterruptedException {
		signUp.fillform();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
