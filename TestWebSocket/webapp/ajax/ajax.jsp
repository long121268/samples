<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ajax poll</title>
<script src="${pageContext.request.contextPath}/js/jquery2.1.0.js"></script>
<script>
	function getNewInfo() {
		var myDate = new Date();
		var before = myDate.getMilliseconds();
		$.ajax({ //一个Ajax过程
			type : "post", //以post方式与后台沟通
			url : "Ajax", //获取后台数据
			dataType : 'text',
			success : function(msg) {//如果调用成功
				$('#msg').val(msg);
				$('#consume').val(new Date().getMilliseconds() - before);
			}
		});
	}
	// 每秒执行一次
	setInterval("getNewInfo()", 1000);
</script>
</head>
<body>
	<h1>
		value from server: <input type="text" id="msg" value="${msg}"></input><br>
		consume time:<input type="text" id="consume" value="0"></input>
	</h1>
	<br>
</body>
</html>