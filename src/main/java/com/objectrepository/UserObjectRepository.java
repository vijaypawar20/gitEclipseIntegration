package com.objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserObjectRepository {
	@FindBy(xpath="//span[text()='Users']")
	public WebElement users;
	
	@FindBy(xpath="//td[2]")
	public List<WebElement> username;
	
	@FindBy(xpath="//td[6]")
	public List<WebElement> gender;
	
	@FindBy(xpath="//tr")
	public List<WebElement> rows;
	
	@FindBy(xpath="//td")
	List<WebElement> data;
	
	@FindBy(tagName="th")
	public List<WebElement> headers;
}
