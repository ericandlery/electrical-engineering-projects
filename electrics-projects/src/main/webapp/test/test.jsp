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
		var node=document.createElement('h1');
		node.textContent=555;
		
		var div=document.getElementById('div');
		div.appendChild(node);
		
		var n1=document.createElement('h2');
		n1.textContent=444;
		div.appendChild(n1);
		
		
		var d2=document.getElementById('d2');
		
		var frag=document.createDocumentFragment();
		console.log(frag);
		
		var d2=$('d2');
		console.log('xxx=='+d2);
		
		var h1=$ce('h1');
		h1.textContent='kimi';
		
		var h2=$ce('h1');
		h2.textContent='ralf';
		
		console.log(h1);
		console.log(h2);
		
		d2.append(h1);
		d2.append(h2);
		
		try{
			www;
		}catch(err){
			alert(err.message);
		}
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