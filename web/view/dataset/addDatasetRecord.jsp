<%@ page language="java" import="java.lang.String" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>

   
<div class="container">
   <div class="panel">
       <ul class="nav nav-tabs">
       	  <li><a href="ManageDataset.do">数据集管理</a></li>
		  <li><a href="view/dataset/importFile.jsp">文件上传</a></li>
          <li class="active"><a href="view/dataset/addDatasetRecord.jsp">新增数据记录</a></li>
		</ul>
        <div class="panel-body">       
        <br>
			<form class="form-horizontal " role="form" method="post" action="AddDatasetRecord.do">	
				    <label class="col-sm-2 control-label">数据集编号</label>
				    <div class="col-sm-2">
				      <input type="number" class="form-control input-sm" name="datasetID">
				    </div>
				    <button type="submit" class="btn btn-primary input-sm col-sm-1 col-sm-push-1">上传</button>
			</form>
			<br><br>
		</div>
</div>
</div>

<%@ include file="/public/frame/bottom.jsp" %>