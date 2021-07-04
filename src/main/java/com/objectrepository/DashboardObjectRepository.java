package com.objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardObjectRepository {
	@FindBy(xpath="//h3") 
	public List<WebElement> courses;

	@FindBy(xpath="//span[text()='Users']")
	public WebElement userpagelink;

	@FindBy(xpath="//span[text()='Operators']")
	public WebElement operatorpagelink;
	
	@FindBy(xpath="//span[text()='Useful Links']")
	public WebElement usefullink;


}
