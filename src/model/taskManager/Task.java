package model.taskManager;

public class Task {
	private String TaskID;
	//任务id
	private String TaskName;
	//任务名
	private String UserID;
	//用户id
	
	private String TaskConfiguration;
	//任务配置
	private String TaskDSID;
	//任务所用数据集id
	
	private String TaskCreateTime;
	//任务创建时间
	private String TaskChangeTime;
	//任务修改时间
	private String TaskDescription;
	//任务描述
	private String TaskPriority;
	//任务优先级
	private String AlgorithmID;
	//任务所用算法id
	
	private String TaskLatestRunTime;
	//任务上次运行时间
	private String TaskRunNumber;
	//任务正在运行数量
	
	private String TaskResultPath;
	//任务结果目录
	
	private String UserName;
	//用户名
	private String TaskDSName;
	//任务所用数据集名称
	private String AlgorithmName;
	//任务所用算法名
	
	public String getTaskID() {
		return TaskID;
	}
	public void setTaskID(String taskID) {
		TaskID = taskID;
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	
	
	public String getTaskConfiguration() {
		return TaskConfiguration;
	}
	public void setTaskConfiguration(String taskConfiguration) {
		TaskConfiguration = taskConfiguration;
	}
	public String getTaskDSID() {
		return TaskDSID;
	}
	public void setTaskDSID(String taskDSID) {
		TaskDSID = taskDSID;
	}
	public String getTaskCreateTime() {
		return TaskCreateTime;
	}
	public void setTaskCreateTime(String taskCreateTime) {
		TaskCreateTime = taskCreateTime;
	}
	public String getTaskChangeTime() {
		return TaskChangeTime;
	}
	public void setTaskChangeTime(String taskChangeTime) {
		TaskChangeTime = taskChangeTime;
	}
	public String getTaskDescription() {
		return TaskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		TaskDescription = taskDescription;
	}
	public String getTaskPriority() {
		return TaskPriority;
	}
	public void setTaskPriority(String taskPriority) {
		TaskPriority = taskPriority;
	}
	public String getAlgorithmID() {
		return AlgorithmID;
	}
	public void setAlgorithmID(String algorithmID) {
		AlgorithmID = algorithmID;
	}
	public String getTaskLatestRunTime() {
		return TaskLatestRunTime;
	}
	public void setTaskLatestRunTime(String taskLatestRunTime) {
		TaskLatestRunTime = taskLatestRunTime;
	}
	
	public String getTaskDSName() {
		return TaskDSName;
	}
	public void setTaskDSName(String taskDSName) {
		TaskDSName = taskDSName;
	}
	public String getTaskResultPath() {
		return TaskResultPath;
	}
	public void setTaskResultPath(String taskResultPath) {
		TaskResultPath = taskResultPath;
	}

	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getAlgorithmName() {
		return AlgorithmName;
	}
	public void setAlgorithmName(String algorithmName) {
		AlgorithmName = algorithmName;
	}
	public String getTaskRunNumber() {
		return TaskRunNumber;
	}
	public void setTaskRunNumber(String taskRunNumber) {
		TaskRunNumber = taskRunNumber;
	}

}
