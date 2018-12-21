package pomDesign;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.FindAnAgentPage;
import Pages.SearchByLocationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAnAgentTest {
final String file ="/Users/sofanabenoutiq/Desktop/TravelersIns_QA/TravelsIns-QA/src/test/resources/config.properties";
	
	WebDriver driver=null;
	  Properties prop;
	  FindAnAgentPage FindAnAgentPage;
	  WebDriverWait wait = null;
	  
		
		@BeforeTest
		  public void setUp() throws IOException {
		    
		    prop = new Properties();
		    FileInputStream ip = new FileInputStream(file);
		    prop.load(ip);
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		    driver.get(prop.getProperty("url"));
		  
		  }
		  
		  @AfterTest
		  public void closeBrowser(){
			  driver.quit();
		  }
		  
	
	
	  @Test 
	  public void FindAnAgentSection(){
		  
		  FindAnAgentPage SearchAgent = new FindAnAgentPage(driver);
		  
		  
		  AssertJUnit.assertEquals( SearchAgent.FindAgentHomePage.getText(),"Find an agent");
		  //For Individuals
		  SearchAgent.ForIndividuals.click();
		  wait=new WebDriverWait(driver,5);
		  wait.until(ExpectedConditions.elementToBeClickable(SearchAgent.FindAgentPreparePreventAndIndiv));
		 
		  //For Business
		  SearchAgent.ForBusiness.click();
		  wait.until(ExpectedConditions.elementToBeClickable(SearchAgent.FindAgentForBusiness));
		  Assert.assertTrue(SearchAgent.FindAgentForBusiness.isDisplayed(), "Find an agent in the For individuals Page is not displayed");
		  
		  //For Prepare and Prevent 
		  SearchAgent.PreparePrevent.click();
		  wait.until(ExpectedConditions.elementToBeClickable(SearchAgent.FindAgentPreparePreventAndIndiv));	 
		  Assert.assertTrue(SearchAgent.FindAgentForIndividuals.isDisplayed(), "Find an agent in the For individuals Page is not displayed");
		  
		  		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
