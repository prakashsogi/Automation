package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Mini_Cal extends SuperTestNG
{
	@Test
	public void testAt_Mini_Cal() throws InterruptedException
	{
		ProjectSpecific.Login();
		driver.findElement(By.xpath("//img[contains(@title,'Open Calendar')]")).click();
		Thread.sleep(1000);
			if (driver.findElement(By.id("miniCal")).isDisplayed())
			{
				WebElement we = driver.findElement(By.xpath("//b[contains(text(),'January 2014')]"));
				String eMsg="January 2014";
				ProjectSpecific.verifyMsg(we, eMsg);
				System.out.println("mini calander is dispalyed");
			}
			else
			{
				System.out.println("mini calander is not dispalyed");
			}
	}

}
