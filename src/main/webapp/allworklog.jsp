<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Users Worklogs</title>
</head>
<body>
	<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
		style="float: left;" />
	<br>
	<br>
	<br>
	<br>
	<a href="UserController?action=logout">Logout</a>
	<div style="text-align: center;">
		<%
		    response.setHeader("Cache-Control", "no-cache");
		    response.setHeader("Cache-Control", "no-store");
		    response.setHeader("Pragma", "no-cache");
		    response.setDateHeader("Expires", 0);
		    if (session.getAttribute("email") == null)
		        response.sendRedirect("home.jsp");
		%>
		<h3>All Users Worklogs</h3>
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