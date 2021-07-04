package com.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.objectrepository.OperatorObjectRepository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class OperatorsPage extends OperatorObjectRepository{
	WebDriver driver=null;
	
	//@FindBy(xpath="")
	

	
	public OperatorsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String readExcel(int row,int col) throws Exception{
		FileInputStream fis =new FileInputStream("jbkexcel.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		 Sheet sh=wb.getSheet("Operators");
		int rows=sh.getRows();
		int cols=sh.getColumns();
		Cell cell=sh.getCell(col, row);
		String value=cell.getContents();
				//System.out.println(value);
		return value;
	}
	
	//01==Verify header of Operators table
	public List<String> expheader() throws Exception{
		List<String> expheader=new ArrayList<String>();
			 for(int j=0;j<=5;j++){
		readExcel(0,j);
		expheader.add(readExcel(0,j));
	}
			 System.out.println(expheader);
			 return expheader;
		}
	public ArrayList<String> actheader(){
		List<WebElement> actheader=driver.findElements(By.tagName("th"));
		ArrayList<String> actualheader=new ArrayList<>();
		for(WebElement acthdr:actheader){
			String data=acthdr.getText();
			actualheader.add(data);
			System.out.println(actualheader);
		}
		
		return actualheader;
	}
	//End of verifuying Headers of Operator data
	
/*02== Verify ID by appending 0 in exp data 
 * 
 */
	public ArrayList<String> expID() throws Exception{
		ArrayList<String> expid=expid=new ArrayList<>();
		for(int i=1;i<=5;i++){
				String value=readExcel(i,0);
				int id=Integer.parseInt(value);
				String exp=String.format("%02d", id);
				expid.add(exp);
				}
		System.out.println("Expected data is== "+expid);
		return expid;
	}
	
	public ArrayList<String> actID(){
		ArrayList<String> actid=new ArrayList<>();
	
		List<WebElement> actbrowserid=driver.findElements(By.xpath("//td[1]"));
		for(WebElement tdata:actbrowserid){
			
			String value=tdata.getText();
			actid.add(value);
			
		}
		System.out.println("Actual data is==  "+actid);
		
		return actid;
	}
	//End of verifying ID
	
	/*Verifying operators who are available on SMS
	 */
	public List<String> expSMSUsers() throws Exception{
		List<String> operatorname=new ArrayList<String>();
		//String contact=null;
	//	String operator = null;
		for(int i=1;i<=5;i++){
			readExcel(i,3);
			if(readExcel(i,3).contains("SMS"))
				// readExcel(i,1);
			operatorname.add(readExcel(i,1));
				//wayofcontact.add(contact);
			    
		}
		
			System.out.println(operatorname);
			return operatorname;
	}
	
	public ArrayList<String> actSMSUsers(){
	
		List<WebElement> contact=driver.findElements(By.xpath("//td[4]"));
		List<WebElement> opnames=driver.findElements(By.xpath("//td[2]"));
		int sizeofoperator=opnames.size();
		ArrayList<String> actopnames=new ArrayList<>();
		String ovalue;
		for(int i=0;i<sizeofoperator;i++){
			String cvalue=contact.get(i).getText();
			if(cvalue.contains("SMS")){
				ovalue=opnames.get(i).getText();
				actopnames.add(ovalue);
			}
		}
		System.out.println(actopnames);
		return actopnames;
		}
//End of verifying operators available on SMS
	
	public void verifyTable(){
		operators.click();
		HashMap<String,List<String>> acthm=new HashMap<String,List<String>>();
		String key=null;
		List<String> value=new ArrayList<String>();
	for(WebElement e:headers){
		if(headers.indexOf(e)==0)
			key=e.getText();
		else
			value.add(e.getText());
			
	}
	acthm.put(key, value);
	
int rowsize=rows.size();
	
	for(int i=2;i<=rowsize;i++)
	{
		List<WebElement> row_data=driver.findElements(By.xpath("//tr["+i+"]/td"));
		for(WebElement row:row_data){
			if(row_data.indexOf(row)==0)
				key=row.getText();
			else
				value.add(row.getText());
					
		}
			System.out.println();
	}
	acthm.put(key,value);
	//System.out.println(acthm);
	for(HashMap.Entry<String,List<String>> entry:acthm.entrySet()){
		System.out.println("  "+entry.getKey());
		
		System.out.println(" "+entry.getValue());
	}
	}

}
