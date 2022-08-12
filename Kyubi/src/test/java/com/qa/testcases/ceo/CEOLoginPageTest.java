package com.qa.testcases.ceo;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Dashboard_CEO;
import com.qa.pages.LoginPage;

public class CEOLoginPageTest extends TestBase{
LoginPage loginceo;
Dashboard_CEO ceosuper;


    public CEOLoginPageTest() {
      super();
    }


     @BeforeMethod
     public void setUp() {
     inititalisation();
     loginceo = new LoginPage();
     }



      @Test(priority=0)
      public void loginPageTitleTest() {
      String title = loginceo.validateloginpagetitle();
      Assert.assertEquals(title, "Login");
      }



      @Test(priority=1)
      public void logintestCEO() throws IOException, InterruptedException {
      loginceo.Login_CEO(prop.getProperty("ceousr"), prop.getProperty("ceopwd"));
      Thread.sleep(10000);
	  loginceo.TakeScreenshot();
      }



      @Test(priority=2)
      public void kyubilogotest() {
      Boolean b = loginceo.validatelogo();
      if (b=true)
      {
        System.out.println("Logo exists");
      }
      else
        System.out.println("Logo does not exists");
      }



      @AfterMethod
      public void teardown() {
       System.out.println("Test completed");
       //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
       //driver.close();
      }

} 