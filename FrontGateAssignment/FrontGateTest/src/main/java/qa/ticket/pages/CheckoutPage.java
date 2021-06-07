package qa.ticket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.ticket.base.TestBase;

public class CheckoutPage extends TestBase{
	
	@FindBy(name="shippingId[]")
	WebElement shippingOption;
	
	@FindBy(id="btn-shipping-submit")
	WebElement next;
	
	//@FindBy(xpath="//*[@id='confirm_agree_terms']")
	//WebElement checkbox;
	
	
	//@FindBy(xpath="//button[@id='creditCardPmButton' and contains(text(),'Credit Card')]")
	//WebElement creditCard;
	
	@FindBy(id="btn-billing-submit")
	WebElement nextSubmit;
	
	@FindBy(id="billing_select_state")
	WebElement selState;
	
	@FindBy(xpath="//button[@id='purchase_tickets']")
	WebElement purchaseTickts;
	
	
	public CheckoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void deliveryOption(String option)
	{
		Select s1 = new Select(shippingOption);
		//s1.selectByValue(option);
		s1.selectByVisibleText(option);
		
	}
	public void nextButton()
	{
		next.click();
	}
	public void creditCard()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("creditCardPmButton")));
		
		element.click();
	}
	public void creditCardNum(String num,String cvv) 
	{
			
		driver.switchTo().frame("braintree-hosted-field-number");
		driver.findElement(By.id("credit-card-number")).sendKeys(num);
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("braintree-hosted-field-cvv");
		driver.findElement(By.id("cvv")).sendKeys(cvv);
		driver.switchTo().parentFrame();
	}
	public void creditCardMonYr(String month,String year)
	{
		driver.switchTo().frame("braintree-hosted-field-expirationMonth");
		driver.findElement(By.id("expiration-month")).sendKeys(month);
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("braintree-hosted-field-expirationYear");
		driver.findElement(By.id("expiration-year")).sendKeys(year);
		driver.switchTo().parentFrame();
	}
	public void phone(String phnumber)
	{
		driver.findElement(By.id("billing_phone")).sendKeys(phnumber);
	}
	public void address(String address)
	{
		driver.findElement(By.id("billing_address")).sendKeys(address);
	}
	public void city(String city)
	{
		driver.findElement(By.id("billing_city")).sendKeys(city);
	}
	public void zipcode(String zip)
	{
		driver.findElement(By.id("billing_zip")).sendKeys(zip);
	}
	
	public void state(String state)
	{
		Select s1 = new Select(selState);
		s1.selectByValue(state);
		
		
	}
	public void nextSubmit()
	{
		nextSubmit.click();
	}
	public void reviewAndConfirm()
	{
		System.out.println("CHeckBox");
		
		WebElement checkbox = driver.findElement(By.id("confirm_agree_terms"));
	/*	Actions action = new Actions(driver);
		action.moveToElement(checkbox);
		action.perform();*/
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",checkbox);

	}
	public ConfirmationPage purchaseTicket() throws InterruptedException
	{
		
		
		System.out.println("Purchase buttons");
		Thread.sleep(5000);
		purchaseTickts.click();
		return new ConfirmationPage();
	}
	

	
	
}
