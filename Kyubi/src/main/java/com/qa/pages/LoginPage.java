package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	    
     //PageFactory--OR
     @FindBy(name="email")
     WebElement email;
		
     @FindBy(name="password")
     WebElement password;
		
     @FindBy(xpath="//button[normalize-space()='Login']")
     WebElement loginBtn;
		
     @FindBy(xpath="//a[@class='logo']//*[name()='svg']")
     WebElement kyubilogo;
		
		
		
    //Initializing the Page Objects
    public LoginPage() {
    PageFactory.initElements(driver, this);
    }	


    //Actions
    public String validateloginpagetitle() {
    return driver.getTitle();
    }


    public boolean validatelogo() {
    return kyubilogo.isDisplayed();
    }


    public Dashboard_SuperAdmin Login_SA(String superuser, String superpassword) throws InterruptedException {
    email.sendKeys(superuser);
    password.sendKeys(superpassword);
    loginBtn.click();
    Thread.sleep(10000);
    return new Dashboard_SuperAdmin();
    }


    public Dashboard_CEO Login_CEO(String ceousr, String ceopwd) {
    email.sendKeys(ceousr);
    password.sendKeys(ceopwd);
    loginBtn.click();
    return new Dashboard_CEO();
    }
    
    
    
    public Dashboard_Partner Login_Partner(String partusr, String partpwd) {
    email.sendKeys(partusr);
    password.sendKeys(partpwd);
    loginBtn.click();
    return new Dashboard_Partner();
    }

    
    public void TakeScreenshot() throws IOException {
    	File screenfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Code for pasting screenshot to a user-specified location
		FileUtils.copyFile(screenfile, new File("D:\\Documents\\Kyubi\\Scr.jpg"));
		
    }
    
}
