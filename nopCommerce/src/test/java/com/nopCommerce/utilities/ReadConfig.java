package com.nopCommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	static Properties pro = new Properties();

	public ReadConfig() {
		File src = new File("./configuration/config.properties");
		try {
			FileInputStream abc = new FileInputStream(src);
			pro.load(abc);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());

		}

	}

	public static String getApplicationurl() {
		String url = pro.getProperty("baseurl");
		return url;

	}

	public static String getUsername() {
		String Username = pro.getProperty("Username");
		return Username;

	}

	public static String getpassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getchromepath() {

		String cpath = pro.getProperty("chromepath");
		return cpath;
	}

	public String getiepath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}

	public String gefirefoxpath() {
		String ffoxpath = pro.getProperty("firefoxpath");
		return ffoxpath;
	}
}
