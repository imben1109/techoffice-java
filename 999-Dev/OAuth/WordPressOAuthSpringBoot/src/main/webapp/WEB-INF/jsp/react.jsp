<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<script src="/lib/react-15.3.1/build/react.min.js"></script>
	<script src="/lib/react-15.3.1/build/react-dom.min.js"></script>
	<script src="/lib/browser.min.js"></script>
</head>
<body>
	<h1>WordPress OAuth</h1>
	<div id="container"></div>
<script type="text/babel">
	// define a compoent by JavaScript function
	class Hello extends React.Component{
		render(){
			return <div>Hello {this.props.name}</div>;
		}
	};

	ReactDOM.render(
		<Hello name="World" />,
		document.getElementById('container')
	);
</script>
</body>

</html>