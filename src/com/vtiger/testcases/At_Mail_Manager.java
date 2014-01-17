package com.vtiger.testcases;

import org.testng.annotations.Test;

import com.vtiger.libraries.ProjectSpecific;
import com.vtiger.libraries.SuperTestNG;

public class At_Mail_Manager extends SuperTestNG
{
	@Test
	public void testAt_Mail_Manager() throws InterruptedException
	{
	ProjectSpecific.Login();
	ProjectSpecific.gotoModule("Recycle Bin");
	Thread.sleep(5000);
	}

}

