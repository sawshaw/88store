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
	<title>管理用户</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="<%=basePath%>" />
	<script type="text/javascript" src="resource/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/other.css" />
	<style type="text/css">
body {
	background: #F7F7F6 url(resource/image/bg.jpg) no-repeat center
		center fixed;
	background-size: cover;
	font-size:2rem;
	color: #fff;
}	
input[type="text"]{
	color:black;
}
input[type="submit"]{
	background-color:#0079FE;
	border:0px;
	margin:10px auto auto 15%;
}
.updateUserId{
	margin:5% 10%;
}
</style>
	</head>
<body>
<h1>更新用户</h1>
<div class="updateUserId">
	<form action="updateUser" method="post">
		<table>
			<tr><td>id</td><td><input type="text" id="u_id" name="user_id" readonly="readonly"/></td></tr>
			<tr style="visibility:hidden;"><td></td><td>xx</td></tr>
			<tr ><td>用户名</td><td><input type="text" id="u_name" name="user_name" /></td></tr>
			<tr style="visibility:hidden;"><td></td><td>xx</td></tr>
			<tr><td>手机号</td><td><input type="text" id="u_phone" name="user_phone" /></td></tr>
			<tr style="visibility:hidden;"><td></td><td>xx</td></tr>
			<tr><td>邮箱</td><td><input 	type="text" id="u_email" name="user_email" /></td></tr>
			<tr style="visibility:hidden;"><td></td><td>xx</td></tr>
			<tr><td>地址</td><td><input 	type="text" id="u_adress" name="user_adress" /></td></tr>
		</table>
		<input type="submit" id="updateSubmit" value="修改"/>
	</form>
</div>
   <script>
	$(function(){
   	var id=getUrlParam("id").replace(/\+/g," ");
   			$("#u_id").val(id);
   			$.ajax({
				url : 'queryByUserId',
				type : 'get',
				contentType : 'text/html',
				data : {user_id:id}
			}).done(function(data) {
				if(data!=false){
				var arr=data.split(",");
				if(arr[0]!="null"){
					$("#u_name").val(arr[0]);
				}
				if(arr[1]!="null"){
					$("#u_phone").val(arr[1]);
				}
				if(arr[2]!="null"){
					$("#u_email").val(arr[2]);	
				}
				if(arr[3]!="null"){
					$("#u_adress").val(arr[3]);
				}
				}else{
					alert("查找用户失败");
				}
			}).fail(function(data) {
			}).always(function() {
				console.log("complete");
			});
			$("#updateSubmit").click(function(){
				if($("#u_name").val()==""){
					alert("用户名不为空");
				}
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
