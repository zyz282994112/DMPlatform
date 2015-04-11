<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/public/frame/head.jsp" %>
<script type="text/javascript" src="public/js/jquery-2.0.3.min.js"></script>
<div class="container">
    <div class="panel panel-default col-md-10">
        <div class="panel-heading">
            <h3>频繁模式挖掘展示</h3>
        </div>

        <div class="panel-body">

            <form name="showfim" action="addAlgorithm.dd" method="post" enctype="multipart/form-data">
                <label for="show_file">展示文件</label>
                <br/>
                <input type="text" id="show_file" name="inputfile">
                <br/>
                <img id="my_image" src="public/images/frames/logo.jpg" >

            </form>

        </div>
        
		
        <%--<div id="parent">--%>
        <%--<div id="replace">--%>
        <%--</div>--%>
        <%--</div>--%>
        <input id="testrr" type="button" value="展示" />
    </div>

    <%@ include file="/view/algorithm/slider.jsp" %>
</div>

<%@ include file="/public/frame/bottom.jsp" %>
<script>
$("#testrr").bind("click",function(){
    var img ="public/images/frames/task1.jpg";

//    $("#my_image").attr("src", img);
   $("#my_image").attr("src",img);
});

</script>
