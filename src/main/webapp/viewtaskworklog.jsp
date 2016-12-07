<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View MyTask Worklogs</title>
</head>
<body>
	<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
		style="float: left;" />
	<br>
	<br>
	<br>
	<br>
	<a href="TaskController?action=mytasks">My Tasks List</a>
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
		<h2>Worklog Details</h2>
		<h4>Task Name:-${taskName}</h4>
		<TABLE border="1" align="center">
			<TR>
				<TH>User Name</TH>
				<TH>Start Time</TH>
				<TH>End Time</TH>
				<TH>Worklog Description</TH>
			</TR>
			<c:forEach items="${worklogs}" var="worklogs">
				<tr>
					<td><c:out value="${worklogs.userFname}" /></td>
					<td><c:out value="${worklogs.startTime}" /></td>
					<td><c:out value="${worklogs.endTime}" /></td>
					<td><c:out value="${worklogs.description}" /></td>
			</c:forEach>
		</TABLE>
	</div>
</body>
</html>