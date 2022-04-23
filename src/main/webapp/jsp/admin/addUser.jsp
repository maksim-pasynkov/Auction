<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<body>
<form name="adminForm" method="POST" action="controller">
    User Type:
    <select name="user_type">
   	<c:forEach items="${temp}" var="d">
   		<option value="${d.id}">${d.name}</option>
   	</c:forEach>
	</select>
    <br></br>
    Login: <input name="login" type="email" required/>
    <br></br>
    Password: <input name="password" type = "password" required/>
    <br></br>
	Full name: <input name="full_name"/>
    <br></br>
	<input type="submit" name="command" value="Save User"/>
	<br></br>
</form>
<form name="adminForm" method="POST" action="controller">
	<input type="hidden" name="command" value="AdminMainPage"/>
	<input type="submit" value="Cancel" />
</form>

</body>
</html>