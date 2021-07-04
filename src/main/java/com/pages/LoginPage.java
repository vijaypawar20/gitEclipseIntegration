package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.objectrepository.LoginObjectRepository;

public class LoginPage extends LoginObjectRepository {
	WebDriver driver=null;


	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean verifyTitle(){
		// Actual title
	
					String mytitle = driver.getTitle();
					System.out.println("page title is==" + mytitle);
					System.out.println("..........");
					// expected title
					String expected_title = "JavaByKiran | Log in";
					if(mytitle.equals(expected_title)){
						
						System.out.println("Application Title  matched");
						return true;
				
					} else{
						
						System.out.println("Application Title is not matched");
						return false;
						
						
					}
		
	}
	
	public DashboardPage navigatetoDashboard(WebDriver driver) throws Exception{
		uname.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		Thread.sleep(5000);
		loginbtn.click();
		return  new DashboardPage(driver);
	}
	

}
