<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/public/frame/head.jsp" %>

<div class="container">
    <div class="panel panel-default col-md-10">
        <div class="panel-heading">
            <h3>更新算法</h3>
        </div>

        <div class="panel-body">
            <form action="uploadJar.dd" method="post" enctype="multipart/form-data">
                <label for="Algorithm_Name">算法名称</label>
                <br/>
                <select id="Algorithm_Name" name="algorithmIdSelect">
                </select>
                <br/>

                <label id="train_label" for="code_file">算法库包</label>
                <br/>
                <input type="file" id="code_file" name="trainJarFile">
                <br/>
                <br/>
                <input type="submit" value="更新"/>
            </form>

        </div>
    </div>

</div>

<%@ include file="/public/frame/bottom.jsp" %>
