package com.automationpractice.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.base.TestBase;

public class SignUp extends TestBase {

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement create;

	@FindBy(xpath = "//form[@id='create-account_form']//span[1]")
	WebElement signupBtn;

	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement gender;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement firstname;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement lastname;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;
	@FindBy(xpath = "//input[@id='address1']")
	WebElement address;
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;

	@FindBy(xpath = "//select[@id='id_state']")
	WebElement state;

	@FindBy(xpath = "//select[@id='id_country']")
	WebElement country;

	@FindBy(xpath = "//input[@id='postcode']")
	WebElement zip;

	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement mobile;

	@FindBy(xpath = "//input[@id='alias']")
	WebElement alias;

	public SignUp() {
		PageFactory.initElements(driver, this);
	}

	public void fillform() {

		
		gender.click();
		firstname.sendKeys("asdasdsd");
		lastname.sendKeys("asdasd");
		
		//email.sendKeys(rand_int1 + "@gmail.com");
		password.sendKeys("Test@1234");
		address.sendKeys("asdadasdasda assdasda");
		city.sendKeys("Pune");
		Select sel = new Select(state);
		sel.selectByIndex(3);
		zip.sendKeys("00000");
		Select sel1 = new Select(country);
		sel1.selectByIndex(1);
		mobile.sendKeys("1234567890");
		alias.sendKeys("dasdas");
	}

}
