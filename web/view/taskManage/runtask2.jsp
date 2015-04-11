<%@ page language="java" import="java.util.*,model.taskManager.*,java.util.Map.Entry,java.util.HashMap" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>
<% Task task = (Task)request.getAttribute("task"); 
HashMap<String,String> hashmap =(HashMap<String,String>)request.getAttribute("hashmap");
%>

<script type="text/javascript">
function validate_form(thisform)
{
with (thisform)
  {
  if (validate_required(TaskDSID,"TaskDSID must be filled out!")==false)
    {TaskDSID.focus();return false;};
  if (validate_required(TaskPriority,"TaskPriority must be filled out!")==false)
    {TaskPriority.focus();return false;};
  if (validate_required(TaskPriority,"TaskPriority must be filled out!")==false)
    {TaskPriority.focus();return false;};
    
  }
}

$(document).ready(function(){
$("#algobtn").click(function(){
	$("#editalgo").show();
})});

$(document).ready(function(){
$("#jiazaibtn").click(function(){
		var map = "";   
	$("#option").each(   
	            function(){    
	            	map += $(this).attr('name') + "="+$(this).val() + "&"; 
	            }   
	 );
	alert(map);
	document.getElementById('hashmap').value = map;
});});
</script>


<div class="container">
	<div class="panel">
		<ul class="nav nav-tabs">
		  <li><a href="TaskInfo.do?taskID=<%=task.getTaskID()%>">查看任务</a></li>
		  <li class="active"><a href="EditTask.do?method=getTaskInfo&taskID=<%=task.getTaskID()%>">修改任务</a></li>
		  <li><a href="AddTaskInstanceServlet.do?taskID=<%=task.getTaskID()%>">运行任务</a></li>
		</ul>
		<div class="panel-body">
 			<form class="form-horizontal" method="post" onsubmit="return validate_form(this)" action="EditTask.do?method=editTask">
			      <input id="hashmap" type="text" name="hashmap" style="display:none"/>
			      <input type="text" name="AlgorithmID" value="<%=task.getAlgorithmID()%>" style="display:none"/>
			      <div  class="form-group">
				    <label class="col-sm-2 control-label">TaskID</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="TaskID" value="<%=task.getTaskID()%>" readonly>
				    </div>
				    <label  class="col-sm-2 control-label">TaskName</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="TaskName"  value="<%=task.getTaskName()%>">
				    </div>
				  </div>
				  
				  <div class="form-group">  
				    <label class="col-sm-2 control-label">TaskPriority</label>
				    <div class="col-sm-3">
				      <input type="number" class="form-control" name="TaskPriority" value="<% out.print(task.getTaskPriority()); %>">
				    </div>
				    <label class="col-sm-2 control-label">TaskDSID</label>
				    <div class="col-sm-3">
				      <input type="number" class="form-control" name="TaskDSID" value="<% out.print(task.getTaskDSID()); %>">
				    </div>
				  </div>
				  
				   <div class="form-group">  
				    <label class="col-sm-2 control-label">TaskDescription</label>
				    <div class="col-sm-4">
				      <textarea row="10" type="text" class="form-control" name="TaskDescription" value="<% out.print(task.getTaskDescription()); %>"></textarea>
				    </div>
				    <div class="col-sm-offset-1 col-sm-2">
				      <a id="algobtn" class="btn btn-default">更改算法</a>
				    </div>
				  </div>
				
				<div id="editalgo" class="form-group" style="display:none">
				    <label  class="col-sm-2 control-label">选择算法</label>
				    <div class="col-sm-2">
				      <select id="Algorithm_Name" class="form-control" name="algorithmList" onchange="adjustInput11(this.options[this.options.selectedIndex].value)"></select>
		                <div id="parent">
		                    <div id="replace"></div>
		                </div>
				    </div>
				</div>			  
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-3">
				      <button id="jiazaibtn" type="submit" class="btn btn-success">提交</button>
				      <a class="btn btn-default" href="TaskInfo.do?taskID=<%=task.getTaskID()%>">取消</a>
				    </div>
				  </div>
				</form>					
		</div>
	
	</div>
</div>

<%@ include file="/public/frame/bottom.jsp" %>

