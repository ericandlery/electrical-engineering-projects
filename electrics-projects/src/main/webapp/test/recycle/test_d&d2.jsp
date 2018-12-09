<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drag & Drop Advanced</title>
<script type="text/javascript">
	function dm(e){
		e.dataTransfer.setData('tt',e.target.id);
// 		alert(e.dataTransfer.getData('tt'));
	}
	function dh(e){
		e.preventDefault();
		alert(e);
		alert(e.dataTransfer.getData('tt'));
	}
	function dropAllowed(e){
		e.preventDefault();
// 		alert(e);
	}
</script>
</head>
<body>
	<h1 id="dragMexxx" draggable="true" ondragstart="dm(event)">Drag Me</h1>
	<hr>
	<h1 id="dropHere" ondrop="dh(event)" ondragover="dropAllowed(event)">Drop Here</h1>
</body>
</html>