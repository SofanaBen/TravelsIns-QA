package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindAnAgentPage {

	public FindAnAgentPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	
	  }
	
	@FindBy(css=".logo")
	public WebElement HomeButton;
	
	@FindBy (css="#tab-quote > div.tab-white.row > div:nth-child(3) > h3")
	public WebElement FindAgentHomePage;
	
	@FindBy(css=".non-tpo")
	public WebElement FindAgentForIndividuals;
	
	@FindBy(css=".btn-findagent.btn-primary.trans-btn")
	public WebElement FindAgentForBusiness;
	
	@FindBy(css=".non-tpo")
	public WebElement FindAgentPreparePreventAndIndiv;
	
	
	@FindBy(id="main-nav-0")
	public WebElement ForIndividuals;
	
	@FindBy(id="main-nav-1")
	public WebElement ForBusiness;
	
	@FindBy (id="main-nav-3")
	public WebElement PreparePrevent;
	
	
	
}
