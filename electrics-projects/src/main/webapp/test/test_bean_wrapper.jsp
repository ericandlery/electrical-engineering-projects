<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Bean Wrapper</title>
</head>
<body>
	<form action="t.do" method="get">
		<input type="number" name="height" value="13">
		<input type="number" name="width" value="9">
		<input type="submit" value="test">
	</form>
	<hr>
	<form action="t.do" method="get">
		<input type="text" name="s" value="kimi">
		<input type="number" name="i" value="${998}">
		<input type="date" name="d">
		<input type="submit" value="test2">
	</form>
</body>
</html>