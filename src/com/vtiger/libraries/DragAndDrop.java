package com.vtiger.libraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("java first programe");
		WebDriver driver=new FirefoxDriver();
		EventFiringWebDriver d = new EventFiringWebDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Prakash/Desktop/Drag.html");
		Actions act= new Actions(driver);
		Thread.sleep(3000);
		//act.dragAndDrop(driver.findElement(By.id("boxA")),driver.findElement(By.id("boxB"))).perform();;
		Actions drag = act.clickAndHold(driver.findElement(By.id("boxA")));
		drag.moveToElement(driver.findElement(By.id("boxB")));
		drag.release(driver.findElement(By.id("boxB")));
		drag.build();
		drag.perform();
	}

}
