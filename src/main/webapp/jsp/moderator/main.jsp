<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
  <title>Moderator</title>
  <link href="${pageContext.request.contextPath}\css\mainModeratorStyle.css" rel="stylesheet" >
</head>
<body>
<div class="wrapper">
  <form name="adminForm" method="POST" action="controller">
    <div class="exit"><input type="submit" name="command" value = "Log Out"/></div>
    <div class="main-buttons-wrapper">
      <form method="POST" action="controller">
        <input type="hidden" name="command" value="Unchecked Items" />
        <div class="btn-wrapper items">
          <input class="mod-main-buttons" type="submit" name="command" value="Items" />
        </div>
      </form>
      <form method="POST" action="controller">
        <input type="hidden" name="command" value="Unchecked Users" />
        <div class="btn-wrapper users">
          <input class="mod-main-buttons" type="submit" name="command" value="Users" />
        </div>
      </form>
    </div>
  </form>
</div>
</body>
</html>