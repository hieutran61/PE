<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>ACCOUNT</title>
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
                        <td>Account</td>
                        <td>Password</td>
                        <td>Fullname</td>
                        <td>Role</td>
                        <td>Status</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <c:if test="${sessionScope.a.role==true}" >
                    <tbody>
                        <c:forEach items="${list}" var="i">
                        <tr>
                            <td>${i.username}</td>
                            <td>${i.password}</td>
                            <td>${i.fullname}</td>
                            <td>${i.role}</td>
                            <td>${i.status}</td>
                            <td>
                                <a role="button" class="btn btn-info" href="updateAccount?username=${i.username}">Update</a>
                                <a role="button" class="btn btn-danger" href="deleteAccount?username=${i.username}">Delete</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </c:if>

                <c:if test="${sessionScope.a.role==false}" >
                    <tbody>
                        <c:forEach items="${list}" var="i">
                        <c:if test="${sessionScope.a.username==i.username}">
                            <tr>
                                <td>${i.username}</td>
                                <td>${i.password}</td>
                                <td>${i.fullname}</td>
                                <td>${i.role==true ? "Admin":"User"}</td>
                                <td>${i.status=="true" ? "Active":"Inactive"}</td>
                                <td>
                                    <a role="button" class="btn btn-info" href="updateAccount?username=${i.username}">Update</a>
                                </td>
                            </tr>
                        </c:if>
                        </c:forEach>
                    </tbody>
                </c:if>
            </table>

            <c:if test="${sessionScope.a.role==true}" >
                <a role="button" class="btn btn-secondary" href="addAccount">Create</a>
            </c:if>
            <a role="button" class="btn btn-secondary" href="product">Product</a>
        </div>
    </body>
</html>
