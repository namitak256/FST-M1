package activities;

import static org.testng.Assert.assertTrue;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.netty.util.Timeout;
import javafx.scene.input.Clipboard;

public class Activity13_2b {

	public static void main(String[] args) throws InterruptedException, IOException, CsvException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		
		String filepath = "src/test/resources/sample.xlsx";

		Activity13_2b obj = new Activity13_2b();
		// obj.writeExcel(filepath);
		// obj.readExcel(filepath);

		XSSFWorkbook wb = new XSSFWorkbook(filepath);
		XSSFSheet sh = wb.getSheetAt(0);
		XSSFRow row = sh.getRow(0);
		XSSFCell cell = row.getCell(0);
		String val = cell.getStringCellValue();
		// System.out.println(val);

		System.out.println(sh.getLastRowNum() + " " + row.getLastCellNum());

		for (int i = 1; i < sh.getLastRowNum()+1; i++) {

			WebElement inputfname= driver.findElement(By.xpath("//input[@id='firstName']"));
			WebElement inputlname= driver.findElement(By.xpath("//input[@id='lastName']"));
			WebElement inputemail= driver.findElement(By.xpath("//input[@id='email']"));
			WebElement inputph= driver.findElement(By.xpath("//input[@id='number']"));
			WebElement submit= driver.findElement(By.xpath("//input[@type='submit']"));
			
			inputfname.clear();
			inputlname.clear();
			inputemail.clear();
			inputph.clear();
			
			String fname = sh.getRow(i).getCell(1).getStringCellValue();
			String lname = sh.getRow(i).getCell(2).getStringCellValue();
			String email = sh.getRow(i).getCell(3).getStringCellValue();
			String ph = sh.getRow(i).getCell(4).getStringCellValue();
			
			System.out.println(fname + " " + lname + " " + email + " " + ph);
			
			inputfname.sendKeys(fname);
			inputlname.sendKeys(lname);
			inputemail.sendKeys(email);
			inputph.sendKeys(ph);
			
			submit.click();
			
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			
			/*
			 * WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
			 * 
			 * w.until(ExpectedConditions.visibilityOf(submit));
			 * w.until(ExpectedConditions.elementToBeClickable(By.xpath(
			 * "//input[@type='submit']")));
			 */
			
			Thread.sleep(3000);

		}
		
		driver.quit();

	}

	public void writeExcel(String filePath) {

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Sheet1");

		List<String[]> data = new ArrayList<String[]>();
		String[] heading = { "ID", "First Name", "Last Name", "Email", "Ph.No." };
		String[] row1 = { "1", "Satvik", "Shah", "satshah@example.com", "4537829158" };
		String[] row2 = { "2", "Avinash", "Kati", "avinashK@example.com", "4892184058" };
		String[] row3 = { "3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830" };

		// Add it to the List
		data.add(heading);
		data.add(row1);
		data.add(row2);
		data.add(row3);

		int rownum = 0;
		for (String[] rowData : data) {
			// Creates a new row in the sheet
			Row row = sheet.createRow(rownum++);
			int cellnum = 0;
			for (String cellData : rowData) {
				// Creates a cell in the next column of that row
				Cell cell = row.createCell(cellnum++);
				cell.setCellValue(cellData);
			}
		}

		try {
			FileOutputStream out = new FileOutputStream(new File(filePath));
			wb.write(out);
			out.close();
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void readExcel(String filePath) {
		try {

			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + " \t ");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + " \t ");
						break;
					default:
						System.out.println("Invalid value");
						break;
					}
				}
				System.out.println("");

			}
			fis.close();
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
