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
		<img src="Image/Todo-App-Logo-Design.png" height="20%" width="5%"
			style="float: left;" /> <br> <br> <br>
			
			<%= request.getAttribute("message") %>
		<h2>Dashboard</h2>
		
		<!-- <div style="border: 1px solid; border-color: black; padding:5% ; width:100px; height:300px">
		
		<label for="alltasks">Total Tasks</label>
		
		</div>

<div style="border: 1px solid; border-color: black; padding:5%;width:100px; height:300px">
		
		<label for="alltasks">My Tasks</label>
		
		</div> -->
<label for="alltasks" style="margin:5%">Total Tasks</label>
<label for="mytasks"style="margin:5%">My Tasks</label>	

<%--  
FOR LABEL IN JSP
<% UserController userCon = new UserController(); %>
 
<label><%=userCon.getAllTasks()%></label>
<label><%=userCon.getMyTasks()%></label>
 --%>	 
 </div>
 
 <a href="dashboard.jsp">Dashboard</a><br><br>
 <a href="mytask.jsp">My Tasks</a><br><br>
 <a href="alltask.jsp">All Tasks</a><br><br>
 
 
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