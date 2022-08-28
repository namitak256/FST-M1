package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/");
		//driver.close();
		driver.quit();
		
		System.setProperty("webdriver.chrome.driver", "C:\\SOFTWARE\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://www.training-support.net/");
		driver1.close();

	}

}
