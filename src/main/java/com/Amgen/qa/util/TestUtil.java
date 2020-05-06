package com.Amgen.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Amgen.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static String TEST_DATA_PATH = "C:\\Users\\rashi\\Desktop\\AmgenBackUp.xlsx";
	
//	public static String TEST_DATA_PATH_PAGE2 = "C:\\Users\\rashi\\Desktop\\AmgenBackUp.xlsx";
	
	static Workbook book;
	static Sheet sheet;

	/*static Workbook book2;
	static Sheet sheet2;*/
	
	public static Object[][] getTestData(String sheetName) {

		FileInputStream file = null;
		try {
			file = new FileInputStream(TEST_DATA_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}


	/*public static Object[][] getTestDataPage2(String sheetNamepage2) {

		FileInputStream file = null;
		try {
			file = new FileInputStream(TEST_DATA_PATH_PAGE2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book2 = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet2 = book2.getSheet(sheetNamepage2);
		Object[][] datapg2 = new Object[sheet2.getLastRowNum()][sheet2.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet2.getLastRowNum(); i++) {
			for (int k = 0; k < sheet2.getRow(0).getLastCellNum(); k++) {
				datapg2[i][k] = sheet2.getRow(i + 1).getCell(k).toString();
			}
		}
		return datapg2;
	}*/
	
}
