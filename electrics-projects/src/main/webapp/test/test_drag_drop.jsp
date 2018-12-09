<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Drag & Drop</title>
<script type="text/javascript">
	var c=0;
	var tt;

	window.onload=function(){
		var tt=document.getElementById('tt');
// 		alert(tt.textContent);
		
		var ds=document.getElementById('ds');
		var dgo=document.getElementById('dgo');
		
		ds.addEventListener('dragstart',function(event){
// 			alert(event.target.textContent);
			event.dataTransfer.setData('text',event.target.textContent);
// 			alert(event.dataTransfer.getData('text'));
		});
		dgo.addEventListener('dragover',function(event){
			dragDrop(event);
		});
		
	}
	
	function dragDrop(e){
// 		tt=document.getElementById('tt');
// 		alert();
// 		alert(tt.textContent);
		alert(e.dataTransfer.getData('text'));
// 		alert(e.dataTransfer.getData('tt'));
	}
</script>
</head>
<body>
	<h1 id="ds" draggable="true">Drag Start</h1>
	<hr>
	<img id="dgo" src="/electrics-projects/resistor_circuit/images/Voltage_Source.png">
	<hr>
	<h4 id="tt">HA</h4>
</body>
</html>