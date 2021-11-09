package org.springframework.samples.petclinic.seleniumwebdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOwnerTest {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8088/");

		Assert.assertTrue(driver.getTitle().equals("PetClinic :: a Spring Framework demonstration"));

		Assert.assertEquals(driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).getText(), "FIND OWNERS");
		driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).click();

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name=\"lastName\"]")).sendKeys("ugurkaraca3");
		driver.findElement(By.cssSelector("button[class=\"btn btn-default\"][type=\"submit\"]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"lastNameGroup\"]/div/span/div/p")).isDisplayed());

	}

}
