<%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 9/27/24
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/admin/users/update?id=<c:out value="${user.id}"/>" method="post">
    <label for="username">Username:</label>
    <input type="text" value="<c:out value="${user.username}"/>" id="username" name="username"><br>
    <label for="password">Password:</label>
    <input type="password" value="<c:out value="${user.password}"/>" id="password" name="password"><br>
    <label for="role">Role:</label>
    <select id="role" name="role">
        <option <c:if test="${user.role == 1}">selected</c:if> value="1">Admin</option>
        <option <c:if test="${user.role == 2}">selected</c:if> value="2">User</option>
    </select><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
