<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="public/frame/head.jsp" flush="true"/>
        <div id="slider" class="container">
        
       
        
        
	        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	        <!-- Indicators -->
	        <ol class="carousel-indicators">
	        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	        </ol>
	        <!-- Wrapper for slides -->
	        <div class="carousel-inner">
	        <div class="item active">
	        <img src="public/images/frames/carousel_1.jpg" alt="">
	        <div class="carousel-caption">
	
	        </div>
	        </div>
	        <div class="item">
	        <img src="public/images/frames/carousel_2.jpg" alt="">
	        <div class="carousel-caption">
	        ...
	        </div>
	        </div>
	        <div class="item">
	        <img src="public/images/frames/carousel_3.jpg" alt="">
	        <div class="carousel-caption">
	        ...
	        </div>
	        </div>
	        ...
	        </div>
	        <!-- Controls -->
	        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
	        <span class="glyphicon glyphicon-chevron-left"></span>
	        </a>
	        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
	        <span class="glyphicon glyphicon-chevron-right"></span>
	        </a>
        </div>
        </div>
        <br><br>

        <div class="container">
        <div class="row panel panel-default">
        <div class="panel-heading">
        <h3>案例简介</h3>
        </div>
        <div class="panel-body">
        <ul class="thumbnails">
        <li class="col-md-3">
        <div class="thumbnail"><img data-src="holder.js/300x200" alt="300x200" src="public/images/frames/task1.jpg" />
        <div class="caption" contenteditable="true">
        <h3>改进型哈佛结构</h3>

        <p>改进型的哈佛结构具有一条独立的地址总线和一条独立的数据总线，两条总线由程序存储器和数据存储器分时复用，使结构更紧凑。</p>

        <p><a class="btn btn-primary" href="#">浏览</a> <a class="btn" href="#">分享</a></p>
        </div>
        </div>
        </li>
        <li class="col-md-3">
        <div class="thumbnail"><img data-src= "holder.js/300x200" alt="300x200" src="public/images/frames/task2.jpg" />
        <div class="caption" contenteditable="true">
        <h3>哈佛结构</h3>

        <p>哈佛结构是一种将程序指令存储和数据存储分开的存储器结构，它的主要特点是将程序和数据存储在不同的存储空间中，进行独立编址。</p>

        <p><a class="btn btn-primary" href="#">浏览</a> <a class="btn" href="#">分享</a></p>
        </div>
        </div>
        </li>
        <li class="col-md-3">
        <div class="thumbnail"><img data-src="holder.js/300x200" alt="300x200" src="public/images/frames/task3.jpg" />
        <div class="caption" contenteditable="true">
        <h3>改进型哈佛结构</h3>

        <p>改进型的哈佛结构具有一条独立的地址总线和一条独立的数据总线，两条总线由程序存储器和数据存储器分时复用，使结构更紧凑。</p>

        <p><a class="btn btn-primary" href="#">浏览</a> <a class="btn" href="#">分享</a></p>
        </div>
        </div>
        </li>
        <li class="col-md-3">
        <div class="thumbnail"><img data-src="holder.js/300x200" alt="300x200" src="public/images/frames/task4.jpg" />
        <div class="caption" contenteditable="true">
        <h3>改进型哈佛结构</h3>

        <p>改进型的哈佛结构具有一条独立的地址总线和一条独立的数据总线，两条总线由程序存储器和数据存储器分时复用，使结构更紧凑。</p>

        <p><a class="btn btn-primary" href="#">浏览</a> <a class="btn" href="#">分享</a></p>
        </div>
        </div>
        </li>
        </ul>
        </div>
        </div>
        </div>
        <%@ include file="public/frame/bottom.jsp" %>