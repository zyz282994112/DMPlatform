<%@ page language="java" import="java.util.*,model.taskManager.*,java.util.Map.Entry,java.util.HashMap" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>
<% TaskInstance taskinstance = (TaskInstance)request.getAttribute("taskinstance"); 
HashMap<String,String> hashmap =(HashMap<String,String>)request.getAttribute("hashmap");
%>

<div class="container">
<div class="panel">
<ul class="nav nav-tabs">
  <li class="active"><a href="CheckTaskInstance.do?TIID=<%=taskinstance.getTaskInstanceID()%>">任务实例信息</a></li>
</ul>
<div class="panel-body">
<table class="table table-condensed">
<h4>基本信息</h4>
<tr>
	<th>TIName</th>
	<td><%=taskinstance.getTaskInstanceName()%>	</td>
	<th>TaskID</th>
	<td><%=taskinstance.getTaskID()%></td>
	<th>TaskLatestRunTime</th>
	<td><%=taskinstance.getTaskLatestRunTime()%></td>
</tr>
<tr>
	<th>TaskName</th>
	<td><%=taskinstance.getTaskName()%></td>
	<th>TaskPriority</th>
	<td><%=taskinstance.getTaskPriority()%></td>
	<th>TaskCreateTime</th>
	<td><%=taskinstance.getTaskCreateTime()%></td>
</tr>
<tr>
	<th>UserName</th>
	<td><%=taskinstance.getUserName()%></td>
	<th>TaskDSName</th>
	<td><%=taskinstance.getTaskDSName()%></td>
	<th>TaskChangeTime</th>
	<td><%=taskinstance.getTaskChangeTime()%></td>
</tr>
<tr>
	<th></th>
	<td></td>
	<th></th>
	<td></td>
	<th></th>
	<td></td>
	<th></th>
	<td></td>
</tr>
</table>


<table class="table table-condensed">
<h4>算法信息</h4>
	<tr>
		<th>AlgorithmName</th>
		<td><%=taskinstance.getAlgorithmName()%></td>	
	</tr>
	<%for (Entry<String, String> entry : hashmap.entrySet()) { %>
	<tr>
		<th><%=entry.getKey() %></th>
		<td><%=entry.getValue()%></td>
	</tr>
	<% } %>
	<tr><th></th><td></td></tr>
</table>


<table class="table table-condensed">
<h4>其它信息</h4>
<tr>
	<th>TaskConfiguration</th>
	<td><%=taskinstance.getTaskConfiguration()%></td>
</tr>
<tr>
	<th>TaskDescription</th>
	<td><%=taskinstance.getTaskDescription()%></td>
</tr>
<tr><th></th><td></td></tr>
</table>

</div>
</div>
</div>


<%@ include file="/public/frame/bottom.jsp" %>
