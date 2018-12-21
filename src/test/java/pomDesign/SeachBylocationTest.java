package pomDesign;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Pages.FindAnAgentPage;
import Pages.SearchByLocationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

		
public class SeachBylocationTest {

	final String file ="/Users/sofanabenoutiq/Desktop/TravelersIns_QA/TravelsIns-QA/src/test/resources/config.properties";
	 Xls_Reader xl = new Xls_Reader("/Users/sofanabenoutiq/Desktop/TravelersIns_QA/TravelsIns-QA/src/test/resources/TestTableResult.xlsx");
	WebDriver driver=null;
	  Properties prop;
	  SearchByLocationPage SearchByLocationPage;
	  WebDriverWait wait = null;
	  
	
	
	
	@BeforeMethod
	@BeforeTest
	  public void setUp() throws IOException {
	    
	    prop = new Properties();
	    FileInputStream ip = new FileInputStream(file);
	    prop.load(ip);
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(prop.getProperty("url"));
	  
	  }
	  
	  @AfterTest
	  public void closeBrowser(){
		  driver.quit();
	  }
	  
	  
	  @Test 
	  public void SearchByLocation() throws InterruptedException {
		
		  SearchByLocationPage SearchLocation = new SearchByLocationPage(driver);
		  
		  driver.findElement(By.id("find-agent-link")).click();
		  
		  Set<String> winIds=driver.getWindowHandles();
	        
	      Iterator<String> it =winIds.iterator();
	        
	        String mainWindow = it.next();
	        String firstWindow=it.next();
	        
	      //1st Scenario 
	      driver.switchTo().window(firstWindow);
	      Thread.sleep(50000);
		  SearchLocation.ZipCode.sendKeys("22303");
		  SearchLocation.City.sendKeys("Alexandria");
		  Select State = new Select (driver.findElement(By.id("state")));
		  State.selectByIndex(5);
		  SearchLocation.StreetAddress.sendKeys("555 Street name");
		  WebElement dropdown = driver.findElement(By.id("insurance_type"));
		  Select optin2 = new Select (dropdown);
		  optin2.selectByIndex(3);
		  
		  WebElement dropdown2 = (driver.findElement(By.id("lob")));
		  Select optin0 = new Select (dropdown2);
		  optin0.selectByIndex(2);
		  SearchLocation.SearchButton.click();
		  
		  //Handling cookies
		  Set <Cookie> ck = driver.manage().getCookies();
		  for(Cookie cookie : ck) {
			  System.out.println(cookie.getName() + "|" +cookie.getValue());
		  }
		  driver.manage().deleteAllCookies();
		  
		  //2nd Scenario 
		  
		  
		  SearchLocation.ZipCode.clear();
		  SearchLocation.ZipCode.sendKeys("20910");
		  SearchLocation.StreetAddress.clear();
		  SearchLocation.StreetAddress.sendKeys("1900 Lytonsville rd");
		  WebElement dropdown3 = driver.findElement(By.id("insurance_type"));
		  Select optin3 = new Select (dropdown3);
		  optin3.selectByIndex(2);
		  WebElement dropdown4 = (driver.findElement(By.id("lob")));
		  Select optin1 = new Select (dropdown4);
		  optin1.selectByIndex(3);
		  SearchLocation.SearchButton.click();
		  
		  
		//3rd Scenario
		  SearchLocation.ZipCode.clear();
		  SearchLocation.ZipCode.sendKeys("20910");
		  SearchLocation.StreetAddress.clear();
		  SearchLocation.StreetAddress.sendKeys("1900 Lytonsville rd");
		  WebElement dropdown5 = driver.findElement(By.id("insurance_type"));
		  Select optin4 = new Select (dropdown5);
		  optin4.selectByIndex(3);
		  WebElement dropdown6 = (driver.findElement(By.id("lob")));
		  Select optin5 = new Select (dropdown6);
		  optin5.selectByIndex(4);
		  SearchLocation.SearchButton.click();
		  
		 
		  driver.switchTo().window(mainWindow);

//		  int rowcount= xl.getRowCount("data");
//		  
//		  for(int i =2 ;i<=rowcount ; i++) {
//			  
//			  List<WebElement> Result = driver.findElements(By.cssSelector(".cell_1.do_not_show_baseball_card"));
//			  
//			  Result.addAll(i, xl.setCellData("data", "Agencies", i));
//			
//		      }
		  }
	  }
	  


