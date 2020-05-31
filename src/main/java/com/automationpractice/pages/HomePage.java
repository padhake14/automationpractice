package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@class=\"login\"]")
	WebElement loginBtn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnLoginBtn() {
		loginBtn.click();
		return new LoginPage();
	}

}
