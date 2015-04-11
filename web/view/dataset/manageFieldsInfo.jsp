<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.lang.String,java.util.*,model.dataset.*" %>
<%@ include file="../../public/frame/head.jsp" %>
<%
  ArrayList<FieldInfo> fields=new ArrayList<FieldInfo>();
  fields = (ArrayList<FieldInfo>)session.getAttribute("fields");
  request.getSession().setAttribute("fieldsNo", String.valueOf(fields.size()));
  String id = (String)session.getAttribute("id");
  request.getSession().setAttribute("id", id);
  String name = (String)session.getAttribute("name");
%>
   
<div class="container">
   <div class="panel">
       <ul class="nav nav-tabs">
		  <li><a href="CatDataset.do?datasetID=<%=id%>&recordLine=-1">查看数据集</a></li>
		  <li><a href="ModifyDsDscrptPre.do?datasetID=<%=id%>" >修改数据集</a></li>
		  <li class="active"><a href="ManageFieldsInfo.do?datasetID=<%=id%>" >字段管理</a></li>
		</ul>
        <div class="panel-body">
	        <form class="form-horizontal" role="form" method="post" action="SaveFieldsInfo.do">
	        	<h4>数据集编号:<%=id%></h4>
				<div class="table-responsive">
				  <table class="table table-condensed table-hover">
					<tr>
					  <th>字段名称</th>
					  <th>字段类型</th>
					  <th>字段说明</th>
					</tr> 
					<%int i=1;
					for(FieldInfo field :fields){ %>
					<tr>
					  <td>
					  <input type="text" name="name<%=i%>" class="form-control" value="<%=field.getFieldName()%>"></input>
					  </td>
					  <td>
					  <input type="text" name="type<%=i%>" class="form-control" value="<%=field.getType()%>"></input>
					  </td>
					  <td>
					  <input type="text" name="meaning<%=i%>" class="form-control" value="<%=field.getMeaning()%>"></input>
					  </td>
					</tr>
					<%i++;}%>	
			 	  </table>
			 	  <input type="submit" value="保存" class="btn btn-default"/>
			  </div>
			</form>
		</div>
</div>
</div>

<%@ include file="../../public/frame/bottom.jsp" %>