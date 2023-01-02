package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.utilities.ReadConfig;

public class Loginpage {

	WebDriver Idriver;

	public Loginpage(WebDriver rdriver) {
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "Email")
	WebElement txtEmail;

	@FindBy(id = "Password")
	WebElement txtPassword;

	@FindBy(xpath = "//button")
	WebElement btnLogin;

	@FindBy(linkText = "Logout")
	WebElement lnkLogout;
	
	static ReadConfig config = new ReadConfig();

	public void setUserName(String user) {

		txtEmail.clear();
		txtEmail.sendKeys(user);

	}

	public void setPassword(String pwd) {

		txtPassword.clear();

		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}

	
	
	

}
