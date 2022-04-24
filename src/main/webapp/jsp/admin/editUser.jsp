<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
<head>
  <title>Edit User</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}\css\inputsStyle.css" >
</head>
<body>
<div class="wrapper">
  <form class="main-form" name="adminForm" method="POST" action="controller">
    <h1>Editing user</h1>
    <p>User Id</p>
    <input name="userId" value="${userId}" readonly/>
    <p>Full name</p>
    <input name="name" value="${name}"/>
    <p>Login</p>
    <input name="login" value="${login}" type="email" required/>
    <p>Password</p>
    <input name="password" value="${password}" type = "password" required/>
    <div class="save-cancel">
      <input class="submit-button" type="submit" name="command" value="Save User Changes"/>
      <form name="adminForm" method="POST" action="controller">
        <input type="hidden" name="command" value="AdminMainPage"/>
        <input class="submit-button" type="submit" value="Cancel" />
      </form>
    </div>
  </form>
</div>

</body>
</html>