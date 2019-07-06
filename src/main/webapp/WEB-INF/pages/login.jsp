<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div><c:choose>
    <c:when test="${loginError}"><p>Wrong login or password</p></c:when>
    <c:when test="${logout}"><p>You are logged out</p></c:when>
</c:choose>
</div>
<form action="/processing-url" method="POST">
    <label for="login">Login    </label>
    <input type="text" name="login" id="login" required>
    <br>
    <label for="password">Password</label>
    <input type="password" name="password" id="password" required>
    <input type="submit" value="Sign in">
</form>

</body>
</html>
