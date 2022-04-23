<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<title>Admin</title>
</head>
<body>
	<form name="adminForm" method="POST" action="controller">
		<p><input type="submit" name="command" value = "Log Out"/></p>
		<p><input type="submit" name="command" value="Add User" />
		<input type="submit" name="command" value="Edit User" />
		<input type="submit" name="command" value="Delete User" />
		<input type="submit" name="command" value="All Users"/>
		${errorMessage}</p>
		<p>Users List</p>
		<table border="1" width="100%" cellpadding="5">
			<tbody>
				<tr>
					<th></th>
					<th>Type</th>
					<th>Name</th>
					<th>Login</th>
					<th>Password</th>
					<th>Account</th>
					<th>Blocked</th>
					<th>Online</th>
				</tr>
				<c:forEach items="${temp}" var="d">
					<tr>
						<td><input type="radio" name="radio" value="${d.id}"/></td>
						<td>${d.userType}</td>
						<td>${d.name}</td>
						<td>${d.login}</td>
						<td>${d.password}</td>
						<td>${d.account}</td>
						<td>
						<c:choose> 
    						<c:when test="${d.blocked=='1'}"> 
        					Blocked
        					<br /> 
    						</c:when>     
						</c:choose>
						</td>
						<td>
						<c:choose> 
    						<c:when test="${d.active=='1'}"> 
        					Online
        					<br /> 
    						</c:when>     
						</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		${errorLoginPassMessage} <br /> ${wrongAction} <br /> ${nullPage} <br />
	</form>
	<hr />
</body>
</html>