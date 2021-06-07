package qa.ticket.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import q.ticket.util.TestUtil;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/qa/ticket/config/config.properties");
		prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		public static void initialization()
		{
			String browserName = prop.getProperty("browser");
			String url = prop.getProperty("url");
			System.out.println("Browser name --"+browserName);
			System.out.println("URL  --"+url);
		
		if(browserName.equals("chrome"))
		{
			System.out.println("*****Fetching chromedriver**********");
			System.setProperty("webdriver.chrome.driver",prop.getProperty("driver_path")+ "/chromedriver");
		    driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//test URL
		driver.get(url);
	}
	
	

}

