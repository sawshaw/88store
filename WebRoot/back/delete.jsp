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
	<title>删除用户中转页</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="<%=basePath%>" />
	<script type="text/javascript"
	src="resource/js/jquery-2.1.1.min.js"></script>
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
	</style>
	</head>
<body>
<h1>删除中...</h1>
   <script>
	$(function(){
   	var id=getUrlParam("id").replace(/\+/g," ");//获取id值
   	var m=getUrlParam("m").replace(/\+/g," ");//把值传过去后台根据m判断是哪个页面执行哪个操作
   	if(m==1){
			$.ajax({
				url : 'deleteUserById',
				type : 'get',
				contentType : 'text/html',
				data : {id:id}
			}).done(function(data) {
				location.href="queryAllUser";
			}).fail(function(data) {
			console.log("fail");
			}).always(function() {
				console.log("complete");
			});
		}else if(m==2){
			$.ajax({
				url : 'deleteGoodsById',
				type : 'get',
				contentType : 'text/html',
				data : {id:id}
			}).done(function(data) {
				location.href="queryAllGoods";
			}).fail(function(data) {
			console.log("fail");
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
