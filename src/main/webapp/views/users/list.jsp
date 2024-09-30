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
    <!--Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>User Page</h1>
    <a class="btn btn-success" href="/admin/users/create">Add new</a>
    <form action="/admin/users" method="get">
        <input type="text" name="keyword">
        <button type="submit">Search</button>
    </form>
    Total user: <c:out value="${data.size()}"/>
    <table class="table">
        <tr>
            <td>#</td>
            <td>UserName</td>
            <td>Role</td>
            <td></td>
        </tr>
        <c:forEach items="${data}" var="user" >
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.username}"/></td>
                <c:if test="${user.role == 1}">
                    <td>Admin</td>
                </c:if>
                <c:if test="${user.role == 2}">
                    <td>User</td>
                </c:if>
                <td>
                    <a class="btn btn-danger" onclick="return confirm('Are you sure?')" href="${pageContext.request.contextPath}/admin/users/delete?id=<c:out value="${user.id}"/> ">Delete</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/users/update?id=<c:out value="${user.id}"/> ">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var = "i" begin = "1" end = "${totalPage}">

                <c:if test="${currentPage == i}">
                    <li class="page-item active" aria-current="page" ><a class="page-link" href="/admin/users?page=<c:out value="${i}"/>"><c:out value="${i}"/></a></li>
                </c:if>
                <c:if test="${currentPage != i}">
                    <li class="page-item" aria-current="page" ><a class="page-link" href="/admin/users?page=<c:out value="${i}"/>"><c:out value="${i}"/></a></li>
                </c:if>

            </c:forEach>


            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
