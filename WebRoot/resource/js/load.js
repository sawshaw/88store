/*div定位和异步加载页面.页面启动时加载页头和页尾*/
$(function(){
		$("#header").load("header.html",function() {
	});
		$("#footer").load("footer.html",function(){
		});
		$("#left").load("left.html",function(){
		});
		$("#search").load("search.html",function(){
		});
});
