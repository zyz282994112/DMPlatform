<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.lang.String,java.util.*,model.dataset.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>		
	<base href=" <%=basePath%>">
	<link rel="stylesheet" type="text/css" href="public/css/bootstrap-theme.css">
	<link rel="stylesheet" type="text/css" href="public/css/bootstrap.css">
    <title>管理数据集</title>
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
  ArrayList<DatasetBean> al=new ArrayList<DatasetBean>();
  al = (ArrayList<DatasetBean>)session.getAttribute("arrayList");
   %>
   <div class="container">
   <div class="jumbotron col-md-10" >
<center>
<b>管理数据集</b>
  <table class="table table table-bordered" border="0" cellpadding="0" cellspacing="3"  align="center">
	<tr>
	<th>数据集编号</th>
	<th>数据集名称</th>
	<th>
	
	</th>
	</tr>
	<%
	for(DatasetBean db :al)
	{ 
	%>
	<tr>
	  <td><%=db.getId()%></td>
	  <td><%=db.getName()%></td>
	  <td>
	  <a href="CatDataset.do?datasetID=<%= db.getId() %>&recordLine=-1">查看数据集描述</a>
	  &nbsp;&nbsp;
	  
	  <a href="ModifyDsDscrptPre.do?datasetID=<%= db.getId() %>">修改数据集</a>
	  &nbsp;&nbsp;
	  <a href="DeleteDataset.do?datasetID=<%= db.getId() %>">删除数据集</a>
	  &nbsp;&nbsp;
	  <a href="view/dataset/dataSample.jsp?datasetID=<%= db.getId() %>">数据抽样</a>
	  &nbsp;&nbsp;
	  <a href="ManageFieldsInfo.do?datasetID=<%= db.getId() %>">字段管理</a>
	  </td>
	</tr>
	<%
	}
	 %>
	</table>	

</center>
</div>
<jsp:include page="../../view/dataset/slider.jsp" flush="true"/>
</div>
<jsp:include page="../../public/frame/bottom.jsp" flush="true"/>

<%
String deleteSuccessed = (String)session.getAttribute("delete_success");
if("true".equals(deleteSuccessed))
{
  %>
  
<script type="text/javascript">
  alert("删除成功！");
  </script>
  
  <% 
  session.setAttribute("delete_success","false");
  }
   %>
 <%
String deleteFailed = (String)session.getAttribute("delete_failed");
if("true".equals(deleteFailed))
{
  %>
  
<script type="text/javascript">
  alert("删除失败！");
  </script>
  
  <%
  session.setAttribute("delete_failed","false");
  }
   %>
  </body>
</html>