<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  user.user: гы
  Date: 10.10.2018
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/admin/add" method="post">
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <br>
    <label for="login">Login</label>
    <input type="text" name="login" id="login">
    <br>
    <label for="password">Password</label>
    <input type="password" name="password" id="password">
    <label for="role">Role</label>
    <input type="text" name="role" id="role">
    <input type="submit" value="Add">
</form>
</body>
</html>
