package testMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginMethods extends BaseMethods{

	
	public void verifyLoginPage() {
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		Assert.assertEquals(pagetitle, "SuiteCRM" , "Page title should match");
	}
	
	public void getHeaderURL() throws InterruptedException {
		WebElement suiteCRMImg = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
		String suiteCRMImgSrc = suiteCRMImg.getAttribute("src");
		System.out.println(suiteCRMImgSrc);
	}
	
	public void fetchFirstCopyrightText() {
		WebElement footer1 = driver.findElement(By.xpath("//div[@class='p_login_bottom']/a[1]"));
		String footer1Text = footer1.getText(); 
		System.out.println(footer1Text);
	}
	
	public void enterLoginCreds() {
		WebElement username = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='username_password']"));
		
		username.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		
	}
	
	public void clickLoginBtn() {
		WebElement LoginBtn = driver.findElement(By.xpath("//input[@name='Login']"));
		
		LoginBtn.click();
	}
	
}
