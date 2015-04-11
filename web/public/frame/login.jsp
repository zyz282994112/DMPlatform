
        <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3 class="modal-title" id="myModalLabel">登陆界面</h3>
        </div>
        <div class="modal-body">
        <form class="form-horizontal" role="form" method="post" action="LoginServlet.action">
        <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">UserID</label>
        <div class="col-sm-10">
        <input type="text" class="form-control" name = "UserID" placeholder="UserID">
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

 
        <div class="modal-footer">
        <button  type="submit" class="btn btn-success">登录</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        </div>
        </form>
        </div>
        </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->