package Scenario_currency;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_component.Base_Class;
import Generic_component.Utility_Class;
import Pageobject_currency.PageObject_curr;

public class Scenario_curr extends Base_Class {
	
	SoftAssert sAssert= new SoftAssert();
	static Logger log=Logger.getLogger(Scenario_curr.class);
	Utility_Class c1= new Utility_Class();

	
	
	@Test(dataProvider="Invalid_curr_test_blnk",dataProviderClass=Dataprovider_currency.DataProvider_curr.class,groups={"currency"})
	public void Invalid_curr_test_blnk(String TC_ID,String Order,String curr_name,String Exp_Res) throws IOException
	{
System.out.println("2");
		String uname = c1.Reading_Properties("uname");
		String pwd = c1.Reading_Properties("pwd");
		log.info("Executing the testcase "+TC_ID+  "  Order of  "+Order);
		
		initBrowsersession1();
		PageObject_curr lpob= new PageObject_curr(browser);
		lpob.Commonprocesscurr(uname,pwd,curr_name);//, Pwd);
		String Actual_Res = lpob.Invalid_curr_test_blnk();
	
		sAssert.assertEquals(Exp_Res, Actual_Res);
		
		if(Actual_Res.equals(Exp_Res))
		{
			log.info("Passed as Expected msg was Valid");
		}
		else
		{
			log.info("Failed as Expected msg was "+Exp_Res + "Actual msg was   "+Actual_Res);
			sAssert.fail("Failed as Expected msg was "+Exp_Res + "Actual msg was   "+Actual_Res);
		}
		tearDown();
		sAssert.assertAll();
		log.info("******************************************");
				
	}
	
    //@Test(dataProvider="Invalid_curr_test",dataProviderClass=Dataprovider_currency.DataProvider_curr.class,groups={"currency"})
	public void Invalid_curr_test(String TC_ID,String Order,String curr_name,String Exp_Res) throws IOException
	{
		String uname = c1.Reading_Properties("uname");
		String pwd = c1.Reading_Properties("pwd");
		log.info("Executing the testcase "+TC_ID+  "  Order of  "+Order);
		
		initBrowsersession1();
		PageObject_curr lpob= new PageObject_curr(browser);
		lpob.Commonprocesscurr(uname,pwd,curr_name);//, Pwd);
		String Actual_Res = lpob.getInvalidcurrResult();		
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

//@Test(dataProvider="Valid_curr_test",dataProviderClass=Dataprovider_currency.DataProvider_curr.class,groups={"currency"})
public void Valid_curr_test(String TC_ID,String Order,String curr_name,String Exp_Res) throws IOException
{
	String uname = c1.Reading_Properties("uname");
	String pwd = c1.Reading_Properties("pwd");
	log.info("Executing the testcase "+TC_ID+  "  Order of  "+Order);
	//System.out.println("hi");
	initBrowsersession1();
	PageObject_curr lpob= new PageObject_curr(browser);
	lpob.Commonprocesscurr(uname,pwd,curr_name);//, Pwd);
	String Actual_Res = lpob.getvalidcurrResult();		
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
