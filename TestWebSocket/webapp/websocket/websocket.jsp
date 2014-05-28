<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>websocket</title>
<script src="${pageContext.request.contextPath}/js/jquery2.1.0.js"></script>
<script>
	var wsUri = "ws://" + window.location.host + "/TestWebSocket/websocket/dateservice";
	var output;
	var websocket;
	
	function onOpen(evt) {
		writeToScreen("CONNECTED");
	}
	function onClose(evt) {
		writeToScreen("DISCONNECTED");
	}
	function onMessage(evt) {
		 writeToScreen('<span style="color: blue;">RESPONSE: ' + evt.data + '</span>');
	}
	function onError(evt) {
		writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
	}
	function doSend(message) {
		writeToScreen("SENT: " + message);
		websocket.send(message);
	}
	function writeToScreen(message) {
		var pre = document.createElement("p");
		pre.style.wordWrap = "break-word";
		pre.innerHTML = message;
		output.appendChild(pre);
	}
	
	$(document).ready(function() {
		output = document.getElementById("output");
		$("button").click(function() {
			connect();
		});
	});
	
	
	function connect() {
		 if ('WebSocket' in window) {
			 websocket = new WebSocket(wsUri);
        } else if ('MozWebSocket' in window) {
       	 	websocket = new MozWebSocket(wsUri);
        } else {
            alert('WebSocket is not supported by this browser.');
            return;
        }	
		 
		// 只有在打开之后才可以发送数据，并不是websocket一创建就发送
		websocket.onopen = function(evt) {
			doSend("start now");
			onOpen(evt);
		};
		websocket.onmessage = function(evt) {
			onMessage(evt);
		};
		websocket.onerror = function(evt) {
			onError(evt);
		};
	}
</script>
</head>
<body>
	<button type="button" id="button">start!</button>
	<br>
	<div id="output"></div>
</body>
</html>