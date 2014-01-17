package com.vtiger.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.libraries.Generic;
import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Project_Tasks extends SuperTestNG
{
	@Test
	public void testAt_Project_Tasks() throws InterruptedException
	{
		String XLPath="G:/VtigerWorkspace/Vtiger/excelfiles/Vtiger.xlsx";
		String Sheet ="project tasks";
		ProjectSpecific.Login();
		ProjectSpecific.gotoModule("Project Tasks");
		driver.findElement(By.xpath("//img[contains(@title,'Create Project Task')]")).click();
		for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
			{
				driver.findElement(By.name("projecttaskname")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 0));
				driver.findElement(By.name("projecttask_no")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 1));
				ProjectSpecific.findListItem(driver.findElement(By.name("projecttaskpriority")), Generic.XLCellValue(XLPath, Sheet, i, 2));
				ProjectSpecific.findListItem(driver.findElement(By.name("projecttasktype")), Generic.XLCellValue(XLPath, Sheet, i, 3));
				if(Generic.XLCellValue(XLPath, Sheet, i, 4).equals("T"))
					{
						driver.findElement(By.xpath("//input[@value='T']")).click();
					}else
					{
						driver.findElement(By.xpath("//input[@value='U']")).click();
					}
				driver.findElement(By.xpath("//img[@title='Select']")).click();
				ArrayList a= new ArrayList();
				a=ProjectSpecific.childBrowser();
				driver.switchTo().window((String) a.get(1));
				driver.findElement(By.linkText(Generic.XLCellValue(XLPath, Sheet, i, 5))).click();
				driver.switchTo().window((String) a.get(0));
				driver.findElement(By.id("jscal_trigger_startdate")).click();
				WebElement date1 =driver.findElement(By.xpath("//div[@class='calendar']//td[contains(text(),16)]"));
				ProjectSpecific.mousehover(date1);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",date1);
				driver.findElement(By.id("jscal_trigger_startdate")).click();
				WebElement date2 =driver.findElement(By.xpath("//div[@class='calendar']//td[contains(text(),23)]"));
				ProjectSpecific.mousehover(date2);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",date2);
				Thread.sleep(2000);
				driver.findElement(By.name("description")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 6));
				driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
				driver.findElement(By.xpath("//img[contains(@title,'Create Project Task')]")).click();
		}
		
	}

}
