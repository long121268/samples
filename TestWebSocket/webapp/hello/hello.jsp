<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>hello world</title>
<script src="${pageContext.request.contextPath}/js/jquery2.1.0.js"></script>
<script>
	$(document).ready(function() {
		$("button").click(function() {
			$("#form").submit();
		});
	});
</script>
</head>
<body>
	<form id="form" action="${pageContext.request.contextPath}/HelloWorld">
		<h1>value from server: ${msg}</h1>
		<br>
		<button type="button" id="button">Click Me!</button>
	</form>
</body>
</html>