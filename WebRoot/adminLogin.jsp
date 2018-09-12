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
	<title>管理员登陆</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="<%=basePath%>" />
	<script type="text/javascript"
	src="resource/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resource/js/dialog-plus-min.js"></script>
	<link rel="stylesheet" type="text/css"
	href="resource/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css"
	href="resource/css/other.css" />
	<link rel="stylesheet" type="text/css"
	href="resource/css/ui-dialog.css" />
	<style type="text/css">
body {
	background: #F7F7F6 url(resource/image/bg.jpg) no-repeat center
		center fixed;
	background-size: cover;
	color: #CCC;
}

#loginPage {
	margin: 3% auto 3% 30%;
	font-size: 2.2rem;
}

label {
	font-size: 1.5rem;
}

.warning {
	font-size: 1rem;
}

#buttonsubmit {
	color: #fff;
	font-size: 1.5rem;
	background: #0079FE;
	margin-bottom: 5%;
}

#login {
	position: relative;
	opacity: 0.65;
	border-radius: 1rem;
	background-color: #fff;
	max-width: 40%;
	max-height: 80%;
	margin: 10% auto auto 30%;
	box-shadow: 0px 5px 5px lightgray;
}
</style>
</head>
<body>
	<div id="login">
		<div id="loginPage">管理员登录</div>
		<div id="form" class="form-horizontal">
			<form class="form-horizontal"  action="adminLogin" method="post">
				<div class="form-group">
					<label for="adminName" class="col-sm-3 control-label">账&nbsp;&nbsp;&nbsp;号</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="adminName"
							name="adminName" placeholder="账号" autofocus="autofocus" />
					</div>
					<label class="warning" id="loginWarning1"></label>
				</div>
				<div class="form-group">
					<label for="passWord" class="col-sm-3 control-label">
						密
						&nbsp;&nbsp;&nbsp;码
					</label>
					<div class="col-sm-6">
						<input type="passWord" class="form-control" id="passWord"
							name="passWord" placeholder="密 码" autofocus="autofocus" />
					</div>
					<label class="warning" id="loginWarning2"></label>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-10">
						<button id="buttonsubmit" type="submit" class="btn btn-default">
							登
							&nbsp;&nbsp;&nbsp;陆
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		var adminName;
		var passWord;
		$(function() {
			//账号
			$("#adminName").blur(function() {
				adminName = $("#adminName").val();
				if (adminName == "") {
					$("#loginWarning1").text("账号不为空");
				} else {
					//验证账号是否存在 
					$.ajax({
						url : 'adminLoginCheck',
						type : 'get',
						contentType : 'text/html',
						data : {admin_name:adminName}
					}).done(function(data) {
						if(data=="true"){   
					     	$("#loginWarning1").text("账号存在"); 
					    }else if(data=="false"){   
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
				$("#adminName").focus(function() {
					if (adminName != "")
						$("#loginWarning1").text("");
				});
			});
			//密码
			$("#passWord").blur(function() {
				passWord = $("#passWord").val();
				if (passWord == "") {
					$("#loginWarning2").text("密码不为空");
				}
				$("#passWord").focus(function() {
					if (passWord != "")
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
				passWord = $("#passWord").val();
				if($("#loginWarning1").text()=="账号不存在"){
					return false;
				}else if (adminName == "") {
					$("#loginWarning1").text("账号不为空");
					return false;
				} else if (passWord == "") {
					$("#loginWarning2").text("密码不为空");
					return false;
				}
			});
		});
	</script>
</body>
</html>
