<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<form name="adminForm" method="POST" action="controller">
	
	User Id: <input name="userId" value="${userId}" readonly/>
	<br></br>
    Login: <input name="login" value="${login}" type="email" required/>
    <br></br>
    Password: <input name="password" value="${password}" type = "password" required/>
    <br></br>
	Full name: <input name="name" value="${name}"/>
    <br></br>
	<input type="submit" name="command" value="Save User Changes"/>
</form>
<form name="adminForm" method="POST" action="controller">
	<input type="hidden" name="command" value="AdminMainPage"/>
	<input type="submit" value="Cancel" />
</form>

</body>
</html>