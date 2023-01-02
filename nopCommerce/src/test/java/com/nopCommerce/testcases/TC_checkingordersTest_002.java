package com.nopCommerce.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.Loginpage;
import com.nopCommerce.pageObjects.checkingorders;
import com.nopCommerce.utilities.ReadConfig;

public class TC_checkingordersTest_002 extends BaseClass

{
	@Test(groups= {"Regression","Sanity"})
	public void checkingordersTest() throws IOException, InterruptedException {

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

		checkingorders orders = new checkingorders(driver);

		 Assert.assertEquals("Dashboard / nopCommerce administration", getPageTitle());
		
		orders.sales();
		logger.info("clicked on sales"); 
		
		orders.orders();
		
		logger.info("clicked on orders");

		Assert.assertEquals("Orders / nopCommerce administration", getPageTitle());

		orders.Billingcountry();
		checkingorders.selectdropdown1(orders.Billingcountry, "Canada");

		orders.Paymentmethod();
		checkingorders.selectdropdown1(orders.Paymentmethod, "Check / Money Order");

		orders.Orderstatus();
		orders.selectdropdown2(orders.Orderstatus1, "Complete");

		orders.Paymentstatuses();
		orders.selectdropdown2(orders.Paymentstatuses1, "Paid");

		orders.Shippingstatuses();
		orders.selectdropdown2(orders.Shippingstatuses1, "Delivered");

		orders.datepicker();

		orders.search();

		boolean status = orders.searchOrders("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
		
		logger.info("all details are entered");
		
		captureScreen(driver, "checkingordersTest");

	}
	
}
