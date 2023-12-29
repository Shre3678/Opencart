package testCases;

import java.awt.AWTException;
import java.awt.Robot;

import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.Base;

public class TC_001_AccountRegistrationTest extends Base
{

@Test(groups= {"Regression","Master"}) 
public void Account_Reg() throws AWTException, InterruptedException
{
	logger.info("Application logs....");
	HomePage HP= new HomePage(driver);
	HP.Myacc();
	HP.Reg();
	RegistrationPage RP= new RegistrationPage(driver);
	//RP.FN("A"+randomString().toUpperCase());
	RP.FN(rb.getString("FN1"));
	RP.LN("B"+randomString().toUpperCase());
		
	RP.E_M(randomAlphaNume()+"@gmail.com");
	
	RP.Pass("$" + randomAlphaNume() + "$");
	RP.NL();
	Robot for_Scrolldown= new Robot();
	for_Scrolldown.mouseWheel(2000);
	Thread.sleep(5000);
	RP.CB();
	RP.Con();
}
	
}
