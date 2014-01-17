package com.vtiger.libraries;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class ProjectSpecific extends SuperTestNG
{
/*	public static void Login()
	{
	//driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.id("submitButton")).click();
	}*/
	public static void Logout()
	{
		WebElement e = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(e).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
	public static void findListItem(WebElement find,String s)
	{
		System.out.println(s);
		//WebElement find = driver.findElement(By.name("search_field"));
		Select sl=new Select(find);
		sl.selectByVisibleText(s);
	}
	public static void searchProduct(WebElement ser,WebElement lst,WebElement search,String prod,String item)
	{
		Select sl=new Select(lst);
		sl.selectByVisibleText(item);
		ser.sendKeys(prod);
		search.click();
	}
	public static void Login()
	{
		//driver.get("https://demo.vtiger.com");
		driver.findElement(By.id("submitButton")).click();
	}
	public static void SearchItem(String stxt,String itm)
	{
		 driver.findElement(By.name("search_text")).sendKeys(stxt);
		 WebElement lst=driver.findElement(By.id("bas_searchfield"));
		 Select s=new Select(lst);
		 s.selectByVisibleText(itm);
		 driver.findElement(By.xpath("//input[contains(@value,'Search Now')]")).click();
		
	}
	public static void clearList()
	{
		Select lst=new Select(driver.findElement(By.id("selectedColumns")));
		if(lst.getOptions().size()>0)
		{
			for(int i=0;i<lst.getOptions().size();)
			{
				lst.selectByIndex(i);
				driver.findElement(By.name("Button1")).click();
				i=0;
				
			}
		}
	} // end of clear method

	public static void verifyMsg(WebElement e,String eMsg)
	{
		String aMsg=e.getText();
		//System.out.println("eMsg="+eMsg);
		//System.out.println("aMsg="+aMsg);
		Assert.assertEquals(aMsg, eMsg);
	}
	public static void verifyMsg1(String eMsg,String aMsg)
	{
		Assert.assertEquals(eMsg, aMsg);
	}
	//go to the perticular module
	public static void gotoModule(String link)
	{
		try
		{
		
			driver.findElement(By.linkText(link)).click();
			System.out.println("link displayed");
		}
		catch( Exception e)
		{
			System.out.println("link is not displayed");
			Actions act=new Actions(driver);
			WebElement more = driver.findElement(By.linkText("More"));
			act.moveToElement(more).perform();
				if(link.equals("Recycle Bin"))
				{
				WebElement we = driver.findElement(By.linkText(link));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",we);
				}else
				{
					driver.findElement(By.linkText(link)).click();
				}
		}
	} // end of go to module
	public static ArrayList<String> childBrowser()
	{
		ArrayList Listwh= new ArrayList();
		Iterator<String> wh = driver.getWindowHandles().iterator();
		String parent=wh.next();
		Listwh.add(parent);
		String child=wh.next();
		Listwh.add(child);
		return Listwh;
	} //end of child browser
	public static void alertPopup()
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public static void mousehover(WebElement we)
	{
		Actions mouse= new Actions(driver);
		mouse.moveToElement(we).perform();
	}//End of mouse hover
	public static String searchGrid(String search)
	{
		String s;
		try
		{
		
			 s = driver.findElement(By.xpath("//tr[td[a[text()='"+search+"']]]/td[2]")).getText();
			return s;
		}catch(Exception e)
		{
			return s= " ";
		}
		
	} //End of Search Grid
}
