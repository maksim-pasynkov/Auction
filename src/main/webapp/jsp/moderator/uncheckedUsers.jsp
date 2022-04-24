<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
  <title>UncheckedUsers</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}\css\tablesStyle.css">
</head>
<body>
<div class="wrapper">
  <form name="uncheckedUsersForm" method="POST" action="controller">
    <h1>Users List</h1>
    <div class="exit"><input type="submit" name="command" value="Moderator Main Page"></div>
    <div class="actions">
      <input type="submit" name="command" value="Lock User" />
      <input type="submit" name="command" value="Unlock User" />
    </div>
    <p>${errorMessage}</p>
    <table>
      <tbody>
      <tr>
        <th></th>
        <th>Name</th>
        <th>Login</th>
        <th>Account</th>
        <th>Blocked</th>
      </tr>
      <c:forEach items="${temp}" var="d">
        <tr>
          <td><input type="radio" name="radio" value="${d.id}"/></td>
          <td>${d.name}</td>
          <td>${d.login}</td>
          <td>${d.account}</td>
          <td>
            <c:choose>
              <c:when test="${d.blocked=='1'}">
                Blocked
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