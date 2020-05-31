package com.automationpractice.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.base.TestBase;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.ProductPage;

public class ProductTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		loginPage = new LoginPage();
		productPage = new ProductPage();
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginBtn();

		productPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		Thread.sleep(5000);
	}

	@Test
	public void productDeatils() throws InterruptedException {
		productPage.productdetails();
		// verifying prices
		Assert.assertEquals(productPage.totalprice, productPage.totalPriceOrderPage);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
