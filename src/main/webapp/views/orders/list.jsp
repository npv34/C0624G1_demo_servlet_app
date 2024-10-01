<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
    <%@ include file="../layouts/navbar.jsp" %>
    <div class="container">
        <div class="card mt-2">
            <div class="card-header">
                <div class="row">
                    <div class="col-12 col-md-2">
                        <h5 class="card-title">Order list</h5>
                    </div>
                    <div class="col-12 col-md-8">
                        <form action="/admin/orders/" method="get" class="d-flex">
                            from:
                            <input type="date" name="from"> to:
                            <input type="date" name="to">
                            <button type="submit" class="btn btn-primary">Filter</button>
                        </form>
                    </div>
                    <div class="col-12 col-md-2">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                Sort:
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                <li><a class="dropdown-item" href="/admin/orders?sort=asc">Order ASC</a></li>
                                <li><a class="dropdown-item" href="/admin/orders?sort=desc">Order DESC</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
            <div class="card-body">
                <table class="table">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Order ID</th>
                        <th scope="col">Customer Name</th>
                        <th scope="col">Order Date</th>
                        <th scope="col">Total Amount</th>
                        <th scope="col">Action</th>
                    </tr>

                    <c:forEach items="${listOrder}" var="order" >
                        <tr>
                            <th scope="row"><c:out value="${order.id}" /></th>
                            <td><c:out value="ORK-${order.id}" /></td>
                            <td><c:out value="${order.customer.getName()}" /></td>
                            <td><c:out value="${order.orderDate}" /></td>
                            <td><c:out value="${order.totalAmount}" /></td>
                            <td>
                                <a href="/admin/orders/detail?id=<c:out value="${order.id}" />">View Detail</a>
                                <a class="text-danger" href="/admin/orders/delete?id=<c:out value="${order.id}" />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
