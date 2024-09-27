<%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 9/27/24
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/admin/users/create" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br>
    <label for="role">Role:</label>
    <select id="role" name="role">
        <option value="1">Admin</option>
        <option value="2">User</option>
    </select><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
