package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationpractice.base.TestBase;

public class ProductPage extends TestBase {

	@FindBy(xpath = "//div[@id=\"block_top_menu\"]//a[contains(text(),'Women')]")
	WebElement women;

	@FindBy(xpath = "(//a[@class=\"quick-view\"])[1]")
	WebElement quickview;

	@FindBy(xpath = "//p[@id=\"quantity_wanted_p\"]/input")
	WebElement quantity;

	@FindBy(xpath = "//p[@id=\"add_to_cart\"]/button")
	WebElement add_to_cart;

	@FindBy(xpath = "//a[@title=\"Proceed to checkout\"]")
	WebElement checkout;

	@FindBy(xpath = "(//a[@title=\"Proceed to checkout\"])[2]")
	WebElement checkout1;

	@FindBy(xpath = "//form[@id=\"form\"]/div/p[2]/div/span/input")
	WebElement agree;

	@FindBy(name = "processCarrier")
	WebElement processCarrier;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public String totalprice;
	public String totalPriceOrderPage;

	public void productdetails() throws InterruptedException {
		women.click();
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//ul[@class=\"product_list grid row\"]/li[1]/div"))).click()
				.build().perform();
		Thread.sleep(3000);

		quickview.click();

		Thread.sleep(3000);

		driver.switchTo().frame(0);

		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id=\"quantity_wanted_p\"]/input")));

		// quickview.click();
		quantity.clear();
		quantity.sendKeys("2");

		add_to_cart.click();

		driver.switchTo().defaultContent();

		new WebDriverWait(driver, 60)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title=\"Proceed to checkout\"]")));

		checkout.click();

		new WebDriverWait(driver, 60).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title=\"Proceed to checkout\"])[2]")));
		checkout1.click();

		new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type=\"submit\"])[2]")));

		driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();

		new WebDriverWait(driver, 60).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"form\"]/div/p[2]/div/span/input")));
		agree.click();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", processCarrier);

		Thread.sleep(5000);

		// String s = driver.findElement(By.id("total_price")).getText();

		driver.findElement(By.xpath("//a[@class='bankwire']")).click();

		new WebDriverWait(driver, 60).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'I confirm my order')]")));

		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
		new WebDriverWait(driver, 60)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"price\"]")));

		totalprice = driver.findElement(By.xpath("//span[@class=\"price\"]")).getText();

		driver.findElement(By.xpath("//a[contains(text(),'My orders')]")).click();

		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//table[@id=\"order-list\"]/tbody/tr/td[3])[1]")));

		totalPriceOrderPage = driver.findElement(By.xpath("(//table[@id=\"order-list\"]/tbody/tr/td[3])[1]")).getText();

	}

}
