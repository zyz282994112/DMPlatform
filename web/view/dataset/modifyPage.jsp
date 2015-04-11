<%@ page  language="java" import="java.lang.String,model.dataset.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>
<%
	  String datasetID = new String();
	  datasetID = (String)session.getAttribute("datasetID");
	  request.getSession().setAttribute("datasetID", datasetID);
	  DatasetBean db = new DatasetBean();
  	  db = (DatasetBean)session.getAttribute("dsDescription");
%>
<script type="text/javascript">
function validate_form(thisform)
{
with (thisform)
  {
  if (validate_required(UserName,"UserName must be filled out!")==false)
    {UserName.focus();return false;};
      if (validate_required(Password,"Password must be filled out!")==false)
    {Password.focus();return false;};
    
  }
}
</script>


<div class="container">
	<div class="panel">
		<ul class="nav nav-tabs">
		  <li><a href="CatDataset.do?datasetID=<%=db.getId()%>&recordLine=-1">查看数据集</a></li>
		  <li class="active"><a href="ModifyDsDscrptPre.do?datasetID=<%=db.getId()%>" >修改数据集</a></li>
		  <li><a href="ManageFieldsInfo.do?datasetID=<%=db.getId()%>" >字段管理</a></li>
		</ul>
		<div class="panel-body">
			<form class="form-horizontal" method="post" onsubmit="return validate_form(this)" action="ModifyDatasetDescriptionServlet.do">
		     	<div  class="form-group">
				    <label class="col-sm-2 control-label">数据集编号</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="UserID" value="<%=datasetID%>" readonly>
				    </div>
				    <label  class="col-sm-2 control-label">数据集名称</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="name"  value="<%=db.getName()%>">
				    </div>
				 </div>
				 <div  class="form-group">
				    <label  class="col-sm-2 control-label">数据集文件类型</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="file_format"  value="<%=db.getFileFormat()%>">
				    </div>
				    <label  class="col-sm-2 control-label">数据集存储路径</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="saving_path"  value="<%=db.getSavingPath()%>">
				    </div>
				 </div>

				<div  class="form-group">
				    <label  class="col-sm-2 control-label">数据集来源</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="source"  value="<%=db.getSource()%>">
				    </div>
				    <label  class="col-sm-2 control-label">数据集创建者</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="creator"  value="<%=db.getCreator()%>">
				    </div>
				 </div>

				<div  class="form-group">
				    <label  class="col-sm-2 control-label">创建者单位</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="creator_company"  value="<%=db.getCreatorCompany()%>">
				    </div>
				    <label  class="col-sm-2 control-label">创建者所在地址</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="creator_address"  value="<%=db.getCreatorAddress()%>">
				    </div>
				 </div>
				 
				<div  class="form-group">
				    <label  class="col-sm-2 control-label">创建者地址邮编</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="creator_zipcode"  value="<%=db.getCreatorZipcode()%>">
				    </div>
				    <label  class="col-sm-2 control-label">创建者联系电话</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="creator_telephone"  value="<%=db.getCreatorTelephone()%>">
				    </div>
				 </div>		
				 	 
				<div  class="form-group">
				    <label  class="col-sm-2 control-label">创建者联系邮箱</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="creator_email"  value="<%=db.getCreatorEmail()%>">
				    </div>
				    <label  class="col-sm-2 control-label">关系型类别</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="relational_category"  value="<%=db.getRelationalCategory()%>">
				    </div>
				 </div>

				<div  class="form-group">
				    <label  class="col-sm-2 control-label">元数据描述说明</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="metadata_description"  value="<%=db.getMetadataDescription()%>">
				    </div>
				    <label  class="col-sm-2 control-label">数据集上传者</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="uploader"  value="<%=db.getUploader()%>">
				    </div>
				 </div>

				<div  class="form-group">
				    <label  class="col-sm-2 control-label">上传者单位</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="uploader_company"  value="<%=db.getUploaderCompany()%>">
				    </div>
				    <label  class="col-sm-2 control-label">上传者所在地址</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="uploader_address"  value="<%=db.getUploaderAddress()%>">
				    </div>
				 </div>

				<div  class="form-group">
				    <label  class="col-sm-2 control-label">上传者地址邮编</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="uploader_zipcode"  value="<%=db.getUploaderZipcode()%>">
				    </div>
				    <label  class="col-sm-2 control-label">上传者联系电话</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="uploader_telephone"  value="<%=db.getUploaderTelephone()%>">
				    </div>
				 </div>

				<div  class="form-group">
				    <label  class="col-sm-2 control-label">上传者联系邮箱</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="uploader_email"  value="<%=db.getUploaderEmail()%>">
				    </div>
				    <label  class="col-sm-2 control-label">数据集说明</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="description"  value="<%=db.getDescription()%>">
				    </div>
				 </div>


	<input type="submit" value="保存" class="btn btn-default"/>
						</form>
									
		</div>
	
	</div>
</div>

        <%@ include file="../../public/frame/bottom.jsp" %>