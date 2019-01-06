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
// 		console.log(map[0].fn);
// 		var s='xyz/01_empty.jpg';
// 		console.log(s.lastIndexOf('/'));
// 		console.log(s.substr(s.lastIndexOf('/')+1));

		var ar=[];
		ar[5]='kimi';
		ar[9]='ralf';
		var jar;
		jar=JSON.stringify(ar);
// 		console.log(jar);

		var s='445';
		console.log(typeof s);
		s=parseInt(s);
// 		console.log(s+'  '+typeof s);

		var m=new Map();
		console.log(m);
		m.set(1,'kimi');
		m.set(2,'ralf');
		m.set(3,'mika');
		var a=Array.from(m);
		console.log(JSON.stringify(a));
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
	<br>
	<a href="t.do">test</a>
</body>
</html>