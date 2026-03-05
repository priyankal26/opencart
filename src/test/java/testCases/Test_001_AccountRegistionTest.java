package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;
import pageObjects.AccountRegistrationPage;
import pageObjects.BasePage;
import pageObjects.HomePage;
import utilities.BaseClass;

public class Test_001_AccountRegistionTest extends BaseClass {
	
	
	
	@Test
	public void verify_account_registration() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage ap=new AccountRegistrationPage(driver);
		ap.setFirstName(randomString().toUpperCase());
		Thread.sleep(3000);
		ap.setLastName(randomString().toUpperCase());
		Thread.sleep(3000);
		ap.setEmail(randomString()+"@gmail.com");
		Thread.sleep(3000);
		ap.setTelephone(randomNumber());
		Thread.sleep(3000);
		String password=randomAlphaNumeri();
		ap.setPassword(password);
		Thread.sleep(3000);
		ap.setConfirmPassword(password);
		Thread.sleep(3000);
		ap.setPrivacyPolicy();
		Thread.sleep(3000);
		ap.clickContinue();
		
		//validation
		String confirmMsg=ap.getConfirmationMsg();
		
		
		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
			
	
}
	
	
}

