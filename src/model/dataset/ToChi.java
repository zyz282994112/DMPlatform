package model.dataset;

public class ToChi {
	public static String toChi(String input) {
		/*
		if(input == null)
		{
			return "";
		}
		*/
	     try {
	         byte[] bytes = input.getBytes("ISO8859-1");
	         return new String(bytes, "utf-8");
	     } catch (Exception ex) {
	     }
	     return null;
	 }
}
