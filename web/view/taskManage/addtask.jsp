<%@ page language="java" import="java.util.*,model.platform.*,model.algorithm.utils.*,java.sql.ResultSet" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>

<div class="container">
	<div class="panel panel-default">
       <ul class="nav nav-tabs">
		  <li class="active"><a href="view/taskManage/addtask.jsp">新增任务</a></li>
		  <li><a href="TaskIndexServlet.do" >任务管理</a></li>
		  <li><a href="TaskInstanceIndex.do" >任务实例管理</a></li>
		</ul>
        <div class="panel-body">
        <form class="form-horizontal" role="form" method="post" action="AddTaskServlet.do">
        	<input id="hashmap" type="text" name="hashmap" style="display:none"/>
        	<div  class="form-group">
			    <label  class="col-sm-2 control-label">任务名称</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" name="TaskName">
			    </div>
			</div>
			<div  class="form-group">
			    <label  class="col-sm-2 control-label">数据集编号</label>
			    <div class="col-sm-1">
			      <input type="number" class="form-control" name="TaskDSID">
			    </div>
			</div>
			<div  class="form-group">
			    <label  class="col-sm-2 control-label">任务优先级</label>
			    <div class="col-sm-1">
			      <input type="number" class="form-control" name="TaskPriority">
			    </div>
			</div>
			<div  class="form-group">
			    <label  class="col-sm-2 control-label">选择算法</label>
			    <div class="col-sm-2">
			      <select id="Algorithm_Name" class="form-control" name="algorithmList" onchange="adjustInput11(this.options[this.options.selectedIndex].value)"></select>
	                <div id="parent">
	                    <div id="replace"></div>
	                </div>
			    </div>
			</div>	 
		  <div class="form-group">
		    <label  class="col-sm-2 control-label">任务描述</label>
		    <div class="col-sm-3">
		    	<textarea rows="6" class="form-control" type="text" name="TaskDescription"></textarea>
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
<%@ include file="/public/frame/bottom.jsp" %>  
      
<script>
$("#jiazaibtn").click(function(){
		var map = "";   
	$("input[id='option']").each(
	            function(){    
	            	map += $(this).attr('name') + "="+$(this).val() + "&"; 
	            }   
	 );
	alert(map);
	document.getElementById('hashmap').value = map;
});
</script>
 			
			 


