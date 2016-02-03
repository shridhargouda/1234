package Generic_component;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility_Class {
	
	
	public String Reading_Properties(String Skey) throws IOException
	{
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Reading_Properties");
		Properties prop = new Properties();
		
		prop.load(fis);
		
		return prop.getProperty(Skey);
		
		
		
		
	}
	

}
