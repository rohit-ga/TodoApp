<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Tasks Page</title>
</head>
<body>
	<form method="get">
		<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
			style="float: left;" /> <br> <br> <br> <br> <a
			href="TaskController?action=dashboard">Dashboard Page</a> <br> <br>
		<a href="UserController?action=logout">Logout</a> <br>
		<%
		    response.setHeader("Cache-Control", "no-cache");
		    response.setHeader("Cache-Control", "no-store");
		    response.setHeader("Pragma", "no-cache");
		    response.setDateHeader("Expires", 0);
		    if (session.getAttribute("email") == null)
		        response.sendRedirect("home.jsp");
		%>
		<div style="text-align: center;">
			<h3>All Tasks</h3>
			<TABLE BORDER="1" align="center">
				<TR>
					<TH>Task Id</TH>
					<TH>Task Name</TH>
					<TH>Task Creation Date</TH>
					<TH>Add</TH>
				</TR>
				<c:forEach items="${allTaskList}" var="allTaskList">
					<tr>
						<td><c:out value="${allTaskList.taskId}" /></td>
						<td><c:out value="${allTaskList.taskName}" /></td>
						<td><c:out value="${allTaskList.taskCreationDate}" /></td>
						<td><a
							href="TaskController?action=add&taskId=<c:out value="${allTaskList.taskId}"/>">Add
								Worklog</a></td>
				</c:forEach>
			</TABLE>
		</div>
	</form>
</body>
</html>