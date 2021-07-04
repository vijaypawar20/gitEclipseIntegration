package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.objectrepository.DashboardObjectRepository;

public class DashboardPage extends DashboardObjectRepository {

	WebDriver driver=null;
	

	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyCourses(){
			ArrayList<String> exp=new ArrayList<String>();
			exp	.add("Selenium");
			exp.add("Java / J2EE");
			exp.add("Python");
			exp.add("Php");
		ArrayList<String> act=new ArrayList<String>();
			for(WebElement course:courses){
				String value=course.getText();
				act.add(value);
				System.out.println(act);
			}
			System.out.println();
			if(act.equals(exp)){
				System.out.println("Courses are verified");
				return true;
			}
			else{
				System.out.println("Courses are not verified");
				return false;
			}
		
}

//to userpage
	public UserPage navigatetoUserPage() {
		userpagelink.click();
		return new UserPage(driver);
		
		
		
	}
	
	//to operatorpage
	public OperatorsPage navigatetoOperatorPage(WebDriver driver) {
		operatorpagelink.click();
		return new OperatorsPage(driver);
		}
	
	public UsefullinkPage navigatetoUsefullinkPage() {
		usefullink.click();
		return new UsefullinkPage(driver);
	}
			
			
		
}
