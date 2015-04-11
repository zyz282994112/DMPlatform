<%@ page language="java" import="java.util.*,model.taskManager.*,java.util.Map.Entry,java.util.HashMap" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>

<div class="container">
<% Task task = (Task)request.getAttribute("task"); 
HashMap<String,String> hashmap =(HashMap<String,String>)request.getAttribute("hashmap");
%>
<div class="panel panel-default ">
<div class="panel-heading">
<h1>Edit Task </h1>
</div>

  <div class="panel-body">
        <form class="form-horizontal" role="form" method="post" action="EditTask.do?method=editTask">
        	<input id="hashmap" type="text" name="hashmap" style="display:none"/>
        		<div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">TaskID</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="TaskID" value=<%=task.getTaskID()%> >
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">TaskName</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="TaskName" value=<%=task.getTaskName()%> >
				    </div>
				  </div>
				 
				  
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">TaskDescription</label>   !!!!!!!!
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="TaskDescription" value=<%=task.getTaskDescription()%> >
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">TaskPriority</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="TaskPriority" value=<%=task.getTaskPriority()%> >
				    </div>
				  </div>
				  				  
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">TaskDSID</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="TaskDSID" value=<%=task.getTaskDSID()%>>
				    </div>
				  </div>
				   <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">AlgorithmID</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="AlgorithmID" value=<%=task.getAlgorithmID()%> >
				    </div>
				  </div>
				    
				
        
             <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button id = "jiazaibtn" type="submit" class="btn btn-default">提交</button>
				    </div>
				  </div>
				</form>
       </div>


</div>
</div>

<%@ include file="../../public/frame/bottom.jsp" %>
