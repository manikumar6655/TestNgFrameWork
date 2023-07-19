package Utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import TestBase.ConstantsUtility;

public class ExcelFileUtility {

	
	public String readDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell cel = r.getCell(cell);
				
		
		DataFormatter df=new DataFormatter();
		String v=	df.formatCellValue(cel);
		wb.close();
		return v;
	}

	
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		int lastRow = s.getLastRowNum();
		wb.close();
		return lastRow;
	}

	
	public void writeDataIntoExcel(String sheet, int row, int cel, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell cell = r.createCell(cel);
		cell.setCellValue(value);

		FileOutputStream fos = new FileOutputStream(ConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();

	}

	
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();

		Object[][] data = new Object[lastRow][lastCell];

		for(int i=0;i<lastRow;i++)
		{ 
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}

		return data;

	}














}


