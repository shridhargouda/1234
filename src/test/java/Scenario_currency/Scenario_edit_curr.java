package Scenario_currency;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_component.Base_Class;
import Generic_component.Utility_Class;
import Pageobject_currency.PageObject_edit;

public class Scenario_edit_curr extends Base_Class {
	

	SoftAssert sAssert= new SoftAssert();
	static Logger log=Logger.getLogger(Scenario_edit_curr.class);
	Utility_Class c1= new Utility_Class();

	@Test(dataProvider="dp_Invalidcurr_blnk",dataProviderClass=Dataprovider_currency.DataProvider_edit.class,groups={"currency"})
	public void test_Invalid_editcurr_blnk(String TC_ID,String Order,String curr_name,String Exp_Res) throws IOException
	{
		String uname = c1.Reading_Properties("uname");
		String pwd = c1.Reading_Properties("pwd");
		
		log.info("Executing the testcase "+TC_ID+  "  Order of  "+Order);
		
		initBrowsersession1();
		
		PageObject_edit lpob= new PageObject_edit(browser);
		lpob.Commonprocess_edit(uname,pwd,curr_name);//, Pwd);
		String Actual_Res = lpob.getInvalidcurrResult_blnk();
	
		
		sAssert.assertEquals(Exp_Res, Actual_Res);
		
		if(Actual_Res.equals(Exp_Res))
		{
			
			log.info("Passed as Expected msg was Valid");
			
		}
		else
		{
			log.info("Failed as Expected msg was " +Exp_Res + "Actual msg was   "+Actual_Res);
			sAssert.fail("Failed as Expected msg was " +Exp_Res + "Actual msg was   "+Actual_Res);
			
		}
		tearDown();
		sAssert.assertAll();
		log.info("******************************************");
				
	}
	
	@Test(dataProvider="dp_Invalidedit",dataProviderClass=Dataprovider_currency.DataProvider_edit.class,groups={"currency"})
	public void test_Invalideditcurr(String TC_ID,String Order,String curr_name,String Exp_Res) throws IOException
	{
		String uname = c1.Reading_Properties("uname");
		String pwd = c1.Reading_Properties("pwd");
		log.info("Executing the testcase "+TC_ID+  "  Order of  "+Order);
		
		initBrowsersession1();
		PageObject_edit lpob= new PageObject_edit(browser);
		lpob.Commonprocess_edit(uname,pwd,curr_name);//, Pwd);
		String Actual_Res = lpob.getInvalidedit();		
		sAssert.assertEquals(Exp_Res, Actual_Res);
		
		if(Actual_Res.equals(Exp_Res))
		{
			log.info("Passed as Expected msg was Valid");	
		}
		else
		{
			log.info("Failed as Expected msg was "+Exp_Res +"Actual msg was   "+Actual_Res);
			sAssert.fail("Failed as Expected msg was "+Exp_Res +"Actual msg was   "+Actual_Res);
		}
		tearDown();
		sAssert.assertAll();
		log.info("******************************************");
				
	}
	
	
	@Test(dataProvider="dp_Validedit",dataProviderClass=Dataprovider_currency.DataProvider_edit.class,groups={"currency"})
	public void test_Validedit_curr(String TC_ID,String Order,String curr_name,String Exp_Res) throws IOException
	{
		String uname = c1.Reading_Properties("uname");
		String pwd = c1.Reading_Properties("pwd");
		log.info("Executing the testcase "+TC_ID+  "  Order of  "+Order);
		//System.out.println("hi");
		initBrowsersession1();
		PageObject_edit lpob= new PageObject_edit(browser);
		lpob.Commonprocess_edit(uname,pwd,curr_name);//, Pwd);
		String Actual_Res = lpob.getValidedit();		
		sAssert.assertEquals(Exp_Res, Actual_Res);
		
		if(Actual_Res.equals(Exp_Res))
		{
			log.info("Passed as Expected msg was Valid");	
		}
		else
		{
			log.info("Failed as Expected msg was "+Exp_Res +"Actual msg was   "+Actual_Res);
			sAssert.fail("Failed as Expected msg was "+Exp_Res +"Actual msg was   "+Actual_Res);
		}
		tearDown();
		sAssert.assertAll();
		log.info("******************************************");			
	}
	
	
	


}
