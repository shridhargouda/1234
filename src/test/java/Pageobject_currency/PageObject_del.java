package Pageobject_currency;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject_del {
	
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


//main delete button 
@FindBy(xpath="//*[@id='CurrencyTableContainer']/div/div[3]/div[2]/span[1]")
WebElement click_delete_main;


//blank delete error OK conifirmation
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement main_delete_OK;
	
	//blank delete error msg text
    @FindBy(xpath="html/body/ul/li/div/div[1]/span")
    WebElement blnk_delete_error;


	//first row text 
	@FindBy(xpath="//*[@id='CurrencyTableContainer']/div/table/tbody/tr/td[2]")
	WebElement first_row_text;
	
	//first check box click
		@FindBy(xpath="//*[@id='CurrencyTableContainer']/div/table/tbody/tr/td[1]/input")
		WebElement clk_first_checkbox_curr;
	
		//first checkbox delete button
		@FindBy(xpath="//button[@class='jtable-command-button jtable-delete-command-button']")
		WebElement frst_chkbox_delete;	
	
		//sub delete button OK confirmation
		@FindBy(xpath="//button[@id='DeleteDialogButton']")
		WebElement subdelete_OK;
		
public PageObject_del(WebDriver Dbrowser)
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



public String getInvalidcurrResult_blnk()
{
	click_delete_main.click();
	
	//click delete button
		WebElement element = browser.findElement(By.xpath("html/body/ul/li/div/div[2]/button"));
		WebDriverWait wait = new WebDriverWait(browser, 10); //here, wait time is 02 seconds

	//wait for delete pop_up message
		wait.until(ExpectedConditions.visibilityOf(element)); //this will wait for elememt to be visible for 02 seconds
		String text = blnk_delete_error.getText();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();

    browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	main_delete_OK.click();
	return text;
	
}

public String firstcurr_delete() throws InterruptedException
{
	String Actual_reslt = null;//=null;
	String initial_value = first_row_text.getText();
	//clk_first_checkbox_curr.click();
	frst_chkbox_delete.click();
	browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	subdelete_OK.click();
	browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	browser.navigate().refresh();
	browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    String after_del_value = first_row_text.getText();
	if(!(after_del_value.equals(initial_value)))
		Actual_reslt="Deleted";
	//Thread.sleep(3000);
	return Actual_reslt;
}




public String getValid_mul_del()
{
	String Actual_reslt = null;
	String initial_value = first_row_text.getText();
	//clk_first_checkbox_curr.click();
	//frst_chkbox_delete.click();
	//browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	for(int j=1;j<=2;j++)
	{	
		browser.findElement(By.xpath("//*[@id='CurrencyTableContainer']/div/table/tbody/tr["+j+"]/td[1]")).click();
		//browser.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	}
	
	click_delete_main.click();
	browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	main_delete_OK.click();
	browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	browser.navigate().refresh();
	browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 String after_del_value = first_row_text.getText();
		if(!(after_del_value.equals(initial_value)))
			Actual_reslt="Deleted";
		//Thread.sleep(3000);
		return Actual_reslt;
	
	/*res="Deleted";
	return res;*/
}



public void Commonprocess_edit1(String UN,String PW)
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
	
	
}
}
