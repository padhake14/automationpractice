package com.automationpractice.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement passwd;

	@FindBy(id = "SubmitLogin")
	WebElement SubmitLogin;

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement create;

	@FindBy(xpath = "//form[@id='create-account_form']//span[1]")
	WebElement createBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public ProductPage login(String username, String password) {
		email.sendKeys(username);
		passwd.sendKeys(password);
		SubmitLogin.click();
		return new ProductPage();
	}

	public SignUp createaccount() {
		Random rand = new Random();

		int rand_int1 = rand.nextInt(1000);
		System.out.println(rand_int1);
		create.sendKeys(rand_int1 + "@gmail.com");
		createBtn.click();
		return new SignUp();

	}
}
