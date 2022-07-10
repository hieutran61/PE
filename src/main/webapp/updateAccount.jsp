<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Update Account</title>
    </head>
    <body>
        <div class="container">
            <h1>Update Account</h1>
            <div class="col-4" >
                <form action="updateAccount" method="post">
                    <h5>Account</h5>
                    <input class="form-control" type="text" name="username" placeholder="Enter Username" value="${acc.username}" readonly>
                    <h5>Password</h5>
                    <input class="form-control" type="password" name="password" placeholder="Enter password" value="${acc.password}">
                    <h5>Fullname</h5>
                    <input class="form-control" type="text" name="fullname" placeholder="Enter Fullname" value="${acc.fullname}">
                    <h5>Role</h5>
                    <select name="role" class="form-select">
                        <option value="1" ${acc.role==true ? "selected":""}>Admin</option>
                        <option value="0" ${acc.role==false ? "selected":""}>User</option>
                    </select>
                    <h5>Status</h5>
                    <select name="status" class="form-select">
                        <option value="1" ${acc.status==true ? "selected":""}>Active</option>
                        <option value="0" ${acc.status==false ? "selected":""}>Inactive</option>
                    </select>
                    <br>
                    <button class="btn btn-primary" type="submit">Save</button>
                    <button class="btn btn-primary" type="reset">Cancel</button>
                </form>
            </div>
        </div>
    </body>
</html>
