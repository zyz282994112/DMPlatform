package model.dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RecordFilter 
{
//	public static int recordFilter(int dataset, String condition)
//	{
//		return -1;
//	}
	
	public static int doRecordFilter(int datasetID, String fieldname, String operator, String value, String separator)
	{
		if(fieldname == null)
		{
			return -1;
		}
		ArrayList<FieldInfo> al = ETL.getFieldsInfo(datasetID);
		String type = new String();
		for(FieldInfo fi:al)
		{
			if(fi.getFieldName().equals(fieldname))
			{
				type = fi.getType();
				break;
			}
		}
		DatasetBeanCl dbc = new DatasetBeanCl();
		DatasetBean db = dbc.searchDsDescription(datasetID);
		String path = db.getAbsolutePath();
		//StringBuffer fileStringBuffer = new StringBuffer();
		File file = new File(path); 
		BufferedReader reader = null; 
		int newID = -1;
		int recordsNo = 0;
		//int line = 0;
		try { 
			reader = new BufferedReader(new FileReader(file)); 
			String record = null; 
			StringBuffer newFile = new StringBuffer();
			while ((record = reader.readLine()) != null){ 
			String field = ETL.getField(record, al, fieldname, separator);
			if(meetRequirement(field, type, operator, value))
			{
				newFile.append(record);
				newFile.append("\r\n");
				System.out.println(record);
				recordsNo++;
			}						
			}
			newID = getNewID(datasetID, newFile, recordsNo);
			System.out.println(newID);
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
	
	private static boolean meetRequirement(String field, String type, String operator, String value)
	{
		if(type.equalsIgnoreCase("int"))
		{
			return meet(Integer.parseInt(field), operator, Integer.parseInt(value));
		}
		if(type.equalsIgnoreCase("float") || type.equalsIgnoreCase("double"))
		{
			return meet(Double.parseDouble(field), operator, Double.parseDouble(value));
		}
		if(type.equalsIgnoreCase("string"))
		{
			return meet(field, operator, value);
		}
		return false;
	}

	private static boolean meet(int field, String operator, int value) 
	{
		if(operator == null || "".equals(operator)) return false;
		if("=".equals(operator))
		{
			return (field == value);
		}
		if(">".equals(operator))
		{
			return (field > value);
		}
		if("<".equals(operator))
		{
			return (field < value);
		}
		if("<>".equals(operator))
		{
			return (field != value);
		}
		if(">=".equals(operator))
		{
			return (field >= value);
		}
		if("<=".equals(operator))
		{
			return (field <= value);
		}
		return false;
	}
	
	private static boolean meet(double field, String operator, double value) 
	{
		if(operator == null || "".equals(operator)) return false;
		if("=".equals(operator))
		{
			return (field == value);
		}
		if(">".equals(operator))
		{
			return (field > value);
		}
		if("<".equals(operator))
		{
			return (field < value);
		}
		if("<>".equals(operator))
		{
			return (field != value);
		}
		if(">=".equals(operator))
		{
			return (field >= value);
		}
		if("<=".equals(operator))
		{
			return (field <= value);
		}
		return false;
	}
	
	private static boolean meet(String field, String operator, String value) 
	{
		if(operator == null || "".equals(operator)) return false;
		if("=".equals(operator))
		{
			return (field.equals(value));
		}
//		if("LIKE".equalsIgnoreCase(operator))
//		{
//			return field.startsWith(value);
//		}
		return false;
	}
	
	private static int getNewID(int datasetID, StringBuffer fileString, int recordsNo)
	{
		String upload = SystemConstants.UPLOADDIRECTORY;
//		String name = "temp.txt";
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
		db.setRecordsNo(String.valueOf(recordsNo));		
		db.setFieldsNo(dbRead.getFieldsNo());
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
		db.setName(dbRead.getName()+"_RecordFilter_"+newID);
		dbc.modify(newID, db);
		return newID;
	}
}
