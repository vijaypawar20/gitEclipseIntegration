package com.tests;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.UserPage;
import com.testbase.TestBase;

public class UserTest extends TestBase{
	WebDriver driver=null;
	public UserPage up;
	@BeforeMethod
	public void userpageWindow() throws Exception{
	 driver=TestBase.launchApp();
	 up=loadLoginPage().navigatetoDashboard(driver).navigatetoUserPage();
	}
	
	@Test
	public void verifyCompleteTable() throws Exception{
		up=new UserPage(driver);
		HashMap<String, List<String>> exp_data=up.completeExpectedtable();
		HashMap<String, List<String>> act_data=up.completeActualTable();
		Assert.assertEquals(act_data, exp_data);
		
	}
	@Test
	public void verifyUsernamewithGender() throws Exception{
		up=new UserPage(driver);
		HashMap<String,String> act_data=up.act_usernamewithGender();
		HashMap<String,String> exp_data=up.exp_usernamewithGender();
		
		
	}
	

}
