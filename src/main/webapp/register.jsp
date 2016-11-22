<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>
<body>

	<div style="text-align: center;">
		<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
			style="float: left;" /> <br> <br> <br>
		<h2>Registration Form</h2>
		<form action="UserController?action=register" method="post">
			First Name:-<br> <input type="text" name="fname"><br>
			Last Name:-<br> <input type="text" name="lname"><br>
			Gender:-<input type="radio" name="sex" value="male" checked>Male
			<input type="radio" name="sex" value="female">Female<br>
			Contact:-<br> <input type="text" name="contact"><br>
			Email:-<br> <input type="text" name="email"><br>
			Password:-<br> <input type="password" name="password"><br>
			<br> <input type="submit" value="Register">
		</form>
	</div>
</body>

</html>

