package com.crm.qa.util;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long Page_Load_TimeOut=20;
	public static long Implicitly_Wait=10;
	
	public static void selectByVisibleText(WebElement element,String name) {
		new Select(element).selectByVisibleText(name);

	}
	
	static Workbook book;
	static Sheet sheet;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\sony\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Adactin_Test_Data.xlsx";

	public static Object[][]  getTestData(String sheetname) {
		
FileInputStream file=null;

try {
	file=new FileInputStream(TESTDATA_SHEET_PATH);
} catch (FileNotFoundException e) {
	e.printStackTrace();
}

try {
	book=WorkbookFactory.create(file);
} catch (InvalidFormatException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}

sheet=book.getSheet(sheetname);
Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

for (int i = 0; i < sheet.getLastRowNum(); i++) {
	for (int j = 0; j <sheet.getRow(0).getLastCellNum(); j++) {
		data[i][j]=sheet.getRow(i+1).getCell(j).toString();
	}
	
}
return data;
	}
    public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
}


	

	
}
