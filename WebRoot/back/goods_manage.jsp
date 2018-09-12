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
	<title>管理商品</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="<%=basePath%>" />
	<script type="text/javascript" src="resource/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" sshref="resource/css/other.css" />
	<style>
	body {
		background: #F7F7F6 url(resource/image/bg.jpg) no-repeat center center fixed;
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
	</style>
	</head>
<body>
  <div style="margin:5% auto auto 15%">
  	<div id="queryForm" style="height:50px;">
 	 	<form action="" method="post">
			<ul>
				<li>
					<label>商品名</label>
					<input id="goods_name"  type="text" />
				</li>
				<li>
					<input type="button" id="btnSearch" class="btnGo" value="查询" style="background-color:#0079FE;border:0px;" />
				</li>
				<li style="margin-left:30px;">
					<input type="button" id="insertButton" class="btnGo" value="新增商品" style="background-color:#0079FE;border:0px;" />
				</li>
				<li style="margin-left:30px;">
					<input type="button" id="newButton" class="btnGo" value="新增分类" style="background-color:#0079FE;border:0px;" />
				</li>
			</ul>
		</form>
	</div>
  <pg:pager maxPageItems="10" url="back/goods_manage.jsp">
  <div style="clear:both;text-align:center;">
    <table border="1" style="border:#0079FE;">
    <tr  class="th"><td>编号</td><td>商品名</td><td>商品数量</td><td>商品价格</td><td>种类</td><td colspan="2" style="width:100px;">操作</td></tr>
    <c:forEach items="${sessionScope.goods_list}" var="list">
    <pg:item>
    <tr>
    <td>${list.goods_id}</td>
    <td>${list.goods_name}</td>
    <td>${list.goods_num}</td>
    <td>${list.goods_price}</td>
     <td>${list.category_name}</td>
    <td style="width:50px;"><a href="back/goods_update.jsp?id=${list.goods_id}">修改</a></td>
    <td style="width:50px;"><a id="deleteById" href="back/delete.jsp?id=${list.goods_id}&m=2">删除</a></td>
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
   		 	var query_name=$("#goods_name").val();
   			location.href="back/query.jsp?query_name="+query_name+"&m="+2;
   		});
   		$("#insertButton").click(function(){
   			location.href="back/goods_add.jsp";
   		});
   		$("#newButton").click(function(){
   			location.href="back/query.jsp?query_name="+3+"&m="+3;
   		});
   	});
   </script>
  </body>
</html>
