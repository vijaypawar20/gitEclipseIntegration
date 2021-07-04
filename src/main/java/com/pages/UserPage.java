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

import com.objectrepository.UserObjectRepository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class UserPage extends UserObjectRepository {
	WebDriver driver=null;
	public UserPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
/*Reading Excel sheet data with passing row and column number 
 * */
	public String readExcel(int row,int col) throws Exception{
		FileInputStream fis =new FileInputStream("jbkexcel.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		 Sheet sh=wb.getSheet("Users");
		int rows=sh.getRows();
		int cols=sh.getColumns();
		//String [][] data=new String [rows][cols];
		//for(int i=1;i<rows;i++){
			//for(int j=0;j<col;j++){
				Cell cell=sh.getCell(col, row);
				String value=cell.getContents();
				//data[i][j]=value;
				//System.out.print(data[i][j]+" ");
				
			
		return value;
	}
	/*Reading complete Expected user table from Excel by using hashmap
	 */
		public HashMap<String, List<String>> completeExpectedtable() throws Exception{
			
		HashMap<String,List<String>> exp_data=new HashMap<String,List<String>>();
		ArrayList<String> expal= null;
		String key=null;

			//Cell cell=sh.getCell(1,i);
			//String key=cell.getContents();
		for(int i=0;i<5;i++)
		{
			key=null;
			expal=null;
			expal=new ArrayList<String>();
			key=readExcel(i,0);
			for(int j=1;j<8;j++)
			{
			 expal.add(readExcel(i,j));
			}
		exp_data.put(key,expal);
		 
		}
		System.out.println(exp_data);
		
		 
		
		return exp_data;
		}
/*Getting complete actual user table  using
 * Hashmap
 * */
		public HashMap<String, List<String>> completeActualTable() {
			users.click();
			String act_key=null;
			HashMap<String,List<String>> acthm=new HashMap<String, List<String>>();
		List<String> act_value=new ArrayList<String>();
			for(WebElement e:headers){
				if(headers.indexOf(e)==0)
					act_key=e.getText();
				else
					act_value.add(e.getText());
				}
			acthm.put(act_key,act_value);
			act_key=null;
			act_value=null;
			int rowsize=rows.size();
			for(int i=2;i<=rowsize;i++){
				act_value=new ArrayList<String>();
				List<WebElement> rowdata=driver.findElements(By.xpath("//tr["+i+"]/td"));
				for(WebElement row:rowdata){
					if(rowdata.indexOf(row)==0)
						act_key=row.getText();
					else
						act_value.add(row.getText());
				}
				acthm.put(act_key, act_value);
				}
			System.out.println(acthm);

		return acthm;
				}
		
		
			
/*
 * Getting actual User table data to print username and Gender column only
 * Using hashmap 
 */
		public HashMap<String, String> act_usernamewithGender(){
		users.click();
		String actkey=null;
		String actvalue=null;
		
		System.out.println("size of the list==="+username.size());
		HashMap<String,String> act_data=new HashMap<String,String>();
		for(WebElement e:headers){
			if(headers.indexOf(e)==1)
				actkey=e.getText();
			else
				actvalue=e.getText();
		}
		for(int i=0;i<username.size();i++)
		{
			actkey=username.get(i).getText();
		
			
			actvalue=gender.get(i).getText();
			act_data.put(actkey,actvalue);
		
		}
		System.out.println(act_data);
		return act_data;
	}

		public HashMap<String, String> exp_usernamewithGender() throws Exception{
			String exp_key=null;
			String exp_value=null;
			HashMap<String,String> exphm=new HashMap<>();
			for(int i=0;i<5;i++){
				exp_key=readExcel(i,1);
				exp_value=readExcel(i,5);
				exphm.put(exp_key, exp_value);
			}
			System.out.println(exphm);
			return exphm;
		}
		
		

		/*Getting Actual only male data from User table
 * 
 */
	public HashMap<String, String> actaualuserOnlyMales(){
		users.click();
		String male_key=null;
		String male_value=null;
		int sizeof_userlist=username.size();
		System.out.println("size of user list==  "+sizeof_userlist);
		//ArrayList<String> act_data=new ArrayList<String>();
		HashMap<String,String> only_male_users=new HashMap<String, String>();
		for(int i=0;i<sizeof_userlist;i++){
			
				
				String value=gender.get(i).getText();
				if(value.contains("Male"))
				{
			   String key=username.get(i).getText();
				System.out.println(key);
				System.out.println(value);
				System.out.println(" male user is==== "+key);
			     }
			}
			only_male_users.put(male_key, male_value);
			System.out.println(only_male_users);
			return only_male_users;
			
	/*===logic for same program  by Mangesh sir=======
	 * 	
	for(WebElement gender1:gender){
		if(gender1.getText().equals("Male")){
			int row=gender.indexOf(gender1)+2;
			System.out.println(row);
		act_data.add(male_data);
		}
	
	System.out.println(act_data);
	}*/
			
	
}

	}
