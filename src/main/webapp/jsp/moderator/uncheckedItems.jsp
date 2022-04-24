<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
  <title>UncheckedItems</title>
  <link href="${pageContext.request.contextPath}\css\tablesStyle.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
  <form name="uncheckedItemsForm" method="POST" action="controller">
    <h1>Check Items</h1>
    <div class="exit"><input type="submit" name="command" value="Moderator Main Page"></div>
    <div class="actions">
      <input type="submit" name="command" value="Check Item" />
      <input type="submit" name="command" value="Withdraw Item" />
    </div>
    <p>${errorMessage}</p>
    <table>
      <tbody>
      <tr>
        <td></td>
        <th>Description</th>
        <th>Type</th>
        <th>Bid Date</th>
        <th>Withdrawal Date</th>
        <th>Owner</th>
        <th>Starting Price</th>
        <th>Current Price</th>
        <th>Bid Increment</th>
        <th>Checked</th>
        <th>State</th>
      </tr>
      <c:forEach items="${temp}" var="d">
        <tr>
          <td><input type="radio" name="radio" value="${d.id}"/></td>
          <td>${d.description}</td>
          <td>${d.itemCategory}</td>
          <td>${d.installDate}</td>
          <td>${d.saleDate}</td>
          <td>${d.owner}</td>
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