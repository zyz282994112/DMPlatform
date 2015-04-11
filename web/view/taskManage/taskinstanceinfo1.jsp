<%@ page language="java" import="java.util.*,model.taskManager.*,java.util.Map.Entry,java.util.HashMap" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>

<div class="container">
<% TaskInstance taskinstance = (TaskInstance)request.getAttribute("taskinstance"); 
HashMap<String,String> hashmap =(HashMap<String,String>)request.getAttribute("hashmap");

%>
<div class="panel panel-default col-md-10">
<div class="panel-heading">
<h1>TaskInstance Information</h1>
</div>
<div class="panel-body">
<br><div class = "row">
<div class = "col-md-2">
	TIName:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getTaskInstanceName()%>	
	</div>
</div>
<div class = "col-md-2">
	TaskID:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getTaskID()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		TaskName:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getTaskName()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		TaskConfiguration:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getTaskConfiguration()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		TaskCreateTime:
	</div>
	<div class = "cotask.get()-md-10">
		<%=taskinstance.getTaskCreateTime()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		TaskChangeTime:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getTaskChangeTime()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		TaskDescription:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getTaskDescription()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		TaskPriority:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getTaskPriority()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		TaskLatestRunTime:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getTaskLatestRunTime()%>	
	</div>
</div>

<br><div class = "row">
	<div class = "col-md-2">
		UserName:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getUserName()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		TaskDSName:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getTaskDSName()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		AlgorithmName:
	</div>
	<div class = "col-md-10">
		<%=taskinstance.getAlgorithmName()%>	
	</div>
</div>

	
</div>


</div>
</div>
</div>

<%@ include file="../../public/frame/bottom.jsp" %>
