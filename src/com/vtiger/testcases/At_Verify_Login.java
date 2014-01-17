package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Verify_Login extends SuperTestNG
{
	@Test
	public void testAt_Verify_Login() throws InterruptedException
	{
		ProjectSpecific.Login();
		//driver.findElement(By.linkText("Leads")).click();
		//Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("//td[@class='moduleName']/a"));
		//System.out.println(e.getText());
		String eMsg="Home";
		ProjectSpecific.verifyMsg(e, eMsg);
	}
	
}
