package model.dataset;
import java.io.File;
import java.sql.*;
import java.util.*;

import model.platform.DBQuery;


public class DatasetBeanCl {
	//private Connection ct=null;
//	private Statement sm=null;
//	private ResultSet rs=null;
	
	//modify
	public boolean modify(int id,DatasetBean dataset){
			boolean modified = false;
			DatasetBean db = searchDsDescription(id);
			//rename file
			String filename = db.getFileName();
			String newFileName = dataset.getFileName();
			if(newFileName != null && !newFileName.equals(filename))
			{
				String path = new String();
				path += db.getSavingPath();
				path += "/";			
				File file = new File(path + filename);				
				if(!file.renameTo(new File(path + newFileName)))
				{
					System.out.println("Name conflict!");
					return false;
				}
				else {
					System.out.println("Rename success!");
				}
			}
			else 
			{
				System.out.println("Rename failure!");
			}
			try {
				//ct=new ConnDB().getConnection();
				//sm=ct.createStatement();
				String sql="update dataset set DSName='"+dataset.getName()+
						   "',DSType='"+dataset.getFileFormat()+
						   "',DSPath='"+dataset.getSavingPath()+
						   "',DSSource='"+dataset.getSource()+
						   "',DSCreater='"+dataset.getCreator()+
						   "',DSCreaterCompany='"+dataset.getCreatorCompany()+
						   "',DSCreaterAddr='"+dataset.getCreatorAddress()+
						   "',DSCreaterPostcode='"+dataset.getCreatorZipcode()+
						   "',DSPhone='"+dataset.getCreatorTelephone()+
						   "',DSEmail='"+dataset.getCreatorEmail()+   
						   "',DSRecordNumber='"+dataset.getRecordsNo()+
						   "',DSFieldNumber='"+dataset.getFieldsNo()+
						   "',DSSize='"+dataset.getSize()+
						   "',DSTpye='"+dataset.getRelationalCategory()+
						   "',DSMetadataDescription='"+dataset.getMetadataDescription()+
						   "',DSUploader='"+dataset.getUploader()+
						   "',DSUploaderCompany='"+dataset.getUploaderCompany()+
						   "',DSUploaderAddr='"+dataset.getUploaderAddress()+
						   "',DSUploaderPostcode='"+dataset.getUploaderZipcode()+
						   "',DSUploaderPhone='"+dataset.getUploaderTelephone()+
						   "',DSUploaderEmail='"+dataset.getUploaderEmail()+  
						   "',DSCreateTime='"+dataset.getCreateTime()+  
						   "',DSUploadTime='"+dataset.getUploadTime()+
						   "',DSChangeTime='"+dataset.getLastModificationTime()+  
						   "',DSDescription='"+dataset.getDescription()+						     
						   "' where DSID='"+id+"'";
				int rowCount = DBQuery.Update(sql,true);
				if(rowCount == 1)
				{
					modified = true;
				}
				DBQuery.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return modified;
	}
	
	//insert
	public int addDataset(DatasetBean dataset){
		//boolean sta=false;
		int rowCount=0, newId=0;
//		ct=new ConnDB().getConnection();
		try {
//			sm=ct.createStatement();
			ResultSet rs = DBQuery.query("select max(DSID) from dataset");
			while(rs.next()){newId=rs.getInt(1)+1;}
			if(Check.cheakFilenameExist(dataset.getName(),newId))
			{
				System.out.println("DatasetBeanCl.java:file name exists!");
				return -1;
			}
			String sql= "insert into dataset (DSID,DSName,DSType,DSPath,DSSource,DSCreater," +
              		"DSCreaterCompany,DSCreaterAddr,DSCreaterPostcode,DSPhone," +
              		"DSEmail,DSRecordNumber,DSFieldNumber,DSSize,DSTpye," +
              		"DSMetadataDescription,DSUploader,DSUploaderCompany,DSUploaderAddr," +
              		"DSUploaderPostcode,DSUploaderPhone,DSUploaderEmail,DSCreateTime," +
              		"DSUploadTime,DSChangeTime,DSDescription)" +
                		"values('" +
                		newId + "','" +
                		dataset.getName() + "','" +
                		dataset.getFileFormat() + "','" +
                		dataset.getSavingPath() + "','" +
                		dataset.getSource() + "','" +
                		dataset.getCreator() + "','" +
                		dataset.getCreatorCompany() + "','" +
                		dataset.getCreatorAddress() + "','" +
                		dataset.getCreatorZipcode() + "','" +
                		dataset.getCreatorTelephone() + "','" +
                		dataset.getCreatorEmail() + "','" +
                		dataset.getRecordsNo() + "','" +
                		dataset.getFieldsNo() + "','" +
                		dataset.getSize() + "','" +
                		dataset.getRelationalCategory() + "','" +
                		dataset.getMetadataDescription() + "','" +
                		dataset.getUploader() + "','" +
                		dataset.getUploaderCompany() + "','" +
                		dataset.getUploaderAddress() + "','" +
                		dataset.getUploaderZipcode() + "','" +
                		dataset.getUploaderTelephone() + "','" +
                		dataset.getUploaderEmail() + "','" +
                		dataset.getCreateTime() + "','"+
                		dataset.getUploadTime() + "','" +
                		dataset.getLastModificationTime() + "','" +
                		dataset.getDescription() + "')" ;                		                		
			rowCount = DBQuery.Update(sql, true);
			DSMetadataBean dsmb = new DSMetadataBean(newId,"");
			DSMetadataBeanCl dsmbc = new DSMetadataBeanCl();
			dsmbc.addDSMetadata(dsmb);
			DBQuery.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowCount == 1)
		{
			return newId;
		}
		else
		{
			return -1;
		}
	}
	
	//search by id
	public DatasetBean searchDsDescription(int id)
	{
//		ct=new ConnDB().getConnection();
		DatasetBean db = new DatasetBean();
		try {
//			sm=ct.createStatement();
			ResultSet rs = DBQuery.query("select * from dataset where DSID='"+id+"' ");
			
			if(rs.next())
			{
				db.setAll(rs.getInt("DSID"), rs.getString("DSName"), rs.getString("DSType"), rs.getString("DSPath"), 
						rs.getString("DSSource"), rs.getString("DSCreater"), rs.getString("DSCreaterCompany"), rs.getString("DSCreaterAddr"),
						rs.getString("DSCreaterPostcode"), rs.getString("DSPhone"), rs.getString("DSEmail"), rs.getString("DSRecordNumber"),
						rs.getString("DSFieldNumber"), rs.getString("DSSize"), rs.getString("DSTpye"), rs.getString("DSMetadataDescription"),
						rs.getString("DSUploader"), rs.getString("DSUploaderCompany"), rs.getString("DSUploaderAddr"), rs.getString("DSUploaderPostcode"),
						rs.getString("DSUploaderPhone"), rs.getString("DSUploaderEmail"), rs.getString("DSCreateTime"), rs.getString("DSUploadTime"),
						rs.getString("DSChangeTime"), rs.getString("DSDescription"));	
//				sm.close();
//				ct.close();
				DBQuery.closeDB();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db;	
	}
	
	//serach function,return all the results
	public ArrayList<DatasetBean> searchAll()
	{
		ArrayList<DatasetBean> al=new ArrayList<DatasetBean>();
//		ct=new ConnDB().getConnection();
		try {
//			sm=ct.createStatement();
//			rs=sm.executeQuery("select * from dataset");
			ResultSet rs = DBQuery.query("select * from dataset");
			while(rs.next())
			{
				DatasetBean db = new DatasetBean();
				db.setAll(rs.getInt("DSID"), rs.getString("DSName"), rs.getString("DSType"), rs.getString("DSPath"), 
						rs.getString("DSSource"), rs.getString("DSCreater"), rs.getString("DSCreaterCompany"), rs.getString("DSCreaterAddr"),
						rs.getString("DSCreaterPostcode"), rs.getString("DSPhone"), rs.getString("DSEmail"), rs.getString("DSRecordNumber"),
						rs.getString("DSFieldNumber"), rs.getString("DSSize"), rs.getString("DSTpye"), rs.getString("DSMetadataDescription"),
						rs.getString("DSUploader"), rs.getString("DSUploaderCompany"), rs.getString("DSUploaderAddr"), rs.getString("DSUploaderPostcode"),
						rs.getString("DSUploaderPhone"), rs.getString("DSUploaderEmail"), rs.getString("DSCreateTime"), rs.getString("DSUploadTime"),
						rs.getString("DSChangeTime"), rs.getString("DSDescription"));
				al.add(db);
			}
//			sm.close();
//			ct.close();
			DBQuery.closeDB(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;	
	}
	
	//delete function
	public boolean deleteDataset(int id)
	{
		//delete file
		DatasetBean db = searchDsDescription(id);
		String path = db.getAbsolutePath();
		File file = new File(path);  
		    if (file.isFile() && file.exists()) {  
		        file.delete();
		    }
		boolean deleted=false;		
		int rowCount = 0;
		try {
			String sql="delete from dataset where DSID="+id;
			rowCount=DBQuery.Update(sql, true);
			DSMetadataBeanCl dsmbc = new DSMetadataBeanCl();
			dsmbc.deleteDSMetadata(id);
			DBQuery.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowCount == 1)
		{
			deleted = true;
		} 
		return deleted;	
	}
}
