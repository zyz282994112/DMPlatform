<%@ page language="java" import="java.util.*,model.taskManager.*,java.util.Map.Entry,java.util.HashMap" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>
<% Task task = (Task)request.getAttribute("task"); 
HashMap<String,String> hashmap =(HashMap<String,String>)request.getAttribute("hashmap");
%>

<div class="container">
<div class="panel">
<ul class="nav nav-tabs">
  <li class="active"><a href="TaskInfo.do?taskID=<%=task.getTaskID()%>">查看任务</a></li>
  <li><a href="EditTask.do?method=getTaskInfo&taskID=<%=task.getTaskID()%>">修改任务</a></li>
  <li><a href="AddTaskInstanceServlet.do?taskID=<%=task.getTaskID()%>">运行任务</a></li>
</ul>
<div class="panel-body">
<table class="table table-condensed">
<h4>基本信息</h4>
<tr>
	<th>ID</th>
	<td><%=task.getTaskID()%>	</td>
	<th>名称</th>
	<td><%=task.getTaskName()%></td>
	<th>创建时间</th>
	<td><%=task.getTaskCreateTime()%></td>
</tr>
<tr>
	<th>优先级</th>
	<td><%=task.getTaskPriority()%></td>
	<th>运行次数</th>
	<td><%=task.getTaskRunNumber()%></td>
	<th>更改时间</th>
	<td><%=task.getTaskChangeTime()%></td>
</tr>
<tr>
	<th>用户名</th>
	<td><%=task.getUserName()%></td>
	<th>数据集</th>
	<td><%=task.getTaskDSName()%></td>
	<th>上次运行时间</th>
	<td><%=task.getTaskLatestRunTime()%></td>
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
		<th>算法名称</th>
		<td><%=task.getAlgorithmName()%></td>	
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
	<th>任务配置信息</th>
	<td><%=task.getTaskConfiguration()%></td>
</tr>
<tr>
	<th>任务描述</th>
	<td><%=task.getTaskDescription()%></td>
</tr>
<tr>
	<th>结果存储路径</th>
	<td><%=task.getTaskResultPath()%></td>
</tr>
<tr><th></th><td></td></tr>
</table>

</div>
</div>
</div>


<%@ include file="/public/frame/bottom.jsp" %>
