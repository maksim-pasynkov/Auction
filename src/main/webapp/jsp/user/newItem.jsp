<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
  <title>New item</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}\css\inputsStyle.css">
</head>
<body>
<div class="wrapper">
  <form class="main-form" name="addItemForm" method="POST" action="controller">
    <h1>New Item</h1>
    <p>Description</p>
    <input name="description" align="left" size = 70/>
    <p>Item type</p>
    <select name="type">
      <c:forEach items="${temp}" var="d">
        <option>${d.name}</option>
      </c:forEach>
    </select>
    <p>Start Price</p>
    <input type="number" name="startPrice" min="0">
    <div class="save-cancel">
      <input class="submit-button" type="submit" name="command" value="Save Item" />
      <form name="addItemForm" method="POST" action="controller">
        <input type="hidden" name="command" value="MyItems"/>
        <input class="submit-button" type="submit" value="Cancel" />
      </form>
    </div>
  </form>
</div>
</body>
</html>