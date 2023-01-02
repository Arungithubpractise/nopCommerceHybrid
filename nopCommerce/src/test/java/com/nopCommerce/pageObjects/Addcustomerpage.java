package com.nopCommerce.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addcustomerpage {

	public WebDriver Idriver;

	public Addcustomerpage(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(Idriver, this);
	}

	By lnkCustomers_menu = By.xpath("//i[@class='nav-icon far fa-user']");
	By lnkCustomers_menuitem = By.xpath("//p[text()=' Customers']");

	By btnAddnew = By.xpath("//i[@class='fas fa-plus-square']");

	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");

	By txtcustomerRoles = By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
	By lstitemAdministrators = By.xpath("//li[contains(text(), 'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(), 'Registered')]");
	By lstitemGuests = By.xpath("//li[contains (text(), 'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(), 'Vendors')]");

	By drpmgrOfVendor = By.xpath("//* [@id='VendorId']");
	By rdMaleGender = By.id("Gender_Male");
	By rdFeMaleGender = By.id("Gender_Female");

	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By txtDob = By.xpath("//input[@id= 'DateOfBirth']");
	By txtCompanyName = By.xpath("//input[@id='Company']");
	By txtAdminContent = By.xpath("//textarea [@id='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");

	public void clickOnCustomersMenu() throws InterruptedException {
		/*
		 * WebDriverWait wait = new WebDriverWait(Idriver, Duration.ofSeconds(30));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(lnkCustomers_menu));
		 */

		Thread.sleep(10);
		Idriver.findElement(lnkCustomers_menu).click();
	}

	public void lnkCustomers_menuitem() {

		Idriver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddnew() {
		Idriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		Idriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		Idriver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRoles(String role) throws InterruptedException {
		if (!role.equals("Registered")) {
			Idriver.findElement(By.xpath("//li//span[@aria-hidden='true']")).click();

		}
		Thread.sleep(3000);

		Idriver.findElement(txtcustomerRoles).click();

		WebElement listitem = null;

		if (role.equals("Administrators")) {
			listitem = Idriver.findElement(lstitemAdministrators);
		}

		else if (role.equals("Registered")) {
			listitem = Idriver.findElement(lstitemRegistered);
		}

		else if (role.equals("Guests")) {
			listitem = Idriver.findElement(lstitemGuests);

		} else if (role.equals("Vendors")) {
			listitem = Idriver.findElement(lstitemVendors);
		}

		listitem.click();
		Thread.sleep(1000);

		// JavascriptExecutor js = (JavascriptExecutor) Idriver;
		// js.executeScript("arguments[0].click();", listitem);
	}

	public void setManagerOfVendor(String value) {
		Select drp = new Select(Idriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			Idriver.findElement(rdMaleGender).click();
		} else if (gender.equals("Female")) {
			Idriver.findElement(rdFeMaleGender).click();
		} else {
			Idriver.findElement(rdMaleGender).click();
		}
	}

	public void setFirstname(String fname) {
		Idriver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLasttname(String lname) {
		Idriver.findElement(txtLastName).sendKeys(lname);
	}

	public void setdob(String dob) {
		Idriver.findElement(txtDob).sendKeys(dob);
	}

	public void setCompanyName(String cname) {
		Idriver.findElement(txtCompanyName).sendKeys(cname);
	}

	public void setAdmincontent(String Acontent) {
		Idriver.findElement(txtAdminContent).sendKeys(Acontent);
	}

	public void clickonsave(String dob) {
		Idriver.findElement(btnSave).click();
	}

}
