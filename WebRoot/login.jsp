<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<title>用户登陆</title>
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
	background: url(resource/image/bg.jpg) no-repeat center center
		fixed;
	background-size: cover;
	color: #fff;
}

#loginPage {
	width: 20%;
	height: 50%;
	margin: 10% auto auto 55%;
	font-size: 3.2rem;
}

#form {
	width: 50%;
	height: 50%;
	position: relative;
	margin: 5% 40%;
}

label {
	font-size: 1.5rem;
}

.warning {
	font-size: 1rem;
}

table {
	margin-left: 26%;
}

#rememberPwd {
	max-width: 1.5rem;
	max-height: 1.5rem;
	min-width: 0.6rem;
	min-height: 0.6rem;
}

#buttonsubmit {
	border-color: #fff;
	color: #fff;
	font-size: 1.5rem;
	background-color: transparent;
}
</style>
</head>
<body>
	<div id="loginPage">用户登录</div>
	<div id="form" class="form-horizontal">
		<form class="form-horizontal" action="userLogin" method="post">
			<div class="form-group">
				<label for="userName" class="col-sm-3 control-label">用户名</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="userName"
						name="userName" placeholder="用户名" autofocus="autofocus" />
				</div>
				<label class="warning" id="loginWarning1"></label>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;码</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="passWord"
						name="passWord" placeholder="密 码" autofocus="autofocus" />
				</div>
				<label class="warning" id="loginWarning2"></label>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<button id="buttonsubmit" type="submit" class="btn btn-default">登&nbsp;&nbsp;&nbsp;陆</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var userName;
		var passWord;
		$(function() {
			//账号
			$("#userName").blur(function() {
				userName = $("#userName").val();
				if (userName == "") {
					$("#loginWarning1").text("账号不为空");
				} else { 
					//验证账号是否存在
					$.ajax({
						url : 'UserCheck',
						type : 'get',
						dataType : 'json',
						contentType:'text/html',
						data : {user_name : userName}
					}).done(function(data) {
						if(data==true){
						}else if(data==false){
							$("#loginWarning1").text("账号不存在");
						}else{
							alert("错误");
						}
					}).fail(function(data) {
						$("#loginWarning1").text("发送请求失败");
					}).always(function() {
						console.log("complete");
					});
				}
				$("#userName").focus(function() {
					if (userName != "")
						$("#loginWarning1").text("");
				});
			});
				//密码
				$("#passWord").blur(function() {
					passWord = $("#passWord").val();
					if (passWord == "") {
						$("#loginWarning2").text("密码不为空");
				}
					$("#password").focus(function() {
						if (password != "")
							$("#loginWarning2").text("");
					});
				});
			//键盘事件绑定
			$(document).keydown(function(event) {
				if (event.keyCode == 13) {
					$("#buttonsubmit").click();
				}
			});
			//表单提交表单只有return false才不会提交
			$("#buttonsubmit").click(function(event) {
				passWord = $("#passWord").val();
				if (userName == "") {
					$("#loginWarning1").text("账号不为空");
					return false;
				}else if($("#loginWarning1").text()=="账号不存在"){
					return false;
				}else if (passWord == "") {
					$("#loginWarning2").text("密码不为空");
					return false;
				}
			});
			});
	</script>
</body>
</html>