package com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pages.AddUserPage;

public class AddUserObjectRepository {
	WebDriver driver=null;
	public AddUserObjectRepository(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//span[text()='Users']")
	public WebElement Users;

	@FindBy(xpath="//a/button")
	public WebElement adduserbtn;

	@FindBy(id="username")
	public WebElement uname;

	@FindBy(id="mobile")
	public WebElement mobile;

	@FindBy(id="email")
	public WebElement email;

	@FindBy(id="course")
	public WebElement course;

	@FindBy(xpath="//*[@id=\"Male\"]")
	public WebElement  male;

	@FindBy(xpath="//*[@id=\"Female\"]")
	public  WebElement  female;

	@FindBy(xpath="//*[@id=\"Male\"]")
	public  WebElement  selectmale;

	@FindBy(tagName="select")
	public  WebElement  state;

	@FindBy(id="password")
	public WebElement  pass;

	@FindBy(id="submit")
	public WebElement  submitbtn;

}
