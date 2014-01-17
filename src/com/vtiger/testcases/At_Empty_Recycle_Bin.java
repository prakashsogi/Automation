package com.vtiger.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Empty_Recycle_Bin extends SuperTestNG
{
	@Test
	public void testAt_Empty_Recycle_Bin() throws InterruptedException
	{
		ProjectSpecific.Login();
		ProjectSpecific.gotoModule("Recycle Bin");
		driver.findElement(By.xpath("//input[@value='Empty Recycle Bin']")).click();
		ProjectSpecific.findListItem(driver.findElement(By.id("select_module")),"FAQ");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Yes']")).click();
		driver.navigate().back();
		WebElement we = driver.findElement(By.xpath("//span[contains(text(),'No records found to Restore in module')]"));
		//WebDriverWait a=new WebDriverWait(driver,10);
		//a.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'No records found to Restore in module')]")));
		//WebElement we = driver.findElement(By.xpath("//span[contains(text(),'No records found to Restore in module')]"));
		Thread.sleep(2000);
		String norec=we.getText();
		if(norec.equals("No records found to Restore in module FAQ"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	
	}

}
