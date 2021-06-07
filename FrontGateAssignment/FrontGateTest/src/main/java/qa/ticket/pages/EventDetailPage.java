package qa.ticket.pages;
/*select 'Select Tickets' for 'edc test event' 
add to cart quantity 1 of Ticket 'GA pass GA'
select 'add to cart'
proceed to checkout
create a new account using email '<someuniquestring>@testtest.net'
fill out all the required checkout information 
On Payment Information, select Credit Card (see note above about test card) 
Decline Secure Ticket
Complete the purchase*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.ticket.base.TestBase;



public class EventDetailPage extends TestBase{
	
	String ticketname;
	
	
	@FindBy(xpath="//*[@id='cart_tickets_form']/div[1]/div[1]/div/div[4]/div[1]/button[2]")
	WebElement ticketQty;

	@FindBy(xpath="//*[@id='btn-add-cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//*[@id='btn-cart-success']")
	WebElement checkoutButtn;
	
	//@FindBy(xpath="//*[contains(text(),'SOLD OUT')]")
	//WebElement ticketstate;
	
	@FindBy(xpath="//*[@class='ladda-label' and text()='Create an Account']")
	WebElement createAcc;
	
	
public EventDetailPage()
{
	PageFactory.initElements(driver, this);
}

public String soldOut() throws InterruptedException
{
	
	List<WebElement> ticket = driver.findElements(By.xpath("//*[@class='col-sm-6 text-left xtix-select']"));
	List<WebElement> ticketstate = driver.findElements(By.xpath("//*[contains(text(),'SOLD OUT')]"));
	
	System.out.println("Number of elements:" +ticketstate.size());
	System.out.println("Number of ticket:" +ticket.size());
for(int i=0;i<ticketstate.size();i++)
{
	System.out.println("Value of i-----"+i);
	if(ticketstate.get(i).getText().contains("SOLD OUT"))
	{
		ticketname = ticket.get(i).getText().toString();
		System.out.println("NAME-------"+ticket.get(i).getText());
	}

	
}
return ticketname;
}

public void ticketQuantity()
{
	ticketQty.click();
}
public CreateAccountPage transaction()
{
	addToCart.click();	
	return new CreateAccountPage();
}
public void checkoutButton()
{
	checkoutButtn.click();
}
public CreateAccountPage createAccount()
{
	createAcc.click();
	return new CreateAccountPage();
}

}
