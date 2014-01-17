package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_ConvertTicket_To_FAQ extends SuperTestNG
{
	@Test
	public void testAt_ConertTicket_To_FAQ() throws InterruptedException
	{
		ProjectSpecific.Login();
		driver.findElement(By.linkText("Trouble Tickets")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Ticket')]")).click();
		//Thread.sleep(3000);
		driver.findElement(By.name("ticket_title")).sendKeys("Problem in creating ABCFFF");
		String title=driver.findElement(By.name("ticket_title")).getAttribute("value");
		//System.out.println(title);
		WebElement priority = driver.findElement(By.name("ticketpriorities"));
		ProjectSpecific.findListItem(priority, "Normal");
		driver.findElement(By.id("hours")).sendKeys("24");
		driver.findElement(By.id("days")).sendKeys("1");
		//driver.findElement(By.className("detailedViewTextBox")).sendKeys("Test@gmail.com");
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		/*Thread.sleep(3000);
		driver.findElement(By.linkText("Trouble Tickets")).click();
		String xpath="//a[text()='"+title+"']";
		Thread.sleep(3000);
		driver.findElement(By.xpath(xpath)).click();*/
		driver.findElement(By.linkText("Convert As FAQ")).click();
		driver.findElement(By.linkText("FAQ")).click();
		String aMsg = driver.findElement(By.linkText(title)).getText();
		ProjectSpecific.verifyMsg1(title, aMsg);
		
		
	}
}
