package org.datadriven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Question3 {

	@Test
	public void readAndWriteOtupt() throws IOException {
		File f = new File("C:\\Users\\VRKRISH\\eclipse-workspace\\DataDriven1\\file\\SAMPLE.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w =new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet("samp");
		int r = sheet.getPhysicalNumberOfRows();
		for(int i=0;i<r;i++  ) {
			Row row = sheet.getRow(i);
			int c = row.getPhysicalNumberOfCells();
			for(int j=0;j<c;j++) {
				Cell cell = row.getCell(j);
			int cellType = cell.getCellType();
			if(cellType ==1) {
				String stringCellValue = cell.getStringCellValue();
				System.out.println("Name:"+stringCellValue);
				}
			else if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd,mmmm,yyyy");
				String string = sdf.format(dateCellValue);				
				System.out.println("Date"+string);
				
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				
				long l = (long)numericCellValue;
				System.out.println("Mobile:"+l);
				
				
			}			
			}
		}
		
	
		
		
	}

}
