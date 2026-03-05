package pageObjects;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);	
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(css="#input-lastname")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement textPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement textConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);	
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		textPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		textConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		checkPolicy.click();
	}
	
	public void clickContinue()
	{
		//btnContinue.click();
		//btnContinue.submit();
		Actions act=new Actions(driver);
		act.moveToElement(btnContinue).perform();
		
		//using javasriptexecutor
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();",btnContinue );
		
		btnContinue.sendKeys(Keys.RETURN);
		
		//explicity wait
		//WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue));
		
	}
		public String getConfirmationMsg()
		{
			try {
				return (msgConfirmation.getText());
				}
			catch(Exception e)
			{
				return (e.getMessage());
			}
		}	
		
	}
	

