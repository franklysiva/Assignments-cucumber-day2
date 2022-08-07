package testngretryngroups;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;
	public String file;
	@BeforeMethod(alwaysRun = true)
	@Parameters({"url", "username", "password"})
	public void preConditions(String url, String username, String password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();
		WebElement crmsfaElement = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaElement.click();
		WebElement leadsButton = driver.findElement(By.linkText("Leads"));
		leadsButton.click();
	}
	@AfterMethod(alwaysRun = true)
	public void postCondtions() {
		driver.close();
	}
	@DataProvider(name="LeadDatas")
	public String[][] datas() throws IOException {
	String[][] leadDatas = LeadData.getLeadDatas(file);
	return leadDatas;
	}
}
