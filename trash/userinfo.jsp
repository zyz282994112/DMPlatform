<%@ page language="java" import="java.util.*,model.platform.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>
<% User user = (User)request.getAttribute("user"); %>

<div class="container">
<div class="panel">
<ul class="nav nav-tabs">
  <li class="active"><a href="UserInfo.do?userid=<%=user.getUserID()%>">用户信息</a></li>
  <li><a href="view/platform/useredit.jsp?userid=<%=user.getUserID()%>" >编辑信息</a></li>
</ul>
<div class="panel-body">
<table class="table">
基本信息
<tr>
	<th>UserID</th>
	<td><%=user.getUserID().toString()%></td>
	<th>aa</th>
	<td>bb</td>
	<th>aa</th>
	<td>bb</td>
</tr>
</table>
<br><div class = "row">
	<div class = "col-md-2">
	UserID:
	</div>
	<div class = "col-md-10">
		<dd><u><%=user.getUserID().toString()%></u>	</dd>
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		UserName:
	</div>
	<div class = "col-md-10">
		<%=user.getUserName()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		Profession:
	</div>
	<div class = "col-md-10">
		<%=user.getProfession()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		Company:
	</div>
	<div class = "col-md-10">
		<%=user.getCompany()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		CAddress:
	</div>
	<div class = "col-md-10">
		<%=user.getCAddress()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		CPhone:
	</div>
	<div class = "col-md-10">
		<%=user.getCPhone()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		CEmail:
	</div>
	<div class = "col-md-10">
		<%=user.getCEmail()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		UserEmail:
	</div>
	<div class = "col-md-10">
		<%=user.getUserEmail()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		UserMSN:
	</div>
	<div class = "col-md-10">
		<%=user.getUserMSN()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		UserQQ:
	</div>
	<div class = "col-md-10">
		<%=user.getUserQQ()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		UserMobile:
	</div>
	<div class = "col-md-10">
		<%=user.getUserMobile()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		UserPhone:
	</div>
	<div class = "col-md-10">
		<%=user.getUserPhone()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		image:
	</div>
	<div class = "col-md-10">
		<%=user.getImagePath()%>	
	</div>
</div>
<br><div class = "row">
	<div class = "col-md-2">
		LastLoginTime:
	</div>
	<div class = "col-md-10">
		<%=user.getLastLoginTime()%>	
	</div>
</div>
	


</div>
</div>
</div>


<%@ include file="../../public/frame/bottom.jsp" %>
