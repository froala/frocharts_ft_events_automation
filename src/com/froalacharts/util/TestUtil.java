package com.froalacharts.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.froalacharts.base.EventsTestBase;

public class TestUtil
{
	static Workbook book;
	static Sheet sheet;
	static String DATA_FILE = System.getProperty("user.dir") + "/src/com/froalacharts/testdata/fteventsdata2.xls";
	
	public static Object[][] getTestData()
	{
		FileInputStream file=null;
		try {
			file = new FileInputStream(DATA_FILE);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sheet=book.getSheet("events");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}
	
	public static void htmlWrite(String htmlData)
	{
		try
		{    
          //FileWriter fw=new FileWriter(EventsTestBase.htmlFile); 
		  //Replace Filewriter with OutputStreamWriter to resolve utf8 char encoding issues for certain tests.
		  //Example binValueFormatted in dataPlotRollOver()
		   OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(EventsTestBase.htmlFile), StandardCharsets.UTF_8);		   
           fw.write(htmlData);    
           fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static boolean thisEventExists(Object[][] data,String apiName)
	{
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			String apiNameSheet = (String) data[i][0];
			if(apiName.equals(apiNameSheet))
				return true;
		}
		return false;
	}
	
	public static String[] getRow(Object[][] data,String eventName)
	{
		String[] allDataOfRow = new String[25];
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			String eventNameSheet = (String) data[i][0];
			if(eventName.equals(eventNameSheet))
			{
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
					allDataOfRow[j] = (String) data[i][j];
			}
		}
		return allDataOfRow;
	}
	public static String getHtml(Object[][] data,String eventTestName)
	{
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			String apiNameSheet = (String) data[i][0];
			if(eventTestName.equals(apiNameSheet))
				return (String) data[i][1];
		}
		return "";
	}
}
