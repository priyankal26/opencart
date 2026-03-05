package utilities;

import java.time.Duration;
import java.util.logging.LogManager;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger.LogManager;

public class BaseClass {

	
//common methods ssetup, teardown and common code writing 1 class
public WebDriver driver;

public Logger logger;//log4j
	
	@BeforeClass
	public void setup()
	{
		logger=LogManager.getLogger(this.getClass())
		
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		
		String generatedString=RandomStringUtils.randomAlphabetic(9);
		return generatedString;
	}
	
	public String randomNumber()
	{
		
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumeri()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		String generatedNumber=RandomStringUtils.randomNumeric(3);
		return generatedString+"@"+generatedNumber;
	}
}
