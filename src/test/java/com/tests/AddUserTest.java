package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.AddUserPage;

public class AddUserTest {
	WebDriver driver=null;
	AddUserPage ap=null;
@BeforeMethod
	public void addUser1() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("file:///D:/Selenium%20Softwares/Offline%20Website/pages/examples/users.html");
	
		driver.manage().window().maximize();
		
		ap=new AddUserPage(driver);
}


@Test
public void addUser() throws Exception{
	String actual=ap.addUser();
	Assert.assertEquals(actual, "User Added Successfully. You can not see added user.");
	
}

}
