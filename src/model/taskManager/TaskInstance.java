package model.taskManager;

public class TaskInstance {
	private String TaskInstanceID;
	private String TaskInstanceName;

	private String TaskInstanceConfiguration;
	private String TaskInstanceDSID;
	private String TaskInstanceResultID;
	private String TaskInstanceDSName;
	private String TaskInstanceResultName;
	private String TaskInstanceStartTime;
	private String TaskInstanceSuspendTime;
	private String TaskInstanceEndTime;
	private String TaskInstanceResultPath;
	private String TIDescription;
	private String ProcessID;
	private String TaskID;
	private String TaskName;
	private String UserID;
	private String UserName;
	private String TaskConfiguration;
	private String TaskDSID;
	private String TaskCreateTime;
	private String TaskChangeTime;
	private String TaskDescription;
	//任务实例的描述信息
	private String TaskPriority;
	private String AlgorithmID;
	private String AlgorithmName;
	private String TaskLatestRunTime;
	private String TaskRunTime;
	private String TaskDSName;
	private String TIState;
	//新添加的字段，表示运行状态:0代表运行成功，-1运行失败，1代表终止，2代表暂停
	
	public String getTaskInstanceName() {
		return TaskInstanceName;
	}
	public void setTaskInstanceName(String taskInstanceName) {
		TaskInstanceName = taskInstanceName;
	}
	public String getTaskInstanceID() {
		return TaskInstanceID;
	}
	public void setTaskInstanceID(String taskInstanceID) {
		TaskInstanceID = taskInstanceID;
	}
	public String getTaskInstanceConfiguration() {
		return TaskInstanceConfiguration;
	}
	public void setTaskInstanceConfiguration(String taskInstanceConfiguration) {
		TaskInstanceConfiguration = taskInstanceConfiguration;
	}
	public String getTaskInstanceDSID() {
		return TaskInstanceDSID;
	}
	public void setTaskInstanceDSID(String taskInstanceDSID) {
		TaskInstanceDSID = taskInstanceDSID;
	}
	public String getTaskInstanceResultID() {
		return TaskInstanceResultID;
	}
	public void setTaskInstanceResultID(String taskInstanceResultID) {
		TaskInstanceResultID = taskInstanceResultID;
	}
	public String getTaskInstanceDSName() {
		return TaskInstanceDSName;
	}
	public void setTaskInstanceDSName(String taskInstanceDSName) {
		TaskInstanceDSName = taskInstanceDSName;
	}
	public String getTaskInstanceResultName() {
		return TaskInstanceResultName;
	}
	public void setTaskInstanceResultName(String taskInstanceResultName) {
		TaskInstanceResultName = taskInstanceResultName;
	}
	public String getTaskInstanceStartTime() {
		return TaskInstanceStartTime;
	}
	public void setTaskInstanceStartTime(String taskInstanceStartTime) {
		TaskInstanceStartTime = taskInstanceStartTime;
	}
	public String getTaskInstanceSuspendTime() {
		return TaskInstanceSuspendTime;
	}
	public void setTaskInstanceSuspendTime(String taskInstanceSuspendTime) {
		TaskInstanceSuspendTime = taskInstanceSuspendTime;
	}
	public String getTaskInstanceEndTime() {
		return TaskInstanceEndTime;
	}
	public void setTaskInstanceEndTime(String taskInstanceEndTime) {
		TaskInstanceEndTime = taskInstanceEndTime;
	}
	public String getTaskInstanceResultPath() {
		return TaskInstanceResultPath;
	}
	public void setTaskInstanceResultPath(String taskInstanceResultPath) {
		TaskInstanceResultPath = taskInstanceResultPath;
	}
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
	public String getAlgorithmName() {
		return AlgorithmName;
	}
	public void setAlgorithmName(String algorithmName) {
		AlgorithmName = algorithmName;
	}
	public String getTaskLatestRunTime() {
		return TaskLatestRunTime;
	}
	public void setTaskLatestRunTime(String taskLatestRunTime) {
		TaskLatestRunTime = taskLatestRunTime;
	}
	public String getTaskRunTime() {
		return TaskRunTime;
	}
	public void setTaskRunTime(String taskRunTime) {
		TaskRunTime = taskRunTime;
	}
	public String getTaskDSName() {
		return TaskDSName;
	}
	public void setTaskDSName(String taskDSName) {
		TaskDSName = taskDSName;
	}
	public String getTIState() {
		return TIState;
	}
	
	public void setTIState(String tIState) {
		TIState = tIState;
	}
	public String getTIDescription() {
		return TIDescription;
	}
	public void setTIDescription(String tIDescription) {
		TIDescription = tIDescription;
	}
	public String getProcessID() {
		return ProcessID;
	}
	public void setProcessID(String pID) {
		ProcessID = pID;
	}

}
