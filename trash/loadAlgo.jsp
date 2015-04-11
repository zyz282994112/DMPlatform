<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/public/frame/head.jsp" %>

<div class="container">
    <div class="panel panel-default col-md-10">
        <div class="panel-heading">
            <h3>加载算法</h3>
        </div>

        <div class="panel-body">
            <form name="loadAlgorithmForm" id="load_algorithm" action="loadalogrithm.do" method="get">
                <label for="Algorithm_Name">算法名称</label>
                <br/>
                <select id="Algorithm_Name" name="algorithmList" onchange="adjustInput(this.options[this.options.selectedIndex].value)">

                </select>

                <div id="parent">
                    <div id="replace">

                    </div>
                </div>
                <br/>

                <input type="submit" value="加载"/>
            </form>
        </div>
    </div>

    <%@ include file="/view/algorithm/slider.jsp" %>
</div>

<%@ include file="/public/frame/bottom.jsp" %>
