package com.vtiger.libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLReadWrite {

	public static void main(String[] args) throws InvalidFormatException, IOException 
	{
		
		FileInputStream fis=new FileInputStream("g:/sogi.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		FileInputStream fos= new FileInputStream("g:/sogi6.xlsx");
		Workbook wb2=WorkbookFactory.create(fos);
		int st=wb.getNumberOfSheets();
		for(int k=0;k<st;k++)
		{
			Sheet sht=wb.getSheetAt(k);
			int rc=sht.getLastRowNum();
			for(int i=0;i<=rc;i++)
			{
				Row r=sht.getRow(i);
				int c=r.getLastCellNum();
				Row r2=wb2.getSheetAt(k).createRow(i);
				for(int j=0;j<c;j++)
				{
					System.out.print(r.getCell(j).getStringCellValue()+" ");
					r2.createCell(j).setCellValue(r.getCell(j).getStringCellValue());
					
				}
				System.out.println();
				
			}
			System.out.println("end of sheet"+k);
		}
		FileOutputStream out= new FileOutputStream("g:/sogi6.xlsx");
		wb2.write(out);

	}

}
