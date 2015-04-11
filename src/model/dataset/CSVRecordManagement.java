package model.dataset;

public class CSVRecordManagement extends DatasetRecordManagement{

	@Override
	public boolean cheakFormat(Integer fieldNumber, String record) {
		
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
			if(c == ';' && inQuotes == false)
			{
				fieldNum++;
			}
		}
		if(fieldNumber != fieldNum)
		{
			System.out.println("���ݸ�ʽ��һ�£�");
			return false;
		}
		else
		{
			return true;
		}
	}

}
