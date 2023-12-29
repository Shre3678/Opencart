package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base 
{
public WebDriver driver;
public Logger logger;
public ResourceBundle rb;

@BeforeClass(groups = { "Master", "Sanity", "Regression" })
@Parameters("browser")
public void setup(String brow)
{
	
	logger= LogManager.getLogger(this.getClass()); //logger setup
	rb=ResourceBundle.getBundle("config"); // for content
	
    if(brow.equals("Chrome"))
    {
	    driver=new ChromeDriver();
    }
    else if(brow.equals("Edge"))
    {
    	driver=new EdgeDriver();
    }
    else if(brow.equals("Firefox"))
    {
    	driver=new FirefoxDriver();
    }
    else
    {
    	driver=new ChromeDriver();
    }
    	
	driver.get(rb.getString("appURL"));// its from the config file
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
}


@AfterClass(groups = { "Master", "Sanity", "Regression" })
public void teardown() throws InterruptedException
{
	//Thread.sleep(2000);
	driver.quit();
}
public String randomString()
{
	String alphas=RandomStringUtils.randomAlphabetic(5);
	return alphas;
}
public String randomNumeric()
{
	String num= RandomStringUtils.randomNumeric(5);
	return num;
}

public String randomAlphaNume()
{
	String alphas=RandomStringUtils.randomAlphabetic(5);
	String num= RandomStringUtils.randomNumeric(5);
	return alphas+num;
}

public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

	try {
		FileUtils.copyFile(source, new File(destination));
	} catch (Exception e) {
		e.getMessage();
	}
	return destination;


}

}
