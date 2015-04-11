package model.dataset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.RandomAccessFile; 

import model.platform.DBQuery;

public class DatasetRecordManagement {
	private DatasetBean db=new DatasetBean();
	/* 
	 * 0£º add record success
	 * 1£º the dataset is being used now,add failed
	 * 2£ºformat conflict,failed
	*/
	public int addDatasetRecord(Integer datasetID, String record)
	{
		if(cheakIsUsed(datasetID) == true)
		{
			return 1;
		}
		setDatasetBean(datasetID);
		if(cheakFormat(Integer.parseInt(db.getFieldsNo()),record) == false)
		{
			return 2;
		}
		addRecord(datasetID,record);
		modifyDescriptionAdd(datasetID);
		return 0;
	}

	public int addDatasetRecords(Integer datasetID, ArrayList<String> records, int rows)
	{
		if(cheakIsUsed(datasetID) == true)
		{
			return 1;
		}
		setDatasetBean(datasetID);
		for(String record:records)
		{
			if(cheakFormat(Integer.parseInt(db.getFieldsNo()),record) == false)
			{
				return 2;
			}
		}		
		try {       
            RandomAccessFile randomFile = new RandomAccessFile(db.getAbsolutePath(), "rw");      
            long fileLength = randomFile.length();             
            randomFile.seek(fileLength);   
            for(String record : records)
            {
            	randomFile.writeBytes(record+"\r\n");
            }
            randomFile.close();      
        } catch (IOException e) {      
            e.printStackTrace();      
        } 
		File f = new File(db.getAbsolutePath());
		db.setRecordsNo(String.valueOf(Integer.parseInt(db.getRecordsNo())+rows));
		db.setSize(String.valueOf(f.length()));
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String last_modification_time = df.format(date);
		db.setLastModificationTime(last_modification_time);
		DatasetBeanCl dbc = new DatasetBeanCl();
		dbc.modify(datasetID, db);
		return 0;
	}
	
	
	public int modifyDatasetRecord(Integer datasetID, Long recordLine, String record)
	{
		if(cheakIsUsed(datasetID) == true)
		{
			return 1;
		}
		setDatasetBean(datasetID);
		modifyRecord(recordLine,record);
		modifyDescriptionMod(datasetID);
		return 0;
	}
	
	public int deleteDatasetRecord(Integer datasetID, Long recordLine)
	{
		if(cheakIsUsed(datasetID) == true)
		{
			return 1;
		}
		setDatasetBean(datasetID);
		deleteRecord(recordLine);
		modifyDescriptionDel(datasetID);
		return 0;		
	}
	
