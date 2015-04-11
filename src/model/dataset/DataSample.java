package model.dataset;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DataSample {
	protected DatasetRecordManagement dsrmRead;
	protected DatasetRecordManagement dsrmWrite;
	public DataSample()
	{
		dsrmRead = new DatasetRecordManagement();
		dsrmWrite = new DatasetRecordManagement();
	}
	public Integer dataSample(Integer datasetID, Integer sampleFormat, Integer sampleNumber)
	{
		if(sampleFormat == 1)
		{
			return dataSampleTopN(datasetID, sampleNumber);
		}
		if(sampleFormat == 2)
		{
			return dataSamplePerN(datasetID, sampleNumber);
		}
		if(sampleFormat ==3)
		{
			return dataSampleNPercent(datasetID, sampleNumber);
		}
		else
		{
			return -1;
		}
	}

	public Integer dataSampleTopN(Integer datasetID, Integer sampleNumber)
	{
		if(sampleNumber <= 0) return -1;		
		int newID = getNewID(datasetID);
		ArrayList<String> records = new ArrayList<String>();
		for(long i=1;i<=(long)sampleNumber;i++)
		{
			String record = dsrmRead.readDatasetRecord(datasetID, i);
			if(record != null)
			{
				//System.out.println(record);
				records.add(record);
			}
			else
				break;
		}
		if(dsrmWrite.addDatasetRecords(newID,records,sampleNumber) != 0)
		{
			deleteNewID(newID);
			return -1;
		}
		DatasetBeanCl dbc = new DatasetBeanCl();
		DatasetBean db = dbc.searchDsDescription(newID);
		DatasetBean dbOld = dbc.searchDsDescription(datasetID);
		db.setName(dbOld.getName()+"_DataSample_"+newID);
		dbc.modify(newID, db);
		return newID;
	}
	
	public Integer dataSamplePerN(Integer datasetID, Integer sampleNumber)
	{
		if(sampleNumber <= 0) return -1;
		int newID = getNewID(datasetID);	
		DatasetBeanCl dbc = new DatasetBeanCl();
		DatasetBean dbOld = dbc.searchDsDescription(datasetID);
		ArrayList<String> records = new ArrayList<String>();
		for(long i=sampleNumber;;i=i+sampleNumber)
		{
			String record = dsrmRead.readDatasetRecord(datasetID, i);
			if(record != null)
			{
				//System.out.println(record);
				records.add(record);
			}
			else
				break;
		}
		if(dsrmWrite.addDatasetRecords(newID,records,
				Integer.parseInt(dbOld.getRecordsNo())/sampleNumber) != 0)
		{
			deleteNewID(newID);
			return -1;
		}
		
		DatasetBean db = dbc.searchDsDescription(newID);
		db.setName(dbOld.getName()+"_DataSample_"+newID);
		dbc.modify(newID, db);
		return newID;
	}
	
	public Integer dataSampleNPercent(Integer datasetID, Integer sampleNumber)
	{
		if(sampleNumber <= 0 || sampleNumber>100) return -1;
		//get total records number
		DatasetBeanCl dbc = new DatasetBeanCl();
		DatasetBean db = dbc.searchDsDescription(datasetID);
		int total = Integer.parseInt(db.getRecordsNo());
		int sampleN = (total*sampleNumber)/100;
//		System.out.println(sampleN);
		return dataSampleTopN(datasetID, sampleN);		
	}
	
	private int getNewID(Integer datasetID)
	{
		String upload = SystemConstants.UPLOADDIRECTORY;
//		String name = new String();
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
        db.setSavingPath(upload);	
        //set records number and fields number
		db.setRecordsNo("0");
		DatasetBean dbRead = dbc.searchDsDescription(datasetID);
		db.setFieldsNo(dbRead.getFieldsNo());
		db.setName("temp");
		db.setFileFormat(dbRead.getFileFormat());
		int newID = dbc.addDataset(db);
		return newID;
	}
	
	private void deleteNewID(int newID) {
		DatasetBeanCl dbc = new DatasetBeanCl();
		dbc.deleteDataset(newID);
	}
}
