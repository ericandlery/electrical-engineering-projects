<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Ajax</title>
<script type="text/javascript">
	var aHtml;

	window.onload=function(){
	}
	
	function testAjax(){
		var xhr=new XMLHttpRequest();
		
		if(xhr!=null){
			xhr.open('GET','TestSimpleAjax',true);
			xhr.send();
			xhr.onreadystatechange=function(){
				if(xhr.readyState===4 && xhr.status===200){
					aHtml=xhr.responseText;
				}
			}
		}
		
	}
	
	function testText(){
		document.getElementById('pp').innerHTML=aHtml;
	}
</script>
</head>
<body>
	<button onclick="testAjax()">AJAX</button>
	<p id="pp">Para</p>
	<button onclick="testText()">Text</button>
</body>
</html>