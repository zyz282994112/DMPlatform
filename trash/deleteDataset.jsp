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
    <title>删除数据集</title>
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
        var datasetID = document.getElementById("datasetID").value;
        
        if(datasetID== "" || isNaN(datasetID))
        {
          alert('数据集编号ID不能为空且必须为数字！');
          return false;
          }
         else
         {
         		
          	return true;
       	}
       }
</script>
  </head>
  
  <body>
   <jsp:include page="../../public/frame/head.jsp" flush="true"/>
   <div class="container">
   <div class="jumbotron col-md-10" >
  <form class="form-horizontal"  method="post" action="DeleteDataset" onsubmit="return check();">
<center>
<b>删除数据集</b>
  <table class="table table-bordered" border="0" cellpadding="0" cellspacing="3"  align="center">

	<tr>
	  <td width="30%" align="right">数据集编号ID:</td>
	  <td width="70%" align="left">
	  <input type="text" id="datasetID" name="datasetID" size="20" class="form-control" ></input>
	  </td>
	</tr>
	</table>
	<input type="submit" value="删除" class="btn btn-default"/>
	</center>
</form>
</div>
<jsp:include page="../../view/dataset/slider.jsp" flush="true"/>
</div>
<jsp:include page="../../public/frame/bottom.jsp" flush="true"/>
<%
String isDeleted = (String)session.getAttribute("delete_success");
if("true".equals(isDeleted))
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
