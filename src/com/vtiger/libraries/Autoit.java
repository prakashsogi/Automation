package com.vtiger.libraries;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Autoit {

	public static void main(String[] args) throws IOException 
	{
		
		
		WebDriver driver=new FirefoxDriver();
		//EventFiringWebDriver d = new EventFiringWebDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("http://www.seleniumhq.org/download/");
		driver.findElement(By.linkText("2.39.0")).click();
		Runtime.getRuntime().exec("g:/Autoit/First.exe");

	}

}
