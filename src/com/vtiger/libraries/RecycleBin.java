package com.vtiger.libraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RecycleBin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.vtiger.com");
		driver.findElement(By.id("submitButton")).click();
		Actions act=new Actions(driver);
		WebElement more = driver.findElement(By.linkText("More"));
		act.moveToElement(more).perform();
		//Thread.sleep(5000);
		//act.moveToElement(driver.findElement(By.name("Recycle Bin"))).perform();*/
		
		//driver.findElement(By.name("Recycle Bin")).click();
		//System.out.println(driver.findElement(By.xpath("//table[@class='allMnuTable']//a[text()='Recycle Bin']")).getText());
		//WebElement e = driver.findElement(By.xpath("//table[@class='allMnuTable']//a[text()='Recycle Bin']"));
		 WebElement e=driver.findElement(By.linkText("Recycle Bin"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",e);
		
		

	}

}
