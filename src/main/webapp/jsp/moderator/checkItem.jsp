<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Check item</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}\css\inputsStyle.css">
</head>
<body>
<div class="wrapper">
  <form class="main-form" name="moderatorForm" method="POST" action="controller">
    <h1>Checking item</h1>
    <input type="hidden" name="itemId" value="${itemId}"/>
    <p>Description</p>
    <input name="descr" value="${descr}" required/>
    <p>Bid Date</p>
    <input name="installDate" value="${installDate}" readOnly/>
    <p>Sale Date</p>
    <input name="saleDate" value="${saleDate}" type="date" required/>
    <p>Step</p>
    <input type="number" name="step" value="${step}" min="1.00" required/>
    <div class="save-cancel">
      <input class="submit-button" type="submit" name="command" value="Save Check Item"/>
      <form name="addItemForm" method="POST" action="controller">
        <input type="hidden" name="command" value="UncheckedItems"/>
        <input class="submit-button" type="submit" value="Cancel" />
      </form>
    </div>
  </form>
</div>

</body>
</html>