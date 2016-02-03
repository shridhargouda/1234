package Pageobject_currency;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_curr {
	
	
	public WebDriver browser;
	
	//*************************************************
	//Strorage for Elements
	///////////////for login///////////////////////
	@FindBy(xpath="//input[@id='username']")
	 WebElement UNtext;
    
    @FindBy(xpath="//input[@id='password']")
    WebElement PassTf;
	////////////////////////////////////////////////
    
    /////////// Control panel and Masters //////////
    @FindBy(xpath="//span[text()='Control Panel']")
    WebElement controlbutt;
	
	@FindBy(xpath="//li[@id='Masters']")
	 WebElement MastButt;
	
	//currency click
    @FindBy(xpath="//span[text()=' Currency']")
    WebElement clk_curr;
	////////////////////////////////////////////////
    
    //create currency click
    @FindBy(xpath="//span[text()='Create Currency']")
    WebElement create_curr;
  
    //enter currrency name
    @FindBy(xpath="//input[@id='CurrencyType']")
     WebElement enter_curr;
    
    //click save currency
    @FindBy(xpath="//button[@id='LoadRecordsButton']")
    WebElement click_save_curr;
    
    //blank currency message
	@FindBy(xpath="//label[@class='error']")
	WebElement msg_Invalid_result_blank;
	
	//same curr name error msg
	@FindBy(xpath="//label[@class='error']")
	WebElement msg_Invalid_result;
	
	
	
	
	@FindBy(xpath="//*[@id='CurrencyTableContainer']/div/table/tbody/tr[1]/td[2]")
	WebElement msg_Valid_result;
	//html body div#wrap div#header.topborder.relative div.floatR.extra_gap div.floatL div span#username.bold a.proper
	
	//***************************************
	
	//Action on those Elements through different methods
	
	//constructor to initialize browser
	
	public PageObject_curr(WebDriver Dbrowser)
	{
		this.browser=Dbrowser;
		PageFactory.initElements(browser, this);
				
	}
	
	//methods for different actions
	/// method to click CP
	public void Click_CP()
	{
		controlbutt.click();
		
	}
	
	// method to click Masters
	public void Click_Masters()
	{
		MastButt.click();
		
	}
	
	// method to click Currency
	public void click_curr()
	{
		clk_curr.click();
		
	}
	
	//click on create currency
	public void create_curr()
	{
		create_curr.click();
	}
	//enter curr name from Excel sheet
	public void entercurrname(String value)
	{
		enter_curr.sendKeys(value);
	}
	
	//click save button
	public void click_save()
	{
		click_save_curr.click();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//method for blank currency name
	public String Invalid_curr_test_blnk()
	{
		return msg_Invalid_result_blank.getText();
	}

	
	//method for error text with same currency name
		public String getInvalidcurrResult()
		{
			return msg_Invalid_result.getText();
		}
	
	//method new curr name entered
	public String getvalidcurrResult()
	{
		return msg_Valid_result.getText();
	   
	}
	 
	
	//**********************************************************************************
	
	//Common process component
	
	public void Commonprocesscurr(String UN,String PW,String curr_name)
	{
		UNtext.clear();
        UNtext.sendKeys(UN);
        PassTf.clear();
        PassTf.sendKeys(PW, Keys.ENTER);
		Click_CP();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Click_Masters();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click_curr();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		create_curr();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		entercurrname(curr_name);
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click_save();
	}
}
