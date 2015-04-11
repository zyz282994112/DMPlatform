package model.algorithm.utils;

import com.google.common.collect.Lists;
import model.algorithm.utils.PathConstant;
import org.apache.mahout.common.Pair;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * author: csy
 * date: 14-1-2
 * description: Parse XML file.
 */
public class XmlParser {
    public static List<Pair<String,String>> paramParser(String aName) throws JDOMException, IOException {
        
    	String xmlPath = PathConstant.CONFPATH+aName+".xml";
    	System.out.println(aName);
        File xmlFile = new File(xmlPath);
//     	System.out.println(xmlPath);
        List<Pair<String,String>> paramList = Lists.newArrayList();
        SAXBuilder sb = new SAXBuilder();
        Document doc = sb.build(xmlFile);
        
        Element root = doc.getRootElement();
        List list = root.getChildren(aName);
        System.out.println(list.toString());
        Element element = (Element) list.get(0);
        
        for(Element e : element.getChildren()){
            paramList.add(new Pair<String, String>(e.getName(),e.getText()));
        }
     	
        return paramList;
    }

}
