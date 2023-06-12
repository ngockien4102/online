<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <jsp:include page="Navigation.jsp"></jsp:include>

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
                    <h2 class="heading text-left">Clothes</h2>
                    <div class="row collection-content">
                        <div class="col-12  collection-text"></div>
                    </div>
                </div>
            </section>
            <div class="products-shop section">
                <div class="container-shop">
                    <div class="title">
                        <span>COLLECTION</span>
                        <h2>Our Clothes</h2>
                    </div>
                    <div class="container-search">
                        <form action="ShopController" class="filter-shop">
                            <div class="item-search">
                                <label for="">Category</label>
                                <select name="category">
                                    <option value="0">All</option>
                                <c:forEach items="${categorys}" var="c">
                                    <option value="${c.categoryId}">${c.nameCategory}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="item-search">
                            <label for="">Name</label>
                            <input type="text" name="name">
                        </div>
                        <div class="item-empty">
                            <input type="number" value="${numPage}" name="indexPage" hidden>
                        </div>
                        <div class="item-search">
                            <label for="">From Price</label>
                            <input type="number" name="fromPrice">
                        </div>
                        <div class="item-search">
                            <label for="">To Price</label>
                            <input type="number" name="toPrice">
                        </div>
                        <div class="item-search btn-search">
                            <button type="submit">Search</button>
                        </div>
                    </form>
                </div>
                <div class="product-items">
                    <!-- single product -->
                    <c:forEach items="${listproduct}" var="p">
                        <div class="product">
                            <div class="product-content">
                                <div class="product-img">
                                    <img src="images/${p.img1}" alt="product image">
                                </div>
                                <div class="product-btns">
                                    <a href="AddToCart?productId=${p.productId}" class="btn-cart"> add to cart
                                        <span><i class="fas fa-plus"></i></span>
                                    </a>
                                    <a href="ProductDetail?pid=${p.productId}" class="btn-buy"> View now
                                        <span><i class="fas fa-search-plus"></i></span>
                                    </a>
                                </div>
                            </div>

                            <div class="product-info">
                                <div class="product-info-top">
                                    <h2 class="sm-title">${p.nameCategory}</h2>
                                    <div class="rating">
                                        <c:forEach begin="1" end="5" step="1" var="rating">
                                            <c:if test="${p.averageRankStar >= rating}">
                                                <span><i class="fas fa-star"></i></span>
                                                </c:if>
                                                <c:if test="${p.averageRankStar < rating}">
                                                <span><i class="fas fa-star" id="notstar"></i></span>
                                                </c:if>
                                            </c:forEach>
                                    </div>
                                </div>
                                <a href="ProductDetail?pid=${p.productId}" class="product-name">${p.nameProduct}</a>

                                <c:if test="${p.isOnDiscount eq 0}">
                                    <p class="product-price"></p>
                                    <p class="product-price">$ ${p.price}</p>
                                </c:if>

                                <c:if test="${p.isOnDiscount eq 1}">
                                    <p class="product-price">$ ${p.price}</p>
                                    <p class="product-price">$ ${p.price - (p.price * p.discount / 100)}</p>
                                </c:if>
                            </div>
                            <c:if test="${p.isOnDiscount eq 1}">
                                <div class="off-info">
                                    <h2 class="sm-title">${p.discount}% off</h2>
                                </div>
                            </c:if>
                        </div>
                    </c:forEach>
                    <!-- end of single product -->
                </div>
                <ul class="listPage">
                    <c:forEach begin="1" end="${endPageProduct}" var="i">
                        <li class="${numPage == i ? "active":""}"><a href="ShopController?index=${i}">${i}</a></li>
                        </c:forEach>
                </ul>
            </div>
        </div>
        <!-- ====== Footer ====== -->
        <jsp:include page="Footer.jsp"></jsp:include>
        <!-- ====== SwiperJs ====== -->
        <script src="./js/swiper-bundle.min.js"></script>
        <script src="js/app.js"></script>
        <style>
            #notstar {
                color: #e4e4e4;
            }
        </style>
    </body>
</html>