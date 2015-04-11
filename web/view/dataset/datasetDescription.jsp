<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.lang.String" %>
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
    <title>添加数据集描述</title>
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
	<script type="text/javascript">
    function check(){
        //var var_records_no = document.getElementById("records_no").value;
        //var var_fields_no = document.getElementById("fields_no").value;
        //var var_size = document.getElementById("size").value;
        return true;
       }
</script>
  </head>
  <body>
  <jsp:include page="../../public/frame/head.jsp" flush="true"/>
   <div class="container">
   <div class="jumbotron col-md-10" >
  
  <form class="form-horizontal" role="form" method="post"  
  action="ModifyDatasetDescriptionServlet.do" onsubmit="return check();">
<center>
<b>数据集描述信息</b>
  <table class="table table-bordered" border="0" cellpadding="0" cellspacing="3"  align="center">
		<%
	  String newId = new String();
	  newId = (String)session.getAttribute("newId");
	  request.getSession().setAttribute("datasetID", newId);
	   %>
	<tr>
	  <td width="30%" align="right">数据集编号ID:</td>
	  <td width="70%" align="left">
	    
	  
	  
	   <%=newId %>
	  
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集名称:</td>
	  <td align="left">
	  <input type="text" name="name" size="20" class="form-control" placeholder="name"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集文件类型:</td>	 
	  <td align="left">
	  <input type="text" name="file_format" size="20" class="form-control" placeholder="file_format"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集存储路径:</td>
	  <td align="left">
	  <input type="text" name="saving_path" size="20" class="form-control" placeholder="saving_path"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集来源:</td>
	  <td align="left">
	  <input type="text" name="source" size="20" class="form-control" placeholder="source"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集创建者:</td>
	  <td align="left">
	  <input type="text" name="creator" size="20" class="form-control" placeholder="creator"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建者单位:</td>
	  <td align="left">
	  <input type="text" name="creator_company" size="20" class="form-control" placeholder="creator_company"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建者所在地址:</td>
	  <td align="left">
	  <input type="text" name="creator_address" size="20" class="form-control" placeholder="creator_address"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建者地址邮编:</td>
	  <td align="left">
	  <input type="text" name="creator_zipcode" size="20" class="form-control" placeholder="creator_zipcode"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建者联系电话:</td>
	  <td align="left">
	  <input type="text" name="creator_telephone" size="20" class="form-control" placeholder="creator_telephone"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">创建者联系邮箱:</td>
	  <td align="left">
	  <input type="text" name="creator_email" size="20" class="form-control" placeholder="creator_email"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">关系型类别:</td>
	  <td align="left">
	  <input type="text" name="relational_category" size="20" class="form-control" placeholder="relational_category"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">元数据描述说明:</td>
	  <td align="left">
	  <input type="text" name="metadata_description" size="20" class="form-control" placeholder="metadata_description"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集上传者:</td>
	  <td align="left">
	  <input type="text" name="uploader" size="20" class="form-control" placeholder="uploader"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">上传者单位:</td>
	  <td align="left">
	  <input type="text" name="uploader_company" size="20" class="form-control" placeholder="uploader_company"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">上传者所在地址:</td>
	  <td align="left">
	  <input type="text" name="uploader_address" size="20" class="form-control" placeholder="uploader_address"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">上传者地址邮编:</td>
	  <td align="left">
	  <input type="text" name="uploader_zipcode" size="20" class="form-control" placeholder="uploader_zipcode"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">上传者联系电话:</td>
	  <td align="left">
	  <input type="text" name="uploader_telephone" size="20" class="form-control" placeholder="uploader_telephone"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">上传者联系邮箱:</td>
	  <td align="left">
	  <input type="text" name="uploader_email" size="20" class="form-control" placeholder="uploader_email"></input>
	  </td>
	</tr>
	<tr>
	  <td align="right">数据集说明:</td>
	  <td align="left">
	  <input type="text" name="description" size="20" class="form-control" placeholder="description"></input>
	  </td>
	</tr>
	
</table>	
	<input type="submit" value="保存" class="btn btn-default"/>

</center>
</form>
<%
   String importFile_success = new String();
   importFile_success = (String)session.getAttribute ( "importFile_success" );
   if("true".equals(importFile_success))
   {
  %>
  
  <script type="text/javascript">
  alert("上传成功！");
  </script>
  
  <% 
  session.setAttribute("importFile_success","false");
  %>
  <%
  }
   %>
  </div>
  <jsp:include page="../../view/dataset/slider.jsp" flush="true"/>
</div>
<jsp:include page="../../public/frame/bottom.jsp" flush="true"/>	
  </body>

</html>
