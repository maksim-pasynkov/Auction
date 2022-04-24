<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
  <title>User</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}\css\mainUserStyle.css">
</head>
<body>
<div class="wrapper">
  <form name="userForm" method="POST" action="controller">
    <div class="exit"><input type="submit" name="command" value = "Log Out"/></div>
    <div class="main-buttons-wrapper">
      <div class="btn-wrapper sale-catalogue">
        <input class="mod-main-buttons" type="submit" name="command" value="Sale Catalogue"/>
      </div>
      <div class="btn-wrapper my-items">
        <input class="mod-main-buttons" type="submit" name="command" value="My Items" />
      </div>
      <div class="btn-wrapper bought-items">
        <input class="mod-main-buttons" type="submit" name="command" value="Bought Items" />
      </div>
    </div>
  </form>
</div>
</body>
</html>