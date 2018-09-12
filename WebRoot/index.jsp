<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@ page import="dao.*,entity.*,service.*,service.impl.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>天天果园</title>
 	<!-- <script  src="all.html"></script> -->
 	<script type="text/javascript" src="resource/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resource/js/load.js"></script>
	<link href="resource/css/common.css" rel="stylesheet">
	<style type="text/css">
	body,html{
		height: 100%;
	}
 	.mainList ul li{
		list-style:none;
		color:#D48B55;
		font-size:16px;
	}
	.list_goods_price a{
		color:#669933;
		font-weight:bolder;
		font-size:22px;	
	}
	.list_goods_price span{
		color:#669933;
		font-weight:bolder;
		font-size:22px;	
	}
	.list_car{
		 background:#669933;
		 color:#fff;
		 float:right;
		 padding:5px 10px;
		 font-weight:bolder;
		 border-radius:5px;
	}
</style>
</head>
<body>
		<div id="header"></div>
		<div id="search"></div>
		<div id="left"></div>
		<div id="main">
			<div style="margin-left:20px;">
    				<%
	    				 GoodsService service = new GoodsServiceImpl();
						 List<Goods> list = service.queryAll();
						 session.setAttribute("goods_list", list) ;
						   %>
	    				<c:forEach items="${sessionScope.goods_list}" var="list">
	    				<div class="mainList" style="float:left;margin-left:-20px;margin-bottom:10px;">
					    	<ul>
					    		<li>
					    			<a href="goods_detail.jsp?goods_id=${list.goods_id}">
					    				<img src="upload/${list.goods_image}" height="180" width="180"/>
					    			</a>
					    		</li>
					    		<li>${list.goods_name}</li>
					    		<li class="list_goods_price">
					    			<span>￥</span><a>${list.goods_price}</a>
					    		</li>
					    		<li>
					    			<a  href="javascript:void(0)" class="list_car" data-value="${list.goods_id}">加入购物车</a>
					    		</li>
					    	</ul>
   						</div>
   						</c:forEach>
   					</div>
    	 		</div>
		<div id="footer"></div>
		<script type="text/javascript">
		$(function(){
			$(".list_car").click(function(){
				var goods_id=$(this).attr("data-value");
				$.ajax({
					url : 'addToCart',
					type : 'get',
					dataType : 'json',
					contentType:'text/html',
					data : {goods_id : goods_id}
				}).done(function(data) {
					if(data==false){
						if(confirm("你没有登录")){
							location.href="login.jsp";
						}
					}else{
						alert("加入购物车成功!");
						 /*用户登录时查找用户购物车数量*/
				       $.ajax({
						    url : 'queryCartNum',
						    type : 'get',
						    contentType : 'text/html'
						  }).done(function(data) {
						  	var arr=data.split(",");
						  	$("#cart_num").text("("+arr[0]+")");
						  }).fail(function(data) {
						  }).always(function() {
						  	console.log("complete");
						  });
				      /*end*/
					}
				}).fail(function(data) {
				}).always(function() {
					console.log("complete");
				});
			});
		});
		</script>
</body>
</html>