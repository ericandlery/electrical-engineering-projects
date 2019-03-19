<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToolTip</title>
<style type="text/css">
	.tooltip{position: relative;display: inline-block;border-bottom: 1px dotted black;cursor: pointer;}
	.tooltip .text{visibility: hidden;width: 80px;background-color: black;color: white;text-align: center;border-radius: 5px;padding: 5px 0;position: absolute;z-index: 999;left: 100%;top: 0px;}
/* 	.tooltip:hover .text{visibility: visible;} */
</style>
<script type="text/javascript">
	function testOver(target){
		target.childNodes[1].style.visibility='visible';
	}
	function testLeave(target){
		target.childNodes[1].style.visibility='hidden';
	}
</script>
</head>
<body>
	<h1>ToolTip</h1>
	<div class="tooltip" onmouseover="testOver(this)" onmouseleave="testLeave(this)">
		Hover Me!
		<span class="text">I'm Text</span>
	</div>
</body>
</html>