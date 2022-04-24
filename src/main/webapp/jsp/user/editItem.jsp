<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Edit Item</title>
  <link href="${pageContext.request.contextPath}\css\inputsStyle.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <form class="main-form" name="userForm" method="POST" action="controller">
      <h1>Editing Item</h1>
      <input type="hidden" name="itemId" value="${itemId}"/>
      <p>Description</p>
      <input name="descr" value="${descr}" required/>
      <p>Start Price</p>
      <input type="number" name="startPrice" value="${startPrice}" min="0" required/>
      <div class="save-cancel">
        <input class="submit-button" type="submit" name="command" value="Save Item Changes"/>
        <form name="addItemForm" method="POST" action="controller">
          <input type="hidden" name="command" value="MyItems"/>
          <input class="submit-button" type="submit" value="Cancel" />
        </form>
      </div>
    </form>
  </div>
</body>
</html>