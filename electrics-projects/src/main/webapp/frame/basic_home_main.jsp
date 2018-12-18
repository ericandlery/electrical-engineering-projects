<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Home of Electrics Projects</title>
<style type="text/css">
</style>
<link href="/electrics-projects/frame/css/frame.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/electrics-projects/frame/javascript/frame.js">
</script>
<script type="text/javascript">
// 	window.onload=function(){
		
// 	}

	function test(height,width){
// 		alert(height+' $$$ '+width);
		goToRCMain(height,width);
	}
	
	function goToRCMain(height,width){
		location.href='/electrics-projects/rcCircuit?height='+height+'&width='+width;
	}
</script>
</head>
<body>
    <header>
    	<h1><a href="/electrics-projects/index.jsp" style="text-decoration:none;">Electrics Projects</a></h1>
    </header>
    <section>
    	<nav>
    		<h1><a href="#" onclick="openRCWindow()">Resistor Circuit</a></h1>
    	</nav>
    	<article>