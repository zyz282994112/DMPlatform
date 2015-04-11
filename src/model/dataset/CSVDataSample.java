package model.dataset;

public class CSVDataSample extends DataSample{
	public CSVDataSample()
	{
		dsrmRead = new CSVRecordManagement();
		dsrmWrite = new CSVRecordManagement();
	}
}