	public String readDatasetRecord(Integer datasetID, Long recordLine)
	{
//		ct=new ConnDB().getConnection();
		DatasetBean db = new DatasetBean();
		String path = new String();
		try {
//			sm=ct.createStatement();
			ResultSet rs = DBQuery.query("select * from dataset where DSID='"+datasetID+"' ");
			if(rs.next())
			{
				db.setAll(rs.getInt("DSID"), rs.getString("DSName"), rs.getString("DSType"), rs.getString("DSPath"), 
						rs.getString("DSSource"), rs.getString("DSCreater"), rs.getString("DSCreaterCompany"), rs.getString("DSCreaterAddr"),
						rs.getString("DSCreaterPostcode"), rs.getString("DSPhone"), rs.getString("DSEmail"), rs.getString("DSRecordNumber"),
						rs.getString("DSFieldNumber"), rs.getString("DSSize"), rs.getString("DSTpye"), rs.getString("DSMetadataDescription"),
						rs.getString("DSUploader"), rs.getString("DSUploaderCompany"), rs.getString("DSUploaderAddr"), rs.getString("DSUploaderPostcode"),
						rs.getString("DSUploaderPhone"), rs.getString("DSUploaderEmail"), rs.getString("DSCreateTime"), rs.getString("DSUploadTime"),
						rs.getString("DSChangeTime"), rs.getString("DSDescription"));
				path = db.getAbsolutePath();
			}
			DBQuery.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file = new File(path); 
		BufferedReader reader = null; 
		int line = 0;
		try { 
			reader = new BufferedReader(new FileReader(file)); 
			String record = null; 
			 
			while ((record = reader.readLine()) != null){ 
			//System.out.println("line " + line + ": " + tempString); 
			line++; 
			if(line == recordLine)
			{
				reader.close(); 
				return record;
			}
			} 
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
		return null;
	}

	public boolean cheakIsUsed(Integer datasetID)
	{
		if(Check.checkDatasetIsUsed(datasetID) == true)
		{
			System.out.println("The dataset is being used now£¡");
			return true;
		}
		else return false;
	}
	
	public boolean cheakFormat(Integer fieldNumber, String record)
	{
		int fieldNum = 1;
		boolean inQuotes = false;
		char c;
		for (int i=0;i<record.length();i++)
		{
			c=record.charAt(i);
			if(c == '\"')
			{
				inQuotes = !inQuotes;
			}
			if(c == ',' && inQuotes == false)
			{
				fieldNum++;
			}
		}
		if(fieldNumber != fieldNum)
		{
			System.out.println("format conflict£¡");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void setDatasetBean(Integer datasetID)
	{
//		ct=new ConnDB().getConnection();
		try {
//			sm=ct.createStatement();
			ResultSet rs = DBQuery.query("select * from dataset where DSID='"+datasetID+"' ");
			if(rs.next())
			{
				db.setAll(rs.getInt("DSID"), rs.getString("DSName"), rs.getString("DSType"), rs.getString("DSPath"), 
						rs.getString("DSSource"), rs.getString("DSCreater"), rs.getString("DSCreaterCompany"), rs.getString("DSCreaterAddr"),
						rs.getString("DSCreaterPostcode"), rs.getString("DSPhone"), rs.getString("DSEmail"), rs.getString("DSRecordNumber"),
						rs.getString("DSFieldNumber"), rs.getString("DSSize"), rs.getString("DSTpye"), rs.getString("DSMetadataDescription"),
						rs.getString("DSUploader"), rs.getString("DSUploaderCompany"), rs.getString("DSUploaderAddr"), rs.getString("DSUploaderPostcode"),
						rs.getString("DSUploaderPhone"), rs.getString("DSUploaderEmail"), rs.getString("DSCreateTime"), rs.getString("DSUploadTime"),
						rs.getString("DSChangeTime"), rs.getString("DSDescription"));
			}
			DBQuery.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addRecord(Integer datasetID,String record)
	{
		try {       
            RandomAccessFile randomFile = new RandomAccessFile(db.getAbsolutePath(), "rw");      
            long fileLength = randomFile.length();             
            randomFile.seek(fileLength);      
            randomFile.writeBytes(record+"\r\n");      
            randomFile.close();      
        } catch (IOException e) {      
            e.printStackTrace();      
        } 
	}
	
	public void deleteRecord(Long recordLine)
	{
		int num = 0;
		BufferedReader br = null;
		try
		{
	     br = new BufferedReader(new FileReader(db.getAbsolutePath()));
	    String str = null;
	    List<String> list = new ArrayList<String>();
	    while( (str=br.readLine()) != null ){
	     ++num;
	     if( num == recordLine )
	      continue;
	     list.add(str);
	    }
	    BufferedWriter bw = new BufferedWriter(new FileWriter(db.getAbsolutePath()));
	    for( int i=0;i<list.size();i++ ){
	     bw.write(list.get(i).toString());
	     bw.newLine();
	    }
	    bw.flush();
	    bw.close();
	    System.out.println("delete success!");
		}catch (IOException e) {      
            e.printStackTrace();      
        } finally
        { 
			if (br != null)
			{ 
				try { 
					br.close(); 
				} 
				catch (IOException e1) { 
				} 
			}
		}
	}
	
	public void modifyRecord(Long recordLine, String record)
	{
		int num = 0;
		BufferedReader br = null;
		try
		{
	     br = new BufferedReader(new FileReader(db.getAbsolutePath()));
	    String str = null;
	    List<String> list = new ArrayList<String>();
	    while( (str=br.readLine()) != null ){
	     ++num;
	     if( num == recordLine )
	      {
	    	 list.add(record);
	      }
	     list.add(str);
	    }
	    BufferedWriter bw = new BufferedWriter(new FileWriter(db.getAbsolutePath()));
	    for( int i=0;i<list.size();i++ ){
	     bw.write(list.get(i).toString());
	     bw.newLine();
	    }
	    bw.flush();
	    bw.close();
	    System.out.println("delete success!");
		}catch (IOException e) {      
            e.printStackTrace();      
        } finally
        { 
			if (br != null)
			{ 
				try { 
					br.close(); 
				} 
				catch (IOException e1) { 
				} 
			}
		}
	}

	public void modifyDescriptionAdd(Integer datasetID)
	{
		File f = new File(db.getAbsolutePath());
		db.setRecordsNo(String.valueOf(Integer.parseInt(db.getRecordsNo())+1));
		db.setSize(String.valueOf(f.length()));
		Date date = new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String last_modification_time = df.format(date);
		db.setLastModificationTime(last_modification_time);
		DatasetBeanCl dbc = new DatasetBeanCl();
		dbc.modify(datasetID, db);
	}
	
	public void modifyDescriptionDel(Integer datasetID)
	{
		File f = new File(db.getAbsolutePath());
		db.setRecordsNo(String.valueOf(Integer.parseInt(db.getRecordsNo())-1));
		db.setSize(String.valueOf(f.length()));
		Date date = new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String last_modification_time = df.format(date);
		db.setLastModificationTime(last_modification_time);
		DatasetBeanCl dbc = new DatasetBeanCl();
		dbc.modify(datasetID, db);
	}
	
	public void modifyDescriptionMod(Integer datasetID)
	{
		File f = new File(db.getAbsolutePath());
		db.setSize(String.valueOf(f.length()));
		Date date = new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String last_modification_time = df.format(date);
		db.setLastModificationTime(last_modification_time);
		DatasetBeanCl dbc = new DatasetBeanCl();
		dbc.modify(datasetID, db);
	}
}
