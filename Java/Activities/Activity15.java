package activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Activity15 {

	private static String FILE_NAME = "C:\\Namita\\Workspace\\FST_java\\src\\activities\\TestSheet.xlsx";
	
	public static void main(String[] args) {

		try {
			
			//File f= new File(FILE_NAME);

			//FileInputStream fis= new FileInputStream(f);
			
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sh= wb.createSheet("Datatypes in Java");
			
			Object[][] datatypes= {
					{"Datatype", "Type", "Size(in bytes)"},
					{"int", "Primitive", 2},
				    {"float", "Primitive", 4},
				    {"double", "Primitive", 8},
				    {"char", "Primitive", 1},
				    {"String", "Non-Primitive", "No fixed size"}
			};
			System.out.println(datatypes.length);
			
			int rownum=0;
			for(Object[] r : datatypes) {
				Row row= sh.createRow(rownum++);
				int cellnum=0;
				for(Object c : r) {
					Cell cell= row.createCell(cellnum++);
					cell.setCellValue(c.toString());
				}
			}
			
			FileOutputStream fos= new FileOutputStream(FILE_NAME);
			wb.write(fos);
			wb.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
