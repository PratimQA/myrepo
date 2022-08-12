package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;


public class Dashboard_SuperAdmin extends TestBase{

	@FindBy(xpath="//a[normalize-space()='API Settings']")
	WebElement apisettings;
	
	@FindBy(xpath="//a[@title='Create CEO']")
	WebElement create_ceo;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement CEO_FirstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement CEO_LastName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement CEO_email;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement CEO_phone;
	
	@FindBy(xpath="//div[@class='col col-6']//div[@class='form-row']//div//div[@class='react-switch-bg']")
	WebElement CEO_extnbal_unli_on;
	
	@FindBy(xpath="//div[@class='col-6']//div[@class='form-row']//div//div[@class='switchAuthentication checked react-switch']//div[@class='react-switch-handle']")
	WebElement CEO_partbal_unli_on;
	
	@FindBy(xpath="//div[@class='switchAuthentication react-switch']//div[@class='react-switch-bg']")
	WebElement CEO_endusrbal_unli_on;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement CEO_add;
	
	
	//Initializing the page objects
	public Dashboard_SuperAdmin(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifydashboard_SAtitle(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title = driver.getTitle();
		System.out.println("The title is "+title);
		return title;
		}
	
	
	public void addCEO(String firstname, String lastname, String ceoemail, String phone) throws InterruptedException{	
		create_ceo.click();
		Thread.sleep(20000);
		CEO_FirstName.sendKeys(firstname);
		CEO_LastName.sendKeys(lastname);
		CEO_email.sendKeys(ceoemail);
		CEO_phone.sendKeys(phone);
		CEO_add.click();
		}
	
	
	public void APISettings(){
		apisettings.click();
		}
	
	
}

