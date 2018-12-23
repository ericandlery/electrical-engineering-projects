<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!doctype html> -->
<!-- <html> -->
<!-- <head> -->
<style type="text/css">
	#div{height: 100%;}
	div h1{text-align: center;overflow :auto;}
	div#outerGrid{background-color: aqua;overflow: auto;margin: auto;width: 95%;height: 55vh;}
	#submit{position: relative;right: -100px;z-index: 1;}
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
					if(data.length!=0){
						initIconPanel(data);
					}else{
						alert('Icons not loaded properly.');
					}
				}
			}
		}
		
	}

	/*Icon dragging event*/
	function dragIcons(e){
		var iconId
		
		/*Only the span's id is needed. Could be improved......*/
		iconId=dragDropFilter('IMG',e,iconId);
// 		console.log(iconId);
		e.dataTransfer.setData('iconId',iconId);
	}
	
	/*Droppable Icons preventDefault*/
	function allowDrop(e){
		e.preventDefault();
	}
	
	/*After getting a droppable icon, it changes image to that droppable.*/
	function getDroppable(e){
		e.preventDefault();
// 		console.log('getDrop'+e.dataTransfer.getData('iconId'));
		var iconId;
		var srcIconId=e.dataTransfer.getData('iconId');
		var srcImgUrl;
		
		/*Only the span's id is needed. Could be improved......*/
		iconId=dragDropFilter('IMG',e,iconId);
		
		console.log(srcIconId);
		srcImgUrl=document.getElementById(srcIconId).getElementsByTagName('IMG')[0].src;
// 		console.log(srcImgUrl);
		
// 		document.getElementById(iconId).innerHTML='<img class="gridImg" src="'+srcImgUrl+'" height="50" width="50">';
		document.getElementById(iconId).firstElementChild.src=srcImgUrl;
// 		e.target.innerHTML='<img src="/electrics-projects/resistor_circuit/images/Voltage_Source.png" height="50" width="50">';
	}
	
	function changeIcon(){
		
	}
	
	/*Use this to get the oustside ID. Could be improved......*/
	/*parameters:(In TagName,In Event,Out IconId)*/
	function dragDropFilter(str,e,iconId){
		if(str.toUpperCase()===e.target.tagName.toUpperCase()){
			iconId=e.target.parentElement.id;
		}else{
			iconId=e.target.id;
		}
		return iconId;
	}
	
	/*Initialize the icon panel*/
	function initIconPanel(data){
		var length=data.length;
		var frag=document.createDocumentFragment();
		var panel=document.getElementById('icons');
		var span=document.createElement('span');
		var img=document.createElement('img');
		
		span.className='icons';
		span.draggable=true;
		span.setAttribute('ondragstart','dragIcons(event)');
		
		img.className='iconImg';
		img.height=50;
		img.width=50;
		
		/*wrap it up*/
		for(var i=0;i<length;i++){
			span.id=data[i].replace('.png','Pic');
			span.title=data[i];
			
			img.alt=data[i].replace('.png','Pic');
			img.src="${pageContext.request.contextPath}/resistor_circuit/images/"+data[i];
						
			span.appendChild(img);
			/*don't forget to clone the node in before*/
			frag.appendChild(span.cloneNode(true));
		}
				
		panel.appendChild(frag);

	}
	
	/*Clear all icons in the grid.*/
	function clearGrids(){
		var grids=document.getElementsByClassName('gridImg');
		for(var i=0;i<grids.length;i++){
			grids[i].src='${pageContext.request.contextPath}/resistor_circuit/images/0_empty.png';
		}
	}
	
	/*Get the result of the game.*/
	function getResult(){
		var form1=document.getElementById('form1');
		form1.submit();
	}
</script>
<!-- </head> -->
<!-- <body> -->
<%@include file="/frame/basic_home_main.jsp"%>
		<div id="div"><!-- Title -->
			<h1>Resistor Circuit</h1>
			<div id="outerGrid"><!-- Grid Tile-->
				<h5>
					Place Your RC Circuit Below
					<span id="submit">
						<button onclick="getResult()">See the Result</button>
						<button onclick="clearGrids()">Clear</button>
					</span>
				</h5>
				<div id="grid"><!-- Grid --><!-- Place your grid below. -->
					<c:if test="${height>0 && width>0}">
						<c:set var="x" value="1"/>
						<c:forEach begin="1" end="${height}" varStatus="loop"><!-- Height -->
							<c:forEach begin="1" end="${width}" varStatus="loop"><!-- Width -->
								<!-- Each span represents a area where an icon can be dragged into. -->
								<span id="span(${x})" title="span(${x})" ondragover="allowDrop(event)" ondrop="getDroppable(event)">
									<img class="gridImg" src="${pageContext.request.contextPath}/resistor_circuit/images/0_empty.png" width="50" height="50">
								</span>
								<c:set var="x" value="${x+1}"/><!-- Counter -->
							</c:forEach>
							<br>
						</c:forEach>
					</c:if>
				</div><!-- End of Grid -->
			</div><!-- End of Grid Title-->
			<div id="icons"><!-- RC Icons -->
				<!-- This division is the Icon Panel which contains all the icons the server holds. -->
	<!-- 			<span id="dcVoltageSource" class="icons" title="DC Voltage Source" draggable="true" ondragstart="dragIcons(event)">DC Voltage Source -->
	<%-- 				<img class="iconImg" alt="DC Voltage Source" src="${pageContext.request.contextPath}/resistor_circuit/images/Voltage_Source.png" height="50" width="50"> --%>
	<!-- 			</span> -->
			</div>
		</div><!-- End of Title -->
		<div hidden="true"><!-- Hidden Form -->
			<form id="form1" action="gridResult.do" method="post" enctype="application/x-www-form-urlencoded">
				<input type="text" name="actionType" value="取得結果">
			</form>
		</div><!-- End of Hidden Form -->
<%@include file="/frame/basic_frame_footer.jsp"%>
<!-- </body> -->
<!-- </html> -->