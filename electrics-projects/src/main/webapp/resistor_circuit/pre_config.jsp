<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set the Grid</title>
<style type="text/css">
	body{background-color: teal;}
	form{text-align: center;}
</style>
<script type="text/javascript">
// 	window.onload=function(){
// 		alert(window.opener.test());
// 	}

	function submitRC(){
		var height=document.getElementById('height').value;
		var width=document.getElementById('width').value;
// 		alert(height+''+width);
		window.opener.test(height,width);
		self.close();
	}
</script>
</head>
<body>
	<form method="get">
		<h1 style="text-align: center;">Set the hight and width</h1>
		<label for="height" title="Height">Height: <input id="height" type="number" name="height"></label><br>
		<label for="width" title="Width">Width: <input id="width" type="number" name="width"></label><br>
		<input type="button" value="Ok" onclick="submitRC()"> <input type="reset" value="Reset"><br>
	</form>
</body>
</html>