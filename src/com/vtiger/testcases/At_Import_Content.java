package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Import_Content extends SuperTestNG
{
		@Test
		public void testAt_Import_Content() throws InterruptedException
		{
		
			ProjectSpecific.Login();
			driver.findElement(By.linkText("Opportunities")).click();
			driver.findElement(By.xpath("//img[@title='Import Opportunities']")).click();
			driver.findElement(By.id("import_file")).sendKeys("g:\\Test\\Opportunities.csv");
			//driver.findElement(By.id("import_file")).click();
			Thread.sleep(5000);
			driver.findElement(By.name("next")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("import")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("cancel")).click();
			
		
		}
}
