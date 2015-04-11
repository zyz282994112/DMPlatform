<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.lang.String,model.dataset.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>		
	<base href=" <%=basePath%>">
	<link rel="stylesheet" type="text/css" href="public/css/bootstrap-theme.css">
	<link rel="stylesheet" type="text/css" href="public/css/bootstrap.css">
    <title>数据集说明文档</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type='text/css'>
	    body {
	      background-color: #CCC;
	    }
	    #content {
	      background-color: #FFF;
	      border-radius: 5px;
	    }
	    #content .main {
	      padding: 20px;
	    }
	    #content .sidebar {
	      padding: 10px;
	    }
	    #content p {
	      line-height: 30px;
	    }
    </style>
	<style type="text/css"></style>    
  </head>
  
  <body>
  
  
   <jsp:include page="../../public/frame/head.jsp" flush="true"/>
   <%
  DatasetBean db = new DatasetBean();
  db = (DatasetBean)session.getAttribute("dsDescription");
   %>
   <div class="container">
   <div class="jumbotron col-md-10" >
<center>
<b>数据集描述信息</b>
  <table class="table table-bordered" border="0" cellpadding="0" cellspacing="3"  align="center">

	<tr>
	  <td width="30%" align="right">数据集编号ID:</td>
	  <td width="70%" align="left">
	  <%=db.getId()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集名称:</td>
	  <td align="left">
	  <%=db.getName()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集文件类型:</td>	 
	  <td align="left">
	  <%=db.getFileFormat()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集存储路径:</td>
	  <td align="left">
	  <%=db.getSavingPath()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集来源:</td>
	  <td align="left">
	  <%=db.getSource()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集创建者:</td>
	  <td align="left">
	  <%=db.getCreator()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建者单位:</td>
	  <td align="left">
	  <%=db.getCreatorCompany()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建者所在地址:</td>
	  <td align="left">
	  <%=db.getCreatorAddress()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建者地址邮编:</td>
	  <td align="left">
	  <%=db.getCreatorZipcode()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建者联系电话:</td>
	  <td align="left">
	  <%=db.getCreatorTelephone()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建者联系邮箱:</td>
	  <td align="left">
	  <%=db.getCreatorEmail()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">记录数:</td>
	  <td align="left">
	  <%=db.getRecordsNo()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">字段数:</td>
	  <td align="left">
	  <%=db.getFieldsNo()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集大小:</td>
	  <td align="left">
	  <%=db.getSize()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">关系型类别:</td>
	  <td align="left">
	  <%=db.getRelationalCategory()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">元数据描述说明:</td>
	  <td align="left">
	  <%=db.getMetadataDescription()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集上传者:</td>
	  <td align="left">
	  <%=db.getUploader()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">上传者单位:</td>
	  <td align="left">
	  <%=db.getUploaderCompany()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">上传者所在地址:</td>
	  <td align="left">
	  <%=db.getUploaderAddress()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">上传者地址邮编:</td>
	  <td align="left">
	  <%=db.getUploaderZipcode()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">上传者联系电话:</td>
	  <td align="left">
	  <%=db.getUploaderTelephone()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">上传者联系邮箱:</td>
	  <td align="left">
	  <%=db.getUploaderEmail()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建时间:</td>
	  <td align="left">
	  <%=db.getCreateTime()%>
	</tr>
	<tr>
	  <td align="right">上传时间:</td>
	  <td align="left">
	  <%=db.getUploadTime()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">最后修改时间:</td>
	  <td align="left">
	  <%=db.getLastModificationTime()%>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集说明:</td>
	  <td align="left">
	  <%=db.getDescription()%>
	  </td>
	</tr>
</table>
</center>
<font size="3">
<a href="view/platform/platindex.jsp">数据挖掘平台</a>
>>
<a href="view/dataset/index.jsp">数据集管理</a>
>>
<a href="ManageDataset">管理数据集</a>
</font>
</div>
<jsp:include page="../../view/dataset/slider.jsp" flush="true"/>
</div>
<jsp:include page="../../public/frame/bottom.jsp" flush="true"/>
<%
   String update_success = new String();
   update_success = (String)session.getAttribute ( "update_success" );
   if("true".equals(update_success))
   {
  %>
  
  <script type="text/javascript">
  alert("修改成功！");
  </script>
  <% 
  session.setAttribute("update_success","false");
  %>
  <%
  }
   %>
  </body>
</html>
