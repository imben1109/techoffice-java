<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script>
		function sendMessage() {
			var input = document.getElementById("input").value;
			var xhttp = new XMLHttpRequest();
			xhttp.open("GET", "send?message=" + input, true);
			xhttp.send();
		}
	</script>
</head>
<body>
	<h1>Spring MVC Server Sent Event Example</h1>
	<input id="input"/><button id="sendBtn" type="button" onclick="sendMessage()">Send</button>

	<div id="message"></div>
	<script>
		var source = new EventSource("emit");
		source.onmessage = function(event) {
		    document.getElementById("message").innerHTML += event.data + "<br>";
		};
	</script>
</body>
</html>
