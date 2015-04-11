package model.dataset;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.platform.DBQuery;

public class DSMetadataBeanCl {
	//private DSMetadataBean dsMetadata;
	
	//add dsmetadata
	public int addDSMetadata(DSMetadataBean dsMetadata){
		int rowsAffected = 0;
		try {
			String sql= "insert into dsmetadata " +
						"(DSID,DSTableHeadDefined,DSFieldsInfo) values('"  +
                		dsMetadata.getId() + "','" +
                		dsMetadata.getTableHeadDefined() + "','" +
                		dsMetadata.getFieldsInfo()
                		+ "')" ;                		                             		
			//执行返回一个int值，表示影响的行数
			rowsAffected=DBQuery.Update(sql, true);
			DBQuery.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsAffected==1){return dsMetadata.getId();}
		else
		{
			return -1;
		}
	}
	
	//delete dsmetadata
	public boolean deleteDSMetadata(int id)
	{
		boolean deleted=false;
		int rowsAffected=0;
		try {
			String sql="delete from dsmetadata where DSID="+id;
			rowsAffected=DBQuery.Update(sql, true);
			DBQuery.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowsAffected==1){deleted=true;}
		return deleted;
	}
	
	//modify dsmetadata
	public boolean modify(int id, DSMetadataBean dsMetadata){
		boolean modified=false;
		int rowsAffected=0;
		if(id != dsMetadata.getId())
		{
			return false;
		}
		try {
			String sql="update dsmetadata set DSFieldsInfo='"
						+dsMetadata.getFieldsInfo()+
						"',DSTableHeadDefined='"+dsMetadata.getTableHeadDefined()+
						"' where DSID='"+id+"'";
			rowsAffected=DBQuery.Update(sql, true);
			DBQuery.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rowsAffected==1){modified=true;}
		return modified;
	}
	
	//read dsmetadata
	public DSMetadataBean read(int id)
	{
		DSMetadataBean dsMetadata = null;
		try {
			ResultSet rs = DBQuery.query("select * from dsmetadata where DSID='"+id+"' ");
			if(rs.next())
			{
				dsMetadata = new DSMetadataBean(rs.getInt("DSID"), rs.getString("DSFieldsInfo"));							
			}
			DBQuery.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsMetadata;	
	}
}
