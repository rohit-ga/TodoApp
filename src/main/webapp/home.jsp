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
		<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
			style="float: left" /><br> <br> <br>
		<%
		    if (request.getAttribute("message") == null) {
		    } else {
		        out.print(request.getAttribute("message"));
		    }
		%>
		<h2>Home page</h2>
	</div>
	<div style="text-align: center;">
		<form action="UserController?action=signin" method="post">
			Email :- <input type="email" name="email" required><br>
			<br> Password :- <input type="password" name="password" required><br>
			<br> <input type="submit" value="Login"><br> <br>
			<a href="register.jsp">New User? Register Here</a>
		</form>
	</div>
</body>
</html>