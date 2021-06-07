package qa.ticket.testcases;

import org.testng.annotations.Test;

import qa.ticket.base.TestBase;
import qa.ticket.pages.EventDetailPage;
import qa.ticket.pages.ValidatingHomePage;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class HomePageVerify extends TestBase {

	ValidatingHomePage validateHomePage; 
	EventDetailPage eventDetail;
	String eventName = "edc test event";
	//Location for the eventName exactly as in the html to validate
	String eventLocation = "\n"
			+ "                                                                                            at South Austin Recreation Centah\n"
			+ "                                                                                                                                        (Park)\n"
			+ "                                                                                    ";
	public HomePageVerify(){
		super();
	}
	
	@BeforeMethod
	public void PageUrl() {
		initialization();
		validateHomePage= new ValidatingHomePage();
		eventDetail = new EventDetailPage();
	}
	//Testcase 1 
	@Test
	public void validateHomePageTest1() {
		boolean flag = validateHomePage.validateEvent(eventName);
		Assert.assertTrue(flag);
			
	}
	//Testcase 2
	@Test(enabled=true)
	public void validateHomePageTest2() {
		boolean flag = validateHomePage.validateEventLocation(eventLocation,eventName);
		Assert.assertTrue(flag);
			
	}
	//Testcase 3
	@Test
	public void verifySoldOutTkt() throws InterruptedException {
		validateHomePage.selectTicket();
		eventDetail.soldOut();
	}
	@AfterMethod
	public void pageClose() {
		//driver.close();
	}
}
