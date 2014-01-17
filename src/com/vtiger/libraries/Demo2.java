package com.vtiger.libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo2 {

	public static void main(String[] args) throws InvalidFormatException, IOException
	{
		String XLPath="G:/VtigerWorkspace/Vtiger/excelfiles/Vtiger.xlsx";
		String Sheet ="Sheet1";
	int rc=Generic.XLRow(XLPath, Sheet);
	for(int i=0;i<=rc;i++)
	{
		int c=Generic.XLColumn(XLPath, Sheet, i);
		for(int j=0;j<c;j++)
		{
			System.out.print(Generic.XLCellValue(XLPath, Sheet, i, j));
		}
		System.out.println();
	}
	}

}
