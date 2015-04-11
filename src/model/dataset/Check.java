package model.dataset;

import java.util.ArrayList;

public class Check {
    public static boolean checkDatasetIsUsed(int id)
    {
        DatasetBeanCl dbc = new DatasetBeanCl();
        DatasetBean db = new DatasetBean();
        db = dbc.searchDsDescription(id);
        if(db.getCount() != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean cheakFilenameExist(String name, int id)
    {
    	DatasetBeanCl dbc = new DatasetBeanCl();
    	ArrayList<DatasetBean> al = dbc.searchAll();
    	for(DatasetBean db : al)
    	{
    		if(db.getId() == id)
    		{
    			continue;
    		}
    		String filename = db.getName();
    		if(name == null)
    		{
    			System.out.println("file name cannot be blank!");
    			return true;
    		}
    		if(name.equals(filename))
    		{
    			System.out.println("there exists a file with the same name!");
    			return true;
    		}
    	}
    	return false;
    }
}