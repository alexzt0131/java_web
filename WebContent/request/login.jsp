<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h3>请登录:</h3>
	<h4><%=request.getAttribute("msg")!=null?request.getAttribute("msg"):""%></h4>
	<form action="/java_web/Login" method="post">
		<input type="text" name="username"  /><br/>
		<input type="password" name="password" /><br/>

		<input type="submit" value="登录" /><br/>
	</from>
	
</body>
</html>
