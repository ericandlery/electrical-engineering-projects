<!doctype html>
<html>
<head>
<style type="text/css">
	#div{}
	div h1{text-align: center;overflow: auto;}
	div#outerGrid{background-color: aqua;overflow: auto;margin: auto;width: 95%;height: 65vh;}
	div#grid{white-space: nowrap;}
	div#grid span{background-color: white;width: 50px;height: 50px;margin-left: 5px;margin-top: 2px;display: inline-block;}
</style>
</head>
<body>
<%@include file="/frame/basic_home_main.jsp"%>
	<div id="div"><!-- Title -->
		<h1>Resistor Circuit</h1>
		<div id="outerGrid"><!-- Grid Tile-->
			<h1>test</h1>
			<div id="grid"><!-- Grid --><!-- Place your grid below. -->
				<c:if test="${height>0 && width>0}">
					<c:forEach begin="1" end="${height}" varStatus="loop"><!-- Height -->
						<c:forEach begin="1" end="${width}" varStatus="loop" var="x"><!-- Width -->
							<span>span${x}</span>
						</c:forEach>
						<br>
					</c:forEach>
				</c:if>
			</div><!-- End of Grid -->
		</div><!-- End of Grid Title-->
	</div><!-- End of Title -->
<%@include file="/frame/basic_frame_footer.jsp"%>
</body>
</html>