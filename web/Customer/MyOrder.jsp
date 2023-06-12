<%-- 
    Document   : cart
    Created on : 31-05-2023, 20:47:31
    Author     : MSII
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- ====== Boxicons ====== -->
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet" />
        <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
              integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Online Shop</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>

    <body>
        <!-- ====== Header ====== -->
        <header class="header">
            <!-- ====== Navigation ====== -->
            <jsp:include page="../Navigation.jsp"></jsp:include>

            </header>

            <section class="common-banner-section">
                <div class="container">
                    <a class="back-btn" href="index.html">
                        <span class="svg-ic">
                            <svg xmlns="http://www.w3.org/2000/svg" width="11" height="5" viewBox="0 0 11 5" fill="none">
                            <path fill-rule="evenodd" clip-rule="evenodd"
                                  d="M10.5791 2.28954C10.5791 2.53299 10.3818 2.73035 10.1383 2.73035L1.52698 2.73048L2.5628 3.73673C2.73742 3.90636 2.74146 4.18544 2.57183 4.36005C2.40219 4.53467 2.12312 4.53871 1.9485 4.36908L0.133482 2.60587C0.0480403 2.52287 -0.000171489 2.40882 -0.000171488 2.2897C-0.000171486 2.17058 0.0480403 2.05653 0.133482 1.97353L1.9485 0.210321C2.12312 0.0406877 2.40219 0.044729 2.57183 0.219347C2.74146 0.393966 2.73742 0.673036 2.5628 0.842669L1.52702 1.84888L10.1383 1.84875C10.3817 1.84874 10.5791 2.04609 10.5791 2.28954Z"
                                  fill="white"></path>
                            </svg>
                        </span>Back to Return
                    </a>
                    <h2 class="heading text-left">Shopping Cart</h2>
                    <div class="row collection-content">
                        <div class="col-12  collection-text"></div>
                    </div>
                </div>
            </section>
            <!-- Cart  -->
            <!--            <form action="CartContact" method="POST">-->
            <section id="cart" class="section cart_Shop">
                <div class="title">
                    <span>COLLECTION</span>
                    <h2>My Order</h2>
                </div>
                <div class="product-categories">
                    <ul class="list-group" role="tablist">
                        <li class="list-group-item text-white" role="presentation">
                            <a href="MyOrder?status=1" role="tab" aria-selected="true">ON HOLD</a>
                        </li>
                        <li class="list-group-item text-white" role="presentation">
                            <a href="MyOrder?status=3" role="tab">PROGRESS</a>
                        </li>
                        <li class="list-group-item text-white" role="presentation">
                            <a href="MyOrder?status=4" role="tab">DONE</a>
                        </li>
                        <li class="list-group-item text-white" role="presentation">
                            <a href="MyOrder?status=2" role="tab">CANCEL</a>
                        </li>
                    </ul>
                </div>
                <table>
                    <thead>
                        <tr>
                            <td>Image</td>
                            <td>Product</td>
                            <td>Price</td>
                            <td>Quantity</td>
                            <td>Subtotal</td>
                            <td>Status</td>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Lcart}" var="c">
                        <tr>
                            <td><img src="images/${c.img1}" alt=""></td>
                            <td><a type="button" class="add-cart-btn" href="OrderDetail?pid=${c.orderId}">${c.nameProduct}</a></td>
                            <td> <c:if test="${c.isOnDiscount == 1}">
                                    $${c.price - (c.price * c.discount)/100}
                                </c:if>
                                <c:if test="${c.isOnDiscount == 0}">
                                    $${c.price}
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${c.isOnDiscount == 1}">
                                    <input class="quantity__input" type="number" name="quantity" id="my-inputQuanlity" min="1" value="${c.quantity}"
                                           max="${c.pquantity}" step="1" readonly>
                                </c:if>
                                <c:if test="${c.isOnDiscount == 0}">
                                    <input class="quantity__input" type="number" name="quantity" id="my-inputQuanlity" min="1" value="${c.quantity}"
                                           max="${c.pquantity}" step="1" readonly>
                                </c:if>
                            </td>
                            <td>
                                <input value="${c.orderId}" name="orderId" hidden>
                                <c:if test="${c.isOnDiscount == 1}">
                                    <strong>$<span class="subtotal" data-price="">${(c.price - (c.price * c.discount)/100) * c.quantity}</span></strong>
                                    </c:if>
                                    <c:if test="${c.isOnDiscount == 0}">
                                    <strong>$<span class="subtotal" data-price="">${c.price * c.quantity}</span></strong>
                                    </c:if>

                            </td>
                            <td>
                                <c:if test="${c.status == 1}">
                                    <span style="color: yellow">Waiting for approval</span>
                                    <br>
                                    <a type="button" href="MyOrder?cancel=${c.orderId}" style="color: red" >Cancel</a>
                                </c:if>
                                <c:if test="${c.status == 2}">
                                    <span style="color: red">Canceled</span>
                                </c:if>
                                <c:if test="${c.status == 3}">
                                    <span style="color: blue">Delivering</span>
                                    <a type="button" href="MyOrder?done=${c.orderId}" style="color: green" >Done</a>
                                </c:if>
                                <c:if test="${c.status == 4}">
                                    <span style="color: greenyellow">Success</span>
                                    <br>
                                    <a type="button" href="ProductDetail?pid=${c.productId}" >FeedBack</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
        <!--        </form>-->
        <!-- ====== Footer ====== -->
        <footer>
            <div class="row">
                <div class="col">
                    <img src="/images/logoShop.png" class="logo" alt="">
                    <p class="des-detail">The best way to find yourself is to lose yourself in the service of others.</p>
                </div>

                <div class="col">
                    <h3>Contact Us <div class="underline"><span></span></div>
                    </h3>
                    <p>9 W 53rd, New York, NY 10519, USA</p>
                    <p class="email-id">jamecolor@gmail.com</p>
                    <h3>+91 212-123-0987</h3>
                </div>
                <div class="col">
                    <h3>Links <div class="underline"><span></span></div>
                    </h3>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Shop</a></li>
                        <li><a href="#">Blog</a></li>
                        <li><a href="#">Gallery</a></li>
                    </ul>
                </div>
                <div class="col">
                    <h3>Newsletter <div class="underline"><span></span></div>
                    </h3>
                    <form>
                        <i class='bx bx-envelope'></i>
                        <input type="email" placeholder="Enter your email" required>
                        <button type="submit"><i class='bx bx-right-arrow-alt'></i></button>
                    </form>
                    <div class="social-icons">
                        <i class="bx bxl-facebook"></i>
                        <i class="bx bxl-twitter"></i>
                        <i class="bx bxl-instagram"></i>
                        <i class="bx bxl-youtube"></i>
                    </div>
                </div>
            </div>
            <hr>
        </footer>
        <!-- ====== SwiperJs ====== -->
        <script src="js/swiper-bundle.min.js"></script>
        <script src="js/app.js"></script>
        <style>
            .product-categories {
                display: block;
                margin: 0;
                padding: 0;
                width: 100%;
            }

            .list-group {
                display: flex;
                flex-wrap: wrap;
                list-style: none;
                margin: 0;
                padding: 0;
            }

            .list-group-item {
                flex: 1 1 25%;
                margin: 0;
                padding: 0;
            }

            .list-group-item a {
                background-color: #fff;
                border: 1px solid #ccc;
                border-radius: 5px 5px 0 0;
                color: #333;
                display: block;
                font-weight: bold;
                padding: 10px;
                text-align: center;
                text-decoration: none;
            }

            .list-group-item a:hover {
                background-color: #ccc;
            }
            a[type="button"] {
                display: inline-block;
                padding: 1rem 2rem;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 1rem;
                text-decoration: none;
                font-size: 1.5rem;
                cursor: pointer;
                text-align: center;
                margin: 0.5rem;
            }

            a[type="button"]:hover {
                background-color: #0069d9;
            }
        </style>
    </body>

</html>