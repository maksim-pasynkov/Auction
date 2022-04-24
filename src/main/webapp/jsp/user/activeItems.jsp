<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
  <title>ActiveItems</title>
  <link href="${pageContext.request.contextPath}\css\tablesStyle.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
  <form name="activeItemsForm" method="POST" action="controller">
    <h1>Sale Catalogue</h1>
    <div class="exit"><input type="submit" name="command" value="User Main Page"></div>
    <table>
      <tbody>
      <tr>
        <th>Description</th>
        <th>Type</th>
        <th>Bid Date</th>
        <th>Owner</th>
        <th>Starting Price</th>
        <th>Current Price</th>
        <th>Bid increment</th>
        <th></th>
      </tr>
      <c:forEach items="${temp}" var="d">
        <tr>
          <td>${d.description}</td>
          <td>${d.itemCategory}</td>
          <td>${d.installDate}</td>
          <td>${d.owner}</td>
          <td>${d.startPrice}</td>
          <td>${d.currentPrice}</td>
          <td>${d.step}</td>
          <td>
            <form method="POST" action="controller">
              <input type="hidden" name="itemId" value="${d.id}">
              <input type="hidden" name="command" value="Buy Item">
              <input class="bit-btn" type="submit" value="Make a bid"/>
            </form></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </form>
</div>
</body>
</html>