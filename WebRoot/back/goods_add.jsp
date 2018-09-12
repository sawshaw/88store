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
	<title>新增商品</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="<%=basePath%>" />
	<script type="text/javascript"
	src="resource/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/other.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/ui-dialog.css" />
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
.insertGoodsId{
	margin:1% 10%;
}
</style>
	</head>
<body>
<h1>新增商品</h1>
<div class="insertGoodsId">
	<form action="addGoods" enctype="multipart/form-data" method="post">
		<table>
			<tr ><td>商品名:</td><td><input type="text" id="g_name" name="goods_name" /></td></tr>
			<tr style="visibility:hidden;"><td></td><td>x</td></tr>
			<tr ><td>商品数量:</td><td><input type="text" id="g_num" name="goods_num" /></td></tr>
			<tr style="visibility:hidden;"><td></td><td>x</td></tr>
			<tr><td>商品价格:</td><td><input type="text" id="g_price" name="goods_price" /></td></tr>
			<tr style="visibility:hidden;"><td></td><td>x</td></tr>
			<tr><td>类别:</td><td>
			<select  id="category" name="category"  style="color:black;">
			<option value="">请选择商品类别:</option>
			</select></td></tr>
			<tr style="visibility:hidden;"><td></td><td>x</td></tr>
			<tr><td>图片:</td><td><input type="file" name="g_image" id="goods_image"/>  </td></tr>
			<tr><td>商品介绍:</td></tr>
			<tr><td colspan="2"><textarea name="goods_desc" cols="35" rows="5"  style="color:#000;"></textarea></td></tr>
		</table>
		<input type="submit" id="addSubmit" value="新增"/>
	</form>
</div>
   <script>
	$(function(){
		//遍历结果集
			$.ajax({
				url : 'queryAllCategory',
				type : 'get',
				contentType : 'text/html'
			}).done(function(data) {
			var json=$.parseJSON(data);//将json字符串转化成json对象
			for(var i=0;i<json.length;i++){
				$("#category").append("<option value='" + json[i].category_id + "'>" + json[i].category_name + "</option>");
			}
			}).fail(function(data) {
			}).always(function() {
				console.log("complete");
			});
			$("#addSubmit").click(function(){
				if($("#g_name").val()=="" || $("#g_name").val()==null){
					alert("请选择商品名字");
					return false;
				}else if($("#g_num").val()==""){
					alert("商品数量不能为空");
					return false;
				}else if($("#g_price").val()==""){
					alert("商品价格不能为空");
					return false;
				}else if($("#category").val()==""){
					alert("请选择商品类别");
					return false;
				}else if ($("#goods_desc").val()==""){
					alert("商品详细介绍不能为空");
					return false;
				}
			});
   	});
   </script>
  </body>
</html>
