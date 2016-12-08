<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
	<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
		style="float: left;" />
	<br>
	<br>
	<br>
	<br>
	<a href="createtask.jsp">Create Your Task</a>
	<br>
	<br>
	<a href="TaskController?action=getalltasks">View All Tasks</a>
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
		<h3>Tasks of Users</h3>
		<TABLE BORDER="1" align="center">
			<TR>
				<TH>Task Id</TH>
				<TH>Task Name</TH>
				<TH>Task Creation Date</TH>
			</TR>
			<c:forEach items="${allTaskList}" var="allTaskList">
				<tr>
					<td><c:out value="${allTaskList.taskId}" /></td>
					<td><c:out value="${allTaskList.taskName}" /></td>
					<td><c:out value="${allTaskList.taskCreationDate}" /></td>
			</c:forEach>
		</TABLE>
	</div>
</body>
</html>