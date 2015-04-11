package model.dataset;

import java.text.SimpleDateFormat;
import java.util.*;



public class DataSort {
	protected DatasetRecordManagement dsrmRead;
	protected DatasetRecordManagement dsrmWrite;
	private ArrayList<sortType> recordList;
	public DataSort()
	{
		dsrmRead = new DatasetRecordManagement();
		dsrmWrite = new DatasetRecordManagement();
	}
	public Integer dataSort(Integer datasetID, String fieldName,boolean asc)
	{//sort dataset by specified fieldName
		int newID=getNewID(datasetID);
		ETL etl=new ETL();
		ArrayList<FieldInfo> fieldinfo=etl.getFieldsInfo(datasetID);
		recordList=new ArrayList<sortType>();
		for(long i=1;;i++){
			String record = dsrmRead.readDatasetRecord(datasetID, i);
			if(record != null){
			String field=etl.getField(record, fieldinfo, fieldName, ",");
			this.recordList.add(new sortType(record,field));
			}
			else break;
		}
		DSMetadataBeanCl dmbc=new DSMetadataBeanCl();
		DSMetadataBean dmb=dmbc.read(datasetID);
		dmb.setId(newID);
		dmbc.modify(newID, dmb);
		
		
		sortString();
		for(FieldInfo f:fieldinfo){
			//System.out.println(f.getFieldName()+"  "+f.getType());
			if(f.getFieldName().equals(fieldName)&&f.getType().contains("int")){System.out.println("sortint");sortInt();}
			if(f.getFieldName().equals(fieldName)&&f.getType().contains("float")){System.out.println("sortfloat");sortFloat();}
			
		}
		
		if(asc)
			for(sortType s:this.recordList){
				if(dsrmWrite.addDatasetRecord(newID, s.getRecord()) != 0)return -1;
			}
		else
			for(int i=this.recordList.size()-1;i>=0;i--){
				sortType s=recordList.get(i);
				if(dsrmWrite.addDatasetRecord(newID, s.getRecord()) != 0)return -1;
			}
		return newID;
	}
	
	private void sortString() {
		Collections.sort(this.recordList, new Comparator<sortType>() {
			public int compare(sortType o1, sortType o2) {
				return o1.getSortField().compareTo(o2.getSortField());
			}
		});
	}
	private void sortInt() {
		Collections.sort(this.recordList, new Comparator<sortType>() {
			public int compare(sortType o1, sortType o2) {
				int n1=Integer.parseInt(o1.getSortField()),n2=Integer.parseInt(o2.getSortField());
				if(n1>n2)return 1;
				else if(n1<n2)return -1;
				else return 0;
			}
		});
	}
	private void sortFloat() {
		Collections.sort(this.recordList, new Comparator<sortType>() {
			public int compare(sortType o1, sortType o2) {
				float n1=Float.parseFloat(o1.getSortField()), n2=Float.parseFloat(o2.getSortField());
				if(n1>n2)return 1;
				else if(n1<n2)return -1;
				else return 0;
			}
		});
	}
	private int getNewID(Integer datasetID)
	{
		String upload = SystemConstants.UPLOADDIRECTORY;
		System.out.println(upload);
		
		//format date
        Date date = new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String create_time = df.format(date);
        String upload_time = df.format(date);
        String last_modification_time = df.format(date);
        DatasetBean db = new DatasetBean();
        DatasetBeanCl dbc = new DatasetBeanCl();
        db.setCreateTime(create_time);
        db.setUploadTime(upload_time);
        db.setLastModificationTime(last_modification_time);
        
        ///set records number and fields number
		db.setRecordsNo("0");
		DatasetBean dbRead = dbc.searchDsDescription(datasetID);
		db.setFieldsNo(dbRead.getFieldsNo());
		
		int newID = dbc.addDataset(db);
		String name = "DatasetSort_"+datasetID+"_to_"+newID+".csv";
		//set DSName & DSType according to "name"		
		for (int i = 0; i < name.length(); i++)   
			if (name.substring(i, i + 1).equals(".")){
				String L=name.substring(0,i);   
			    String R=name.substring(i+1); 
				db.setName(L);
				db.setFileFormat(R);  
			}
		db.setSavingPath(upload + "/" + name);	
		dbc.modify(newID, db);
		return newID;
	
	}


}

class sortType{
	private String record;
	private String sortField;
	public sortType(String record, String sortField) {
	        this.record = record;
	        this.sortField = sortField;
	    }
	public String getSortField() {
        return sortField;
    }
	public String getRecord() {
        return record;
    }
}
