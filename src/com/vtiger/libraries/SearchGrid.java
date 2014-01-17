package com.vtiger.libraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchGrid {

	public static void main(String[] args)
	{
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(35,TimeUnit.SECONDS);
		driver.get("https://demo.vtiger.com");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Leads")).click();
		try
		{
		WebElement we = driver.findElement(By.xpath("//tr[td[a[text()='Linda22']]]/td[4]"));
		System.out.println(driver.findElement(By.xpath("//tr[td[a[text()='Linda']]]/td[5]")).getText());
		}catch(Exception e)
		{
			System.out.println("no such lead");
		}
		

	}

}
