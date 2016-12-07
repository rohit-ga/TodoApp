<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Your Worklog</title>
</head>
<body>
	<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
		style="float: left;" />
	<br>
	<br>
	<br>
	<br>
	<a href="UserController?action=logout">Logout</a>
	<br>
	<%
	    response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Cache-Control", "no-store");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
	    if (session.getAttribute("email") == null)
	        response.sendRedirect("home.jsp");
	%>
	<div style="text-align: center;">

		<h3>Add Worklog Here</h3>
		<br>
		<form method="post" action="UserTaskController?action=worklog">
			Task Id:- <input type="text" name="taskId" value="${taskId}"
				readonly="readonly"><br> <br> Start Time:- <input
				type="datetime-local" name="startTime" value="2000-01-01 00:00"><br>
			<br> End Time:- <input type="datetime-local" name="endTime"
				value="2000-01-01 00:00"><br> <br> Log
			Description:- <input type="text" name="description"><br>
			<br> <input type="submit" value="Save"><br> <br>
		</form>
	</div>
</body>
</html>