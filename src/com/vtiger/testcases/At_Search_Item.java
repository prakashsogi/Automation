package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.libraries.Generic;
import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Search_Item extends SuperTestNG
{
	@Test
	public void testAt_Search_Item()
	{
	String XLPath="G:/VtigerWorkspace/Vtiger/excelfiles/Vtiger.xlsx";
	String Sheet ="search";
	ProjectSpecific.Login();
	driver.findElement(By.linkText("Leads")).click();
	String lead=Generic.XLCellValue(XLPath, Sheet, 0, 0);
	for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
			{
			ProjectSpecific.SearchItem(Generic.XLCellValue(XLPath, Sheet, i, 1),lead);
			String xpath="//tr[td[a[text()='"+Generic.XLCellValue(XLPath, Sheet, i, 1)+"']]]//td[3]/a";
			String expt=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("text from application "+expt);
			System.out.println("-------------------");
			if (Generic.XLCellValue(XLPath, Sheet, i, 1).equals(expt))
			{
				System.out.println("Item "+ expt+" is present,seacrh successful");
			}else
			{
				System.out.println("item "+expt+" is not present");
			}
			driver.findElement(By.name("search_text")).clear();
			
		
			}
	
	}

}
