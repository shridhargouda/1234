package Dataprovider_currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_component.ExcelReadWrite;

public class DataProvider_curr {
	
	@DataProvider(name="Invalid_curr_test_blnk")
	public static Iterator<String[]> Invalid_curr_test_blnk() throws IOException
	{
		System.out.println("1");
		List<String[]> Obj = flagRowCount("Invalid_curr_test_blnk");
		return Obj.iterator();	
	}
	
	@DataProvider(name="Invalid_curr_test")
	public static Iterator<String[]> Invalid_curr_test() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("Invalid_curr_test");
		return Obj.iterator();	
	}

	@DataProvider(name="Valid_curr_test")
	public static Iterator<String[]> Valid_curr_test() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("Valid_curr_test");
		return Obj.iterator();	
	}
	
	
	
	//to get the flag row count
	public static List<String[]> flagRowCount(String script_name) throws IOException
	{
		//"D:\\akash\\salenium\\Reach_OAMC\\Excel-files\\01_Reachwell_masters_currency_Data.xls"
		ExcelReadWrite x=new ExcelReadWrite(System.getProperty("user.dir") + "\\Excel_sheets\\Masters\\01_Reachwell_masters_currency_Data.xls");
		HSSFSheet create_curr = x.Setsheet("create_curr");
		int xlRowcount = x.getrowcount(create_curr);
		
		//Declare a Array List
		List<String[]> List_login= new ArrayList<String[]>();
		
		//traversing Excel
		for(int xlRow=1;xlRow<=xlRowcount;xlRow++)
		{
			
			String Execute_Flag = x.Readvalue(create_curr, xlRow, "Execute_Flag");
			String Scriptname = x.Readvalue(create_curr, xlRow, "Scriptname");
			
			
			if((Execute_Flag.equals("Y")&&(Scriptname.equals(script_name))))
				{
				
				String[] arr_login= new String[4];
				
				arr_login[0]=x.Readvalue(create_curr, xlRow, "TC_ID");
				arr_login[1]=x.Readvalue(create_curr, xlRow, "Order");
				arr_login[2]=x.Readvalue(create_curr, xlRow, "curr_name");
				//arr_login[3]=x.Readvalue(create_curr, xlRow, "Pwd");
				arr_login[3]=x.Readvalue(create_curr, xlRow, "Exp_Res");
				
				List_login.add(arr_login);			
				}//end of if
								
		}//end of for
		
		return List_login;
	}

}
