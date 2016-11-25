<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 	<%@ page import = com.todoapp.controller.TaskController %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard Page</title>
</head>
<body>
	<div style="text-align: center;">
	<form action="TaskController?action=dashboard">
		<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
			style="float: left;" /> <br> <br> <br>
			
			<%= request.getAttribute("message") %>
		<h2>Dashboard</h2>
		
<label for="alltasks" style="margin:5%">Total Tasks<%= request.getAttribute("allTask") %></label>
<label for="mytasks"style="margin:5%">My Tasks<%= request.getAttribute("mytask") %></label>	

 
<%--   
<% TaskController userCon = new TaskController(); %>
 
<label>Total Tasks<%=userCon.allTaskSize()%></label>
<label>My Tasks<%=userCon.myTaskSize()%></label>
 --%>
 
  </form>	 
 </div>
 
 <a href="TaskController?action=dashboard">Dashboard</a><br><br>
 <a href="TaskController?action=mytasks">My Tasks</a><br><br>
 <a href="TaskController?action=alltasks">All Tasks</a><br><br>
 
 
		<!-- <form action="UserController?action=dashboard" method="post">
		<input type="submit" value="Dashboard"><br><br>
		</form>
	
	<form action="UserController?action=mytasks" method="get">
	<input type="submit" value="Mytasks"><br><br>
	</form>
	<form action="UserController?action=alltasks">
	<input type="submit" value="Alltasks"><br><br>
	</form> -->
	
</body>
</html>