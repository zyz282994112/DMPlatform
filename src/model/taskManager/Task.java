package model.taskManager;

public class Task {
	private String TaskID;
	//����id
	private String TaskName;
	//������
	private String UserID;
	//�û�id
	
	private String TaskConfiguration;
	//��������
	private String TaskDSID;
	//�����������ݼ�id
	
	private String TaskCreateTime;
	//���񴴽�ʱ��
	private String TaskChangeTime;
	//�����޸�ʱ��
	private String TaskDescription;
	//��������
	private String TaskPriority;
	//�������ȼ�
	private String AlgorithmID;
	//���������㷨id
	
	private String TaskLatestRunTime;
	//�����ϴ�����ʱ��
	private String TaskRunNumber;
	//����������������
	
	private String TaskResultPath;
	//������Ŀ¼
	
	private String UserName;
	//�û���
	private String TaskDSName;
	//�����������ݼ�����
	private String AlgorithmName;
	//���������㷨��
	
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
