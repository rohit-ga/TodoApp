<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Tasks</title>
</head>
<body>
	<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
		style="float: left;" />
	<br>
	<br>
	<br>
	<br>
	<a href="TaskController?action=dashboard">Go to Dashboard</a>
	<br>
	<br>
	<a href="UserController?action=logout">Logout</a>
	<%
	    response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Cache-Control", "no-store");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
	    if (session.getAttribute("email") == null)
	        response.sendRedirect("home.jsp");
	%>
	<div style="text-align: center;">
		<h2>My Tasks</h2>
		<form method="get">
			<a href="createtask.jsp">create task</a><br> <br>

			<TABLE BORDER="1" align="center">
				<TR>
					<TH>Task Id</TH>
					<TH>Task Name</TH>
					<TH>Task Creation Date</TH>
					<th>views</th>
				</TR>
				<c:forEach items="${myTaskList}" var="myTaskList">
					<tr>
						<td><c:out value="${myTaskList.taskId}" /></td>
						<td><c:out value="${myTaskList.taskName}" /></td>
						<td><c:out value="${myTaskList.taskCreationDate}" /></td>
						<td><a
							href="UserTaskController?action=view&taskId=<c:out value="${myTaskList.taskId}"/>">View
								Worklogs</a></td>
				</c:forEach>
			</TABLE>
		</form>
	</div>
</body>
</html>