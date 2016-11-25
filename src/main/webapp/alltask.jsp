<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Tasks</title>
</head>
<body>
	<div style="text-align: center;">
		<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
			style="float: left;" /> <br> <br> <br>

		<h2>All Tasks</h2>

		<TABLE BORDER="1" align="center">
			<TR>
				<TH>Task Id</TH>
				<TH>Task Name</TH>
				<TH>Task Creation Date</TH>
			</TR>

			<c:forEach items="${taskList}" var="taskList">
				<tr>
					<td><c:out value="${taskList.taskId}" /></td>
					<td><c:out value="${taskList.taskName}" /></td>
					<td><c:out value="${taskList.taskCreationDate}" /></td>
			</c:forEach>
		</TABLE>
	</div>
	<a href="dashboard.jsp">Dashboard Page</a>
</body>
</html>