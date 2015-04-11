<%@ page  language="java" import="java.lang.String,model.dataset.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>
<%
	String datasetID =(String)session.getAttribute("datasetID");
	request.getSession().setAttribute("datasetID", datasetID);
	Integer dsid = Integer.parseInt(datasetID);
	ArrayList<FieldInfo> fields=new ArrayList<FieldInfo>();
  fields = (ArrayList<FieldInfo>)session.getAttribute("fields");
	
%>

<div class="container">
	<div class="panel">
		<ul class="nav nav-tabs">
		  <li><a href="DataSampleSelectDs.do">数据抽样</a></li>
          <li><a href="FieldFilterSelectDs.do">字段过滤</a></li>
		  <li class="active"><a href="RecordFilterSelectDs.do">记录过滤</a></li>
		</ul>
		<div class="panel-body">
			<form class="form-horizontal" role="form" method="post" action="DoRecordFilter.do">
	        	<h4>数据集编号:<%=dsid%></h4>
					<select name="selectField" class="form-control">
		 			<%
	   				for(FieldInfo field :fields){
	   					out.println("<option value="+field.getFieldName()+">");
	   					out.println(field.getFieldName());
	   					out.println("</option>");	   					
	   				}
	   				
		 		 	%>
					</select>
					<select name="selectOperator" class="form-control">
		 			<option value="=">=</option>
		 			<option value=">">&gt;</option>
		 			<option value="<">&lt;</option>
		 			<option value="<>">&lt;&gt;</option>
		 			<option value=">=">&gt;=</option>
		 			<option value="<=">&lt;=</option>
					</select>
					<input type="number" class="form-control input-sm" name="value">
			 	  <input type="submit" value="保存" class="btn btn-default"/>
			  </div>
			</form>
		</div>
	
	</div>
</div>

        <%@ include file="../../public/frame/bottom.jsp" %>