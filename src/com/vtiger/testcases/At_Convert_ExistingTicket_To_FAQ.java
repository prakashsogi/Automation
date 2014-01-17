package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vtiger.libraries.Generic;
import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Convert_ExistingTicket_To_FAQ extends SuperTestNG
{
	@Test
	public void testAt_Convert_ExistingTicket_To_FAQ() throws InterruptedException
	{
		String xlname="G:/VtigerWorkspace/Vtiger/excelfiles/Vtiger.xlsx";
		String Sheet="tickets";
		ProjectSpecific.Login();
		driver.findElement(By.linkText("Trouble Tickets")).click();
		driver.findElement(By.linkText(Generic.XLCellValue(xlname, Sheet, 0, 0))).click();
		driver.findElement(By.linkText("Convert As FAQ")).click();
		driver.findElement(By.linkText("FAQ")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//tr[td[a[text()='"+Generic.XLCellValue(xlname, Sheet, 0, 0)+"']]]//input")).click();
		//driver.findElement(By.xpath("//a[text()='"+Generic.XLCellValue(xlname, Sheet, 0, 0)+"']")).click();
		String aMsg=driver.findElement(By.linkText(Generic.XLCellValue(xlname, Sheet, 0, 0))).getText();
		System.out.println("eMsg="+Generic.XLCellValue(xlname, Sheet, 0, 0));
		System.out.println("aMsg="+aMsg);
		ProjectSpecific.verifyMsg1(Generic.XLCellValue(xlname, Sheet, 0, 0), aMsg);
		
		
		
	}

}
