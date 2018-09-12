<%@ page language="java" import="java.util.*" pageEncoding="utf-8" buffer="none"%>
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
	<title>管理订单</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="<%=basePath%>" />
	<script type="text/javascript" src="resource/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/other.css" />
	<style>
	body {
		background: #F7F7F6 url(resource/image/bg.jpg) no-repeat center
			center fixed;
		background-size: cover;
		font-size:2rem;
		color: #fff;
}	
	td{
		width:100px;
	}
	.th{
		font-weight:bolder;
	}
	ul li{
		list-style:none;
		float:left;
		margin-left:10px;
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
  <div style="margin:5% auto auto 15%">
  	<div id="queryForm" style="height:50px;">
 	 	<form action="" method="post">
			<ul>
				<li>
					<label>用户名</label>
					<input id="user_name"  type="text" />
				</li>
				<li>
					<input type="button" id="btnSearch" class="btnGo" value="查询"  />
				</li>
			</ul>
		</form>
	</div>
  <pg:pager maxPageItems="10" url="back/user_manage.jsp">
  <div style="clear:both;text-align:center;">
    <table border="1" style="border:#0079FE;">
    <tr class="th"><td>订单号</td><td>商品名称</td><td>商品价格</td><td>商品数量</td><td>用户名</td></tr>
    <c:forEach items="${sessionScope.order_list}" var="list">
    <pg:item>
    <tr>
    <td>${list.order_id}</td>
    <td>${list.goods_name}</td>
    <td>${list.goods_price}</td>
    <td>${list.order_num}</td>
    <td>${list.user_name}</td>
    </tr>
    </pg:item>
    </c:forEach>
    </table>
    </div>
    <div style="width:300px;font-size:16px; margin:20px auto auto 150px;"> 
    <pg:index>
    <pg:first><a href="${pageUrl}">第一页</a></pg:first>
    <pg:prev><a href="${pageUrl}">上一页</a></pg:prev>
    <pg:pages><a href="${pageUrl}">${pageNumber}</a></pg:pages>
    <pg:next><a href="${pageUrl}">下一页</a></pg:next>
    <pg:last><a href="${pageUrl}">最后一页</a></pg:last>
    </pg:index>
    </div>
   </pg:pager>
   </div>
   <script>
	$(function(){ 
   		$("#btnSearch").click(function(){
   		 	var query_name=$("#user_name").val();
   			location.href="back/query.jsp?query_name="+query_name+"&m="+4;
   		});
   	});
   </script>
  </body>
</html>
