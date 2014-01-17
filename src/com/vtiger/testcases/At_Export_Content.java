
package com.vtiger.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Export_Content extends SuperTestNG
{
	@Test
	public void testAt_Export_Content() throws InterruptedException
	{
		ProjectSpecific.Login();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Export Opportunities']")).click();
		driver.findElement(By.name("export_data")).click();
		//driver.findElement(By.name("export_data")).click();
		driver.findElement(By.name("Export")).click();
		Thread.sleep(3000);
					
		
	}

}
