package com.nopCommerce.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.Loginpage;
import com.nopCommerce.utilities.ReadConfig;
import com.nopCommerce.utilities.XLUtility;

public class TC_LoginDDT_004 extends BaseClass {

	@Test(dataProvider = "LoginData",groups= {"Sanity"})
	public void loginDDT(String user, String pwd, String exp) throws InterruptedException, IOException {
		Loginpage lp = new Loginpage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(ReadConfig.getApplicationurl());
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");

		lp.clickLogin();

		logger.info("clicked on Login");

		String exptitle = "Dashboard / nopCommerce administration";
		String acttitle = driver.getTitle();
		
		
		if (exp.equals("Valid")) 
		{
			if (exptitle.equals(acttitle))
			{
				lp.clickLogout();
				Assert.assertTrue(true);
			} 
			else 
			{
				Assert.assertTrue(false);
			}
		} 
		else if (exp.equals("Invalid")) 
		{
			if (exptitle.equals(acttitle)) 
			{
				lp.clickLogout();
				Assert.assertTrue(false);
			}
		} 
		else 
		{
			Assert.assertTrue(true);
		}

		captureScreen(driver, "loginTest");

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException, InterruptedException {
		String path = "C:\\Users\\arunn\\eclipse-workspace\\nopCommerce\\src\\test\\java\\com\\nopCommerce\\testdata\\loginData.xlsx";

		XLUtility xl = new XLUtility(path);

		int totalrows = xl.getRowCount("login");

		int totalcol = xl.getCellCount("login", 1);

		String logindata[][] = new String[totalrows][totalcol];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcol; j++) {
				logindata[i - 1][j] = XLUtility.getCellData("login", i, j);

			}
		}
		return logindata;
	}

}
