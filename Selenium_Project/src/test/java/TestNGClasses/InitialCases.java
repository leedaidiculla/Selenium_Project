package TestNGClasses;

import org.testng.annotations.Test;

import utility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class InitialCases {
	DriverManager obj = new DriverManager();
	WebDriver driver;
	String exceptedURL = "https://selenium.obsqurazone.com/index.php";

	@Test
	public void valueCheck1() throws InterruptedException {
		WebElement inputForm = driver.findElement(By.xpath("//*[@id='collapsibleNavbar']/ul/li[2]/a"));
		inputForm.click();
		Thread.sleep(2000);
		WebElement textbox = driver.findElement(By.id("single-input-field"));
		textbox.sendKeys("Hello");
		Thread.sleep(2000);
		WebElement button = driver.findElement(By.id("button-one"));
		button.click();
		Thread.sleep(2000);
		WebElement getValue = driver.findElement(By.id("message-one"));
		String appvalue = getValue.getText();
		if (appvalue.contains("Hello")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("String comparison failed");
		}
	}

	@Test
	public void valueCheck2() throws InterruptedException {
		WebElement textbox2 = driver.findElement(By.id("value-a"));
		int a = 10;
		String s = Integer.toString(a);
		textbox2.sendKeys(s);
		Thread.sleep(2000);
		WebElement textbox3 = driver.findElement(By.id("value-b"));
		int b = 10;
		String s1 = Integer.toString(b);
		textbox3.sendKeys(s1);
		Thread.sleep(2000);
		WebElement button = driver.findElement(By.id("button-two"));
		button.click();
		Thread.sleep(2000);
		WebElement getValue = driver.findElement(By.id("message-two"));
		String appvalue = getValue.getText();
		int sum = 200;
		String s2 = Integer.toString(sum);
		if (appvalue.contains(s2)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Sum of two numbers are not correct");
		}

	}

	@BeforeTest
	public void beforeTest() {

		obj.launchBrowser(exceptedURL);
		this.driver = obj.driver;
	}

	@AfterTest
	public void afterTest() {
		obj.closeBrowser();
	}

}
