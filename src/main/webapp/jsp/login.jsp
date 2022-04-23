<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" href="loginCss.css">
</head>
<body>
<form name="loginForm" method="POST" action="controller">
  
  <header>
    <h1>Online Auction</h1>
  </header>
  
  <div class="login">
    <input type="hidden" name="command" value="login" />
  
    <div class="error">
      <p>${errorLoginPassMessage}</p>
      <p>${wrongAction}</p>
      <p>${nullPage}</p>
    </div>
    
    <div>Login</div>
    <input type="text" name="login" value="" />
    <div>Password</div>
    <input type="password" name="password" value="" />
    <input type="submit" class="login-button" value="Log in" />
  </div>
</form>
</body>
</html>