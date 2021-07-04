package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.testbase.TestBase;

public class DashboardTest extends TestBase {
	WebDriver driver=null;
	public DashboardPage dp=null;
	
	@BeforeMethod
	public void dashboardWindow() throws Exception{
		
	
		driver=TestBase.launchApp();
		dp=loadLoginPage().navigatetoDashboard(driver);
	}
	
	
	
	@Test
	public void verifyCourse(){                                                                 
		                    
			Assert.assertTrue(dp.verifyCourses());
		
		
	}

}
