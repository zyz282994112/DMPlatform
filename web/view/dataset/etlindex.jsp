<%@ page language="java" import="java.lang.String,java.util.*,model.dataset.*" pageEncoding="UTF-8"%>
<%@ include file="../../public/frame/head.jsp" %>
<div class="container">
   <div class="panel">
       <ul class="nav nav-tabs">
       	  <li><a href="ManageDataset.do">数据集管理</a></li>
		  <li><a href="view/dataset/importFile.jsp">文件上传</a></li>
          <li class="active"><a href="view/dataset/etlindex.jsp">ETL</a></li>
		</ul>
        <div class="panel-body">
        <ul class="thumbnails">
        <li class="col-md-3">
        <div class="thumbnail"><img data-src="holder.js/300x200" alt="300x200" src="public/images/frames/task1.jpg" />
        <div class="caption" contenteditable="false">
        <h3>数据抽样</h3>
        <p>一共分为三步：选择数据集，设置抽样条件，开始抽样。</p>
        <p><a  class="btn btn-primary" href="DataSampleSelectDs.do" role="button">开始</a></p>
        </div>
        </div>
        </li>
        
        <li class="col-md-3">
        <div class="thumbnail"><img data-src="holder.js/300x200" alt="300x200" src="public/images/frames/task1.jpg" />
        <div class="caption" contenteditable="false">
        <h3>字段过滤</h3>
        <p>一共分为三步：选择数据集，设置字段过滤条件，开始字段过滤。</p>
        <p><a class="btn btn-primary" href="FieldFilterSelectDs.do">开始</a></p>
        </div>
        </div>
        </li>
        
        <li class="col-md-3">
        <div class="thumbnail"><img data-src="holder.js/300x200" alt="300x200" src="public/images/frames/task1.jpg" />
        <div class="caption" contenteditable="false">
        <h3>记录过滤</h3>
        <p>一共分为三步：选择数据集，设置记录过滤条件，开始记录过滤。</p>
        <p><a class="btn btn-primary" href="RecordFilterSelectDs.do">开始</a></p>
        </div>
        </div>
        </li>
        
        <li class="col-md-3">
        <div class="thumbnail"><img data-src="holder.js/300x200" alt="300x200" src="public/images/frames/task1.jpg" />
        <div class="caption" contenteditable="false">
        <h3>记录排序</h3>
        <p>一共分为三步：选择数据集，设置排序条件，开始排序。</p>
        <p><a class="btn btn-primary" href="#">开始</a></p>
        </div>
        </div>
        </li>
        </ul>
        </div>
    </div>
</div>


<%@ include file="../../public/frame/bottom.jsp" %>