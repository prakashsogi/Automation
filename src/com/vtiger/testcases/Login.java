package com.vtiger.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new FirefoxDriver();
		EventFiringWebDriver d = new EventFiringWebDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.navigate().to("https://demo.vtiger.com");
		System.out.println(driver.findElement(By.id("submitButton")).getAttribute("value"));
		Dimension size = driver.findElement(By.id("submitButton")).getSize();
				System.out.println(size.width);
		System.out.println(size.getHeight());
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.name("query_string")).sendKeys("prakash come here");
		System.out.println("Typed text = "+driver.findElement(By.name("query_string")).getAttribute("value"));
		System.out.println(driver.findElement(By.xpath("//input[@alt='Find']")).getAttribute("src"));
		System.out.println("URL = "+driver.getCurrentUrl());
		System.out.println("titel = "+driver.getTitle());
		Thread.sleep(2000);
		d.executeScript("scroll(0,6000)");
		//System.out.println("page source = "+driver.getPageSource());
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@id='stuff_1']"))).perform();
		Thread.sleep(2000);
		d.executeScript("scroll(0,300)");
		
		

	}

}
