<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Product</title>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-light bg-light">
                <form class="form-inline">
                    <c:if test="${sessionScope.a==null}">
                        <a role="button" class="btn btn-outline-success" href="login">Login</a>               
                    </c:if>
                    <c:if test="${sessionScope.a!=null}">
                        <a role="button" class="btn btn-outline-success" href="logout">Logout</a>    
                        <a role="button" class="btn btn-sm btn-outline-secondary" href="#">hello ${sessionScope.a.username}</a>             
                    </c:if>
                </form>
            </nav>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <td>ProductID</td>
                        <td>Product Name</td>
                        <td>Quantity</td>
                        <td>Price</td>
                        <td>Image</td>
                        <td>User Create</td>
                        <td>Date Create</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="i">
                    <tr>
                        <td>${i.productId}</td>
                        <td>${i.productName}</td>
                        <td>${i.quantity}</td>
                        <td>${i.price}</td>
                        <td><img src="images/${i.image}" class="img-thumbnail" width="100px"></td>
                        <td>${i.userCreate}</td>
                        <td>${i.dateCreate}</td>
                        <c:if test="${sessionScope.a.role==true}" >
                            <td>
                                <a role="button" class="btn btn-info" href="updateProduct?productId=${i.productId}">Update</a>
                                <a role="button" class="btn btn-danger" href="deleteProduct?productId=${i.productId}">Delete</a>
                            </td>
                        </c:if>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:if test="${sessionScope.a.role==true}" >
                <a role="button" class="btn btn-secondary" href="addProduct">Create</a>
            </c:if>
            <a role="button" class="btn btn-secondary" href="account">Account</a>

        </div>
    </body>
</html>
