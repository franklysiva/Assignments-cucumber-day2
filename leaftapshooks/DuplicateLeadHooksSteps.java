package leaftapshooks;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;

public class DuplicateLeadHooksSteps extends BaseClass {
	@Given("Click on Duplicate Lead Button")
	public void clickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@Given("And Click on Submit Button")
	public void clickSubmitButton() {
		driver.findElement(By.name("submitButton")).click();
	}
}
