package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.libraries.Generic;
import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Delete_Project_Task extends SuperTestNG
{
	@Test
	public void testAt_Delete_Project_Task()
	{
		String XLPath="G:/VtigerWorkspace/Vtiger/excelfiles/Vtiger.xlsx";
		String Sheet ="project tasks";
		ProjectSpecific.Login();
		ProjectSpecific.gotoModule("Project Tasks");
		boolean checked=true;
			for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
			{
				try{
				driver.findElement(By.xpath("//tr[td[a[text()='"+Generic.XLCellValue(XLPath, Sheet, i, 0)+"']]]//input[@type='checkbox']")).click();
				
				}
				catch(Exception e)
				{
					System.out.println("no scuh project exists");
					 checked=false;
				}
			}
				if(checked)
				{
				driver.findElement(By.xpath("//input[@value='Delete']")).click();
				ProjectSpecific.alertPopup();
				}
			
		
	}

}
