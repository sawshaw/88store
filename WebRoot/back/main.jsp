<%@ page language="java" import="java.util.*,entity.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>后台管理</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="<%=basePath%>" />
	<script type="text/javascript"
	src="resource/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css"
	href="resource/css/bootstrap.min.css" />
  </head>
<frameset rows="10%,*,5%" frameborder="no" > /*设置frame无边框*/
  	<frame name="top" noresize="noresize" scrolling="no" src="back/top.html">
  <frameset cols="8%,*">
  	<frame name="nav" noresize="noresize" src="back/nav.html">
  	<frame  name="showframe" src="back/welcome.html">
  	</frameset>
  	<frame name="footer" noresize="noresize" scrolling="no" src="back/footer.html">
  </frameset>
<noframes><body>
</body></noframes>
</html>

