<%@ page language="java" import="java.lang.String,java.util.*,model.dataset.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>
<%
  ArrayList<DatasetBean> al=new ArrayList<DatasetBean>();
  al = (ArrayList<DatasetBean>)session.getAttribute("arrayList");
%>
   
<div class="container">
   <div class="panel">
       <ul class="nav nav-tabs">
       	  <li class="active"><a href="ManageDataset.do">数据集管理</a></li>
		  <li><a href="view/dataset/importFile.jsp">文件上传</a></li>
          <li><a href="view/dataset/etlindex.jsp">ETL</a></li>
		</ul>
        <div class="panel-body">
			<div class="table-responsive">
			  <table class="table table-striped table-bordered table-hover" id="news">
	 			<tr>
		 			<th>数据集编号</th>
		 			<th>数据集名称</th>
		 			<th>查看数据集</th>
		 			<th>修改数据集</th>
		 			<th>删除数据集</th>
		 			<th>数据抽样</th>
		 			<th>字段管理</th>
		 		</tr>
		 		<%
	   				for(DatasetBean db :al){
	   					out.println("<tr>");
	   					out.println("<td>"+db.getId());
	   					out.println("<td>"+db.getName());
	   					out.println("<td><a href=\"CatDataset.do?datasetID="+db.getId()+"&recordLine=-1\"><span class=\"glyphicon glyphicon-search \"></span>查看</a>");
	   					out.println("<td><a href=\"ModifyDsDscrptPre.do?datasetID="+db.getId()+"\"><span class=\"glyphicon glyphicon-wrench \"></span>修改</a>");
	   					out.println("<td><a onclick=\"return p_del()\" href=\"DeleteDataset.do?datasetID="+db.getId()+"\"><span class=\"glyphicon glyphicon-trash \"></span>删除</a>");
	   					out.println("<td><a href=\"view/dataset/dataSample.jsp?datasetID="+db.getId()+"\"><span class=\"glyphicon glyphicon-filter \"></span>抽样</a>");
	   					out.println("<td><a href=\"ManageFieldsInfo.do?datasetID="+db.getId()+"\"><span class=\"glyphicon glyphicon-book \"></span>字段管理</a>");
	   					out.println("</tr>");
	   					
	   				}
		 		 %>
				 		 
		 	  </table>
		  </div>
		
		</div>

</div>
</div>

<%@ include file="../../public/frame/bottom.jsp" %>