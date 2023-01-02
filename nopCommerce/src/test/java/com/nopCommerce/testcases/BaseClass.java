package com.nopCommerce.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopCommerce.utilities.ReadConfig;

public class BaseClass {

	ReadConfig config = new ReadConfig();

	public String baseurl = ReadConfig.getApplicationurl();
	public String Username = ReadConfig.getUsername();
	public String password = ReadConfig.getpassword();
	public WebDriver driver;

	public static Logger logger;

	Properties configProp;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws IOException {

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", config.getchromepath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", config.gefirefoxpath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", config.getiepath());
			driver = new InternetExplorerDriver();
		}

		logger = Logger.getLogger("nopComemrce");// added Logger
		PropertyConfigurator.configure("Log4j.properties"); // added logger

		Layout layout = new PatternLayout("%d  %c %m %n");
		Appender appender = new FileAppender(layout, "./log/Logging.log");
		BasicConfigurator.configure(appender);

		logger = Logger.getLogger(this.getClass().getName());

	}

	public static String randomString() {
		String generateString1 = RandomStringUtils.randomAlphabetic(5);
		return (generateString1);

	}
	
	
	public String getPageTitle() {

		return driver.getTitle();

	}

	@AfterClass
	public void teardown() {

		driver.quit();

	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}