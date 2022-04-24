<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
  <title>Add User</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}\css\inputsStyle.css" >
</head>
<body>
<div class="wrapper">
  <form class="main-form" name="adminForm" method="POST" action="controller">
    <h1>Adding new user</h1>
    <p>User Type</p>
    <select class="user-type-cb" name="user_type">
      <c:forEach items="${temp}" var="d">
        <option value="${d.id}">${d.name}</option>
      </c:forEach>
    </select>
    <p>Full name</p>
    <input name="full_name" type="text"/>
    <p>Login</p>
    <input name="login" type="email" required/>
    <p>Password</p>
    <input name="password" type="password" required/>
    <div class="save-cancel">
      <input class="submit-button" type="submit" name="command" value="Save User"/>
      <form class="cancel" name="adminForm" method="POST" action="controller">
        <input type="hidden" name="command" value="AdminMainPage"/>
        <input class="submit-button" type="submit" value="Cancel" />
      </form>
    </div>
  </form>
</div>

</body>
</html>