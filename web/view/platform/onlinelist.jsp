<%@ page language="java" import="java.util.*,model.platform.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>

<div class="container">
   <div class="panel">
       <ul class="nav nav-tabs">
		  <li><a href="UserList.dd">系统用户管理</a></li>
		  <li class="active"><a href="OnlineList.dd" >在线用户管理</a></li>
		  <li><a href="view/platform/useredit.jsp?userid=" >所有任务管理</a></li>
		</ul>
        <div class="panel-body">
			<div class="table-responsive">
			  <table class="table table-striped table-bordered table-hover">
	 			<tr>
		 			<th>用户ID</th>
		 			<th>用户名</th>
		 			<th>职业</th>
		 			<th>公司</th>
		 			<th>公司电话</th>
		 			<th>查看详细信息</th>
		 			<th>修改用户信息</th>
		 			<th>删除用户</th>
		 		</tr>
		 		<%
		 			
		 			List<User> alluser=(List<User>)request.getAttribute("alluser");
	   				for(User user : alluser){
	   					out.println("<tr>");
	   					out.println("<td>"+user.getUserID());
	   					out.println("<td>"+user.getUserName());
	   					out.println("<td>"+user.getProfession());
	   					out.println("<td>"+user.getCompany());
	   					out.println("<td>"+user.getCPhone());
	   					out.println("<td><a href=\"UserInfo.do?userid="+user.getUserID()+"\"><span class=\"glyphicon glyphicon-search \"></span>查看</a>");
	   					out.println("<td><a href=\"view/platform/useredit.jsp?userid="+user.getUserID()+"\"><span class=\"glyphicon glyphicon-wrench \"></span>修改</a>");
	   					out.println("<td><a onclick=\"return p_del()\" href=\"DeleteUser.do?userid="+user.getUserID()+"\"><span class=\"glyphicon glyphicon-trash \"></span>删除</a>");
	   					out.println("</tr>");
	   					
	   				}
		 		 %>
				 		 
		 	  </table>
		  </div>
		
		</div>

        </div>
        </div>

        <%@ include file="../../public/frame/bottom.jsp" %>