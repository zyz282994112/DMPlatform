<%@ page language="java" import="java.util.*,model.platform.*" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>

   
<div class="container">
   <div class="panel">
       <ul class="nav nav-tabs">
       		<li class="active"><a href="view/algorithm/addAlgo.jsp">增加算法</a></li>
            <li><a href="view/algorithm/delAlgo.jsp">删除算法</a></li>
            <li><a href="view/algorithm/modifyAlgo.jsp">修改算法</a></li>
            <li><a href="view/algorithm/queryAlgo.jsp">查询算法</a></li>
            <li><a href="view/algorithm/updateAlgo.jsp">更新算法</a></li>
		</ul>
        <div class="panel-body">  
	        <form class="form-horizontal" name="AddAlgorithm" action="addAlgorithm.dd" method="post" enctype="multipart/form-data" >
	                    <div class="form-group">
	                    	<label class="col-sm-2 control-label" for="Algorithm_Name">算法名称</label>
						    <div class="col-sm-2">
						    	<input class="form-control" id="Algorithm_Name" type="text" name="algorithmname"/>
						    </div>
					 	</div>
					 	<div class="form-group">
	                    	<label class="col-sm-2 control-label" for="Algorithm_Type">算法类型</label>
						    <div class="col-sm-2">
						    	<select class="form-control" id="Algorithm_Type" name="algorithmtype">
			                        <option value="cluster" selected="selected">聚类算法</option>
			                        <option value="class">分类算法</option>
			                        <option value="fim">频繁模式</option>
			                        <option value="outlie">异常算法</option>
                                    <option value="rule">关联规则</option>

			                    </select>
						    </div>
					 	</div>
					 	<div  class="form-group">
					 		<label class="col-sm-2 control-label" for="Algorithm_Path">算法配置</label>
						    <div class="col-sm-2">
						      <input id="Algorithm_Path" name="algorithmpath" class=" form-controls" type="file">
						    </div>
						 </div>
						 <div  class="form-group">
					 		<label id="train_label" class="col-sm-2 control-label" for="code_file">算法库包</label>
						    <div class="col-sm-2">
						      <input id="code_file" name="algorithmjar" class=" form-controls" type="file">
						    </div>
						 </div>
					 	<div class="form-group">
	                    	<label class="col-sm-2 control-label" for="Algorithm_Description">算法描述</label>
						    <div class="col-sm-3">
						    	<textarea class="form-control" id="Algorithm_Description" type="text" name="algorithmdescription"></textarea>
						    </div>
					 	</div>
	                    <div  class="form-group">
						    <div class="col-sm-2 col-sm-push-2">
						      <button type="submit" class="btn btn-primary">上传</button>
						    </div>
					 	</div>
	                </form>
				
		</div>
</div>
</div>

<%@ include file="/public/frame/bottom.jsp" %>