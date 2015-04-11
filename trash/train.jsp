<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/public/frame/head.jsp" %>


<div class="container">
    <div class="panel panel-default col-md-10">
        <div class="panel-heading">
            <h3>加载算法</h3>
        </div>

        <div class="panel-body">
            <br/>

            <p>模型训练中！</p>
            <br/>

            <p>请耐心等待！</p>
            <br/>
            <p> jobId is :
                <%=request.getAttribute("jobname")%>
            </p>
            <a href="localhost:50030/jobtracker.jsp">查看任务</a>
            <br/>
        </div>
    </div>

    <%@ include file="/view/algorithm/slider.jsp" %>
</div>

<%@ include file="/public/frame/bottom.jsp" %>
