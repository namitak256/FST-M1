package activities;

import static org.testng.Assert.assertTrue;

import java.awt.RenderingHints.Key;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.netty.util.Timeout;
import javafx.scene.input.Clipboard;

public class Activity13_1 {

	public static void main(String[] args) throws InterruptedException, IOException, CsvException {
		
		//WebDriver driver = new FirefoxDriver();
		
		CSVReader reader = new CSVReader(new FileReader("C:\\Namita\\Workspace\\FST_Selenium\\src\\main\\java\\activities\\Data.csv"));

		//Load content into list
		List<String[]> list = reader.readAll();
		System.out.println("Number of rows: "+list.size());
		
		Iterator<String[]> itr = list.iterator();

		while(itr.hasNext()) {
		    String[] str = itr.next();

		    System.out.print("Values are: ");
		    for(int i=0;i<str.length;i++) {
		        System.out.print(" " + str[i]);
		    }
		        System.out.println(" ");
		}
		
		Thread.sleep(3000);
		//driver.quit();
		

	}

}
