package org.springframework.samples.petclinic.seleniumwebdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOwnerTest {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	public void test() {
		driver.get("https://192.168.83.1:8088/");
		System.out.println(driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).getText());
		driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).click();

	}

}
