<%@ page language="java" import="java.util.*,model.platform.*" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>

   
<div class="container">
   <div class="panel">
       <ul class="nav nav-tabs">
       	  <li><a href="ManageDataset.do">数据集管理</a></li>
		  <li class="active"><a href="view/dataset/importFile.jsp">文件上传</a></li>
          <li><a href="view/dataset/etlindex.jsp">ETL</a></li>
		</ul>
        <div class="panel-body">       
        <br>
			<form class="form-horizontal " role="form" method="post" action="ImportFile.do" enctype="multipart/form-data" onsubmit="return filecheck();">			
		  		   <div  class="form-group">
				    <div class="col-sm-4">
				      <input class=" controls" type="file" name="filePath">
				      <p class="help-block"><small>支持CSV,SQL,EXCEL,TXT格式文件.</small></p>
				    </div>
				    <button type="submit" class="btn btn-primary input-sm">上传</button>
				 </div>
			</form>
		</div>
</div>
</div>

<%@ include file="/public/frame/bottom.jsp" %>