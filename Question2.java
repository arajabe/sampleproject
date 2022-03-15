package org.datadriven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Question2 {

	@Test
	public void readExcel() throws IOException {
		File f = new File("C:\\Users\\VRKRISH\\eclipse-workspace\\DataDriven1\\file\\SAMPLE.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet("samp");
	int r = sheet.getPhysicalNumberOfRows();
	Row row = sheet.getRow(0);
	int c = row.getPhysicalNumberOfCells();
	System.out.println("Number of Rows   :"+r);
	System.out.println("Number of Coloum :"+c);
	}

}
