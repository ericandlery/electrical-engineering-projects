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
	window.onload=function(){
		/*Get icon list to set the icon panel*/
		var xhr=new XMLHttpRequest();
		xhr.open('POST','iconAjax.do',true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
		xhr.send('actionType=getIconList');
		xhr.onreadystatechange=function(){
			if(xhr.readyState===4 && xhr.status===200){
				var type=xhr.getResponseHeader('Content-Type');
				if(type.indexOf('application/json')===0){
					/*All icon urls*/
					var data=JSON.parse(xhr.responseText);
					console.log(data);
					console.log(data[1]);
					console.log('${pageContext.request.contextPath}');
				}
			}
		}
	}

	/*Icon dragging event*/
	function dragIcons(e){
		var iconId
		
		/*Only the span's id is needed. Could be improved......*/
		iconId=dragDropFilter('IMG',e,iconId);
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
		var srcIconId;
		
		/*Only the span's id is needed. Could be improved......*/
		iconId=dragDropFilter('IMG',e,iconId);
		
		document.getElementById(iconId).innerHTML='<img src="${pageContext.request.contextPath}/resistor_circuit/images/Voltage_Source.png" height="50" width="50">';
// 		e.target.innerHTML='<img src="/electrics-projects/resistor_circuit/images/Voltage_Source.png" height="50" width="50">';
		srcIconId=e.dataTransfer.getData('iconId');
	}
	
	function changeIcon(){
		
	}
	
	/*Use this to get the oustside ID. Could be improved......*/
	function dragDropFilter(str,e,iconId){
		if(str.toUpperCase()===e.target.tagName.toUpperCase()){
			iconId=e.target.parentElement.id;
		}else{
			iconId=e.target.id;
		}
		return iconId;
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
							<span id="span(${x})" title="span(${x})" ondragover="allowDrop(event)" ondrop="getDroppable(event)"><img src="${pageContext.request.contextPath}/resistor_circuit/images/empty.png" width="50" height="50"></span><!-- Each span represents a area where an icon can be dragged into. -->
							<c:set var="x" value="${x+1}"/><!-- Counter -->
						</c:forEach>
						<br>
					</c:forEach>
				</c:if>
			</div><!-- End of Grid -->
		</div><!-- End of Grid Title-->
		<div id="icons"><!-- RC Icons -->
			<span id="dcVoltageSource" class="icons" title="DC Voltage Source" draggable="true" ondragstart="dragIcons(event)"><!-- DC Voltage Source -->
				<img class="iconImg" alt="DC Voltage Source" src="${pageContext.request.contextPath}/resistor_circuit/images/Voltage_Source.png" height="50" width="50">
			</span>
		</div>
	</div><!-- End of Title -->
<%@include file="/frame/basic_frame_footer.jsp"%>
</body>
</html>