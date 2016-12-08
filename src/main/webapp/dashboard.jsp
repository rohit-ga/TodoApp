<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard Page</title>
</head>
<body>
	<div style="text-align: center;">
		<form method="get">
			<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
				style="float: left;" /> <br> <br> <br>
			<%
			    if (request.getAttribute("message") == null) {

			    } else {
			        out.print(request.getAttribute("message"));
			    }
			%>
			<h2>Dashboard</h2>

			<label for="alltasks" style="margin: 5%">Total Tasks = <%=request.getAttribute("allTask")%></label>
			<label for="mytasks" style="margin: 5%">My Tasks = <%=request.getAttribute("myTask")%></label>
		</form>
	</div>
	<a href="TaskController?action=dashboard">Dashboard</a>
	<br>
	<br>
	<a href="TaskController?action=mytasks">My Tasks</a>
	<br>
	<br>
	<a href="TaskController?action=alltasks">All Tasks</a>
	<br>
	<br>
	<a href="UserController?action=logout">Logout</a>
	<br>
	<br>
	<%
	    response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Cache-Control", "no-store");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
	    if (session.getAttribute("email") == null)
	        response.sendRedirect("home.jsp");
	%>

</body>
</html>