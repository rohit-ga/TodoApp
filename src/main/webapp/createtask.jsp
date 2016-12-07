<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Task</title>
</head>
<body>
	<div style="text-align: center;">
		<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
			style="float: left;" /> <br> <br> <br>
		<%
		    if (request.getAttribute("message") == null) {

		    } else {
		        out.print(request.getAttribute("message"));
		    }
		%>
		<form action="TaskController?action=create" method="post">
			<br> <br>Task Name:- <input type="text" name=taskname
				required><br> <br> <input type="submit"
				value="Create">
		</form>
		<form action="TaskController?action=back">
			<input type="button" value="Back"><br>
			<br>
		</form>
		<a href="UserController?action=logout">Logout</a>
		<%
		    response.setHeader("Cache-Control", "no-cache");
		    response.setHeader("Cache-Control", "no-store");
		    response.setHeader("Pragma", "no-cache");
		    response.setDateHeader("Expires", 0);
		    if (session.getAttribute("email") == null)
		        response.sendRedirect("home.jsp");
		%>
	</div>
</body>
</html>