<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: гы
  Date: 06.11.2018
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h3>Welcome, <c:out value="${user.name}" /></h3>
<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>
