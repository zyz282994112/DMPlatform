package model.dataset;

public class CheckDsIsUsed {
    public static boolean isUsed(int id)
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
}