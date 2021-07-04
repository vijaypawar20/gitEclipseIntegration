package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.LoginPage;

public class TestBase {
	static WebDriver driver=null;
	static FileInputStream fis=null;
	public static String readProperty(String propname) throws Exception{
		fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/"+"/config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		return prop.getProperty(propname);
		
	} 
	public static WebDriver launchApp() throws Exception{
		String url=readProperty("url");
		String browser1=readProperty("browser");
		if("chrome".equals(browser1)){
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public LoginPage loadLoginPage(){
		LoginPage lp=new LoginPage(driver);
		return lp;
	}

}
