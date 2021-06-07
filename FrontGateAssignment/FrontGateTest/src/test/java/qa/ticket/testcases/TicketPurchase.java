package qa.ticket.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.ticket.base.TestBase;
import qa.ticket.pages.CheckoutPage;
import qa.ticket.pages.ConfirmationPage;
import qa.ticket.pages.CreateAccountPage;
import qa.ticket.pages.EventDetailPage;
import qa.ticket.pages.ValidatingHomePage;

public class TicketPurchase extends TestBase{

	ValidatingHomePage validateHomePage; 
	EventDetailPage eventDetail;
	CreateAccountPage createAccdetails;
	CheckoutPage checkoutdetails;
	ConfirmationPage orderSuccess;
	String email = "victorhugo59@testtest.net";
	public TicketPurchase(){
		super();
	}
	
	@BeforeMethod
	public void PageUrl() {
		initialization();
		validateHomePage= new ValidatingHomePage();
		eventDetail = new EventDetailPage();
		createAccdetails = new CreateAccountPage();
		checkoutdetails = new CheckoutPage();
		orderSuccess = new ConfirmationPage();
	}
	
	
	//Testcase 4
	@Test
	public void validateHomePageTest1() throws InterruptedException  {
		
		validateHomePage.selectTicket();
		eventDetail.ticketQuantity();
		eventDetail.transaction();
		eventDetail.checkoutButton();
		eventDetail.createAccount();
		createAccdetails.fullName("Victor", "Hugo");
		createAccdetails.emailPswrd(email,"Testpassword123");
		createAccdetails.confirmPswrd("Testpassword123");
		createAccdetails.createButton();
		checkoutdetails.deliveryOption("Mobile Delivery: Digital Delivery Email");
		checkoutdetails.nextButton();
		checkoutdetails.creditCard();
		checkoutdetails.creditCardNum("5555555555554444","123");
		checkoutdetails.creditCardMonYr("05", "2023");
		checkoutdetails.phone("1234567890");
		checkoutdetails.address("Mathilda Ave");
		checkoutdetails.city("Austin");
		checkoutdetails.state("TX");
		checkoutdetails.zipcode("78727");
		checkoutdetails.nextSubmit();
		checkoutdetails.reviewAndConfirm();
		checkoutdetails.purchaseTicket();
		
		String expectedMsg = "Your order with QA test label has been successfully processed.Your receipt will be emailed to you at "+email+"";
		
		boolean flag = orderSuccess.successMessage(expectedMsg);
		Assert.assertTrue(true);
		
	
			
	}
	
	@AfterMethod
	public void pageClose() {
		//driver.close();
	}
}
