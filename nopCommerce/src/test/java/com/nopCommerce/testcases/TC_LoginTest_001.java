package com.nopCommerce.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.Loginpage;
import com.nopCommerce.utilities.ReadConfig;

public class TC_LoginTest_001 extends BaseClass 

{
	@Test(groups= "Regression")
	public void loginTest() throws IOException {
		
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
		
		captureScreen(driver, "loginTest");
		
		

	}
}
