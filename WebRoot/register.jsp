<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>用户注册</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="<%=basePath%>" />
	<script type="text/javascript" src="resource/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/other.css" />
	<style type="text/css">
body {
	background: url(resource/image/bg.jpg) no-repeat center center fixed;
	background-size: cover;
}
#registerPage {
	width: 50%;
	height: 50%;
	margin: 10% auto auto 55%;
	font-size: 3.2rem;
	color: #fff;
}
#form {
	width: 50%;
	height: 50%;
	position: relative;
	margin: 5% 40%;
}

label {
	font-size: 1.5rem;
	color: #fff;
}
.warning{
	font-size: 1rem;
}
#buttonsubmit{
	border-color: #fff;
	color: #fff;
	font-size: 1.5rem;
	background-color: transparent;
}
</style>
</head>
<body>
	<div id="registerPage">用户注册</div>
	<div id="form" class="form-horizontal">
		<form class="form-horizontal" action="userRegister" method="post">
			<div class="form-group">
				<label for="userName" class="col-sm-3 control-label">用户名</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="userName" name="userName" placeholder="用户名" autofocus="autofocus"></div>
				<label class="warning" id="loginWarning1"></label>
			</div>
			<div class="form-group">
				<label for="passWord" class="col-sm-3 control-label">密 &nbsp;&nbsp;&nbsp;码</label>
				<div class="col-sm-5">
					<input type="passWord" class="form-control" id="passWord" name="passWord" placeholder="密 码" autofocus="autofocus"></div>
				<label class="warning" id="loginWarning2"></label>
			</div>
			<div class="form-group">
				<label for="passWord1" class="col-sm-3 control-label">重复密码</label>
				<div class="col-sm-5">
					<input type="passWord" class="form-control" id="passWord1" name="passWord1" placeholder="重复密 码" autofocus="autofocus"></div>
				<label class="warning" id="loginWarning3"></label>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">邮 &nbsp;&nbsp;&nbsp;箱</label>
				<div class="col-sm-5">
					<input type="email" class="form-control" id="email" name="email" placeholder="xxx@xx.com" autofocus="autofocus"></div>
				<label class="warning" id="loginWarning4"></label>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<button id ="buttonsubmit" type="submit" class="btn btn-default">注 &nbsp;&nbsp;&nbsp;册</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	$(function() {
		/** 用户注册验证**/
		$("#userName").blur(function(){
			var userName=$("#userName").val();
			if(userName==""){
				$("#loginWarning1").text("账号不为空");
			}else if(!(/^[A-Za-z0-9]+$/).test(userName)){
					$("#loginWarning1").text("账号为数字或密码的组合");
		     }else{//ajax
		     	$.ajax({
						url : 'UserCheck',
						type : 'get',
						dataType : 'json',
						contentType:'text/html',
						data : {user_name : userName}
					}).done(function(data) {
						if(data==true){
							$("#loginWarning1").text("账号已注册");
						}else if(data==false){
							$("#loginWarning1").text("账号可注册");
						}else{
							alert("错误");
						}
					}).fail(function(data) {
						$("#loginWarning1").text("发送请求失败");
					}).always(function() {
						console.log("complete");
					});
		     //ajax
		     }
			$("#userName").focus(function(event) {
				if(userName!=""){
					$("#loginWarning1").text("");
				}
			});
		});
		$("#passWord").blur(function(){
			var passWord=$("#passWord").val();
			if(passWord==""){
				$("#loginWarning2").text("密码不为空");
			}
			$("#passWord").focus(function(event) {
				if(passWord!=""){
					$("#loginWarning2").text("");
				}
			});
		});
		$("#passWord1").blur(function(){
			var passWord1=$("#passWord1").val();
			if(passWord1==""){
				$("#loginWarning3").text("密码不为空");
			}
		$("#passWord1").focus(function(event) {
			if(passWord1!=""){
				$("#loginWarning3").text("");
			}
		});
		});
		$("#email").blur(function(){
			var email=$("#email").val();
			if(email==""){
				$("#loginWarning4").text("邮件地址不为空");
			}
		$("#email").focus(function(event) {
			if(email!=""){
			$("#loginWarning4").text("");
			}
		});
		});
		$(document).keydown(function(event){
			if(event.keyCode==13){
				$("#buttonsubmit").click();
			}
		});
		$("#buttonsubmit").click(function(event) {
			if($("#userName").val()==""){
				$("#loginWarning1").text("账号不为空");
				return false;
			}else if($("#loginWarning1").text()=="账号已注册"||$("#loginWarning1").text()=="账号为数字或密码的组合"){
				return false;
			}else if ($("#passWord").val()==""){
				$("#loginWarning2").text("密码不为空");
				return false;
			}else if ($("#passWord1").val()=="") {
				$("#loginWarning3").text("确认密码不为空");
				return false;
			}else if ($("#passWord").val()!=$("#passWord1").val()) {
				$("#loginWarning3").text("密码不一致");
				return false;
			}else if ($("#email").val()=="") {
				$("#loginWarning4").text("邮件地址不为空");
				return false;
			}
		});
	});
	</script>
</body>
</html>