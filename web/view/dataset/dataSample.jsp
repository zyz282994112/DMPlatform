<%@ page  language="java" import="java.lang.String,model.dataset.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>
<%
	String datasetID =(String)session.getAttribute("datasetID");
	request.getSession().setAttribute("datasetID",datasetID);
	Integer dsid = Integer.parseInt(datasetID);
%>

<div class="container">
	<div class="panel">
		<ul class="nav nav-tabs">
		<li class="active"><a href="view/dataset/dataSample.jsp?datasetID=<%=dsid%>" >数据抽样</a></li>
		  <li><a href="FieldFilterSelectDs.do">字段过滤</a></li>
		  <li><a href="RecordFilterSelectDs.do" >记录过滤</a></li>
		</ul>
		<div class="panel-body">
			<form class="form-horizontal" method="post" action="DataSampleServlet.do">
		     	<div  class="form-group">
				    <label class="col-sm-2 control-label">数据集编号</label>
				    <div class="col-sm-1">
				      <input type="number" class="form-control input-sm" name="datasetID" value="<%=dsid%>" readonly>
				    </div>
				 </div>
				 <div  class="form-group">
				    <label class="col-sm-2 control-label">抽样格式</label>
				    <div class="col-sm-2">
				      <select class="form-control input-sm" name="sampleFormat">
						  <option value ="topN">抽取前N条</option>
						  <option value ="perN">每隔N条抽一条</option>
						  <option value="nPercent">按百分比抽取</option>
					</select>
				    </div>
				 </div>
				 <div  class="form-group">
				    <label class="col-sm-2 control-label">抽样数量</label>
				    <div class="col-sm-2">
				      <input type="number" class="form-control input-sm" name="sampleNumber">
				    </div>
				 </div>
				 <br>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-3">
				      <button type="submit" class="btn btn-success">提交</button>
				      <a class="btn btn-default" href="CatDataset.do?datasetID=<%=dsid%>&recordLine=-1">取消</a>
				    </div>
				  </div>
				  
			</form>
									
		</div>
	
	</div>
</div>

        <%@ include file="../../public/frame/bottom.jsp" %>