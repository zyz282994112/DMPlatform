package model.dataset;

import java.io.UnsupportedEncodingException;

//�ַ���ת����֧��������,iso-8859-1,gb2312,gbk,utf-8
public class Tools {

	public  String getNewString(String input) {

			String result = null;
			try {
				//result = new String(input.getBytes("iso-8859-1"),"gb2312");
				byte[] bytes = input.getBytes("ISO8859-1");
				result = new String(bytes, "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		   return result;
	}	
	
}
