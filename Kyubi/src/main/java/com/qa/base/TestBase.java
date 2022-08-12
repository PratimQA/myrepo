package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		
		try { 
			prop = new Properties();
		    FileInputStream ip = new FileInputStream("C:\\Users\\Pratim\\eclipse-workspace\\Kyubi\\src\\main\\java\\com\\qa\\config\\config.properties");
		    prop.load(ip);
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}


   public void inititalisation() {
	   String browsername = prop.getProperty("browser");
	   
	   if(browsername.equals("chrome")) {
		   System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		   driver = new ChromeDriver();	   
	   }
	   else if(browsername.equals("firefox")){
		   System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\geckodriver.exe");
		   driver = new FirefoxDriver();	
	   }
   
   
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
      
      driver.get(prop.getProperty("url"));
      
   
   }

}
