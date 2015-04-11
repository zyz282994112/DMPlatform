package model.dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.util.List;

public class CalRecordsFieldsNo {
	public static int calculateRecordsNo(String path,String filename)
	{
		File file = new File(path + "/" + filename); 
		BufferedReader reader = null; 
		int line = 0;
		try { 
			reader = new BufferedReader(new FileReader(file)); 
			while ((reader.readLine()) != null){ 
			//System.out.println("line " + line + ": " + tempString); 
			line++; 
			} 
			reader.close(); 
			} catch (IOException e) { 
			e.printStackTrace(); 
			System.out.println("IOException£¡");
			} finally {
			if (reader != null){
			try {
			reader.close(); 
			} catch (IOException e1) { 
			} 
			}
			}
		return line;
	}
	public static int calculateFieldsNo(String path,String filename)
	{
		int fields = 1;
		File file = new File(path + "/" + filename); 
		BufferedReader reader = null; 
		try { 
			reader = new BufferedReader(new FileReader(file)); 
			String tempString = null; 
			 
			if ((tempString = reader.readLine()) != null){ 
			//System.out.println("line " + line + ": " + tempString); 
				char c;
				for (int i=0;i<tempString.length();i++)
				{
					c=tempString.charAt(i);
					if(c == ',')
					{
						fields++;
					}
				}
			} 
			else
			{
				System.out.println("!!");
				return 0;
			}
			reader.close(); 
			} catch (IOException e) { 
			e.printStackTrace(); 
			System.out.println("wrong£¡");
			} finally { 
			if (reader != null){ 
			try { 
			reader.close(); 
			} catch (IOException e1) { 
			} 
			}
			}
		return fields;
	}

}
