<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>查询和新增商品分类</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="<%=basePath%>"/>
	<script type="text/javascript" src="resource/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/other.css" />
	<style type="text/css">
body {
	background: #F7F7F6 url(resource/image/bg.jpg) no-repeat center center fixed;
	background-size: cover;
	font-size:2rem;
	color: #fff;
}
input[type="text"]{
		width:150px;
		height:30px;
		color:black;
	}
.btnGo{
		background-color:#0079FE;
		border:0px;
	}
</style>
</head>
<body>
	<h1>查询中...</h1>
	<div class="newCategory" style="display:none;margin-left:100px">
		分类名称:
		<input type="text" name="category_name" id="category_name"/>
		<input type="submit" value="新增" class="btnGo"/>
	</div>
	<script>
	$(function(){
	var query_name=getUrlParam("query_name").replace(/\+/g," ");
	var m=getUrlParam("m").replace(/\+/g," ");
	if(m==1){
   			$.ajax({
				url : 'queryAllUser',
				type : 'get',
				contentType : 'text/html',
				data : {query_name:query_name}
			}).done(function(data) {
				location.href="back/user_manage.jsp";
			}).fail(function(data) {
			}).always(function() {
				console.log("complete");
			});
		}else if(m==2){
			$.ajax({
				url : 'queryAllGoods',
				type : 'get',
				contentType : 'text/html',
				data : {query_name:query_name}
			}).done(function(data) {
				location.href="back/goods_manage.jsp";
			}).fail(function(data) {
			}).always(function() {
				console.log("complete");
			});
		}else if(m==3){
			$("h1").html("新增分类");
			$(".newCategory").show();
			$(".btnGo").click(function(){
				var category_name=$("#category_name").val();
				console.log(category_name);
				alert($("#category_name").val());
				$.ajax({
					url : 'newCategory',
					type : 'get',
					contentType : 'text/html',
					data : {category_name:category_name}
				}).done(function(data) {
					location.href="back/goods_manage.jsp";
				}).fail(function(data) {
				}).always(function() {
					console.log("complete");
				});	
			});
		}else if(m==4){
			$.ajax({
				url : 'queryAllOrder',
				type : 'get',
				contentType : 'text/html',
				data : {query_name:query_name}
			}).done(function(data) {
				location.href="back/order_manage.jsp";
			}).fail(function(data) {
			}).always(function() {
				console.log("complete");
			});
		}
   	});
   	function getUrlParam(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
		}
   </script>
</body>
</html>