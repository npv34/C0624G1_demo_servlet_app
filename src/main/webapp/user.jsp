<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="org.codegym.ecommert.Entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 9/25/24
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Page</h1>
<c:out value="${data.size()}"/>
<table>
  <tr>
    <td>#</td>
    <td>Name</td>
    <td>Email</td>
      <td></td>
  </tr>
  <c:forEach items="${data}" var="user" >
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><a href="${pageContext.request.contextPath}/admin/users/delete?id=<c:out value="${user.id}"/> ">Delete</a></td>
         </tr>
  </c:forEach>
</table>
</body>
</html>
