package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	public WebDriver driver;
	
	public void launchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver", 
				"E:\\Eclipse Work Space\\Selenium_Project\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions onarg = new ChromeOptions();
		onarg.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(onarg);
		driver.manage().window().maximize();	
		driver.get(url);
	}
	
	public void closeBrowser()
	{
		driver.close();
	}

}
