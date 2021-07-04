package com.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjectRepository {
	@FindBy(id="email")
	public WebElement uname;
	
	@FindBy(id="password")
	public WebElement pass;
	
	@FindBy(xpath="//button")
	public WebElement loginbtn;

}
