package testngretryngroups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends BaseClass {
	
	@BeforeTest(alwaysRun = true)
	public void dataFile() {
		file = "EditLead";
	}

	@Test(dataProvider = "LeadDatas" , groups = {"functional" , "regression"})
	public void runEditLead (String firstName, String lastName, String companyName, String compName, String fNameEdit) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='firstName']"))
				.sendKeys(firstName);
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='companyName']"))
				.sendKeys(companyName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
		WebElement fNameElement = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]"));
		String fName = fNameElement.getText();
		WebElement lNameElement = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-lastName']//a)[1]"));
		String lName = lNameElement.getText();
		WebElement cNameElement = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-companyName']//a)[1]"));
		String cName = cNameElement.getText();
		if (fName.equals(firstName) && lName.equals(lastName) && cName.equals(companyName)) { 
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		} 
		else {
			System.out.println("Condition Not Met");
		}
		Thread.sleep(2000);
		driver.findElement(By.linkText("Edit")).click();
		WebElement editCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
		editCompanyName.clear();
		editCompanyName.sendKeys(compName);
		WebElement editFirstName = driver.findElement(By.id("updateLeadForm_firstName"));
		editFirstName.clear();
		editFirstName.sendKeys(fNameEdit);
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(4000);
		String editedCName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText().replaceAll("[^a-zA-Z]","").trim();
		String editedFName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		if (editedCName.endsWith(compName) && editedFName.equals(fNameEdit)) {
			System.out.println("Lead Edit Completed!");
		}
	}
}