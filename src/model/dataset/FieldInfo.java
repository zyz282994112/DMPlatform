package model.dataset;

public class FieldInfo {
	private String fieldName;
	private String type;
	private String meaning;
	
	public FieldInfo()
	{
		fieldName = "";
		type = "";
		meaning = "";
	}
	public FieldInfo(String fieldName, String type, String meaning)
	{
		this.fieldName = fieldName;
		this.type = type;
		this.meaning = meaning;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	@Override
	public String toString()
	{
		return "fieldName:" + this.fieldName +
				"  type:" + this.type +
				"  meaning:" + this.meaning;
	}
}
