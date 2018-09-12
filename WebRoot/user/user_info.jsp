<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
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
 	<script type="text/javascript" src="./resource/js/jquery-2.1.1.min.js"></script>
	<link href="./resource/css/common.css" rel="stylesheet">
	<style type="text/css">
	body,html{
		height: 100%;
	}
	#mainXX{
		min-height: 568px;
		margin:100px 200px;
	}
</style>
</head>
<body>
		<div id="header"></div>
		<div id="search"></div>
		<div id="mainXX">
    	</div>
		<div id="footer"></div>
		<script type="text/javascript">
	$(document).ready(function () {
		$("#header").load("header.html",function() {
		});
		$("#footer").load("footer.html",function(){
		});
		$("#search").load("search.html",function(){
		});
});
</script>
</body>
</html>