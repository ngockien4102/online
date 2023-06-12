
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />

        <title>Online Shop</title>
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
              integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" type="text/css"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <!-- ====== Swiper CSS ====== -->
        <link rel="stylesheet" href="css/swiper-bundle.min.css" />
    </head>
    <body>
        <!-- ====== Header ====== -->
        <header class="header">
            <!-- ====== Navigation ====== -->
            <jsp:include page="../Navigation.jsp"></jsp:include>

            </header>
            <section class="common-banner-section">
                <div class="container">
                    <h2 class="heading text-left">MyOrder Detail</h2>
                    <div class="row collection-content">
                        <div class="col-12  collection-text"></div>
                    </div>
                </div>
            </section>
            <div class="main-wrapper">
                <div class="container">
                    <form action="CartDetail" method="POST">
                        <div class="product-div">
                            <div class="product-div-left">
                                <div class="img-container">
                                    <img src="images/${detail.img1}">
                            </div>
                        </div>
                        <div class="product-div-right">
                            <span class="product-name">${detail.nameProduct}</span>
                            <c:if test="${detail.isOnDiscount == 0}">
                                <span class="product-price">Price: $${detail.price}</span>
                            </c:if>
                            <c:if test="${detail.isOnDiscount == 1}">
                                <span class="product-price">Price: $${detail.price - (detail.price * detail.discount)/100}</span>
                            </c:if>
                            <span class="product-price">Quantity: 
                                <input class="quantity__input" type="number" name="quantity" id="my-inputQuanlity" min="1" value="${detail.quantity}"
                                       max="${detail.pquantity}" step="1" readonly>
                            </span>
                            <c:if test="${detail.isOnDiscount == 0}">
                                <strong><span class="subtotal">Total: $${detail.price * detail.quantity}</span></strong>
                            </c:if>
                            <c:if test="${detail.isOnDiscount == 1}">
                                <strong><span class="subtotal">Total: $${(detail.price - (detail.price * detail.discount)/100) * detail.quantity}</span></strong>
                            </c:if>
                            <input value="${detail.orderId}" name="orderId" hidden>
                            <div class="product-rating">
                                <span><i class="fas fa-star"></i></span>
                                <span><i class="fas fa-star"></i></span>
                                <span><i class="fas fa-star"></i></span>
                                <span><i class="fas fa-star"></i></span>
                                <span><i class="fas fa-star-half-alt"></i></span>
                                <span>(350 ratings)</span>
                            </div>
                            <div class="btn-groups">
                                <a href="MyOrder" class="btn btn-primary"><i class="fas fa-wallet"></i>Back My Order</a>
                                <a href="ShopController" type="button" class="btn btn-primary"><i class="fas fa-wallet"></i>Shop</a>
                            </div>
                            <div class="people">
                                <h4>Full Name: ${sessionScope.customer.firstName} ${sessionScope.customer.lastName}</h4>   
                                <p class="time">Phone: ${sessionScope.customer.phone}</p>
                                <p class="Evaluate">Address: ${address.address} </p>
                                <p class="Evaluate">Note: ${address.notes} </p>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

        </div>

        <!-- ====== Footer ====== -->
        <jsp:include page="../Footer.jsp"></jsp:include>
        <!-- ====== SwiperJs ====== -->
        <script src="./js/swiper-bundle.min.js"></script>
        <script src="js/productDetail.js"></script>
        <script src="js/app.js"></script>
        <script src="js/product.js"></script>
    </body>
</html>
