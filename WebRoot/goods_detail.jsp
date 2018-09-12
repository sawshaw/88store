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
	<script type="text/javascript" src="resource/js/jquery.spinner.js"></script>
	<link href="resource/css/jquery.spinner.css" rel="stylesheet">
	<link href="resource/css/common.css" rel="stylesheet">
	<style type="text/css">
	body,html{
		height: 100%;
	}
	.wrapper{
		margin-left:50px;
	}	
	#goods_image{
		float:left;
	}
	.detail_wrapper{
	float:left;
	margin:50px auto auto 50px;
	}
	span{
		color:#D48B55;
	}
	#goods_name{
		font-size:24px;
	}
	#goods_price{
		font-size:16px;
	}
	#goods_num{
		font-size:16px;
	}
	#goods_desc{
		clear:both;
	}
	.list_car{
		 background:#669933;
		 color:#fff;
		 padding:10px 10px;
		 font-weight:bolder;
		 border-radius:5px;
		 cursor:pointer;
		 margin-left:60px;
	}
	.spinner{
	display:inline-block;
	}
	#num{
		display:inline;
	}
	.foot_span{
		color:white;
	}
</style>
</head>
<body>
		<div id="header"></div>
		<div id="search"></div>
		<div id="left"></div>
		<div id="main">
			<div class="wrapper">
				<span>
					<img src="" height="270" width="270" id="goods_image"/>
				</span>
				<div class="detail_wrapper">
						<span id="goods_name">
						</span><br><br>
						<span id="goods_price">
						</span>
						<span id="goods_num">
						</span><br><br><br><br>
						<span id="num">
							<input type="text" class="spinner" id="spinner"/>
						</span>
						<span class="list_car">
						加入购物车
						</span>
				</div>
				<div style="clear:both;visibility:hidden;">XXX</div>
				<div style="background-color:#65A031;width:100%;height:30px;clear:both;margin-top:20px;font-size:24px;color:white;">商品详情</div>
				<div id="goods_desc" style="margin-top:10px;"></div>
			</div>
    	</div>
		<div id="footer"></div>
	<script type="text/javascript">
		$(function(){
		var goods_id=getUrlParam("goods_id").replace(/\+/g," ");
		  $.ajax({
		    url : 'queryByGoodsId',
		    type : 'get',
		    contentType : 'text/html',
		    data:{goods_id:goods_id}
		  }).done(function(data) {
		 	if(data!=false){
				var arr=data.split(",");
				if(arr[0]!="null"){
					$("#goods_name").text(arr[0]);
				}
				if(arr[1]!="null"){
					$("#goods_num").html("商品数量:<b>"+arr[1]+"</b>");
				}
				if(arr[2]!="null"){
					$("#goods_price").html("价格:<b>"+arr[2]+"</b>元,");	
				}
				if(arr[4]!="null"){
					$("#goods_desc").text(arr[4]);
				}
				if(arr[5]!="null"){
					$("#goods_image").attr("src", "upload/"+arr[5]);//改变图片源 
				}
			}else{
				alert("查找商品信息失败");
				}
		  }).fail(function(data) {
		  }).always(function() {
		  	console.log("complete");
		  });
		   $(".spinner").spinner({});
		   $(".list_car").click(function(){
		  		 $.ajax({
				    url : 'addToCart',
				    type : 'get',
				    contentType : 'text/html',
				    data : {goods_id : goods_id,order_num :$("#spinner").val()}
				  }).done(function(data) {
				  	if(data=="false"){
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
		function getUrlParam(name){
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg);  //匹配目标参数
			if (r!=null) return unescape(r[2]); return null; //返回参数值
		}
	</script>
</body>
</html>