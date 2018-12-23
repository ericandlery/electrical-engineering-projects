<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Page</title>
<style type="text/css">
</style>
<script type="text/javascript">
	window.onload=function(){
		var map=[];
		map=[{kimi:'mp4'},{ralf:'fw'}];
		map=[
			{fn:'kimi',ln:'raikkonen'},
			{fn:'ralf',ln:'schumacher'},
			{fn:'mika',ln:'hakkinen'}
			];
		console.log(map.map(getMap));
	}
	
	function getMap(item,index){
		return item.fn+' '+item.ln;
	}
	
	/*Simple get element by ID function*/
	function $(id){
		return document.getElementById(id);
	}
	
	Glo={
		a:function(){
			alert('global func a');
		}
	}
	
	/*Simple create element function*/
	function $ce(tag){
		return document.createElement(tag);
	}
	
	
</script>
</head>
<body>
	<div id="div"></div>
	<br>
	<div id="d2">test</div>
</body>
</html>