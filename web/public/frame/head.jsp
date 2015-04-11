    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>
        <head>
        <title>数据挖掘平台</title>
        <%  
			String path = request.getContextPath();  
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
		%> 
		<base href=" <%=basePath%>">  
  
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="public/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="public/css/bootstrap-theme.css">
        <!--<link rel="stylesheet" type="text/css" href="public/css/table.css">-->
        <script type="text/javascript" src="public/js/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="public/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="public/js/ourJS.js"></script>
        <script type="text/javascript" src="public/js/scripts.js"></script>
        <!--<script type="text/javascript" src="public/js/table.js"></script>-->
        <script src="public/js/stickUp.min.js"></script>
        
        </head>
        <body onload="showAlogrithm()">
        
        <%--<script type="text/javascript">--%>
         	<%--jQuery(function($) {--%>
                <%--$(document).ready( function() {--%>
                  <%--//enabling stickUp on the '.navbar-wrapper' class--%>
                  <%--$('#topheader').stickUp();--%>
                <%--});--%>
              <%--});--%>
        <%--</script>--%>


        
        
        <div>
            <nav id="topheader" class="navbar navbar-inverse "  role="navigation" style="margin-bottom: 0px;">

                    <header  class="headr">
                        <div  class="row">
                            <div class="col-md-8 col-md-push-1">
                               <div class="row">
                                    <img src="public/images/frames/18.png" style="padding-left: 0px;" class="img-responsive col-md-1"/>
                                   <h3 style="color: #ffffff">医疗大数据挖掘平台</h3>
                               </div>
                            </div>
                            <div class="input-group col-md-2" style="padding-top: 20px;">
                                <input style="padding-top: 0px;padding-bottom: 0px;
                                height: 25px;
                                padding-left: 0px;
                                padding-right: 0px;
                                border-left-width: 0px;
                                border-bottom-width: 0px;
                                border-right-width: 0px;
                                border-top-width: 0px;
                                margin-left: 0px;
                                " type="text" class="form-control">
                                  <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" style="
                                        padding-top: 0px;
                                        padding-bottom: 0px;
                                        height: 25px;
                                        border-bottom-width: 0px;
                                        border-top-width: 0px;
                                    ">
                                      <label class="glyphicon glyphicon-search"></label></button>
                                  </span>
                            </div>
                        </div>
                    </header>
                <div class="row">
                <ul class="nav navbar-nav col-md-9 col-md-push-1">
                    <li><a href="index.jsp">主页</a></li>
                    <li><a class="active" href="ManageDataset.do">数据集管理</a>
                         <ul>
                            <li><a href="ManageDataset.do">数据集管理</a></li>
                            <li><a href="view/dataset/importFile.jsp">文件上传</a></li>
                            <li><a href="view/dataset/addDatasetRecord.jsp">新增数据记录</a></li>
                         </ul>
                    </li>
                    <li><a href="view/algorithm/queryAlgo.jsp">算法管理</a>
                        <ul>
                            <li><a href="view/algorithm/addAlgo.jsp">增加算法</a></li>
                            <li><a href="view/algorithm/delAlgo.jsp" >删除算法</a><li>
                            <li><a href="view/algorithm/modifyAlgo.jsp" >修改算法</a><li>
                            <li><a href="view/algorithm/updateAlgo.jsp" >更新算法</a><li>
                            <li><a href="view/algorithm/queryAlgo.jsp" >查询算法</a><li>
                        </ul>
                    </li>
                    <li><a class="active" href="TaskIndexServlet.do">任务管理</a>
                        <ul>
                        <li><a href="view/taskManage/addtask.jsp">新增任务</a></li>
                        <li><a href="TaskIndexServlet.do">任务管理(用户)</a></li>
                        <li><a href="TaskInstanceIndex.do">任务实例管理(用户)</a></li>
                        </ul>
                    </li>
                    <li><a href="#">结果管理</a></li>
                    <li><a class="active" href="UserInfo.do?userid=<%=request.getSession(false).getAttribute("userid")%>">平台管理</a>
                         <ul>
                            <li><a href="UserInfo.do?userid=<%=request.getSession(false).getAttribute("userid")%>">个人信息</a></li>
                            <li><a href="UserList.dd">系统用户管理</a></li>
                            <li><a href="OnlineList.dd">在线用户管理</a></li>
                            <li><a href="AllTask.do">所有任务管理</a></li>
                        </ul>
                    </li>
                    <li><a href="#">关于我们</a></li>
                    <li class="pull-right" data-target="#login"  data-toggle="modal" style="color: #ffffff"><a href="#login">登录</a></li>
                    <li data-toggle="modal" class="pull-right"><a href="register.jsp">注册</a></li>
                </ul>
               </div>
            </nav>

	   </div>









        <!-- 登录弹出框代码（考虑提取到另一个文件中，以及cookie） -->
        <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" >&times;</button>
        <h3 class="modal-title" id="myModalLabel">登陆界面</h3>
        </div>
        <div class="modal-body">
        <form class="form-horizontal"  method="post" action="LoginServlet.action">
        <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">UserName</label>
        <div class="col-sm-10">
        <input type="text" class="form-control" name = "UserName" placeholder="UserName">
        </div>
        </div>
        <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
        <input type="password" class="form-control" name="Password" placeholder="Password">
        </div>
        </div>
        <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
        <label>
        <input type="checkbox"> Remember me
        </label>
        </div>
        </div>
        </div>

        <!-- 对弹出框进行操作 -->
        <div class="modal-footer">
        <button  type="submit" class="btn btn-success">登录</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        </div>
        </form>
        </div>
        </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

      
        </body>
        </html>