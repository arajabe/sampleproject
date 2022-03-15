package org.datadriven6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainClass {
	static WebDriver driver;
	
	@BeforeClass
	public void browserConfiguration() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}

	@BeforeMethod
	public void loginDetails() throws IOException {
		driver.get("https://www.facebook.com/");
		File f = new File("C:\\Users\\VRKRISH\\eclipse-workspace\\DataDriven6\\File\\SAMPLE - Copy.xlsx");
		FileOutputStream fos = new FileOutputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet sheet = w.createSheet("face book data");
		Row row= sheet.createRow(0);
		Cell cell0 = row.createCell(0);
		cell0.setCellValue("arajabe@gmail.com");
		Cell cell1 = row.createCell(1);
		cell1.setCellValue("chennai");
w.write(fos);	
	}
	@Test
	public void loginPage() throws IOException {
		WebElement userid = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement button = driver.findElement(By.xpath("//button[@value='1']"));
		File f = new File("C:\\Users\\VRKRISH\\eclipse-workspace\\DataDriven6\\File\\SAMPLE - Copy.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet("face book data");
		Row row = sheet.getRow(0);
		Cell cell1 = row.getCell(0);
		Cell cell2 = row.getCell(1);		
		userid.sendKeys(cell1.getStringCellValue());
		password.sendKeys(cell2.getStringCellValue());
		button.click();
		String url = driver.getCurrentUrl();
		boolean b = url.contains("https://www.facebook.com/login/device-based/regular/login/?login_attempt");
	Assert.assertTrue(b);	
	}
	
	
	
	

}
