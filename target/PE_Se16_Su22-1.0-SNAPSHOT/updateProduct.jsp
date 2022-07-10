<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Update Product</title>
    </head>
    <body>
        <div class="container">
            <h1>Update Product</h1>
            <div class="col-4" >
                <form action="updateProduct" method="post" enctype="multipart/form-data">
                    <input class="form-control" type="hidden" name="productId" value="${pro.productId}">
                    <h5>Product Name</h5>
                    <input class="form-control" type="text" name="productName" placeholder="Enter Product Name" value="${pro.productName}">
                    <h5>Quantity</h5>
                    <input class="form-control" type="number" name="quantity" placeholder="Enter quantity" value="${pro.quantity}">
                    <h5>Price</h5>
                    <input class="form-control" type="number" name="price" placeholder="Enter Price" step=0.1 min=0 value="${pro.price}">
                    <h5>Image</h5>
                    <img src="images/${pro.image}" class="img-thumbnail" width="100px">
                    <input class="form-control" type="file" name="image">
                    <input type="text" name="userCreate" value="${sessionScope.a.username}">
                    <br>
                    <button class="btn btn-primary" type="submit">Save</button>
                    <button class="btn btn-primary" type="reset">Cancel</button>
                </form>
            </div>
        </div>
    </body>
</html>
