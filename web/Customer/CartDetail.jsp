
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
                    <a class="back-btn" href="ShopController">
                        <span class="svg-ic">
                            <svg xmlns="http://www.w3.org/2000/svg" width="11" height="5" viewBox="0 0 11 5" fill="none">
                            <path fill-rule="evenodd" clip-rule="evenodd"
                                  d="M10.5791 2.28954C10.5791 2.53299 10.3818 2.73035 10.1383 2.73035L1.52698 2.73048L2.5628 3.73673C2.73742 3.90636 2.74146 4.18544 2.57183 4.36005C2.40219 4.53467 2.12312 4.53871 1.9485 4.36908L0.133482 2.60587C0.0480403 2.52287 -0.000171489 2.40882 -0.000171488 2.2897C-0.000171486 2.17058 0.0480403 2.05653 0.133482 1.97353L1.9485 0.210321C2.12312 0.0406877 2.40219 0.044729 2.57183 0.219347C2.74146 0.393966 2.73742 0.673036 2.5628 0.842669L1.52702 1.84888L10.1383 1.84875C10.3817 1.84874 10.5791 2.04609 10.5791 2.28954Z"
                                  fill="white"></path>
                            </svg>
                        </span>Back to Return
                    </a>
                    <h2 class="heading text-left">Clothes Detail</h2>
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
                                <c:if test="${detail.isOnDiscount == 1}">
                                    <input class="quantity__input" type="number" name="quantity" id="my-inputQuanlity" min="1" value="${detail.quantity}"
                                           max="${detail.pquantity}" step="1" onchange="updateSubtotal(this, ${detail.price - (detail.price * detail.discount)/100})">
                                </c:if>
                                <c:if test="${detail.isOnDiscount == 0}">
                                    <input class="quantity__input" type="number" name="quantity" id="my-inputQuanlity" min="1" value="${detail.quantity}"
                                           max="${detail.pquantity}" step="1" onchange="updateSubtotal(this, ${detail.price})">
                                </c:if>
                            </span>
                            <c:if test="${detail.isOnDiscount == 0}">
                                <strong>Total: $<span class="subtotal" data-price="${detail.price * detail.total}">${detail.price * detail.quantity}</span></strong>
                                </c:if>
                                <c:if test="${detail.isOnDiscount == 1}">
                                <strong>Total: $<span class="subtotal" data-price="${(detail.price - (detail.price * detail.discount)/100) * detail.quantity}">${(detail.price - (detail.price * detail.discount)/100) * detail.quantity}</span></strong>
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
                                <button type="submit" class="my-btn">
                                    <i class="fas fa-shopping-cart"></i>Add to cart
                                </button>
                                <a href="CartContact" class="my-btn">
                                    <i class="fas fa-wallet"></i>Back Cart Contact
                                </a>
                                <br>
                                <a href="DeleteOrder?id=${detail.orderId}" class="my-btn">
                                    <i class='bx bx-trash'></i>Delete
                                </a>
                                <a href="ShopController" type="button" class="my-btn">
                                    <i class="fas fa-shopping-bag"></i>Shop
                                </a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- ====== Recent Products ====== -->
        <section class="section collection">
            <div class="title">
                <span>COLLECTION</span>
                <h2>Recent Product</h2>
            </div>

            <div class="products container">
                <div class="swiper mySwiper">
                    <div class="swiper-wrapper" id="products">
<c:forEach items="${list6newP}" var="p">
                            <div class="swiper-slide">
                                <div class="product">
                                    <div class="top d-flex">
                                        <a href="ProductDetail?pid=${p.productId}">
                                            <img src="images/${p.img1}" alt="" />
                                            <div class="icon d-flex">
                                                <i class="bx bxs-heart"></i>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="bottom">
                                        <h4>${p.nameProduct}</h4>
                                        <p class="sub-blog-descrip">${p.describe}</p>
                                        <div class="d-flex">
                                            <div class="price"><p>$${p.price - (p.price * p.discount / 100)}</p>
                                                <c:if test="${p.isOnDiscount eq 1}">
                                                    <del>$${p.price}</del>
                                                </c:if>
                                            </div>
                                            <div class="rating">
                                                <i class="bx bxs-star"></i>
                                                <i class="bx bxs-star"></i>
                                                <i class="bx bxs-star"></i>
                                                <i class="bx bxs-star"></i>
                                                <i class="bx bxs-star"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="pagination">
                    <div class="custom-pagination"></div>
                </div>
            </div>
        </section>
        <!-- ====== Footer ====== -->
        <jsp:include page="../Footer.jsp"></jsp:include>
        <!-- ====== SwiperJs ====== -->
        <script src="./js/swiper-bundle.min.js"></script>
        <script src="js/productDetail.js"></script>
        <script src="js/app.js"></script>
        <script src="js/product.js"></script>
        <script>
                                               function updateSubtotal(input, price) {
                                                   const quantity = input.value;
                                                   const subtotal = quantity * price;
                                                   const subtotalElement = input.parentNode.parentNode.querySelector('.subtotal');
                                                   subtotalElement.setAttribute('data-price', subtotal);
                                                   subtotalElement.innerHTML = subtotal;
                                                   updateTotal();
                                               }

                                               function updateTotal() {
                                                   const subtotalElements = document.querySelectorAll('.subtotal');
                                                   let total = 0;
                                                   subtotalElements.forEach(element => {
                                                       const subtotal = parseInt(element.getAttribute('data-price'));
                                                       if (!isNaN(subtotal)) {
                                                           total += subtotal;
                                                       }
                                                   });
                                                   document.getElementById('total-price').innerHTML = total;
                                               }
        </script>
        <style>
            .my-btn {
                background-color: #4CAF50; /* Green background color */
                color: white; /* White text color */
                font-size: 16px; /* Font size */
                border: none; /* Remove border */
                padding: 12px 24px; /* Add padding */
                text-align: center; /* Center text */
                text-decoration: none; /* Remove underline */
                display: inline-block; /* Make element inline */
                margin: 4px 2px; /* Add margin */
                cursor: pointer; /* Add cursor pointer */
            }
        </style>
    </body>
</html>
