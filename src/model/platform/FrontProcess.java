package model.platform;

import java.util.HashMap;
import java.util.Map.Entry;

public class FrontProcess {
	
	public static HashMap<String, String> toHashMap(String allname){
		
		String[] tmp = allname.split("&");
		HashMap<String, String> map = new HashMap<String, String>();
		for(String var:tmp){
			String[] temp = var.split("=");
			if(temp.length ==2)
				map.put(temp[0],temp[1]);
			else 
				map.put(temp[0],"");
		}
		return map;
	}
	
	public static void main(String[] args){
		String ss="aa=2&bb=3&cc=4&";
		HashMap<String, String> map = toHashMap(ss);
		for (Entry<String, String> entry : map.entrySet()) {  
			  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		  
		}  
		
	}
	
}
