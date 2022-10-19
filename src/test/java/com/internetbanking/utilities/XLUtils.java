package com.internetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  XSSFWorkbook wb;
	public  XSSFSheet ws;
	public  XSSFRow row;
	public  XSSFCell cell;
	public  CellStyle style;
	String path = null;

	
	public XLUtils(String path)
	{
		this.path= path; 
	}
	

	public int getRowCount (String sheetName) throws IOException 
	{
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook (fi);
	ws=wb.getSheet(sheetName);
	int rowcount = ws.getLastRowNum();
	wb.close();
	fi.close();
	return rowcount;
	}

	public int getCellCount (String sheetName, int rownum) throws IOException
	{
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook (fi);
	ws=wb.getSheet (sheetName);
	row=ws.getRow(rownum);
	int cellcount = row.getLastCellNum();
	wb.close();
	fi.close();
	return cellcount;
	}



	public String getCellData(String sheetName, int rownum, int colnum) throws IOException
	{
	fi = new FileInputStream(path); 
	wb=new XSSFWorkbook(fi); 
	ws=wb.getSheet(sheetName); 
	row=ws.getRow(rownum); 
	cell=row.getCell(colnum); 
	
	DataFormatter formatter = new DataFormatter();
	String data;
	
	try
	{
	data = formatter.formatCellValue(cell);
	}

	catch (Exception e)
	{
	data="";
	}
	wb.close();
	fi.close();
	return data;
	}


	public  void setCellData (String sheetName,int rownum, int colnum, String data) throws IOException

	{
	fi=new FileInputStream(path);
	wb=new XSSFWorkbook (fi);
	ws=wb.getSheet (sheetName);
	
	row=ws.getRow(rownum);
	cell=row.createCell(colnum); 
	cell.setCellValue(data);
	
	fo=new FileOutputStream(path);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	}
	
	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException
	
	{
		
	fi=new FileInputStream(path); 
	wb=new XSSFWorkbook (fi); 
	ws=wb.getSheet(sheetName);

	row=ws.getRow(rownum); 
	cell=row.getCell(colnum);

	style=wb.createCellStyle();

	style.setFillForegroundColor (IndexedColors.GREEN.getIndex()); 
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	cell.setCellStyle(style);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();

	}
}


