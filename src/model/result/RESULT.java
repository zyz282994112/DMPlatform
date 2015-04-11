package model.result;

public class RESULT {
	private int ResultID;
	private String ResultName;
	private String ResultPath;
	private int TaskID;
	private String TaskName;
	private int TIID;
	private String TIName;
	private String ResultType;
	private String ResultTime;
	private String ResultDescription;
	
	public void setResultID(int ResultID) {
		this.ResultID = ResultID;
	}

	public int getResultID() {
		return ResultID;
	}

	public void setResultName(String ResultName) {
		this.ResultName = ResultName;
	}

	public String getResultName() {
		return ResultName;
	}

	public void setResultPath(String ResultPath) {
		this.ResultPath = ResultPath;
	}

	public String getResultPath() {
		return ResultPath;
	}

	public void setTaskID(int TaskID) {
		this.TaskID = TaskID;
	}

	public int getTaskID() {
		return TaskID;
	}

	public void setTaskName(String TaskName) {
		this.TaskName = TaskName;
	}

	public String getTaskName() {
		return TaskName;
	}
		
	public void setTIID(int TIID) {
		this.TIID = TIID;
	}

	public int getTIID() {
		return TIID;
	}

	public void setTIName(String TIName) {
		this.TIName = TIName;
	}

	public String getTIName() {
		return TIName;
	}

	public void setResultType(String ResultType) {
		this.ResultType = ResultType;
	}

	public String getResultType() {
		return ResultType;
	}

	public void setResultTime(String ResultTime) {
		this.ResultTime = ResultTime;
	}

	public String getResultTime() {
		return ResultTime;
	}

	public void setResultDescription(String ResultDescription) {
		this.ResultDescription = ResultDescription;
	}

	public String getResultDescription() {
		return ResultDescription;
	}
}