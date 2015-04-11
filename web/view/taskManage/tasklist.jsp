<%@ page language="java" import="java.util.*,model.taskManager.*" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>

<div class="container">
	<div class="panel panel-default">
        <ul class="nav nav-tabs">
		  <li><a href="view/taskManage/addtask.jsp">新增任务</a></li>
		  <li class="active"><a href="TaskIndexServlet.do" >任务管理</a></li>
		  <li><a href="TaskInstanceIndex.do" >任务实例管理</a></li>
		</ul>
        <div class="panel-body">
	        <div class="table-responsive">
		        <table class="table table-striped table-bordered table-hover">
		        <tr>
		        <th>编号</th> 
		        <th>任务名称</th>       
		        <th>所用算法</th>
		        <th>数据集</th>
		        <th>运行次数</th>
		        <th>优先级</th>
		        <th>任务创建者</th>
		        <th>创建时间</th>
		        <th>查看任务</th>
		        <th>修改任务</th>
		        <th>终止任务</th>
		        <th>运行任务</th>
		        </tr>
		            <%
				 			List<Task> alltask=(List<Task>)request.getAttribute("alltask");
				 			int i=0;
			   				for(Task task : alltask){
			   					out.println("<tr>");
			   					i=i+1;
			   					out.println("<td>"+i);
			   					out.println("<td>"+task.getTaskName());
			   					out.println("<td>"+task.getAlgorithmName());
			   					out.println("<td>"+task.getTaskDSName());
			   					out.println("<td>"+task.getTaskRunNumber());
			   					out.println("<td>"+task.getTaskPriority());
			   					out.println("<td>"+task.getUserName());
			   					out.println("<td>"+task.getTaskCreateTime());
			   					out.println("<td><a href=\"TaskInfo.do?taskID="+task.getTaskID()+"\"><span class=\"glyphicon glyphicon-search \"></span>查看</a>");
			   					out.println("<td><a href=\"EditTask.do?method=getTaskInfo&taskID="+task.getTaskID()+"\"><span class=\"glyphicon glyphicon-wrench \"></span>修改</a>");
			   					out.println("<td><a onclick=\"return p_del()\" href=\"DeleteTaskServlet.do?taskID="+task.getTaskID()+"\"><span class=\"glyphicon glyphicon-trash \"></span>删除</a>");
			   					out.println("<td><a href=\"AddTaskInstanceServlet.do?taskID="+task.getTaskID()+"\"><span class=\"glyphicon glyphicon-trash \"></span>运行</a>");
			   					
			   					out.println("</tr>");
			   				}
				 		 %>
		        </table>
	        </div>
        </div>
	</div>
</div>

<%@ include file="/public/frame/bottom.jsp" %>