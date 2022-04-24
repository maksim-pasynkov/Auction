<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
  <title>Admin</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}\css\tablesStyle.css">
</head>
<body>
<div class="wrapper">
  <form name="adminForm" method="POST" action="controller">
    <h1>Users List</h1>
    <div class="exit"><input type="submit" name="command" value = "Log Out"/></div>
    <div class="actions">
      <input type="submit" name="command" value="Add User" />
      <input type="submit" name="command" value="Edit User" />
      <input type="submit" name="command" value="Delete User" />
      <input type="submit" name="command" value="All Users"/>
    </div>
  
    <p>${errorMessage}</p>
    <table class="first-table">
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
  
    <c:forEach items="${temp}" var="d">
      <table class="second-table">
        <tbody>
        <tr>
          <td>
            <div><input type="radio" name="radio" value="${d.id}"/> Type</div>
            <div>${d.userType}</div>
          </td>
        </tr>
        <tr>
          <td>
            <div>Name</div>
            <div>${d.name}</div>
          </td>
        </tr>
        <tr>
          <td>
            <div>Login</div>
            <div>${d.login}</div>
          </td>
        </tr>
        <tr>
          <td>
            <div>Password</div>
            <div>${d.password}</div>
          </td>
        </tr>
        <tr>
          <td>
            <div>Account</div>
            <div>${d.account}</div>
          </td>
        </tr>
        <tr>
          <td>
            <div>
              <c:choose>
                <c:when test="${d.blocked=='1'}">
                  Blocked
                </c:when>
              </c:choose>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div>
              <c:choose>
                <c:when test="${d.active=='1'}">
                  Online
                </c:when>
                <c:when test="${d.active=='0'}">
                  Offline
                </c:when>
              </c:choose>
            </div>
          </td>
        </tr>
        </tbody>
      </table>
    </c:forEach>
    
  </form>
</div>

</body>
</html>