<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.1/sockjs.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
	</head>
	<body>
		<h1>Spring MVC Websocket Example</h1>
		<input id="input"/><button type="button" onclick="send()">Send</button>
		<div id="messages" style="border: 1px solid"></div>
		<script>
			var socket = new SockJS('/SpringWebsocketExample/example');
		    stompClient = Stomp.over(socket);
		    stompClient.connect({}, function (frame) {
		        console.log('Connected: ' + frame);
		        stompClient.subscribe('/topic/example', function (message) {
		        	document.getElementById("messages").innerHTML += message.body + "<br/>";  
		        });
		    });
		    
		    function send(){
				var input = document.getElementById("input").value;
				document.getElementById("input").value = "";
				var xhttp = new XMLHttpRequest();
				xhttp.open("GET", "send?message=" + input, true);
				xhttp.send();
			}
		</script>
	</body>
</html>
