package com.qa.testcases.partner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Dashboard_Partner;
import com.qa.pages.LoginPage;

public class PartnerLoginPageTest extends TestBase {
LoginPage loginpartner;
Dashboard_Partner daspartner;

      public PartnerLoginPageTest() {
    	  super();
      }

      
      @BeforeMethod
      public void setUp() {
      inititalisation();
      loginpartner = new LoginPage();
      }



       @Test(priority=0)
       public void loginPageTitleTest() {
       String title = loginpartner.validateloginpagetitle();
       Assert.assertEquals(title, "Login");
       }



       @Test(priority=1)
       public void logintestCEO() throws IOException, InterruptedException {
       loginpartner.Login_CEO(prop.getProperty("ceousr"), prop.getProperty("ceopwd"));
       Thread.sleep(10000);
       loginpartner.TakeScreenshot();
       }



       @Test(priority=2)
       public void kyubilogotest() {
       Boolean b = loginpartner.validatelogo();
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
