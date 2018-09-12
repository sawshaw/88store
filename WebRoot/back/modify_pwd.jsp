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
	<title>密码管理</title>
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
	margin: 10% auto auto 40%;
	font-size: 3.2rem;
}

#form {
	width: 50%;
	height: 50%;
	position: relative;
	margin: 5% auto;
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
	<div id="loginPage">修改密码</div>
	<div id="form" class="form-horizontal">
		<form class="form-horizontal">
			<div class="form-group">
				<label for="oldPwd" class="col-sm-3 control-label">原密码</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="oldPwd"
						name="oldPwd" placeholder="原密码" autofocus="autofocus" />
				</div>
				<label class="warning" id="loginWarning1"></label>
			</div>
			<div class="form-group">
				<label for="newPwd" class="col-sm-3 control-label">新密码</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="newPwd"
						name="newPwd" placeholder="新密码" autofocus="autofocus" />
				</div>
				<label class="warning" id="loginWarning2"></label>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<button id="buttonsubmit" type="submit" class="btn btn-default">修&nbsp;&nbsp;&nbsp;改</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var oldPwd;
		var newPwd;
		$(function() {
			//旧密码
			$("#oldPwd").blur(function() {
				oldPwd = $("#oldPwd").val();
				if (oldPwd == "") {
					$("#loginWarning1").text("旧密码不为空");
				}else {
					//验证原密码是否正确 
					$.ajax({
						url : 'adminPwdCheck',
						type : 'get',
						contentType : 'text/html',
						data : {oldPwd:oldPwd}
					}).done(function(data) {
						if(data=="true"){   
					     	$("#loginWarning1").text("密码正确"); 
					    }else if(data=="false"){   
					     	$("#loginWarning1").text("密码不正确"); 
					     }else{
					     	alert("错误");
					     } 
					}).fail(function(data) {
						$("#loginWarning1").text("发送请求失败");
					}).always(function() {
						console.log("complete");
					});
				} 
				$("#oldPwd").focus(function() {
					if (oldPwd != "")
						$("#loginWarning1").text("");
				});
			});
				//新密码
				$("#newPwd").blur(function() {
					newPwd = $("#newPwd").val();
					if (newPwd == "") {
						$("#loginWarning2").text("新密码不为空");
				}
					$("#newPwd").focus(function() {
						if (newPwd != "")
							$("#loginWarning2").text("");
					});
				});
			//键盘事件绑定
			$(document).keydown(function(event) {
				if (event.keyCode == 13) {
					$("#buttonsubmit").click();
				}
			});
			//表单提交
			$("#buttonsubmit").click(function(event) {
				newPwd=$("#newPwd").val();
				if($("#loginWarning1").text()=="密码不正确"){
					return false;
				}else if (oldPwd == "") {
					$("#loginWarning1").text("旧密码不为空");
					return false;
				}else if (newPwd== "") {
					$("#loginWarning2").text("新密码不为空");
					return false;
				}else{
					//提交表单
					$.ajax({
						url : 'modifyAdminPwd',
						type : 'get',
						contentType : 'text/html',
						data : {newPwd:newPwd}
					}).done(function(data) {
						if(data=="true"){ 
							console.log("修改成功");  
					    }else if(data=="false"){ 
					    	console.log("修改失败");
					    	alert("更改失败");
					     }else{
					     	alert("错误");
					     } 
					}).fail(function(data) {
						$("#loginWarning1").text("发送请求失败");
					}).always(function() {
						console.log("complete");
						//强制刷新父页面,关闭当前页面，开一个新页面
						//window.parent.location.reload(true);
						window.opener=null;
						window.open('','_self');
						window.close();//关闭当前页面
						location.href="back/aa.jsp";//刷新退出登录
					});
				}
						window.open("adminLogin.jsp");//打开一个新页面
			});
			});
	</script>
</body>
</html>