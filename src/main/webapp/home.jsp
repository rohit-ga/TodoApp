<!-- <html>
<body>
<h2>Hello World!</h2>
</body>
</html>
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<div style="text-align: center;">
		<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"/>
		<h2>Home page</h2>
	</div>
	<div style="text-align: center;">
		<form action="UserController?action=login" method="post"></form>
		Email :- <input type="text" name="email"><br> Password :-
		<input type="password" name="password"><br> <input
			type="submit" value="Login"><br> <a href="register.jsp">New
			User? Register Here</a>
		<!-- <form action="UserController?action=register" method="post"></form> 
<input type=submit value="New User?Register Here">
 -->
	</div>
</body>
</html>