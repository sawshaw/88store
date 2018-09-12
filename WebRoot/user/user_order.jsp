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
	th{
		width:200px;
		text-align:center;
	}
	td{
		width:200px;
		text-align:center;
	}
</style>
</head>
<body>
		<div id="header"></div>
		<div id="search"></div>
		<div id="mainXX">
		<h1>订单列表</h1>
			<div id="orderList">
			<table>
				<tr>
					<th>订单号</th>
					<th>价格(元)</th>
					<th>下单时间</th>
				</tr>
			</table>
			</div>
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
		queryOrder();
		$(document).on("click",".order_detail",function(){//动态绑定
			var order_id=$(this).find(".order_id").text();
			var XX=$(this).parent().parent().parent().find(".XX");
			XX.parent().siblings().find(".XX").hide();
			$(this).parent().parent().next(".orderDetail").show();
			$(this).parent().parent().siblings().next(".orderDetail").hide();
			$.ajax({
				url : 'userQueryOrderDetail',
				type : 'get',
				dataType : 'json',
				contentType:'text/html',
				data:{order_id:order_id}
			}).done(function(data) {
				//var json=eval("("+data+")");
				for(var i=0;i<data.length;i++){
					XX.append("<table>"+"<tr class='order_xx'>"
							+"<td class='order_goods_name'>"+ data[i].goods_name+"</td>"
							+"<td class='order_goods_price'>"+data[i].goods_price+"</td>"
							+"<td class='order_order_num'>"+data[i].order_num+"</td>"
							+"</tr>"+"</table>");
				}
			}).fail(function(data) {
			}).always(function() {
				console.log("complete");
			});
	});
});
	/*查询订单*/
	function queryOrder(){
		$.ajax({
			url : 'userQueryOrder',
			type : 'get',
			dataType : 'json',
			contentType:'text/html'
		}).done(function(data) {
			//var json=eval("("+data+")");
			for(var i=0;i<data.length;i++){
				$("#orderList").append("<table>"
					+"<tr class='order_detail'>"
						+"<td class='order_id'>"+ data[i].order_id+"</td>"
						+"<td class='order_price'>"+data[i].order_price+"</td>"
						+"<td class='order_time'>"+(parseInt(data[i].order_time.year)+1900)+"-"+(parseInt(data[i].order_time.month)+1)+"-"+(data[i].order_time.date)+" "+(parseInt(data[i].order_time.hours)+1)+":"+(data[i].order_time.minutes)+":"+(data[i].order_time.seconds)+"</td>"
					+"</tr>"
				+"</table>"
				+"<table class='orderDetail' style='display:none;'>"
				+"<tr>"
					+"<td>商品名</td>"
					+"<td>价格(元)</td>"
					+"<td>数量</td>"
				+"</tr>"
			+"</table>"
			+"<div class='XX'>"
			+"</div>");
			}
		}).fail(function(data) {
		}).always(function() {
			console.log("complete");
		});
	}
</script>
</body>
</html>