package TestNGClasses;

import org.testng.annotations.Test;

import pageObjectmodel.HomePage;
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
	
	@Test(priority = 0,enabled = true)
	public void valueCheck1() throws InterruptedException {
		
// Code for page object model without Page Factor
		/*
		 * WebElement inputForm =
		 * driver.findElement(By.xpath("//*[@id='collapsibleNavbar']/ul/li[2]/a"));
		 * inputForm.click(); Thread.sleep(2000); WebElement textbox =
		 * driver.findElement(By.id("single-input-field")); textbox.sendKeys("Hello");
		 * Thread.sleep(2000); WebElement button =
		 * driver.findElement(By.id("button-one")); button.click(); Thread.sleep(2000);
		 * WebElement getValue = driver.findElement(By.id("message-one")); String
		 * appvalue = getValue.getText();
		 */
		
// Code for page object model with Page Factor	
		HomePage objHome = new HomePage(driver);
		objHome.messageVerification();
		Thread.sleep(2000);
		String appvalue=objHome.returnTextValue();
		Thread.sleep(2000);
		if (appvalue.contains("Hello")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("String comparison failed");
		}
	}

	@Test(priority = 1,enabled=true)
	public void valueCheck2() throws InterruptedException {
		
		/*
		 * WebElement textbox2 = driver.findElement(By.id("value-a")); int a = 10;
		 * String s = Integer.toString(a); textbox2.sendKeys(s); Thread.sleep(2000);
		 * WebElement textbox3 = driver.findElement(By.id("value-b")); int b = 10;
		 * String s1 = Integer.toString(b); textbox3.sendKeys(s1); Thread.sleep(2000);
		 * WebElement button = driver.findElement(By.id("button-two")); button.click();
		 * Thread.sleep(2000); WebElement getValue =
		 * driver.findElement(By.id("message-two")); String appvalue =
		 * getValue.getText(); int sum = 20; String s2 = Integer.toString(sum);
		 */
		HomePage objHome = new HomePage(driver);
		objHome.additionVerification();
		Thread.sleep(2000);
		String appvalue=objHome.returnNumValue();
		Thread.sleep(2000);
		if (appvalue.contains("20")) {
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
