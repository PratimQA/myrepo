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

  public class SuperDashboardPageTest extends TestBase{
      LoginPage LoginPage;
      Dashboard_SuperAdmin DashboardPage;
      
      
      public SuperDashboardPageTest() {
           super();
      }	
	
      
      
      @BeforeMethod
  	  public void setUp() throws InterruptedException {
  	    inititalisation();
  		LoginPage = new LoginPage();
  		DashboardPage = LoginPage.Login_SA(prop.getProperty("superusr"), prop.getProperty("superpwd"));
  	  }
      
      
      
      @Test(priority=0)
      public void dash_title() {
    	  DashboardPage.verifydashboard_SAtitle();
      }
      
      
      
      
      @Test(priority=1)
      public void create_ceo() throws InterruptedException {
    	  DashboardPage.addCEO("david989", "parkson", "david989@gmail.com", "1234567890");
      }
      
      
      
      @Test(priority=2)
      public void Test_APISettings() {
    	  DashboardPage.APISettings();
      }
      
      
      
      @AfterMethod
  	  public void teardown() throws InterruptedException {
  		System.out.println("Test completed");
  		//Thread.sleep(10);
  		//driver.close();
  	}
      
      
      
      
      
}
