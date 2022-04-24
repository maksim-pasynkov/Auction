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
    <h1>My Items</h1>
    <div class="exit"><input type="submit" name="command" value="User Main Page"></div>
    <div class="actions">
      <input type="submit" name="command" value="Add Item"></p>
      <input type="submit" name="command" value="Edit Item"/>
      <input type="submit" name="command" value="Delete Item"/>
      <input type="submit" name="command" value="Put on sale"/>
      <input type="submit" name="command" value="Withdraw"/>
    </div>
    <p>${errorMessage}</p>
    <table border="1" width="100%" cellpadding="5">
      <tbody>
      <tr>
        <th></th>
        <th>Description</th>
        <th>Type</th>
        <th>Bid Date</th>
        <th>Starting Price</th>
        <th>Current Price</th>
        <th>Bid Increment</th>
        <th>Checked</th>
        <th>Status</th>
      </tr>
      <c:forEach items="${temp}" var="d">
        <tr>
          <td><input type="radio" name="radio" value="${d.id}"/></td>
          <td>${d.description}</td>
          <td>${d.itemCategory}</td>
          <td>${d.installDate}</td>
          <td>${d.startPrice}</td>
          <td>${d.currentPrice}</td>
          <td>${d.step}</td>
          <td>
            <c:choose>
              <c:when test="${d.checked=='1'}">
                Checked
                <br />
              </c:when>
            </c:choose>
          </td>
          <td>
            <c:choose>
              <c:when test="${d.active=='1'}">
                On Sale
                <br />
              </c:when>
              <c:otherwise>
                Withdrawn
                <br />
              </c:otherwise>
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