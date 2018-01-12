<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		用户名<input type="text" name="username"/></br>
		密码<input type="password" name="password"></br>
		省份<input type="text" name="address.province"></br>
		<input type="submit" value="登录" >
		<input type="hidden" name="_method" value="POST">
	</form>
	
	<!-- <script type="text/javascript" src="js/jquery-1.8.3.js"></script> -->
</body>
</html>