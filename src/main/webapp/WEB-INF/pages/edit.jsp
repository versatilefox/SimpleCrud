<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  user.user: гы
  Date: 10.10.2018
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit user</h2>
<form action="/admin/edit" method="POST">
        <table>
            <tr><input type="hidden" name="id" value="<c:out value='${user.id}' />"/></tr>
            <tr><input type="hidden" name="role" value="<c:out value='${user.role}' />"/></tr>
            <tr>
                <th><label for="login">Login</label></th>
                <td>
                    <input type="text" name="login" id="login"
                           value="<c:out value='${user.login}' />"/>
                </td>
            </tr>
            <tr>
                <th><label for="name">Name</label></th>
                <td>
                    <input type="text" name="name" id="name" value="<c:out value='${user.name}' />"/>
                </td>
            </tr>

            <tr>
                <th>Password</th>
                <td>
                    <input type="text" name="password"
                           value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
