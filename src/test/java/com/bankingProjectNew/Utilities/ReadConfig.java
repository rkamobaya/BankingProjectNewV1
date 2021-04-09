package com.bankingProjectNew.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
// 1st -----> create an object of properties class (its a Java util class). 
// 2nd ------> then we need to create a constructor. that constructor will import the data in read mode
//			  (that's why we use FileInputStream), load the complete file (pro.load(fis))
//			  And suppose the file is not at that location, there is a chance to get an exception. 
	
	Properties pro;
	
//when I create an object of this class ReadConfig, this constructor will be invoked. And the Property 
//will be loaded. Once the properties class is loaded then we need to read each of every variable value 
//by adding a method. We need to add different method for every variable.
	public ReadConfig()          
	{
		
		File scr = new File("./Configurations\\config.properties");	
		
		try {
			FileInputStream fis = new FileInputStream(scr);
			pro = new Properties();
			pro.load(fis);
			}
		catch (Exception e)
			{
			System.out.println("Exception is" + e.getMessage());
			
			}
	}
		
//We need to different method for every variable. 
//we will create different method one by one to read each of every variable and their values. Just like POM
//what this method will do ? for ex the method getApplicationURL() will read the value from the properties file
//pro.property("baseURL");   et store in a variable ---> String url = pro.getProperty("baseURL"); 
// and return that variable url ----> return url;
//suppose in the future if I add more variables, then I need to add also their corresponding methods to read their values
		
		
		public String getApplicationURL()
		{
			String url = pro.getProperty("baseURL");
			return url;
		}
		
		public String getUsername()
		{
			String username = pro.getProperty("username");
			return username;
		}
		
		public String getPassword()
		{
			String pswrd = pro.getProperty("password");
			return pswrd;
		}
		
		public String getChromePath()
		{
			String chrome= pro.getProperty("chromePath");
			return chrome;
		}
		
		public String getGeckoPath()
		{
			String gecko = pro.getProperty("geckodriverPath");
			return gecko;
		}
		
		public String getInternetExplorerPath()
		{
			String ie = pro.getProperty("internetExplorerPath");
			return ie;
		}
		
		public String getEdgePath()
		{
			String edge = pro.getProperty("edgePath");
			return edge;
		}
		
		
	
		
		
		
	}
	
	
	
	
	
	


