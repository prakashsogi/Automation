package com.vtiger.testcases;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Delete_Duplicate extends SuperTestNG
{

	@Test
	public void testAt_Delete_Duplicate() throws InterruptedException
	{
		ProjectSpecific.Login();
		driver.findElement(By.linkText("Leads")).click();
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
				List<WebElement> chk = driver.findElements(By.xpath("//table[tbody[tr[td[b[text()='recordid']]]]]//tr[contains(td[3],'qq')]/td[5]/input"));
			 	for(int i=0;i<chk.size();i++)
			 	{
				 chk.get(i).click();
			 	}
			 	driver.findElement(By.xpath("//table[tbody[tr[td[b[text()='recordid']]]]]//tr[contains(td[3],'qq')]/td[6]/input")).click();
			 	Set<String> wh = driver.getWindowHandles();
			 	Iterator<String> iwh=wh.iterator();
			 	String parent=iwh.next();
			 	String child=iwh.next();
			 	System.out.println(driver.switchTo().window(child).findElement(By.xpath("//input[@title='Merge']")).getAttribute("title"));
			 	driver.switchTo().window(child).findElement(By.xpath("//input[@title='Merge']")).click();
			
		}
		else
		{
			System.out.println("There are no duplicates");
		}
				
		
	}
	
}

