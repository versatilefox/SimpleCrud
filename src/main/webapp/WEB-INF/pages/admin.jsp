<%--
  Created by IntelliJ IDEA.
  User: гы
  Date: 16.10.2018
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title></title>
    <style>
        table {
            width: 100%;
            border: 0.5px double black;
            border-collapse: collapse;
        }
        th {
            text-align: left;
            background: #ccc;
            padding: 5px;
            border: 1px solid black;
        }
        td {
            padding: 5px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<a href="/admin/add">Add new user</a>
<br>
<a href="/logout">Logout</a>
<table>
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Name</th>
        <th>Password</th>
        <th></th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <c:out value="${user.id}"/>
            </td>
            <td>
                <c:out value="${user.login}" />
            </td>
            <td>
                <c:out value="${user.name}" />
            </td>
            <td>
                <c:out value="${user.password}" />
            </td>
            <td>
                <a href="/admin/edit/${user.id}">Edit</a>


            <td>
                <a href="/admin/delete/${user.id}">Delete</a>
        </tr>
    </c:forEach>

</table>
</body>
</html>
