<%@ page language="java" import="java.lang.String,java.util.*,model.dataset.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>
<%
  ArrayList<DatasetBean> al=new ArrayList<DatasetBean>();
  al = (ArrayList<DatasetBean>)session.getAttribute("arrayList");
%>
   
<div class="container">
   <div class="panel">
       <ul class="nav nav-tabs">
          <li class="active"><a href="DataSampleSelectDs.do">数据抽样</a></li>
          <li><a href="FieldFilterSelectDs.do">字段过滤</a></li>
		  <li><a href="RecordFilterSelectDs.do">记录过滤</a></li>
		</ul>
        <div class="panel-body">
        <form class="form-horizontal " role="form" method="post" action="DataSampleSetCondition.do">	
		<select name="selectdataset" class="form-control">
		 		<%
	   				for(DatasetBean db :al){
	   					out.println("<option value="+db.getId()+">");
	   					out.println(db.getId());
	   					out.println(' ');
	   					out.println(db.getName());
	   					out.println("</option>");	   					
	   				}
	   				
		 		 %>
		</select>
		<button type="submit" class="btn btn-primary input-sm col-sm-1 col-sm-push-1">下一步</button>
		</form>
		</div>

</div>
</div>

<%@ include file="../../public/frame/bottom.jsp" %>