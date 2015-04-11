    <%@ page language="java" import="java.util.*,model.platform.*" pageEncoding="UTF-8"%>
        <%@ include file="public/frame/head.jsp" %>
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
        <div class="panel panel-default">
        <div class="panel-heading">
        <h3>欢迎注册</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" method="post" onsubmit="return validate_form(this)" action="InsertServlet.action">
                <div  class="form-group">
                    <label  class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="UserName">
                    </div>
                    <label class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-3">
                        <input type="password" pattern="[A-z0-9]{3,16}" title="你的密码长度必须介于3~16位之间!" class="form-control" name="Password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">职业</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="Profession">
                    </div>
                    <label class="col-sm-2 control-label">公司</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="Company">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">用户手机</label>
                    <div class="col-sm-3">
                        <input type="text" pattern="[0-9]{11}" title="must input right tel number!" class="form-control" name="UserMobile">
                    </div>
                    <label class="col-sm-2 control-label">用户电话</label>
                    <div class="col-sm-3">
                        <input type="text" pattern="[0-9]{11}" title="must input right tel number!" class="form-control" name="UserPhone">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">MSN</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="UserMSN">
                    </div>
                    <label class="col-sm-2 control-label">QQ</label>
                    <div class="col-sm-3">
                        <input type="text" pattern="[0-9]{5,}" title="请输入正确的QQ号！" class="form-control" name="UserQQ" >
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">公司邮箱</label>
                    <div class="col-sm-3">
                        <input type="email" class="form-control" name="CEmail">
                    </div>
                    <label class="col-sm-2 control-label">用户邮箱</label>
                    <div class="col-sm-3">
                        <input type="email" class="form-control" name="UserEmail" >
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">公司电话</label>
                    <div class="col-sm-3">
                        <input type="text" pattern="[0-9]{5,}" title="must input right tel number!" class="form-control" name="CPhone" >
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">公司地址</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="CAddress" >
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-3">
                        <button type="submit" class="btn btn-success">注册</button>
                        <a class="btn btn-default" href="#">取消</a>
                    </div>
                </div>
            </form>
			 </div>

        </div>
        </div>

        <%@ include file="public/frame/bottom.jsp" %>