package com.vtiger.libraries;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Demo {

	public static void main(String[] args) 
	{
		System.out.println("java first programe");
		WebDriver driver=new FirefoxDriver();
		EventFiringWebDriver d = new EventFiringWebDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.navigate().to("https://demo.vtiger.com");
		List<WebElement> e = driver.findElements(By.tagName("input"));
		System.out.println(e.size());
		for(int i=0;i<e.size();i++)
		{
			System.out.println(e.get(i).getAttribute("name"));
		}
		
		driver.findElement(By.id("submitButton")).click();
		WebElement m = driver.findElement(By.linkText("More"));
		Actions act=new Actions(driver);
		act.moveToElement(m).perform();
		

	}

}
