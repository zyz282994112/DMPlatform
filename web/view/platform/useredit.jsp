<%@ page  language="java" import="java.util.*,model.platform.*" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>
<% 
Integer userid = Integer.parseInt(request.getParameter("userid"));
User user = UserBean.select(userid);
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
		  <li><a href="UserInfo.do?userid=<%=user.getUserID()%>">查看信息</a></li>
		  <li class="active"><a href="view/platform/useredit.jsp?userid=<%=user.getUserID()%>" >编辑信息</a></li>
		</ul>
		<div class="panel-body">
		 			<form class="form-horizontal" method="post" onsubmit="return validate_form(this)" action="UpdateServlet.do">
					      <div  class="form-group">
						    <label class="col-sm-2 control-label">用户ID</label>
						    <div class="col-sm-3">
						      <input type="text" class="form-control" name="UserID" value="<%=user.getUserID()%>" readonly>
						    </div>
						    <label  class="col-sm-2 control-label">用户名</label>
						    <div class="col-sm-3">
						      <input type="text" class="form-control" name="UserName"  value="<% out.print(user.getUserName()); %>">
						    </div>
						  </div>
						  
						  <div class="form-group">  
						    <label class="col-sm-2 control-label">职业</label>
						    <div class="col-sm-3">
						      <input type="text" class="form-control" name="Profession" value="<% out.print(user.getProfession()); %>">
						    </div>
						    <label class="col-sm-2 control-label">密码</label>
						    <div class="col-sm-3">
						      <input type="password" pattern="[A-z0-9]{3,16}" title="你的密码长度必须介于3~16位之间!" class="form-control" name="Password" value="<% out.print(user.getPassword()); %>">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label class="col-sm-2 control-label">用户手机</label>
						    <div class="col-sm-3">
						      <input type="text" pattern="[0-9]{11}" title="must input right tel number!" class="form-control" name="UserMobile" value="<% out.print(user.getUserMobile()); %>">
						    </div>
						    <label class="col-sm-2 control-label">用户电话</label>
						    <div class="col-sm-3">
						      <input type="text" pattern="[0-9]{11}" title="must input right tel number!" class="form-control" name="UserPhone" value="<% out.print(user.getUserPhone()); %>">
						    </div>
						  </div>
						  
						   <div class="form-group">
						    <label class="col-sm-2 control-label">MSN</label>
						    <div class="col-sm-3">
						      <input type="text" class="form-control" name="UserMSN" value="<% out.print(user.getUserMSN()); %>">
						    </div>
						     <label class="col-sm-2 control-label">QQ</label>
						    <div class="col-sm-3">
						      <input type="text" pattern="[0-9]{5,}" title="请输入正确的QQ号！" class="form-control" name="UserQQ" value="<% out.print(user.getUserQQ()); %>">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label class="col-sm-2 control-label">公司邮箱</label>
						    <div class="col-sm-3">
						      <input type="email" class="form-control" name="CEmail" value="<% out.print(user.getCEmail()); %>">
						    </div>
						    <label class="col-sm-2 control-label">用户邮箱</label>
						    <div class="col-sm-3">
						      <input type="email" class="form-control" name="UserEmail" value="<% out.print(user.getUserEmail()); %>">
						    </div>
						  </div>
						  
						  <div class="form-group">
						  	<label class="col-sm-2 control-label">公司电话</label>
						    <div class="col-sm-3">
						      <input type="text" pattern="[0-9]{5,}" title="must input right tel number!" class="form-control" name="CPhone" value="<% out.print(user.getCPhone()); %>">
						    </div>
						    <label class="col-sm-2 control-label">公司</label>
						    <div class="col-sm-3">
						      <input type="text" class="form-control" name="Company" value="<% out.print(user.getCompany()); %>">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label class="col-sm-2 control-label">公司地址</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" name="CAddress" value="<% out.print(user.getCAddress()); %>">
						    </div>
						  </div>
						  
										  
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-3">
						      <button type="submit" class="btn btn-success">提交</button>
						      <a class="btn btn-default" href="UserInfo.do?userid=<%=userid%>">取消</a>
						    </div>
						  </div>
						</form>
									
		</div>
	
	</div>
</div>

        <%@ include file="../../public/frame/bottom.jsp" %>