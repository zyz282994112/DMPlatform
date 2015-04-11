<%@ page language="java" import="java.lang.String,model.dataset.*" pageEncoding="UTF-8"%>
<%@ include file="/public/frame/head.jsp" %>
<%
  String fieldsNo = new String();
  DatasetBean db = (DatasetBean)session.getAttribute("datasetBean");
  fieldsNo = db.getFieldsNo();
  int num = Integer.parseInt(fieldsNo);
  request.getSession().setAttribute("db", db);
%>
   
<div class="container">
   <div class="panel">
       <ul class="nav nav-tabs">
          <li class="active"><a href="view/dataset/addDatasetRecord.jsp">添加数据记录</a></li>
		</ul>
        <div class="panel-body">       
        <br>
			<form class="form-horizontal " role="form" method="post" action="SubmitAddDsRecord.do">	
				<div  class="form-group">
				    <label class="col-sm-2 control-label">数据集编号</label>
				    <div class="col-sm-2">
				      <input type="number" class="form-control input-sm" name="datasetID" value="<%=db.getId()%>" readonly>
				    </div>
			 	</div>
			 	
			 	<% for(int i=0;i<num;i++){ %>
					<div  class="form-group">
					<label class="col-sm-2 control-label">字段<%=i+1%></label>
					<div class="col-sm-2">
						<input type="text" id="datasetID" name="fields<%=i+1%>" class="form-control" ></input>
					</div>
					</div>
				<% } %>
			 	
			 	<div  class="form-group">
				    <div class="col-sm-2 col-sm-push-2">
				      <button type="submit" class="btn btn-primary">提交</button>
				    </div>
			 	</div>
			</form>
			<br><br>
		</div>
</div>
</div>
<%
   String add_record = new String();
   add_record = (String)session.getAttribute ( "add_record" );
   if("true".equals(add_record))
   {
  %>
  
  <script type="text/javascript">
  alert("添加数据记录成功！");
  </script>
  <% 
  session.setAttribute("add_record","false");
  %>
  <%
  }
   %>
<%@ include file="/public/frame/bottom.jsp" %>