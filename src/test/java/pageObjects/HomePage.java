package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

//Elements
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a/span")
	WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()=\"Register\"]")
	WebElement lnkReg;
	@FindBy(linkText = "Login")   
	WebElement linkLogin;
	
//Action Methods	

	public void Myacc()
	{
		lnkMyaccount.click();
	}

	public void Reg()
	{
		lnkReg.click();
	}
	public void clickLogin()   
	{
		linkLogin.click();
	}
	
}
