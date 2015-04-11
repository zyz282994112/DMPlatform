<%@ page language="java" import="java.util.*,model.platform.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>
<% User user = (User)request.getAttribute("user");%>

<div class="container">
<div class="panel">
<ul class="nav nav-tabs">
  <li class="active"><a href="UserInfo.do?userid=<%=user.getUserID()%>">查看信息</a></li>
  <li><a href="view/platform/useredit.jsp?userid=<%=user.getUserID()%>" >编辑信息</a></li>
</ul>
<div class="panel-body">
<table class="table table-condensed">
<h4>基本信息</h4>
<tr>
	<th>用户名</th>
	<td><%=user.getUserName()%>	</td>
	<th>用户ID</th>
	<td><%=user.getUserID().toString()%></td>
	<th>职业</th>
	<td><%=user.getProfession()%></td>
	<th>手机</th>
	<td><%=user.getUserMobile()%>	</td>
</tr>
<tr>
	<th>电话</th>
	<td><%=user.getUserPhone()%></td>
	<th>邮箱</th>
	<td><%=user.getUserEmail()%></td>
	<th>MSN</th>
	<td><%=user.getUserMSN()%></td>
	<th>QQ</th>
	<td><%=user.getUserQQ()%></td>
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
</table>


<table class="table table-condensed">
<h4>公司信息</h4>
	<tr>
		<th>名称</th>
		<td><%=user.getCompany()%></td>	
	</tr>
	<tr>
		<th>邮箱</th>
		<td><%=user.getCEmail()%></td>
	</tr>
	<tr>
		<th>电话</th>
		<td><%=user.getCPhone()%></td>
	</tr>
	<tr>
		<th>地址</th>
		<td><%=user.getCAddress()%>	</td>
	</tr>
	<tr><th></th><td></td></tr>
</table>


<table class="table table-condensed">
<h4>登录信息</h4>
<tr>
	<th>最近登录时间</th>
	<td><%=user.getLastLoginTime()%></td>
</tr>
<tr><th></th><td></td></tr>
</table>

</div>
</div>
</div>


<%@ include file="../../public/frame/bottom.jsp" %>
