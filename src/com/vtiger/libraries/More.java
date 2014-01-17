package com.vtiger.libraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class More {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//ProjectSpecific.Login();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.vtiger.com");
		driver.findElement(By.id("submitButton")).click();
		try
		{
			//driver.findElement(By.linkText("Project Milestones")).isDisplayed();
			driver.findElement(By.linkText("Project Milestones")).click();
			System.out.println("link displayed");
		}
		catch( Exception e)
		{
			System.out.println("link is not displayed");
			String link="PBX Manager";
		Actions act=new Actions(driver);
		WebElement more = driver.findElement(By.linkText("More"));
		act.moveToElement(more).perform();
		//String Xpath = "//table[@class='allMnuTable']//tbody/tr/td/a[text()='"+link+"']";
		//driver.findElement(By.xpath("//table[@class='allMnuTable']//tbody/tr/td/a[text()='Price Books']")).click();
		//driver.findElement(By.xpath(Xpath)).click();
		driver.findElement(By.linkText(link)).click();
		
		}
		
		

	}

}
