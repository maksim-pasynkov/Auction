<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
  <title>Admin</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\css\style.css">
</head>
<body>
<div class="wrapper">
  <form name="adminForm" method="POST" action="controller">
    <h1>Users List</h1>
    <div class="logout"><input type="submit" name="command" value = "Log Out"/></div>
    <div class="admin-actions">
      <input type="submit" name="command" value="Add User" />
      <input type="submit" name="command" value="Edit User" />
      <input type="submit" name="command" value="Delete User" />
      <input type="submit" name="command" value="Online Users"/>
    </div>
    
    <p>${errorMessage}</p>
    <table>
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
                Оnline
                <br />
              </c:when>
            </c:choose>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </form>
</div>

</body>
</html>