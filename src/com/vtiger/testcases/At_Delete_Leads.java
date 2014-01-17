package com.vtiger.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Delete_Leads extends SuperTestNG {

	public static void main(String[] args) throws InterruptedException 
	{
		ProjectSpecific.Login();
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr[td[a[text()='ZZ']]]//input[@type='checkbox']")).click();
		String v = driver.findElement(By.xpath("//tr[td[a[text()='ZZ']]]//td[3]")).getText();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(3000);
		ProjectSpecific.SearchItem(v, "Last Name");
		Thread.sleep(30000);
		String cmp="No Lead Found !";
		String str = driver.findElement(By.xpath("//span[contains(text(),'No Lead Found')]")).getText();
		System.out.println(str);
		if(str.equals(cmp))
		{
			System.out.println("deleted successfuly");
		}
	}

}
