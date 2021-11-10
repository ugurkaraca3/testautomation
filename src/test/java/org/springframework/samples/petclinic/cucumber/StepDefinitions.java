package org.springframework.samples.petclinic.cucumber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	@AfterMethod
	public void tOut() throws InterruptedException {
		Thread.sleep(500);
	}

	@Given("Browser is opened")
	public void browser_is_opened() {
//		ChromeOptions cr = new ChromeOptions();
//		cr.addArguments();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@When("Petclinic is opened")
	public void petclinic_is_opened() {
		driver.get("http://localhost:8088/");
		Assert.assertTrue(driver.getTitle().equals("PetClinic :: a Spring Framework demonstration"));
	}

	@When("Find Owner is clicked")
	public void find_owner_is_clicked() {
		Assert.assertEquals(driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).getText(), "FIND OWNERS");
		driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).click();
	}

	@When("Search LastName")
	public void search_last_name(io.cucumber.datatable.DataTable dataTable) {
		List<String> data = dataTable.asList();
		driver.findElement(By.cssSelector("input[id=\"lastName\"]")).sendKeys(data.get(1));
	}

	@When("Search is clicked")
	public void search_is_clicked() {
		driver.findElement(By.cssSelector("input[id=\"lastName\"]")).sendKeys(Keys.ENTER);

	}

	@Then("Owner Verified")
	public void owner_verified() {
		Assert.assertTrue(driver.findElement(By.cssSelector("a[href=\"11/edit\"]")).isDisplayed());
	}

	@After
	public void cleanUp() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
