package pageObjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[@id='collapsibleNavbar']/ul/li[2]/a")
	public WebElement inputform;
	
	@FindBy(id="single-input-field")
	public WebElement textbox;
	
	@FindBy(id="button-one")
	public WebElement button;
	
	@FindBy(id="message-one")
	public WebElement getvalue;
	
	@FindBy(id="value-a")
	public WebElement textbox2;
	
	@FindBy(id="value-b")
	public WebElement textbox3;
	
	@FindBy(id="button-two")
	public WebElement button2;
	
	@FindBy(id="message-two")
	public WebElement getvalue2;
	
	public void messageVerification() {
		inputform.click();
		textbox.sendKeys("Hello");
		button.click();		
	}
	
	public String returnTextValue() {
		return getvalue.getText();
	}
	
	public void additionVerification() {
		textbox2.sendKeys("10");
		textbox3.sendKeys("10");
		button2.click();	
	}
	
	public String returnNumValue()
	{
		return getvalue2.getText();
	}
}
