package com.qa.testcases.superadmin;

import java.io.File;
import java.time.Duration;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Dashboard_SuperAdmin;
import com.qa.pages.LoginPage;

    public class SuperLoginPageTest extends TestBase {
	LoginPage loginsuper;
	Dashboard_SuperAdmin dashsuper;
	
	
	public SuperLoginPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		inititalisation();
		loginsuper = new LoginPage();
	}
	
	
	
	@Test(priority=0)
	public void loginPageTitleTest() {
		String title = loginsuper.validateloginpagetitle();
	    Assert.assertEquals(title, "Login");
	}
	
	
	
	@Test(priority=1)
	public void Kyubilogotest() {
	     Boolean flag = loginsuper.validatelogo();
	     Assert.assertTrue(flag);
	}
	
	
	
	@Test(priority=3)
	public void loginTestSA() throws IOException, InterruptedException {
		dashsuper = loginsuper.Login_SA(prop.getProperty("superusr"), prop.getProperty("superpwd"));
		Thread.sleep(10000);
		loginsuper.TakeScreenshot();
	}
	
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		System.out.println("Test completed");
		Thread.sleep(10);
		driver.close();
	}
	
	
}
