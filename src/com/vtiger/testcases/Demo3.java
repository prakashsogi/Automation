package com.vtiger.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.libraries.Generic;
import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class Demo3 extends SuperTestNG
{

	public static void main(String[] args) 
	{
		
		String XLPath="G:/VtigerWorkspace/Vtiger/excelfiles/Vtiger.xlsx";
		String Sheet ="Sheet1";
		ProjectSpecific.Login();
		driver.findElement(By.linkText("Leads")).click();
		/*
		driver.findElement(By.xpath("//img[contains(@title,'Create Lead')]")).click();
		WebElement e = driver.findElement(By.name("assigned_user_id"));
		Select sl= new Select(e);
		int k=sl.getOptions().size();
		List<WebElement> list = sl.getOptions();
		for(int i=0;i<k;i++)
		{
			System.out.print(list.get(i).getText()+" ");
			System.out.println(list.get(i).getText().length());
		}
		System.out.println("from excel");
		String v=Generic.XLCellValue(XLPath, Sheet, 0, 4);
		System.out.println(v);
		System.out.println(v.length());
		sl.selectByVisibleText(v);
		String s="[lead] prakash";
		System.out.println(s.substring(7));*/
		WebElement e = driver.findElement(By.xpath("//tr[td[a[text()='Albert']]]//td[5]"));
		Actions act=new Actions(driver);
		//act.moveToElement(e).perform();
		act.clickAndHold(e).perform();
		//act.moveByOffset(2,100);
		System.out.println(e.getText());
		
		

	}

}
