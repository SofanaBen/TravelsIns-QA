package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class SearchByLocationPage {

	public SearchByLocationPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	
	  }
	
	
	@FindBy(id="zip")
	public WebElement ZipCode;
	
	
	@FindBy(id="city")
	public WebElement City;
	
	
	@FindBy(css=".textbox.address")
	public WebElement StreetAddress;

	
	@FindBy(id="address")
	public WebElement Address;

	
	@FindBy(id="search_button")
	public WebElement SearchButton;
	
	
}
