package leaftapshooks;

import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateLeadHooksSteps extends BaseClass {
	
	@Given("Click on Create Lead Page")
	public void clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	@Given("Enter Company name as {string}")
	public void companyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
	}
	@Given("Enter First name as {string}")
	public void firstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}
	@Given("Enter Last name as {string}")
	public void lastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}
	@Given("Give Phone number as {string}")
	public void phoneNumber(String phoneNum) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNum);
	}
	@Given("Click on Create Lead Submit Button")
	public void clickSubmitButtton() {
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("View Lead Page should be displayed")
	public void viewLeadPage() {
		String text = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText();
		if (text.equals("View Lead")) {
			System.out.println("View Lead Page is displayed");
		} else {
			System.out.println("View Lead Page is not displayed, Check if the Lead Created");
		}
	}
}
