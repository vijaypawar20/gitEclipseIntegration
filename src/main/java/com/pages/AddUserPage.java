package com.pages;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.objectrepository.AddUserObjectRepository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class AddUserPage extends AddUserObjectRepository  {
	public AddUserPage(WebDriver driver){
		super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	public String readExcel(int row,int col) throws Exception{
		FileInputStream fis =new FileInputStream("jbkexcel.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		 Sheet sh=wb.getSheet("Users");
		int rows=sh.getRows();
		int cols=sh.getColumns();
				Cell cell=sh.getCell(col, row);
				String value=cell.getContents();
				
			
		return value;
	}
WebDriver driver=null;
public String addUser() throws Exception{	
	//Users.click();
	adduserbtn.click();
	for(int i=1;i<=2;i++){
    uname.sendKeys(readExcel(1,0));
    mobile.sendKeys("88888855");
    email.sendKeys("vijay@gmail.com");
    course.sendKeys("J2EE");
   boolean male1= male.isSelected();
   boolean female1= female.isSelected();
    if(male1==false && female1==false)
    	selectmale.click();
    Select sel=new Select(state);
    sel.selectByIndex(1);
    List<WebElement> states=sel.getOptions();
    pass.sendKeys("222555");
	}
    submitbtn.click();
   
  Alert al=driver.switchTo().alert();
  String act=al.getText();
  Thread.sleep(5000);
  al.accept();
return act;
}
public void checkValidMobile(){
	adduserbtn.click();
	driver.findElement(By.xpath(""));
}

}
