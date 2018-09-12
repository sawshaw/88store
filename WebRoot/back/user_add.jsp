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
.insertUserId{
	margin:5% 10%;
}
</style>
	</head>
<body>
<h1>新增用户</h1>
<div class="insertUserId">
	<form action="addUser" method="post">
		<table>
			<tr ><td>用户名</td><td><input type="text" id="u_name" name="user_name" /></td></tr>
			<tr style="visibility:hidden;"><td></td><td>xx</td></tr>
			<tr ><td>密码</td><td><input type="text" id="u_pwd" name="user_pwd" /></td></tr>
			<tr style="visibility:hidden;"><td></td><td>xx</td></tr>
			<tr><td>手机号</td><td><input type="text" id="u_phone" name="user_phone" /></td></tr>
			<tr style="visibility:hidden;"><td></td><td>xx</td></tr>
			<tr><td>邮箱</td><td><input 	type="text" id="u_email" name="user_email" /></td></tr>
			<tr style="visibility:hidden;"><td></td><td>xx</td></tr>
			<tr><td>地址</td><td><input 	type="text" id="u_adress" name="user_adress" /></td></tr>
		</table>
		<input type="submit" id="addSubmit" value="新增"/>
	</form>
</div>
   <script>
	$(function(){
			$("#addSubmit").click(function(){
				if($("#u_name").val()==""){
					alert("用户名不为空");
					return false;
				}else if($("#u_pwd").val()==""){
					alert("密码不能为空");
					return false;
				}
			});
   	});
   </script>
  </body>
</html>
