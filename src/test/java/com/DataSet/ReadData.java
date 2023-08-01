package com.DataSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadData {
	String fpath = "D:\\Purvi_SeleniumDemos\\MyMavenProject\\DataFiles\\LoginData.xlsx";
	File file;
	FileInputStream fis ;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadData r1 = new ReadData();
		r1.getLoginData();
	}
	
	@DataProvider
	public Object[][] getLoginData() throws IOException {
		 file = new File(fpath);
		  fis = new FileInputStream (file);
		  wb = new XSSFWorkbook(fis);
		  sheet = wb.getSheetAt(0);	
	int	rows = sheet.getPhysicalNumberOfRows();
	
	String loginData[][] = new String[rows][2];
		for(int i=0; i<rows; i++) {
			  
			//  row = sheet.getRow(i);
			  for(int j=0 ; j<2 ; j++) {
				  
				//  cell = row.getCell(j);
				  cell= sheet.getRow(i).getCell(j);
				//  System.out.println(cell.getStringCellValue());
				  loginData[i][j] = cell.getStringCellValue();
			  }
			
		  }
		wb.close();
		fis.close();
		return loginData;
	}

}
