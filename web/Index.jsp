
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- ====== Favicon ====== -->
        <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />
        <!-- ====== Boxicons ====== -->
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet" />
        <!-- ====== Swiper CSS ====== -->
        <link rel="stylesheet" href="css/swiper-bundle.min.css" />
        <!-- ====== Custom CSS ====== -->
        <link rel="stylesheet" href="css/styles.css" />
        <title>Online Shop</title>
    </head>

    <body>
        <!-- ====== Header ====== -->
        <header class="header">
            <!-- ====== Navigation ====== -->
            <jsp:include page="Navigation.jsp"></jsp:include>
                <!-- ====== Silder ====== -->
                <section class="header-silder">
                    <div class="media-icons">
                        <a href=""><i class="bx bxl-facebook"></i></a>
                        <a href=""><i class="bx bxl-twitter"></i></a>
                        <a href=""><i class="bx bxl-instagram"></i></a>
                    </div>

                    <div class="swiper bg-slider">
                        <div class="swiper-wrapper">
                        <c:forEach items="${sliders}" var="s">
                            <div class="swiper-slide">
                                <img src="images/${s.img}" />
                                <div class="text-content">
                                    <h2 class="title">${s.title}</h2>
                                    <p>${s.describes}</p>
                                    <button class="read-btn"><a href="blogDetailsController?sid=${s.sliderId}">Read More <i class='bx bx-right-arrow-alt'></i></a></button>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="bg-slider-thumbs">
                    <div class="swiper-wrapper thumbs-container">
                        <c:forEach items="${sliders}" var="s">
                            <img src="images/${s.img}" class="swiper-slide" alt="">
                        </c:forEach>
                    </div>
                </div>
            </section>

        </header>
        <!-- ====== Collection ====== -->
        <section class="section collection">
            <div class="title">
                <span>COLLECTION</span>
                <h2>Our Top Collection</h2>
            </div>
            <div class="filters d-flex">
                <c:forEach items="${categorys}" var="c">
                    <div><a href="HomePage?cid=${c.categoryId}">${c.nameCategory}</a></div>
                    </c:forEach>
            </div>

            <div class="products container">
                <div class="swiper mySwiper">
                    <div class="swiper-wrapper" id="products">
                        <c:forEach items="${products}" var="product">

                            <div class="swiper-slide">
                                <a href="ProductDetail?pid=${product.productId}">
                                    <div class="product">
                                        <div class="top d-flex">

                                            <img src="images/${product.img1}" alt="" />
                                            <div class="icon d-flex">
                                                <i class="bx bxs-heart"></i>
                                            </div>

                                        </div>
                                        <div class="bottom">
                                            <h4>${product.nameProduct}</h4>
                                            <p class="sub-blog-descrip">${product.describe}</p>
                                            <div class="d-flex">
                                                <div class="price"><p>$${product.price - (product.price * product.discount / 100)}</p>
                                                    <c:if test="${product.isOnDiscount eq 1}">
                                                        <del>$${product.price}</del>
                                                    </c:if>
                                                </div>
                                                <div class="rating">
                                                    <c:forEach begin="1" end="5" step="1" var="rating">
                                                        <c:if test="${product.averageRankStar >= rating}">
                                                            <i class="bx bxs-star"></i>
                                                        </c:if>
                                                        <c:if test="${product.averageRankStar < rating}">
                                                            <i class="bx bxs-star" id="notstar"></i>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </div>

                        </c:forEach>
                    </div>
                </div>
                <div class="pagination">
                    <div class="custom-pagination"></div>
                </div>
            </div>
        </section>

        <!-- ====== New Arrival ====== -->
        <section class="section new-arrival">
            <div class="title">
                <span>NEW ARRIVAL</span>
                <h2>Latest Collection</h2>
            </div>

            <div class="row container">
                <div class="col col-1">
                    <img src="images/poster-1.png" alt="" />
                    <h3>
                        2023 Trends <br />
                        Women’s Smart Skirt
                    </h3>
                </div>
                <div class="col col-2">
                    <img src="images/poster-2.png" alt="" />
                    <h3>
                        2023 Trends <br />
                        Women’s Smart Skirt
                    </h3>
                </div>
                <div class="col col-3">
                    <img src="images/poster-3.png" alt="" />
                    <h3>
                        2023 Trends <br />
                        Women’s Smart Shirt <br />
                        <span>Discover More:</span>
                    </h3>
                </div>
            </div>
        </section>

        <!-- ====== Categories ====== -->
        <section class="section categories">
            <div class="title">
                <span>CATEGORIES</span>
                <h2>2023 Latest Collection</h2>
            </div>

            <div class="products container">
                <c:forEach items="${list6newP}" var="newproduct">
                    <div class="product">
                        <a href="ProductDetail?pid=${newproduct.productId}">
                            <div class="top d-flex">

                                <img src="images/${newproduct.img1}" alt="" />
                                <div class="icon d-flex">
                                    <i class="bx bxs-heart"></i>
                                </div>

                            </div>
                            <div class="bottom">
                                <div class="d-flex">
                                    <h4>
                                        ${newproduct.nameProduct}
                                        <p class="sub-blog-descrip categories-des-product">${newproduct.describe}</p>
                                    </h4> 
                                </div>
                                <div class="d-flex">
                                    <div class="price"><p>$${newproduct.price - (newproduct.price * newproduct.discount / 100)}</p>
                                        <c:if test="${newproduct.isOnDiscount eq 1}">
                                            <del>$${newproduct.price}</del>
                                        </c:if>
                                    </div>
                                    <div class="rating">
                                        <c:forEach begin="1" end="5" step="1" var="rating">
                                            <c:if test="${newproduct.averageRankStar >= rating}">
                                                <i class="bx bxs-star"></i>
                                            </c:if>
                                            <c:if test="${newproduct.averageRankStar < rating}">
                                                <i class="bx bxs-star" id="notstar"></i>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </a> 
                    </div>
                </c:forEach>
            </div>

            <!--            <div class="button d-flex">
                            <a class="btn loadmore">Load More</a>
                        </div>-->
        </section>

        <!-- ====== Statistics ====== -->
        <section class="section statistics">
            <div class="title">
                <span>STATS</span>
                <h2>Our Statistics</h2>
            </div>

            <div class="row container">
                <div class="col">
                    <div class="icon">
                        <i class="bx bxs-check-square"></i>
                    </div>
                    <h3>Easy Order System</h3>
                    <p>Lorem Ispum is a placeholder text commomly used as a free text.</p>
                </div>
                <div class="col">
                    <div class="icon">
                        <i class="bx bxs-user"></i>
                    </div>
                    <h3>On Time Delievery</h3>
                    <p>Lorem Ispum is a placeholder text commomly used as a free text.</p>
                </div>
                <div class="col">
                    <div class="icon">
                        <i class="bx bxs-dollar-circle"></i>
                    </div>
                    <h3>Money Back Gaurantee</h3>
                    <p>Lorem Ispum is a placeholder text commomly used as a free text.</p>
                </div>
                <div class="col">
                    <div class="icon">
                        <i class="bx bxs-user"></i>
                    </div>
                    <h3>24/7 Customer Support</h3>
                    <p>Lorem Ispum is a placeholder text commomly used as a free text.</p>
                </div>
            </div>
        </section>

        <!-- ====== Blogs ====== -->
        <section class="section blog">
            <div class="title">
                <span>BLOGS</span>
                <h2>Latest News</h2>
            </div>

            <div class="row container">
                <c:forEach items="${blog}" var="b">
                    <div class="col">
                        <div class="top">
                            <a href="blogDetailsController?bid=${b.blogId}"><img src="images/${b.img}" alt="" /></a>                         
                        </div>
                        <div class="bottom">
                            <h3>${b.title}</h3>
                            <h4 class="sub-blog-descrip">
                                ${b.describes}
                            </h4>
                            <a href="blogDetailsController?bid=${b.blogId}">Read More</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
        <!-- ====== Footer ====== -->
        <jsp:include page="Footer.jsp"></jsp:include>
        <!-- ====== SwiperJs ====== -->
        <script src="js/swiper-bundle.min.js"></script>
        <!-- ====== Custom Script ====== -->
        <script src="js/product.js"></script>
        <script src="js/app.js"></script>
        <style>
            #notstar {
                color: #e4e4e4;
            }
        </style>
    </body>

</html>
