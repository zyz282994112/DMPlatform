<%@ page  language="java" import="java.lang.String,model.dataset.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>
<%
	String datasetID =(String)session.getAttribute("datasetID");
	request.getSession().setAttribute("datasetID", datasetID);
	Integer dsid = Integer.parseInt(datasetID);
	ArrayList<FieldInfo> fields=new ArrayList<FieldInfo>();
  fields = (ArrayList<FieldInfo>)session.getAttribute("fields");
  request.getSession().setAttribute("fieldsNo", String.valueOf(fields.size()));
	
%>

<div class="container">
	<div class="panel">
		<ul class="nav nav-tabs">
		  <li><a href="DataSampleSelectDs.do">数据抽样</a></li>
          <li class="active"><a href="FieldFilterSelectDs.do">字段过滤</a></li>
		  <li><a href="RecordFilterSelectDs.do">记录过滤</a></li>
		</ul>
		<div class="panel-body">
			<form class="form-horizontal" role="form" method="post" action="DoFieldFilter.do">
	        	<h4>数据集编号:<%=dsid%></h4>
				<div class="table-responsive">
				  <table class="table table-condensed table-hover">
					<tr>
					  <th>字段名称</th>
					  <th>字段类型</th>
					  <th>字段说明</th>
					  <th>选择字段</th>
					</tr> 
					<%int i=1;
					for(FieldInfo field :fields){ %>
					<tr>
					  <td>
					  <input type="text" name="name<%=i%>" class="form-control" value="<%=field.getFieldName()%>" readonly></input>
					  </td>
					  <td>
					  <input type="text" name="type<%=i%>" class="form-control" value="<%=field.getType()%>" readonly></input>
					  </td>
					  <td>
					  <input type="text" name="meaning<%=i%>" class="form-control" value="<%=field.getMeaning()%>" readonly></input>
					  </td>
					  <td>
					  	<label>
    					<input type="checkbox" name="select<%=i %>"value="1">
    					如果想选择此字段，在前面打勾。
  						</label>
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