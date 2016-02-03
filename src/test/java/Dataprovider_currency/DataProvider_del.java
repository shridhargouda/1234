package Dataprovider_currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_component.ExcelReadWrite;
public class DataProvider_del {
	@DataProvider(name="dp_Invaliddel_blnk")
	public static Iterator<String[]> Invalidedit_blnkData() throws IOException
	{
		List<String[]> Obj = flagRowcount("Invalid_delete_blnk");
		return Obj.iterator();
	}
	
	
	@DataProvider(name="dp_validdel")
	public static Iterator<String[]> Invalideditdata() throws IOException
	{
		List<String[]> Obj = flagRowcount("valid_frstcurr_del");
		return Obj.iterator();		
		
	}
	
	
	@DataProvider(name="dp_Valid_mul_del")
	public static Iterator<String[]> ValideditData() throws IOException
	{
		List<String[]> Obj = flagRowcount("Valid_mul_del");
		return Obj.iterator();
	}
	
	
	
	public static List<String[]> flagRowcount(String script_name) throws IOException
	{
		ExcelReadWrite x= new ExcelReadWrite(System.getProperty("user.dir") + "\\Excel_sheets\\Masters\\01_Reachwell_masters_currency_Data.xls");
		HSSFSheet Scenario_edit = x.Setsheet("Delete_curr");
		int xlRowcount = x.getrowcount(Scenario_edit);
		
		//Declare
		List<String[]> List_edit= new ArrayList<String[]>();
		
		
		for(int xlrow=1;xlrow<=xlRowcount;xlrow++)
		{
			String Execute_Flag = x.Readvalue(Scenario_edit, xlrow, "Execute_Flag");
			String Scriptname = x.Readvalue(Scenario_edit, xlrow, "Scriptname");
			
			if((Execute_Flag.equals("Y")&&(script_name.equals(Scriptname))))
			{
				String[] arr_edit= new String[3];
				arr_edit[0]=x.Readvalue(Scenario_edit, xlrow, "TC_ID");
				arr_edit[1]=x.Readvalue(Scenario_edit, xlrow, "Order");
				//arr_edit[2]=x.Readvalue(Scenario_edit, xlrow, "curr_name");
				arr_edit[2]=x.Readvalue(Scenario_edit, xlrow, "Exp_Res");
				
				List_edit.add(arr_edit);			
			}
					
			
		}//end of the for loop
		
		return List_edit;
		
	}
}
