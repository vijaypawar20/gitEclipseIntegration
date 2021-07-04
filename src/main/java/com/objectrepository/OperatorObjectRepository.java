package com.objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OperatorObjectRepository {
	@FindBy(xpath="//span[text()='Operators']")
	public WebElement operators;
	
	@FindBy(tagName="th")
	public List<WebElement> headers;
	
	
	@FindBy(tagName="tr")
	public List<WebElement> rows;

}
