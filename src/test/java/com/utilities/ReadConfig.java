package com.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public static String readPropertyFileData(String keyName,String fileName) {
		String rederValue=null;
		
		
		Properties properties=null;
		try {
			FileReader filereader=new FileReader("./configuration/"+fileName+".properties");
			System.out.println(filereader);
			properties=new Properties();
			properties.load(filereader);
			rederValue=properties.getProperty(keyName);
		}catch(IOException e){
			e.printStackTrace();
			
		}
		return rederValue;
	}
}
