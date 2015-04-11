<%@ page language="java" import="java.lang.String,model.dataset.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>
<%
  DatasetBean db = new DatasetBean();
  db = (DatasetBean)session.getAttribute("dsDescription");
%>

<div class="container">
<div class="panel">
	<ul class="nav nav-tabs">
	  <li class="active"><a href="CatDataset.do?datasetID=<%=db.getId()%>&recordLine=-1">查看数据集</a></li>
	  <li><a href="ModifyDsDscrptPre.do?datasetID=<%=db.getId()%>" >修改数据集</a></li>
	  <li><a href="ManageFieldsInfo.do?datasetID=<%=db.getId()%>" >字段管理</a></li>
	</ul>
<div class="panel-body">
<table class="table table-condensed">
<h4>数据集基本信息</h4>
<tr>
	<th>编号</th>
	<td><%=db.getId()%>	</td>
	<th>名称</th>
	<td><%=db.getName()%></td>
	<th>文件类型</th>
	<td><%=db.getFileFormat()%></td>
	<th>存储路径</th>
	<td><%=db.getSavingPath()%>	</td>
</tr>
<tr>
	<th>字段数</th>
	<td><%=db.getFieldsNo()%></td>
	<th>数据集大小</th>
	<td><%=db.getSize()%></td>
	<th>记录数</th>
		<td><%=db.getRecordsNo()%></td>
	<th>最后修改时间</th>
	<td><%=db.getLastModificationTime()%></td>
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
</table><br>


<table class="table table-condensed">
<h4>创建者信息</h4>
	<tr>
		<th>姓名</th>
		<td><%=db.getCreator()%></td>
		<th>关系型类别</th>
		<td><%=db.getRelationalCategory()%></td>
		<th>联系电话</th>
		<td><%=db.getCreatorTelephone()%></td>
		<th>数据集来源</th>
		<td><%=db.getSource()%></td>	
	</tr>
	<tr>
		<th>邮箱</th>
		<td><%=db.getCreatorEmail()%></td>
		<th>地址邮编</th>
		<td><%=db.getCreatorZipcode()%></td>
		<th>单位</th>
		<td><%=db.getCreatorCompany()%></td>
		<th>所在地址</th>
		<td><%=db.getCreatorAddress()%></td>
	</tr>
	<tr>
		<th>创建时间</th>
		<td><%=db.getCreateTime()%></td>
		<th></th>
		<td></td>
		<th></th>
		<td></td>
		<th></th>
		<td></td>
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
</table><br>

<table class="table table-condensed">
	<h4>上传者信息</h4>
	<tr>
		<th>姓名</th>
		<td><%=db.getUploader()%></td>
		<th>联系电话</th>
		<td><%=db.getUploaderTelephone()%></td>
		<th>邮箱</th>
		<td><%=db.getUploaderEmail()%></td>
		<th>单位</th>
		<td><%=db.getUploaderCompany()%></td>
	</tr>	
	<tr>
		<th>地址邮编</th>
		<td><%=db.getUploaderZipcode()%></td>
		<th>上传时间</th>
		<td><%=db.getUploadTime()%></td>
		<th>所在地址</th>
		<td><%=db.getUploaderAddress()%></td> 	
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
</table><br>

<table class="table table-condensed">
	<h4>其它信息</h4>
	<tr>
		<th>元数据描述说明</th>
		<td><%=db.getMetadataDescription()%></td>
	</tr>
	<tr>
		<th>数据集说明</th>
		<td><%=db.getDescription()%></td>
	</tr>
	<tr>
		<th></th>
		<td></td>
	</tr>	
</table><br>


</div>
</div>
</div>


<%@ include file="../../public/frame/bottom.jsp" %>
