package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.OperatorsPage;
import com.pages.UserPage;
import com.testbase.TestBase;

public class OperatorsTest extends TestBase{
	WebDriver driver=null;
	OperatorsPage op=null;
	@BeforeMethod
	public void Operatorwindow() throws Exception{
			driver=super.launchApp();
		op=loadLoginPage().navigatetoDashboard(driver).navigatetoOperatorPage(driver);
	op=new OperatorsPage(driver);
	}
	@Test
	public void verifyOperatorTable() throws Exception{
		op.verifyTable();
	
	}
	@Test
	public void verifyHeader() throws Exception{
		op.actheader();
		op.expheader();
		Assert.assertEquals(op.actheader(), op.expheader());
	}
	@Test
	public void verifyID() throws Exception{
		
		Assert.assertEquals(op.actID(),op.expID());
	}
	@Test
	public void verifySMSoperator() throws Exception{
		Assert.assertEquals(op.actSMSUsers(),op.expSMSUsers());
	}

}
