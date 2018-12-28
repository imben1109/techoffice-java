<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.3.1/dist/jquery.min.js"></script>
		<script>
			function sayhi(){
				$.get("sayhi", function(data){
					alert(data);
				})
			}
			
			function saybye(){
				$.get("saybye", function(data){
					alert(data);
				})
			}
		</script>
	</head>
<body>
	<h1>Spring MVC Hello World Example</h1>

	<h2>${message}</h2>
	
	<button onclick="sayhi()">say hi</button>
	<button onclick="saybye()">say Bye</button>
	
</body>
</html>
