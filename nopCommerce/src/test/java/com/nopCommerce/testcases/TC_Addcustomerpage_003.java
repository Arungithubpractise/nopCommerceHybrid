package com.nopCommerce.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.Addcustomerpage;
import com.nopCommerce.pageObjects.Loginpage;
import com.nopCommerce.utilities.ReadConfig;

public class TC_Addcustomerpage_003 extends BaseClass

{
	@Test(groups= {"Sanity"})
	public void Addcustomerpage() throws IOException, InterruptedException {

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(ReadConfig.getApplicationurl());
		
		Loginpage lp = new Loginpage(driver);

		logger.info("URL id opened");

		lp.setUserName(Username);

		logger.info("User name is entered");
		
        lp.setPassword(password);
		
		logger.info("password  is entered");

		lp.clickLogin();
		
		logger.info("clicked on Login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Addcustomerpage addcust = new Addcustomerpage(driver);

		Assert.assertEquals("Dashboard / nopCommerce administration", getPageTitle());

		addcust.clickOnCustomersMenu();

		addcust.lnkCustomers_menuitem();

		addcust.clickOnAddnew();

		Assert.assertEquals("Add a new customer / nopCommerce administration", getPageTitle());

		String email = randomString() + "@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setCustomerRoles("Guests");
		
		addcust.setManagerOfVendor("Vendor 2");
		addcust.setGender("Male");
		addcust.setFirstname("Pavan");
		addcust.setLasttname("kumar");
		addcust.setdob("7/05/1985");
		addcust.setCompanyName("busyQA");
		addcust.setAdmincontent("This is for Testing.....");

		addcust.clickonsave(null);
		Thread.sleep(10);

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
		
		captureScreen(driver, "Addcustomerpage");

	}


}
