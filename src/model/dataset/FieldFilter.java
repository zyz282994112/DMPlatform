package model.dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.platform.DBQuery;

public class FieldFilter {
	public static int fieldFilter(int datasetID, ArrayList<String> fields, String separator)
	{
		String path = new String();
		String fieldsInfo = new String();
		int newID = -1;
//		String datasetName = new String();
//		String datasetFormat = new String();
		try {
			DatasetBeanCl dbc = new DatasetBeanCl();
			DatasetBean db = dbc.searchDsDescription(datasetID);
			path = db.getAbsolutePath();
			ResultSet rs=DBQuery.query("select * from dsmetadata where DSID='"+datasetID+"' ");
			if(rs.next())
			{
				if("N".equals(rs.getString("DSTableHeadDefined")))
				{
					System.out.println("fields not defined!");
					return -1;
				}
				fieldsInfo = rs.getString("DSFieldsInfo");
			}
			else
			{
				System.out.println("dataset not found!");
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DSMetadataBean dsmb = new DSMetadataBean(datasetID, fieldsInfo);
		ArrayList<FieldInfo> al = dsmb.extractFieldsInfo();
		File file = new File(path);
		BufferedReader reader = null; 
		//int line = 0;
		try { 
			reader = new BufferedReader(new FileReader(file)); 
			String record = null; 
			StringBuffer newFile = new StringBuffer();
			while ((record = reader.readLine()) != null){ 
			ArrayList<String> result = doFilter(record, al, fields, separator);
			if(result == null)
			{
				System.out.println("FieldFilter.java:filter wrong!");
				return -1;
			}
			String newRecord = ETL.implode(result, separator);
			newFile.append(newRecord);
			newFile.append("\r\n");
			}
			newID = getFilterNewID(datasetID, newFile, fields.size());
			//dsrmWrite.addDatasetRecord(newID, newFile);
			reader.close();
			} catch (IOException e) { 
			e.printStackTrace(); 
			System.out.println("IOException£¡");
			} finally { 
			if (reader != null){ 
			try { 
			reader.close(); 
			} catch (IOException e1) { 
			} 
			}
			}
		return newID;
	}
	
	private static ArrayList<String> doFilter(String record, ArrayList<FieldInfo> al, ArrayList<String> fields, String separator)
	{
		ArrayList<String> filterRecord = new ArrayList<String>();
		ArrayList<String> splitRecord = ETL.split(record, separator);
		if(al.size() != splitRecord.size())
		{
			System.out.println("field information wrong!");
			return null;
		}
		HashMap<String,String> hashmap = new HashMap<String,String>();
		for(int i=0;i<al.size();i++)
		{
			hashmap.put(al.get(i).getFieldName(), splitRecord.get(i));
		}
		for(int i=0;i<fields.size();i++)
		{
			filterRecord.add(hashmap.get(fields.get(i)));
		}
		return filterRecord;
	}
	
	private static int getFilterNewID(int datasetID, StringBuffer fileString, int fieldsNo)
	{
		String upload = SystemConstants.UPLOADDIRECTORY;
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
        DatasetBean dbRead = dbc.searchDsDescription(datasetID);
		db.setRecordsNo(dbRead.getRecordsNo());		
		db.setFieldsNo(String.valueOf(fieldsNo));
		db.setName("temp");
		db.setFileFormat(dbRead.getFileFormat());
		int newID = dbc.addDataset(db);
		
		try {       
            RandomAccessFile randomFile = new RandomAccessFile(db.getAbsolutePath(), "rw");      
            long fileLength = randomFile.length();             
            randomFile.seek(fileLength);      
            randomFile.writeBytes(fileString.toString());
            randomFile.close();      
        } catch (IOException e) {      
            e.printStackTrace(); 
        }
		db.setName(dbRead.getName()+"_FieldFilter_"+newID);
		//db.setFileFormat(dbRead.getFileFormat());
		//db.setSavingPath(upload);
		dbc.modify(newID, db);
		return newID;
	}

}
