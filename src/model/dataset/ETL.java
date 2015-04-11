package model.dataset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.platform.DBQuery;

public class ETL {
	public static ArrayList<String> split(String record, String separator)
	{
		ArrayList<String> al= new ArrayList<String>();
		if( "".equals(record) || record == null)
		{
			return al;
		}		
		int indexBegin = 0;
		int indexEnd = 0;
		while((indexEnd=record.indexOf(separator,indexBegin)) != -1)
		{
			String name = record.substring(indexBegin, indexEnd);
			indexBegin = indexEnd + separator.length();
			al.add(name);
		}
		al.add(record.substring(indexBegin));
		return al;
	}
	
	public static String implode(ArrayList<String> result, String separator)
	{
		StringBuffer newRecord = new StringBuffer();
		for(int i=0;i<result.size()-1;i++)
		{
			newRecord.append(result.get(i));
			newRecord.append(separator);
		}
		newRecord.append(result.get(result.size()-1));
		return newRecord.toString();
	}
	
	public static ArrayList<FieldInfo> getFieldsInfo(int datasetID)
	{
		ArrayList<FieldInfo> fieldsInfo = new ArrayList<FieldInfo>();
		String fields = new String();
		try {
			ResultSet rs=DBQuery.query("select * from dsmetadata where DSID='"+datasetID+"' ");
			if(rs.next())
			{
				if("N".equals(rs.getString("DSTableHeadDefined")))
				{
					System.out.println("fields not defined!");
					return fieldsInfo;
				}
				fields = rs.getString("DSFieldsInfo");
			}
			else
			{
				System.out.println("dataset not found!");
				return fieldsInfo;
			}
			DSMetadataBean dsmb = new DSMetadataBean(datasetID, fields);
			fieldsInfo = dsmb.extractFieldsInfo();	
			DBQuery.closeDB();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return fieldsInfo;
	}
	
	public static String getField(String record, ArrayList<FieldInfo> al, String fieldName, String separator)
	{
		if(fieldName == null)
		{
			return "";
		}
		ArrayList<String> fields = split(record, separator);
		int index = 0;
		for(int i=0;i<al.size();i++)
		{
			if(fieldName.equals(al.get(i).getFieldName()))
			{
				index = i;
				break;
			}
		}
		if(index > fields.size())
		{
			System.out.println("out of range!");
			return "";
		}
		return fields.get(index);
	}
}
