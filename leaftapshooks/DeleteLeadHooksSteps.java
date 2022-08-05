package leaftapshooks;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;

public class DeleteLeadHooksSteps extends BaseClass {
	
	@Given("Click on Phone Tab under Find by")
	public void clickPhoneTab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@Given("Enter Phone number as {string}")
	public void enterPhoneNum(String Phone) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(Phone);
	}
	String leadID;
	@Given("Get the First LeadID number in the List and Click on it")
	public void getLeadIdAndClick() {
		leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).getText();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
	}
	@Given("Click on Delete Button")
	public void deleteLead() {
		driver.findElement(By.linkText("Delete")).click();
	}
	@Given("Check Deleted Lead using LeadID")
	public void checkDeletedLead() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Find by']//following::input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if(text.equals("No records to display")) {
			System.out.println("Lead ID: "+leadID+" Deleted Successfully");
		} else {
			System.out.println("Something went wrong, LeadID: "+leadID+" is not deleted");
		}
	}
}
