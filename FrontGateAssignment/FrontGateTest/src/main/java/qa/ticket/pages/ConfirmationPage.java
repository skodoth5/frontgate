package qa.ticket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.ticket.base.TestBase;

public class ConfirmationPage extends TestBase {

	
	@FindBy(className="order-confirm")
	WebElement message;
	
	public ConfirmationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean successMessage(String expected)
	{
		boolean flag;
		
		System.out.println(message.getText().toString());
		String actualMessage = message.getText().toString();
		if(actualMessage.contains(expected))
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
			return flag;
		
		
	}
}
