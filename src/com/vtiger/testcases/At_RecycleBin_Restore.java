package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.libraries.Generic;
import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_RecycleBin_Restore extends SuperTestNG
{
	@Test
	public static void testAt_RecycleBin_Restore() throws InterruptedException
	{
		String XLPath="G:/VtigerWorkspace/Vtiger/excelfiles/Vtiger.xlsx";
		String Sheet ="recycle bin";
		String Sheet2="project tasks";
		ProjectSpecific.Login();
		String norec="";
		ProjectSpecific.gotoModule("Recycle Bin");
		ProjectSpecific.findListItem(driver.findElement(By.id("select_module")),Generic.XLCellValue(XLPath, Sheet, 3, 0));
	/*	try
		{
			norec=driver.findElement(By.xpath("//span[contains(text(),'No records found to Restore in module')]")).getText();
			//System.out.println("record are there");*/
			for(int i=0;i<=Generic.XLRow(XLPath, Sheet2);i++)
			{
			try
			{
			driver.findElement(By.xpath("//tr[td[a[text()='"+Generic.XLCellValue(XLPath, Sheet2, i, 0)+"']]]//input")).click();
			driver.findElement(By.xpath("//input[@value='Restore']")).click();
			ProjectSpecific.alertPopup();
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(Generic.XLCellValue(XLPath, Sheet2, i, 0)+"no such record to restore");
			}
			}
		/*}catch(Exception e)
		{
			if(norec.equals(Generic.XLCellValue(XLPath, Sheet, 1, 1)))
			{
			System.out.println("no records to restore in module"+Generic.XLCellValue(XLPath, Sheet, 1, 0));
			}
		}*/
		
	}
}
