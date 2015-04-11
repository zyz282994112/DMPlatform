package model.taskManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLAcessBean {
	public static int createXMLFile(String filename,Map<String, String> hashmap) throws IOException{
		//renturn 0 表示成功，其他表示不成功
		
		File file = new File(filename);
		file.getParentFile().mkdirs();
//		String absoultepath  = file.getAbsolutePath();
//		String  path = file.getName();
//		absoultepath = absoultepath.substring(0, absoultepath.length() - path.length());
		
		
		System.out.println("createXMLFile list.size() = " + hashmap.size());
		
		
		Document document = DocumentHelper.createDocument();
		Element parametersElement = document.addElement("paraments");
		Iterator iter = hashmap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String paramentName = (String) entry.getKey();
			String paramentValue = (String) entry.getValue();
			Element paramentElement = parametersElement.addElement(paramentName);
			paramentElement.setText(paramentValue);
		}
		
				
		XMLWriter writer = new XMLWriter(new FileWriter(new File(filename)));
		
		writer.write(document);
		writer.flush();
		writer.close();
		
		return 0;
	}



	public static HashMap<String, String> parseXML(String fileName) {
		File file = new File(fileName);//
		HashMap<String, String> hashmap = null;
		
			
		SAXReader saxReader = new SAXReader();
		
		try {
			Document document = saxReader.read(file); //读取文件保存到document中
			
			Element root = document.getRootElement();//获取根目录
			hashmap = new HashMap<String, String>();
			for(Iterator i=root.elementIterator();i.hasNext();){
				Element records = (Element)i.next();

				hashmap.put(records.getName().toString(), records.getText().toString());
				
			}
		} catch (DocumentException e) {
			System.out.println("org.dom4j.DocumentException");
			e.printStackTrace();
		}
		System.out.println("parseXML sucess!");
		return hashmap;
	}
	
	
	


}
