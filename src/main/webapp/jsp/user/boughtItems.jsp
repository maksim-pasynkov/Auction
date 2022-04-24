<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
  <title>ActiveItems</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}\css\tablesStyle.css">
</head>
<body>
  <div class="wrapper">
    <form name="activeItemsForm" method="POST" action="controller">
      <h1>Bought Items</h1>
      <div class="exit"><input type="submit" name="command" value="User Main Page"></div>
      <table>
        <tbody>
        <tr>
          <th>Description</th>
          <th>Type</th>
          <th>Bid Date</th>
          <th>Withdrawal Date</th>
          <th>Owner</th>
          <th>Start Price</th>
          <th>Hammer Price</th>
          <th>Bid increment</th>
        </tr>
        <c:forEach items="${temp}" var="d">
          <tr>
            <td>${d.description}</td>
            <td>${d.itemCategory}</td>
            <td>${d.installDate}</td>
            <td>${d.saleDate}</td>
            <td>${d.owner}</td>
            <td>${d.startPrice}</td>
            <td>${d.currentPrice}</td>
            <td>${d.step}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </form>
  </div>
</body>
</html>