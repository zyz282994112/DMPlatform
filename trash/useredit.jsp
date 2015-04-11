    <%@ page  language="java" import="java.util.*,model.platform.*" pageEncoding="UTF-8"%>
        <%@ include file="../../public/frame/head.jsp" %>

        <div class="container">
<% 
Integer userid = Integer.parseInt(request.getParameter("userid"));
User user = UserBean.select(userid);
if(user == null)
	 user = new User();
%>
        <div class="panel panel-default col-md-10">
        <div class="panel-heading">
        <h1>Welcome!<%=user.getUserName()%></h1>
        </div>
        <div class="panel-body">
 			<form class="form-horizontal"  method="post" action="UpdateServlet.do">
			      <div style="display:none" class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">UserID</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="UserID" value="<%=user.getUserID()%>" >
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">UserName</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="UserName"  value="<% out.print(user.getUserName()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">Profession</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="Profession" value="<% out.print(user.getProfession()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">CAddress</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="CAddress" value="<% out.print(user.getCAddress()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">Company</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="Company" value="<% out.print(user.getCompany()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">CPhone</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="CPhone" value="<% out.print(user.getCPhone()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">CEmail</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="CEmail" value="<% out.print(user.getCEmail()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">UserEmail</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="UserEmail" value="<% out.print(user.getUserEmail()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">UserMSN</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="UserMSN" value="<% out.print(user.getUserMSN()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">UserQQ</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="UserQQ" value="<% out.print(user.getUserQQ()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">UserMobile</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="UserMobile" value="<% out.print(user.getUserMobile()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">UserPhone</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="UserPhone" value="<% out.print(user.getUserPhone()); %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">Password</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" name="Password" value="<% out.print(user.getPassword()); %>">
				    </div>
				  </div>				  
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-default">提交</button>
				    </div>
				  </div>
				</form>
			 </div>

        </div>
        <%@ include file="../../view/platform/slider.jsp" %>
        </div>

        <%@ include file="../../public/frame/bottom.jsp" %>