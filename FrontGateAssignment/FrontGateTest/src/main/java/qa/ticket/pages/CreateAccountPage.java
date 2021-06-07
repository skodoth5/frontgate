package qa.ticket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.ticket.base.TestBase;

public class CreateAccountPage extends TestBase{
	@FindBy(xpath="//*[@id='cart_tickets_form']/div[1]/div[1]/div/div[4]/div[1]/button[2]")
	WebElement firstName;

	@FindBy(xpath="//*[@id='btn-add-cart']")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id='btn-cart-success']")
	WebElement checkoutButton;
	
	@FindBy(xpath="//*[@class='ladda-label' and text()='Create an Account']")
	WebElement createAcc;
	
	public CreateAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void fullName(String fname,String lastnme)
	{
		driver.findElement(By.id("create_firstName")).sendKeys(fname);
		driver.findElement(By.id("create_lastName")).sendKeys(lastnme);
		
	}
	
	public void emailPswrd(String email,String password)
	{
		driver.findElement(By.id("create_email")).sendKeys(email);
		driver.findElement(By.id("create_new_password")).sendKeys(password);
		
	}
	public void confirmPswrd(String confemail)
	{
		driver.findElement(By.id("create_confirm_password")).sendKeys(confemail);
	
	}
	public CheckoutPage createButton()
	{
		driver.findElement(By.id("btn-user-create")).click();
		return new CheckoutPage();
	}
	
	

}
