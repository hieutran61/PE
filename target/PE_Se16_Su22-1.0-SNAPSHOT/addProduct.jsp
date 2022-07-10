
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <title>Add Product</title>
    </head>
    <body>
        <div class="container">
            <h1>Add Product</h1>
            <div class="col-4" >
                <form action="addProduct" method="post" enctype="multipart/form-data">
                    <h5>Product Name</h5>
                    <input class="form-control" type="text" name="productName" placeholder="Enter Product Name">
                    <h5>Quantity</h5>
                    <input class="form-control" type="number" name="quantity" placeholder="Enter quantity">
                    <h5>Price</h5>
                    <input class="form-control" type="number" name="price" placeholder="Enter Price" step=0.1 min=0>
                    <h5>Image</h5>
                    <input class="form-control" type="file" name="image" placeholder="Default input" aria-label="default input example" required>
                    <input type="text" name="userCreate" value="${sessionScope.a.username}">
                    <br>
                    <button class="btn btn-primary" type="submit">Save</button>
                    <button class="btn btn-primary" type="reset">Cancel</button>
                </form>
            </div>
        </div>
    </body>
</html>
