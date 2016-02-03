package Generic_component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base_Class {
	
	protected WebDriver browser;
	Utility_Class c1= new Utility_Class();
	static Logger log=Logger.getLogger(Base_Class.class);
	
	
	public void initBrowsersession1() throws IOException
	{
		String browsertype = c1.Reading_Properties("btype");
		if(browsertype.equals("ff"))
		{
		       browser= new FirefoxDriver();
		       //browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		       log.info("Intialized the browser in Firefox");
		}
		
		else if(browsertype.equals("ch"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Browser_exe_files\\chromedriver.exe");
			browser= new ChromeDriver();
			log.info("Intialized the browser in Chrome");
		}
		
		else if(browsertype.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Browser_exe_files\\IEDriverServer1.exe");
			browser= new InternetExplorerDriver();
			log.info("Intialized the browser in IE");
			
		}
		
		
		browser.manage().deleteAllCookies();
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		browser.get(c1.Reading_Properties("URL"));
				
		
	}
	
	
	public void tearDown()
	{
		browser.quit();
		log.info("Closed the Browser");
		
	}

}