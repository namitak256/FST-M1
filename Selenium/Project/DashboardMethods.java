package testMethods;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardMethods extends BaseMethods {

	public void verifyHomePage() {
		String homePageURL = "https://alchemy.hguy.co/crm/index.php?module=Home&action=index";
		WebElement dashboardTab = driver.findElement(By.xpath("//a[@id='tab0']"));

		Assert.assertTrue(driver.getCurrentUrl().equals(homePageURL));
		Assert.assertTrue(dashboardTab.getText().contains("SUITECRM DASHBOARD"));
	}

	public void fetchNavMenuColor() {
		WebElement navMenu = driver.findElement(By.xpath("//div[@id='toolbar']"));
		String navMenuColor = navMenu.getCssValue("color");
		System.out.println(navMenuColor);

	}

	public void verifyTabExists() {
		WebElement activitiesTab = driver.findElement(By.xpath("//a[@id='grouptab_3']"));
		System.out.println("Is Activities tab displayed: " + activitiesTab.isDisplayed());
		Assert.assertTrue(activitiesTab.isDisplayed());

	}

	public void navSalesLeads() {
		WebElement salesTab = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
		WebElement leadsOption = driver.findElement(By.xpath("//a[@id='grouptab_0']/..//a[@id='moduleTab_9_Leads']"));

		salesTab.click();
		leadsOption.click();
	}

	public void clickAddtnlInfoIcon() throws InterruptedException {

		String additionalInfoMsgBtn = "(//span[@title='Additional Details'])[1]";

		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(additionalInfoMsgBtn)));
		Assert.assertTrue(isElementVisible(additionalInfoMsgBtn));

		driver.findElement(By.xpath(additionalInfoMsgBtn)).click();

	}

	public void getPopUpInfo() {

		String MobileNo = "(//b[text()='Mobile:']/following-sibling::span)[1]";

		Assert.assertTrue(isElementVisible(MobileNo));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MobileNo)));

		System.out.println(driver.findElement(By.xpath(MobileNo)).getText());
	}

	public void navSalesAccounts() {
		WebElement salesTab = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
		WebElement AccountsOption = driver
				.findElement(By.xpath("//a[@id='grouptab_0']/..//a[@id='moduleTab_9_Accounts']"));

		salesTab.click();
		AccountsOption.click();
	}

	public void fetchNameFromTable() {

		String accountsTable = "//table[@class='list view table-responsive']";
		String accountsPageTitle = "//h2[@class='module-title-text'][contains(text(),'Accounts')]";
		String name;

		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accountsTable)));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accountsPageTitle)));
		
		Assert.assertTrue(isElementVisible(accountsTable));
		Assert.assertTrue(isElementVisible(accountsPageTitle));

		List<WebElement> liOdd = driver
				.findElements(By.xpath("//table[@class='list view table-responsive']//tr[@class='oddListRowS1']"));

		System.out.println(liOdd.size());

		for (int i = 0; i <= 4; i++) {
			name = liOdd.get(i).findElement(By.xpath("./td[3]//a")).getText();
			System.out.println(name);
		}
	}

	public void fetchNameUserFromTable() {

		String leadsTable = "//table[@class='list view table-responsive']";
		String LeadsPageTitle = "//h2[@class='module-title-text'][contains(text(),'Leads')]";
		String name;
		String user;

		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(leadsTable)));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeadsPageTitle)));
		
		Assert.assertTrue(isElementVisible(leadsTable));
		Assert.assertTrue(isElementVisible(LeadsPageTitle));

		List<WebElement> liAll = driver
				.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));

		System.out.println(liAll.size());

		for (int i = 0; i <= 9; i++) {
			name = liAll.get(i).findElement(By.xpath("./td[3]//a")).getText();
			user = liAll.get(i).findElement(By.xpath("./td[8]//a")).getText();
			System.out.println("Name: "+name+"\tUser: "+user);
		}
	}

}
