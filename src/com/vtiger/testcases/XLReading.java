package com.vtiger.testcases;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLReading {

	public static void main(String[] args) throws InvalidFormatException, IOException
	{
		
		FileInputStream fis = new FileInputStream("g:/sogi6.xlsx");
		Workbook  wb= WorkbookFactory.create(fis);
		Sheet st= wb.getSheet("Sheet1");
		wb.createSheet("pradeep2");				
		int rc=st.getLastRowNum();
		for(int i=0;i<=rc;i++)
		{
			Row r=st.getRow(i);
			int cc=r.getLastCellNum();
			Row cr=wb.getSheet("pradeep2").createRow(i);
			for(int j=0;j<cc;j++)
			{
				//System.out.print(r.getCell(j).getStringCellValue()+ " ");
				System.out.print(wb.getSheet("sheet1").getRow(i).getCell(j).getStringCellValue()+ " ");
				String cell=wb.getSheet("sheet1").getRow(i).getCell(j).getStringCellValue();
				cr.createCell(j).setCellValue(cell);
				//cr.createCell(j).setCellValue(arg0);//overloaded method
			}
			System.out.println();
		
			
		}
	try
		{
		FileOutputStream out = new FileOutputStream("g:/sogi6.xlsx");
		wb.write(out);
		}catch(Exception e)
		{
			System.out.println("thereis a error");
		}
				
	}

}
