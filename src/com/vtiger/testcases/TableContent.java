package com.vtiger.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TableContent {

	public static void main(String[] args) 
	{
		
		WebDriver driver=new FirefoxDriver();
		EventFiringWebDriver d = new EventFiringWebDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.navigate().to("https://demo.vtiger.com");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Leads")).click();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='lvt small']//tr"));
		//List<WebElement> col = driver.findElements(By.xpath("//table[@class='lvt small']//td"));
		System.out.println(rows.size());
		for(int i=3;i<=rows.size();i++)
		{
			String v="//table[@class='lvt small']//tr["+i+"]/td";
			List<WebElement> col = driver.findElements(By.xpath(v));
			//System.out.println(col.size());
			for(int j=1;j<col.size();j++)
			{
				System.out.print(col.get(j).getText());
			}
			System.out.println();
		}

	}

}
