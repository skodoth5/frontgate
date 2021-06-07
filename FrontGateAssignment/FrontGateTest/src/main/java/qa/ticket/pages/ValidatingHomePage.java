package qa.ticket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.ticket.base.TestBase;



public class ValidatingHomePage extends TestBase{
	
	//Page Objects
	//
   // edc test event
    
	
	//@FindBy(xpath="//a[contains(text(),'edc test event')]")
	//WebElement eventName;
	

	
	//@FindBy(xpath="//*[@class='location' and contains(text(),'South Austin Recreation Centah')]//parent::ul//parent::div//a[contains(text(),'edc test event')]")
	//WebElement eventVenue;
	
	@FindBy(xpath="//a[@href='https://qatest.frontgatetickets.com/event/oszl4fmtntm3kjyk' and contains(text(),'Select Tickets')]")
	WebElement selectTicketButton;
	
	//Initialize PageObject
	public ValidatingHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateEvent(String eventName)
	{
		WebElement eventName1 = driver.findElement(By.xpath("//a[contains(text(),'"+eventName+"')]"));		
		return eventName1.isDisplayed();
	}

	public boolean validateEventLocation(String location,String eventName)
	{
		WebElement eventVenue = driver.findElement(By.xpath("//*[@class='location' and contains(text(),'"+location+"')]//parent::ul//parent::div//a[contains(text(),'"+eventName+"')]"));
		return eventVenue.isDisplayed();
	}
	
	public EventDetailPage selectTicket()
	{
		selectTicketButton.click();
		return new EventDetailPage();
	}
	

}
