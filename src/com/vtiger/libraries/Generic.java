package com.vtiger.libraries;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Generic
{
	public static int XLRow(String xlname,String sheet)
	{
		int rc;
		try{
		FileInputStream fis = new FileInputStream(xlname);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet st=wb.getSheet(sheet);
		 rc=st.getLastRowNum();
		}
		catch(Exception e)
		{
			return rc=-1;
		}
		return rc;
	}
	
	public static int XLColumn(String xlname,String sheet,int row)
	{
		int cc;
		try{
		FileInputStream fis = new FileInputStream(xlname);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet st=wb.getSheet(sheet);
		cc=wb.getSheet(sheet).getRow(row).getLastCellNum();
		}
		catch(Exception e)
		{
			return cc=-1;
		}
		return cc;
	}


public static String XLCellValue(String xlname,String sheet,int rowNum,int cellNum)
{
	String cellValue;
	try{
	FileInputStream fis = new FileInputStream(xlname);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet st=wb.getSheet(sheet);
	cellValue=wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	catch(Exception e)
	{
		return cellValue=" ";
	}
	return cellValue;
}
}
