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
    <title>查看数据集</title>
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
   <div class="container">
   <div class="jumbotron col-md-10" >
  <form class="form-horizontal" role="form" method="post"  
  action="AddDatasetRecord.do" onsubmit="return check();">
<center>
<b>新增数据记录</b>
  <table class="table table-bordered" border="0" cellpadding="0" cellspacing="3"  align="center">

	<tr>
	  <td width="30%" align="right">数据集编号ID</td>
	  <td width="70%" align="left">
	  <input type="text" id="datasetID" name="datasetID" size="20" class="form-control" ></input>
	  </td>
	</tr>
	</table>
	<input type="submit" value="新增数据记录" class="btn btn-default"/>
	</center>
</form>
</div>
<jsp:include page="../../view/dataset/slider.jsp" flush="true"/>
</div>
<jsp:include page="../../public/frame/bottom.jsp" flush="true"/>
  </body>
</html>
