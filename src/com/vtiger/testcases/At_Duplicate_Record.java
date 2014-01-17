package com.vtiger.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Duplicate_Record extends SuperTestNG
{

	@Test
	public void testAt_Duplicate_Record() throws InterruptedException
	{
		ProjectSpecific.Login();
		driver.findElement(By.linkText("Leads")).click();
		//ProjectSpecific.SearchItem("ZZ", "Last Name");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@title='Find Duplicates']")).click();
		ProjectSpecific.clearList();
		WebElement avail = driver.findElement(By.id("availList"));
		ProjectSpecific.findListItem(avail, "First Name");
		driver.findElement(By.name("Button")).click();
		driver.findElement(By.name("save&merge")).click();
		List<WebElement> rows = driver.findElements(By.xpath("//table[tbody[tr[td[b[text()='recordid']]]]]//tr"));
		if(rows.size()>1)
		{
			System.out.println("duplicate rows are there");
			
		}
		else
		{
			System.out.println("There are no duplicates");
		}
				
		
	}
	
}
