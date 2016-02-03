package Pageobject_currency;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_edit {
	
	WebDriver browser;
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
//click on edit curr
@FindBy(xpath="//*[@id='CurrencyTableContainer']/div/table/tbody/tr[1]/td[5]/a/div")
WebElement clk_edit_curr;

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

//with different curr name edit succesfull 
	@FindBy(xpath="//*[@id='CurrencyTableContainer']/div/table/tbody/tr[1]/td[2]")
	WebElement msg_Valid_edit;
	
	
	public PageObject_edit(WebDriver Dbrowser)
	{
		this.browser=Dbrowser;
		PageFactory.initElements(browser, this);
	}
	
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
	
//////////////////////////////////////////////////////////////////		
		
	public void clk_edit_curr()
	{
		clk_edit_curr.click();
	}
//////////////////////////////////////////////////////////////////

	public void entercurrname(String value)
	{
		enter_curr.clear();
		enter_curr.sendKeys(value);
	}
	
	//click save button
		public void click_save()
		{
			click_save_curr.click();
			browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
		public String getValidedit()
		{
			return msg_Valid_edit.getText();
		}
		
		
	public String getInvalidcurrResult_blnk()
	{
		return msg_Invalid_result_blank.getText();
	}
	
	
		public String getInvalidedit()
		{
			return msg_Invalid_result.getText();
		}
		
    
		
		public void Commonprocess_edit(String UN,String PW,String curr_name)
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
			clk_edit_curr();
			entercurrname(curr_name);
			click_save();	
			
		}

}