package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage
{
   public WebDriver driver;
	public RegistrationPage(WebDriver driver) 
	{
		super(driver);
    }
	
	//Elements
	@FindBy(xpath="//input[@id=\"input-firstname\"]")
	WebElement FirstName;
	@FindBy(xpath="//input[@id=\"input-lastname\"]")
	WebElement LastName;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement E_Mail;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	@FindBy(id="input-newsletter-no")
	WebElement News_letter;
	@FindBy(xpath="(//input[@name='agree'])[1]")
	WebElement checkbox;
	@FindBy(xpath="//button[@type='submit']")
	WebElement Continue;
	
	//Action Method
	public void FN(String Fname)
	{
		FirstName.sendKeys(Fname);
	}
	public void LN(String Lname)
	{
		LastName.sendKeys(Lname);
	}
	public void E_M(String Email)
	{
		E_Mail.sendKeys(Email);
	}
	public void Pass(String password)
	{
		Password.sendKeys(password);
	}
	public void NL()
	{
		FirstName.click();
	}
	public void CB()
	{
		checkbox.click();
	}
	public void Con()
	{
	Continue.click();
	}
	
}
