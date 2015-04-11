<%@ page language="java" import="java.util.*,model.platform.*" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>

   
<div class="container">
   <div class="panel">
       <ul class="nav nav-tabs">
       		<li><a href="view/algorithm/addAlgo.jsp">增加算法</a></li>
            <li><a href="view/algorithm/delAlgo.jsp">删除算法</a></li>
            <li><a href="view/algorithm/modifyAlgo.jsp">修改算法</a></li>
            <li><a href="view/algorithm/queryAlgo.jsp">查询算法</a></li>
            <li class="active"><a href="view/algorithm/updateAlgo.jsp">更新算法</a></li>
		</ul>
        <div class="panel-body">  
	        <form class="form-horizontal" action="uploadJar.dd" method="post" enctype="multipart/form-data" >
	                    <div class="form-group">
	                    	<label class="col-sm-2 control-label" for="Algorithm_Name">算法名称</label>
						    <div class="col-sm-2">
						    	<select class="form-control" id="Algorithm_Name" name="algorithmIdSelect" onchange="showADesInfoForQuery(this.options[this.options.selectedIndex].value)">
                				</select>
						    </div>
					 	</div>
					 	
						 <div  class="form-group">
					 		<label id="train_label" class="col-sm-2 control-label" for="code_file">算法库包</label>
						    <div class="col-sm-2">
						      <input id="code_file" name="trainJarFile" class=" form-controls" type="file">
						    </div>
						 </div>
	                    <div  class="form-group">
						    <div class="col-sm-2 col-sm-push-2">
						      <button type="submit" class="btn btn-primary">更新</button>
						    </div>
					 	</div>
	                </form>
				
		</div>
</div>
</div>

<%@ include file="/public/frame/bottom.jsp" %>