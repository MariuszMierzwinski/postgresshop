<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 14.07.19
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Pricing example · Bootstrap</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/pricing/">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="pricing.css" rel="stylesheet">
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">Sport Shop SDA JSP</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="basket.jsp">Basket</a>
        <a class="p-2 text-dark" href="#">Control Panel</a>
        <a class="btn btn-outline-primary" action href="${pageContext.request.contextPath}">HOME</a>
    </nav>
    <a class="btn btn-outline-primary" action href="sign_In.jsp">ADMIN</a>
</div>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Sport products</h1>
    <p class="lead">Store mission, some healthy lifestyle promotion</p>
</div>
<div class="container">

    <div class="card-deck mb-3 text-center">
        <div class="container">
            <div class="row">
                <div class="col-sm">
                    <h6>Product</h6>
                </div>
                <div class="col-sm">
                    <h6>Price</h6>
                </div>
                <div class="col-sm">
                    <h6>Product size</h6>
                </div>
                <div class="col-sm">
                    <h6>Colour</h6>
                </div>
                <div class="col-sm">
                    <h6>Sex</h6>
                </div>
                <div class="col-sm">
                    <h6>Quantity</h6>
                </div>
                <div class="col-sm">
                    <h6></h6>
                </div>
                <div class="col-sm">
                    <h6></h6>
                </div>
                <div class="container">
                    <br>
                </div>

                <c:forEach var="product" items="${requestScope.products}">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm">
                                    ${product.name}
                            </div>
                            <div class="col-sm">
                                    ${product.price}
                            </div>
                            <div class="col-sm">
                                    ${product.size}
                            </div>
                            <div class="col-sm">
                                    ${product.colour}
                            </div>
                            <div class="col-sm">
                                    ${product.sex}
                            </div>
                            <div class="col-sm">
                                    ${product.quantity}
                            </div>
                            <div class="col-sm">
                                <a href="productManagement?id=${product.id}&add=dec" class="btn btn-primary btn-sm"
                                   type="button">-</a>
                            </div>
                            <div class="col-sm">
                                <a href="productManagement?id=${product.id}&add=inc" class="btn btn-primary btn-sm"
                                   type="button">+</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="container">
                    <br>
                </div>
                <div class="container">
                    <h3>Add Products</h3>
                </div>
                <div class="container">
                    <br>
                </div>
                <div class="container">
                    <form method="POST" action=${pageContext.request.contextPath} target="_blank">
                        <div class="row">
                            <div class="col">
                                <input type="text" class="form-control" name="name" placeholder="name">
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" name="price" placeholder="price">
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" name="size" placeholder="size">
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" name="colour" placeholder="colour">
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" name="sex" placeholder="sex">
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" name="quantity" placeholder="quantity">
                            </div>
                        </div>
                        <div class="container">
                            <br>
                        </div>

                        <button type="submit" class="col-sm">Submit
                        </button>
                    </form>
                    <div class="container">
                        <br>
                    </div>
                    <div class="container">
                        <h3>Transactions list</h3>
                    </div>
                    <div class="container">
                        <br>
                    </div>
                    <c:forEach var="transaction" items="${requestScope.transactions}">
                    <div class="container">
                        <br>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-sm">
                                <h4> User mail: </h4>
                            </div>
                            <div class="col-sm">
                                <h4>   ${transaction.client.email} </h4>
                            </div>
                        </div>
                        <c:set var="count" value="0" scope="page"/>


                        <c:forEach var="product" items="${transaction.products}">
                            <div class="row">
                                <div class="col-sm">
                                        ${product.name}
                                </div>
                                <div class="col-sm">
                                        ${product.quantity}
                                </div>
                            </div>

                            <c:set var="count" value="${count + product.price*product.quantity}" scope="page"/>

                        </c:forEach>

                        <div class="row">
                            <div class="col-sm">
                                <h5> Total price: </h5>
                            </div>
                            <div class="col-sm">
                                <h5>   ${count} </h5>
                            </div>

                        </div>

                    </div>


                </div>
                <div class="container">
                    <br>
                </div>
                </c:forEach>

            </div>
        </div>
        <footer class="pt-4 my-md-5 pt-md-5 border-top">
            <div class="row">
                <div class="col-12 col-md">
                    <img class="mb-2" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="24"
                         height="24">
                    <small class="d-block mb-3 text-muted">&copy; 2017-2019</small>
                </div>
                <div class="col-6 col-md">
                    <h5>Features</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="text-muted" href="#">Cool stuff</a></li>
                        <li><a class="text-muted" href="#">Random feature</a></li>
                        <li><a class="text-muted" href="#">Team feature</a></li>
                        <li><a class="text-muted" href="#">Stuff for developers</a></li>
                        <li><a class="text-muted" href="#">Another one</a></li>
                        <li><a class="text-muted" href="#">Last time</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md">
                    <h5>Resources</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="text-muted" href="#">Resource</a></li>
                        <li><a class="text-muted" href="#">Resource name</a></li>
                        <li><a class="text-muted" href="#">Another resource</a></li>
                        <li><a class="text-muted" href="#">Final resource</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md">
                    <h5>About</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="text-muted" href="#">Team</a></li>
                        <li><a class="text-muted" href="#">Locations</a></li>
                        <li><a class="text-muted" href="#">Privacy</a></li>
                        <li><a class="text-muted" href="#">Terms</a></li>
                    </ul>
                </div>
            </div>
        </footer>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</div>
</body>
</html>

