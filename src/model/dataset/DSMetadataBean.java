package model.dataset;

import java.util.ArrayList;

public class DSMetadataBean 
{
	private int id;//id
	private String fieldsInfo;//fields information
	private String tableHeadDefined;//"Y" means defined,"N" means not
	
//	public DSMetadataBean()
//	{
//		fieldsInfo = "";
//	}
	
	public DSMetadataBean(int id, String fieldsInfo)
	{
		this.id = id;
		this.fieldsInfo = fieldsInfo;
		if("".equals(fieldsInfo) || fieldsInfo == null)
		{
			tableHeadDefined = "N";
		}
		else
		{
			tableHeadDefined = "Y";
		}
	}
	
	public DSMetadataBean(int id,ArrayList<FieldInfo> fields)
	{
		this.id = id;
		fieldsInfo = "";
		for(FieldInfo field : fields)
		{
			fieldsInfo += field.getFieldName();
			fieldsInfo += SystemConstants.SEPARATOR;
			fieldsInfo += field.getType();
			fieldsInfo += SystemConstants.SEPARATOR;
			fieldsInfo += field.getMeaning();
			fieldsInfo += SystemConstants.SEPARATOR;
		}
		if("".equals(fieldsInfo))
		{
			tableHeadDefined = "N";
		}
		else
		{
			tableHeadDefined = "Y";
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFieldsInfo() {
		return fieldsInfo;
	}
	public void setFieldsInfo(String fieldsInfo) {
		this.fieldsInfo = fieldsInfo;
	}
	public String getTableHeadDefined() {
		return tableHeadDefined;
	}

	public void setTableHeadDefined(String tableHeadDefined) {
		this.tableHeadDefined = tableHeadDefined;
	}
	
	public ArrayList<FieldInfo> extractFieldsInfo()
	{
		ArrayList<FieldInfo> fields= new ArrayList<FieldInfo>();
		if("".equals(fieldsInfo))
		{
			return fields;
		}
		
		int indexBegin = 0;
		int indexEnd = 0;
		while((indexEnd=fieldsInfo.indexOf(SystemConstants.SEPARATOR,indexBegin)) != -1)
		{
			//name
			String name = fieldsInfo.substring(indexBegin, indexEnd);
			//type
			indexBegin = indexEnd + SystemConstants.SEPARATOR.length();
			if((indexEnd=fieldsInfo.indexOf(SystemConstants.SEPARATOR,indexBegin)) == -1)
			{
				break;
			}
			String type = fieldsInfo.substring(indexBegin, indexEnd);
			//meaning
			indexBegin = indexEnd + SystemConstants.SEPARATOR.length();
			if((indexEnd=fieldsInfo.indexOf(SystemConstants.SEPARATOR,indexBegin)) == -1)
			{
				break;
			}
			String meaning = fieldsInfo.substring(indexBegin, indexEnd);
			FieldInfo field = new FieldInfo(name, type, meaning);			
			fields.add(field);
			indexBegin = indexEnd + SystemConstants.SEPARATOR.length();
		}
		return fields;
	}
	public boolean fieldsInfoDefined()
	{
		if(tableHeadDefined == null || "N".equals(tableHeadDefined))
		{
			return false;
		}
		if(fieldsInfo == null || "".equals(fieldsInfo))
		{
			return false;
		}
		return true;
	}
}
