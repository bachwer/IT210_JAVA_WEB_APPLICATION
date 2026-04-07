<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 06/04/2026
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Login</h2>

<form action="${pageContext.request.contextPath}/login" method="post">
    Username: <input type="text" name="username"/><br>
    Password: <input type="password" name="password"/><br>
    <button type="submit">Login</button>
</form>

<p style="color:red">${error}</p>

</body>
</html>