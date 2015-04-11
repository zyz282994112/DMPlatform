<%@ page language="java" import="java.util.*,model.taskManager.*" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>

 <div class="container">
	<div class="panel panel-default">
        <ul class="nav nav-tabs">
		  <li><a href="view/taskManage/addtask.jsp">新增任务</a></li>
		  <li><a href="TaskIndexServlet.do" >任务管理</a></li>
		  <li class="active"><a href="TaskInstanceIndex.do" >任务实例管理</a></li>
		</ul>
        <div class="panel-body">
	        <div class="table-responsive">
	        <table class="table table-striped table-bordered table-hover">
	        <tr>
	        <th>编号</th> 
	        <th>实例名称</th>
	        <th>运行状态</th>
	        <th>任务名称</th>       
	        <th>所用算法</th>
	        <th>所用数据集</th>
	        <th>开始时间</th>
	        <th>结束时间</th>
	        <th>查看</th>
	        <th>终止</th>
	        <th>运行</th>
	        </tr>
	            <%
			 			List<TaskInstance> alltaskinstance =(List<TaskInstance>)request.getAttribute("alltaskinstance");
			 			int i=0;
		   				for(TaskInstance taskinstance : alltaskinstance){
		   					out.println("<tr>");
		   					i=i+1;
		   					out.println("<td>"+i);
		   					out.println("<td>"+taskinstance.getTaskInstanceName());
		   					out.println("<td>"+taskinstance.getTIState());
		   					out.println("<td>"+taskinstance.getTaskName());
		   					out.println("<td>"+taskinstance.getAlgorithmName());
		   					out.println("<td>"+taskinstance.getTaskDSName());
		   					out.println("<td>"+taskinstance.getTaskInstanceStartTime());
		   					out.println("<td>"+taskinstance.getTaskInstanceEndTime());
		   					out.println("<td><a href=\"CheckTaskInstance.do?TIID="+taskinstance.getTaskInstanceID()+"\"><span class=\"glyphicon glyphicon-search \"></span>查看</a>");
		   					out.println("<td><a href=\"StopTaskInstance.do?TIID="+taskinstance.getTaskInstanceID()+"\"><span class=\"glyphicon glyphicon-trash \"></span>终止</a>");
		   					out.println("<td><a onclick=\"return p_del()\" href=\"DeleteTaskInstance.do?TIID="+taskinstance.getTaskInstanceID()+"\"><span class=\"glyphicon glyphicon-trash \"></span>删除</a>");
		   					
		   					out.println("</tr>");
		   					
		   				}
			 		 %>
	
	        </table>
	        </div>

        </div>

        </div>
        </div>

        <%@ include file="../../public/frame/bottom.jsp" %>