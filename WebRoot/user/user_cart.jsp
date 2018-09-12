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
	}
/*****购物车*********/
.gwc{ width:950px;overflow:hidden;}
.gwc_tb1{ width:100%; border-top:5px solid #48b9e5; background:#d0e7fa; height:38px; margin-top:20px; overflow:hidden;}
.tb1_td1{ width:50px; text-align:center;}
.tb1_td2{ width:100px; text-align:center;}
.tb1_td3{ width:60px; text-align:center;}
.gwc_tb2{ width:100%; margin-top:20px; background:#eef6ff; border:1px solid #e5e5e5; padding-top:20px; padding-bottom:20px;}
.goods_checked{ width:100px; text-align:center;}
.goods_image{ width:120px; text-align:center;padding-left:100px;}
.goods_image img{ width:96px; height:96px; border:2px solid #c9c6c7;}
.goods_name{ width:100px;}
.goods_price{width:100px;text-align:center;}
.goods_name a{ font-size:14px; line-height:22px;}
.goods_num{ width:160px;text-align:right;}
.goods_all_price{width:200px;text-align:center;}
.goods_delete{width:160px;text-align:center;}


.gwc_tb3{ width:100%; border:1px solid #d2d2d2; background:#e7e7e7; height:46px; margin-top:20px; }
.gwc_tb3 tr td{font-size:14px;}
.tb3_td2{ width:160px;text-align:center;}
.tb3_td2 span{ color:#ff5500;font-size:14px; font-weight:bold; padding-left:5px; padding-right:5px; }
.tb3_td3{ width:220px;text-align:center;}
.tb3_td3 span{ font-size:18px; font-weight:bold;}
.tb3_td4{ width:110px;text-align:right;}
.jz2{ width:100px; height:46px; line-height:46px; text-align:center; font-size:18px; color:#fff; background:#ee0000; display:block; float:right;}
#settle{font-size:18px;padding:13px 30px;background-color:#F22D00;color:white;cursor:not-allowed;}/*cursor:not-allowed;pointer*/
/*****购物车*********/
</style>
</head>
<body>
		<div id="header"></div>
		<div id="search"></div>
		<div id="mainXX">
			<div class="gwc" style=" margin:auto;">
				<table cellpadding="0" cellspacing="0" class="gwc_tb1">
					<tr>
						<td class="tb1_td1"><input id="Checkbox1" type="checkbox"  class="allselect"/>全选</td>
						<td class="tb1_td2">商品信息</td>
						<td class="tb1_td3">单价(元)</td>
						<td class="tb1_td3">数量</td>
						<td class="tb1_td3">金额</td>
						<td class="tb1_td3">操作</td>
					</tr>
					</table>
				<c:forEach items="${sessionScope.cart_list}" var="list">
				<table cellpadding="0" cellspacing="0" class="gwc_tb2">
					<tr>
						<td class="goods_checked"><input type="checkbox" value="1" name="checkbox" class="newslist-1" /></td>
						<td class="goods_image"><img src="upload/${list.goods_image}"/></td>
						<td class="goods_name">${list.goods_name}</td>
						<td class="goods_price">${list.goods_price}</td>
						<td class="goods_num">
							<input class="cart_id" style="visibility:hidden;"value="${list.cart_id}"/>
							<input class="min1" name=""  style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="-" />
							<input class="text_box1" name="" type="text" value="${list.order_num}" disabled="disabled" style=" width:30px; text-align:center; border:1px solid #ccc;" />
							<input class="add1" name="" style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="+" />
						</td>
						<td class="goods_all_price"><label class="total1" class="tot" style="color:#ff5500;font-size:14px; font-weight:bold;">${list.totalPrice}</label></td>
						<td class="goods_delete" style="cursor:pointer;">删除</td>
					</tr>
				</table>
				</c:forEach>
				<table cellpadding="0" cellspacing="0" class="gwc_tb3">
					<tr>
						<td class="tb1_td1"style="width:68px;text-alin:center;"><input type="checkbox" id="checkAll" class="allselect" />全选</td>
						<td class="tb3_td2">已选商品 <label class="goodsAllNuM" style="color:#ff5500;font-size:14px; font-weight:bold;">0</label> 件</td>
						<td class="tb3_td3">合计(不含运费):<span>￥</span><span style=" color:#ff5500;"><label id="zong1" style="color:#ff5500;font-size:14px; font-weight:bold;">0</label></span></td>
						<!-- <td style="visibility:hidden;"><span id="user_name"></span></td> -->
						<td class="tb3_td4"><span id="settle">结算</span></td>
					</tr>
				</table>
			</div>
			<div style="width:100%;height:100px;"></div>
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
		/*删除*/
		$(".goods_delete").click(function(){
			var cart_id=$(this).parent().find(".cart_id").val();
			$(this).parent().find(".newslist-1").prop("checked", false);//设置为不选中
			$(this).parent().parent().parent().css("display","none");
			//ajax
				$.ajax({
					url : 'deleteCart',
					type : 'get',
					dataType : 'json',
					contentType:'text/html',
					data:{cart_id:cart_id}
				}).done(function(data) {
				}).fail(function(data) {
				}).always(function() {
					console.log("complete");
				});
				//ajax
				getCount();
				updateCartNum();
		});
		/*遍历如果为1则不能减*/
		$(".text_box1").each(function(){
			if(parseFloat($(this).val())==1){
			$(this).prev(".min1").val("");
			$(this).attr("disabled",true);
			}
		});
		
		/*减*/
		$(".min1").click(function(){
			if($(this).next(".text_box1").val()==1){
				$(this).attr("disabled",true);
				$(this).val("");
			}else{
				$(this).next(".text_box1").val(parseFloat($(this).next(".text_box1").val())-1);
				var cart_id=$(this).prev(".cart_id").val();
				var order_num=$(this).next(".text_box1").val();
				//ajax
				$.ajax({
					url : 'cartUpdateNum',
					type : 'get',
					dataType : 'json',
					contentType:'text/html',
					data:{cart_id:cart_id,order_num:order_num}
				}).done(function(data) {
				}).fail(function(data) {
				}).always(function() {
					console.log("complete");
				});
				//ajax
				var goods_price=parseFloat($(this).parent().prev(".goods_price").html());
				var goods_num=parseFloat($(this).next(".text_box1").val());
				var total=goods_price*goods_num;
				$(this).parent().next(".goods_all_price").children(".total1").text(total);
				getCount();
			}
		});
		
		/*加*/
		$(".add1").click(function(){
			$(this).prev(".text_box1").val(parseFloat($(this).prev(".text_box1").val())+1);
			var cart_id=$(this).parent().find(".cart_id").val();
			var order_num=$(this).prev(".text_box1").val();
			//ajax
			$.ajax({
				url : 'cartUpdateNum',
				type : 'get',
				dataType : 'json',
				contentType:'text/html',
				data:{cart_id:cart_id,order_num:order_num}
			}).done(function(data) {
			}).fail(function(data) {
			}).always(function() {
				console.log("complete");
			});
			//ajax
			$(this).prev(".text_box1").prev(".min1").attr("disabled",false);
			$(this).prev(".text_box1").prev(".min1").val("-");
			var goods_price=parseFloat($(this).parent().prev(".goods_price").html());
			var goods_num=parseFloat($(this).prev(".text_box1").val());
			var total=goods_price*goods_num;
			$(this).parent().next(".goods_all_price").children(".total1").text(total);
			getCount();
		});
		
		/*全选*/
		$(".allselect").click(function (){
			if($(this).is(":checked")){
				$(".gwc_tb2 input[name=checkbox]").each(function (){
					$(this).prop("checked", true);
					$(this).parent().parent().parent().parent().css({ "background-color": "pink", "color": "#ffffff" });
				});
				$("#Checkbox1").prop("checked", true);
				$("#checkAll").prop("checked", true);
			}else{
				$("input[name=checkbox]").each(function (){
						$(this).prop("checked", false);
						$("#Checkbox1").prop("checked", false);
						$("#checkAll").prop("checked", false);
						$(this).parent().parent().parent().parent().css({ "background-color": "#eef6ff", "color": "#000000" });
				});
			}
			getCount();
			settle();
		});
		
		/*单选*/
		$(".gwc_tb2 input[name=checkbox]").click(function (){
			getCount();
			settle();
		});
		
		/*单击事件*/
		$(".gwc_tb2 input[name=checkbox]").click(function () {
			if($(this).is(":checked")) {
			$(this).parent().parent().parent().parent().css({ "background-color": "pink", "color": "#ffffff" });
		} else {
			$(this).parent().parent().parent().parent().css({ "background-color": "#eef6ff", "color": "#000000" });
		}
		settle();
	});
	/*结算*/
	$("#settle").click(function(){
		/*时间*/
		var order_time=getNowDateAndHour();
		/*订单总额*/
		var order_price=$("#zong1").text();
		/*订单号*/
		var order_id=getDateAndHour();
		if($(".goodsAllNuM").text()==0){
			alert("请选择商品");
			return false;
		}else{
			//ajax
			$.ajax({
				url : 'insertOrder',
				type : 'get',
				dataType : 'json',
				contentType:'text/html',
				data:{order_time:order_time,order_price:order_price,order_id:order_id}
			}).done(function(data) {
			}).fail(function(data) {
			}).always(function() {
				console.log("complete");
			});
			//ajax
			$(".gwc_tb2 input[name=checkbox]").each(function (){
				if($(this).is(":checked")){
					/*商品名字*/
					var goods_name=$(this).parent().parent().find(".goods_name").text();
					var goods_price=$(this).parent().parent().find(".goods_price").text();
					var order_num=$(this).parent().parent().find(".text_box1").val();
					/*购物车编号*/
					var cart_id=$(this).parent().parent().find(".cart_id").val();
					//ajax
					$.ajax({
						url : 'insertOrderDetail',
						type : 'get',
						dataType : 'json',
						contentType:'text/html',
						data:{goods_price:goods_price,order_id:order_id,order_num:order_num,goods_name:goods_name}
					}).done(function(data) {
					}).fail(function(data) {
					}).always(function() {
						console.log("complete");
					});
					//ajax
					/*删除购物车:结算的时候先把订单插入再删除购物车中的商品*/
					$.ajax({
					    url : 'deleteCart',
					    type : 'get',
					    contentType : 'text/html',
					    data:{cart_id:cart_id}
					}).done(function(data) {
					}).fail(function(data) {
					}).always(function() {
						console.log("complete");
					}); 
					$(this).parent().parent().parent().parent().css("display","none");
					$(".goodsAllNuM").text(0);
					$("#zong1").text(0);
					 $("#settle").unbind("click"); 
					updateCartNum();
				}
			});
		}
		alert("生成订单成功");
	});
});
	
	/*计算购物车总数量*/
	function getCount(){
			var total=0;
			var num=0;
			$(".gwc_tb2 input[name=checkbox]").each(function (){
				if($(this).is(":checked")){
					for(var i = 0; i < $(this).length; i++){
						total+=parseFloat($(this).parent().parent().find(".total1").text());
						num+=1;
					}
				}
				$(".goodsAllNuM").text(num);
				$("#zong1").text(total);
			});
		}
	/*结算按钮*/
	function settle(){
		if($(".goodsAllNuM").text()==0){
			$("#settle").css("cursor","not-allowed");
		}else{
			$("#settle").css("cursor","pointer");
		}
	}
		/*用时间当订单号*/
	function getDateAndHour(){
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		if(month<9) month='0'+month;
			var day = date.getDate();
		if(day<10) day='0'+day;
			var hour = date.getHours();
		if(hour<10) hour='0'+hour;
			var minute = date.getMinutes();
		if(minute<10) minute='0'+minute;
			var second = date.getSeconds();
		if(second<10) second='0'+second;
			/*订单号*/
    		return  year.toString()+month.toString()+day.toString()+hour.toString()+minute.toString();
    }
    	/*获取当前日期和时间*/
	function getNowDateAndHour(){
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		if(month<9) month='0'+month;
			var day = date.getDate();
		if(day<10) day='0'+day;
			var hour = date.getHours();
		if(hour<10) hour='0'+hour;
			var minute = date.getMinutes();
		if(minute<10) minute='0'+minute;
			var second = date.getSeconds();
		if(second<10) second='0'+second;
    		return  year+'-'+month+'-'+day+' '+hour+':'+minute+':'+second;
    }
    /*删除时更新购物车数量*/
    function updateCartNum(){
		 $.ajax({
		    url : 'queryCartNum',
		    type : 'get',
		    contentType : 'text/html'
		  }).done(function(data) {
		  	var arr=data.split(",");
		  	$("#cart_num").text("("+arr[0]+")");
		  }).fail(function(data) {
		  }).always(function() {
		  	console.log("complete");
		  });
	  }
</script>
</body>
</html>