<!doctype html>
<html>
<head>
<style type="text/css">
	#div{height: 100%;}
	div h1{text-align: center;overflow: auto;}
	div#outerGrid{background-color: aqua;overflow: auto;margin: auto;width: 95%;height: 55vh;}
	div#grid{white-space: nowrap;}
	div#grid span{background-color: white;width: 50px;height: 50px;margin-left: 5px;margin-top: 2px;display: inline-block;border: 5px solid black;border-radius: 5px;}
	div#outerGrid h5{text-align: center;}
	div#icons{background-color: orange;width: 95%;height: 20%;margin: auto;border: 5px solid black;border-radius: 5px;}
	.icons{border: 5px solid black;border-radius: 5px;display: inline-block;margin: 5px;}
</style>
<script type="text/javascript">
	/*Icon dragging event*/
	function dragIcons(e){
		var iconId
		
		/*The span's id is needed. Could be improved......*/
		if('IMG'.toUpperCase()===e.target.tagName.toUpperCase()){
			iconId=e.target.parentElement.id;
		}else{
			iconId=e.target.id;
		}
// 		alert(iconId);
		e.dataTransfer.setData('iconId',iconId);
	}
	
	/*Droppable Icons preventDefault*/
	function allowDrop(e){
		e.preventDefault();
	}
	
	/*After getting a droppable icon, it chnages image to that droppable.*/
	function getDroppable(e){
		e.preventDefault();
		var iconId;
		alert(e.target);
		
		/*
		TODO span and img tag problem
		*/
		
		e.target.innerHTML='<img src="/electrics-projects/resistor_circuit/images/Voltage_Source.png" height="50" width="50">';
	}
	
	function changeIcon(){
		
	}
</script>
</head>
<body>
<%@include file="/frame/basic_home_main.jsp"%>
	<div id="div"><!-- Title -->
		<h1>Resistor Circuit</h1>
		<div id="outerGrid"><!-- Grid Tile-->
			<h5>Place Your RC Circuit Here</h5>
			<div id="grid"><!-- Grid --><!-- Place your grid below. -->
				<c:if test="${height>0 && width>0}">
					<c:set var="x" value="1"/>
					<c:forEach begin="1" end="${height}" varStatus="loop"><!-- Height -->
						<c:forEach begin="1" end="${width}" varStatus="loop"><!-- Width -->
							<span id="span(${x})" title="span(${x})" ondragover="allowDrop(event)" ondrop="getDroppable(event)"><img src="/electrics-projects/test/test_imgs/tttt.png" width="50" height="50"></span><!-- Each span represents a area where an icon can be dragged into. -->
							<c:set var="x" value="${x+1}"/><!-- Counter -->
						</c:forEach>
						<br>
					</c:forEach>
				</c:if>
			</div><!-- End of Grid -->
		</div><!-- End of Grid Title-->
		<div id="icons"><!-- RC Icons -->
			<span id="dcVoltageSource" class="icons" title="DC Voltage Source" draggable="true" ondragstart="dragIcons(event)"><!-- DC Voltage Source -->
				<img class="iconImg" alt="DC Voltage Source" src="/electrics-projects/resistor_circuit/images/Voltage_Source.png" height="50" width="50">
			</span>
		</div>
	</div><!-- End of Title -->
<%@include file="/frame/basic_frame_footer.jsp"%>
</body>
</html>