package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.testbase.TestBase;

public class LoginTest extends TestBase {
	WebDriver driver=null;
	public LoginPage lp=null;
	@BeforeMethod
	public void setUp_Browser() throws Exception
	{
		driver=TestBase.launchApp();
        driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		lp=new LoginPage(driver);
		//lp.navigatetoDashboard(driver);
	}
	@Test
	public void verifyLoginTitle() throws Exception{
		Assert.assertTrue(lp.verifyTitle());
		
	}
	@Test
	public void verifyDashboardTitle() throws Exception{
		lp.navigatetoDashboard(driver);
		
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		
	}

}
