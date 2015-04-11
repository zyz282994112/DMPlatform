package model.dataset;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controller.dataset.*;

public class DatasetMerge {
	
	protected  DatasetRecordManagement dsrmRead;
	protected  DatasetRecordManagement dsrmWrite;
	public DatasetMerge()
	{
		dsrmRead = new DatasetRecordManagement();
		dsrmWrite = new DatasetRecordManagement();
	}
	public  Integer datasetMerge(Integer datasetID1, Integer datasetID2)
	{
		//merge dataset1 and dataset2 to a new dataset
		
		int newID=getNewID(datasetID1,datasetID2);
		ETL etl=new ETL();
		ArrayList<FieldInfo> fieldinfo1=etl.getFieldsInfo(datasetID1);
		ArrayList<FieldInfo> fieldinfo2=etl.getFieldsInfo(datasetID2);
		ArrayList<FieldInfo> fieldinfoNew = new ArrayList<FieldInfo>();;
		for(FieldInfo f1:fieldinfo1)
			for(FieldInfo f2:fieldinfo2){
				if(f1.getFieldName().equals(f2.getFieldName())&&f1.getType().equals(f2.getType())){
					fieldinfoNew.add(f1);
				}
			}
		DatasetBeanCl dbc = new DatasetBeanCl();
		DatasetBean db = dbc.searchDsDescription(newID);
		db.setFieldsNo(fieldinfoNew.size()+"");
		dbc.modify(newID, db);
		System.out.println(db.getFieldsNo());
		String fieldinfoNewString=new String();
		for(FieldInfo f:fieldinfoNew)
			fieldinfoNewString+=f.toString();
		for(long i=1;;i++){
			String record = dsrmRead.readDatasetRecord(datasetID1, i);
			if(record != null)
			{
				System.out.println(record);
				ArrayList<String> result = new ArrayList<String>();
				for(FieldInfo f:fieldinfoNew){
					result.add(etl.getField(record, fieldinfoNew, f.getFieldName(),","));
				}
				for(String s:result)System.out.println(s);
				String newRecord=etl.implode(result, ",");
				System.out.println(newRecord);
				if(dsrmWrite.addDatasetRecord(newID, newRecord) != 0)
				{
					//System.out.println(dsrmWrite.addDatasetRecord(newID, record));
					return -1;
				}
			}
			else
				break;
		}
		for(long i=1;;i++){
			String record = dsrmRead.readDatasetRecord(datasetID2, i);
			if(record != null)
			{
				System.out.println(record);
				ArrayList<String> result = new ArrayList<String>();
				for(FieldInfo f:fieldinfoNew){
					result.add(etl.getField(record, fieldinfoNew, f.getFieldName(),","));
				}
				for(String s:result)System.out.println(s);
				String newRecord=etl.implode(result, ",");
				System.out.println(newRecord);
				if(dsrmWrite.addDatasetRecord(newID, newRecord) != 0)
				{
					//System.out.println(dsrmWrite.addDatasetRecord(newID, record));
					return -1;
				}
			}
			else
				break;
		}
		
		DSMetadataBeanCl dmbc=new DSMetadataBeanCl();
		DSMetadataBean dmb=dmbc.read(newID);
		dmb.setFieldsInfo(fieldinfoNewString);
		dmb.setTableHeadDefined("Y");
		dmbc.modify(newID, dmb);
		
		return newID;
	}
	private int getNewID(Integer datasetID1,Integer datasetID2)
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

		
		int newID = dbc.addDataset(db);
		String name = "DatasetMerge_"+datasetID1+"_"+datasetID2+"_to_"+newID+".csv";
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
