/**
 * 
 */
package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.libraries.Generic;
import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

/**
 * @author Prakash
 *
 */
public class At_Create_Leads extends SuperTestNG
{
	@Test
	public void testAt_Create_Leads()
	{
		String XLPath="G:/VtigerWorkspace/Vtiger/excelfiles/Vtiger.xlsx";
		String Sheet ="Sheet1";
		ProjectSpecific.Login();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Lead')]")).click();
				//String v=Generic.XLCellValue(XLPath, Sheet, 0, 0);
				for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
				{
				driver.findElement(By.name("firstname")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 0));
				driver.findElement(By.name("lastname")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 1));
				driver.findElement(By.name("company")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 2));
				WebElement lst1 = driver.findElement(By.name("leadsource"));
				ProjectSpecific.findListItem(lst1, Generic.XLCellValue(XLPath, Sheet, i, 3));
				WebElement lst2 = driver.findElement(By.name("assigned_user_id"));
				ProjectSpecific.findListItem(lst2, Generic.XLCellValue(XLPath, Sheet, i, 4));
				driver.findElement(By.name("button")).click();
				String txt=driver.findElement(By.className("dvHeaderText")).getText();
				String eMsg=Generic.XLCellValue(XLPath, Sheet, i, 5);
				//System.out.println(txt.substring(9));
				String aMsg=txt.substring(10);
				ProjectSpecific.verifyMsg1(eMsg, aMsg);
				driver.findElement(By.linkText("Leads")).click();
				driver.findElement(By.xpath("//img[contains(@title,'Create Lead')]")).click();
				}
				
	}

}
