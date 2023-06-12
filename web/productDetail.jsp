
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="css/styles.css">
        <!-- ====== Swiper CSS ====== -->
        <link rel="stylesheet" href="css/swiper-bundle.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" 
              integrity="sha512-9zZi5beaQcGZCXvJcZKj/9KCmzQJQb+2Q3rWT3Ld8iEO5vVfjJvO3vGs8NQ+g6DZx3iMnRy7kK0j9eqL5XVxQ==" 
              crossorigin="anonymous" referrerpolicy="no-referrer" />
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
                    <h2 class="heading text-left">Clothes Detail</h2>
                    <div class="row collection-content">
                        <div class="col-12  collection-text"></div>
                    </div>
                </div>
            </section>
            <div class="main-wrapper">
                <div class="container">
                    <form action="AddToCart" method="POST">
                        <div class="product-div">
                            <div class="product-div-left">
                                <div class="img-container">
                                    <img src="images/${products.img1}">
                            </div>
                            <div class="hover-container">
                                <div><img src="images/${products.img1}"></div>
                                <div><img src="images/${products.img2}"></div>
                                <div><img src="images/${products.img3}"></div>
                            </div>
                            <input name="productId" value="${products.productId}" hidden>
                        </div>
                        <div class="product-div-right">
                            <span class="product-category">${products.nameCategory}</span>
                            <span class="product-name">${products.nameProduct}</span>
                            <span class="product-price">
                                $${products.price - (products.price * products.discount / 100)}
                                <c:if test="${products.isOnDiscount eq 1}">
                                    <del>$${products.price}</del>
                                </c:if>
                            </span>
                            <div class="pdp-price-section">
                                <div class="prorow-lbl-qntty">
                                    <label class="product-labl">Quantity</label>
                                    <quantity-input class="quantity qty-spinner">
                                        <button type="button" class="quantity__button no-js-hidden quantity-decrement " id="minus" onclick="stepper(this)">
                                            <svg width="12" height="2" viewBox="0 0 12 2" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path d="M0 0.251343V1.74871H12V0.251343H0Z" fill="#61AFB3"></path>
                                            </svg>
                                        </button>
                                        <input class="quantity__input" type="number" name="quantity" id="my-inputQuanlity" min="1" value="1"
                                               max="${products.quantity}" step="1">
                                        <button type="button" class="quantity__button no-js-hidden quantity-increment" id="plus" onclick="stepper(this)">
                                            <svg width="12" height="12" viewBox="0 0 12 12" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path
                                                d="M6.74868 5.25132V0H5.25132V5.25132H0V6.74868H5.25132V12H6.74868V6.74868H12V5.25132H6.74868Z"
                                                fill="#61AFB3"></path>
                                            </svg>
                                        </button>
                                    </quantity-input>
                                </div>
                            </div>
                            <div class="product-rating">
                                    <c:forEach begin="1" end="5" step="1" var="rating">
                                        <c:if test="${products.averageRankStar >= rating}">
                                        <i class="fas fa-star"></i>
                                    </c:if>
                                    <c:if test="${products.averageRankStar < rating}">
                                        <i class="fas fa-star" id="notstar"></i>
                                    </c:if>
                                </c:forEach>
                                <span>(${products.totalFeedback} ratings)</span>
                            </div>
                            <p class="product-description">${products.describe}</p>
                            <div class="btn-groups">
                                <Button type="submit" class="add-cart-btn"><i class="fas fa-shopping-cart"></i>add to
                                    cart</Button>
                                <button type="submit" class="buy-now-btn"><i class="fas fa-wallet"></i>buy now</button>
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
                                                <c:forEach begin="1" end="5" step="1" var="rating">
                                                    <c:if test="${p.averageRankStar >= rating}">
                                                        <i class="bx bxs-star"></i>
                                                    </c:if>
                                                    <c:if test="${p.averageRankStar < rating}">
                                                        <i class="fas fa-star" id="notstar"></i>
                                                    </c:if>
                                                </c:forEach>
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
        <div class="main">
            <c:if test="${sessionScope.customer != null}">
                <c:if test="${f.status == 4}">
                    <c:if test="${f.personId == 0}">
                        <div class="feedback">
                            <h4>Feedback</h4>
                            <form action="FeedBack" method="Post">
                                <input name="productId" value="${products.productId}" readonly style="display: none">
                                <div class="rating">
                                    <input type="radio" id="star5" name="rating" value="5">
                                    <label for="star5"><i class="fas fa-star"></i></label>
                                    <input type="radio" id="star4" name="rating" value="4">
                                    <label for="star4"><i class="fas fa-star"></i></label>
                                    <input type="radio" id="star3" name="rating" value="3">
                                    <label for="star3"><i class="fas fa-star"></i></label>
                                    <input type="radio" id="star2" name="rating" value="2">
                                    <label for="star2"><i class="fas fa-star"></i></label>
                                    <input type="radio" id="star1" name="rating" value="1">
                                    <label for="star1"><i class="fas fa-star"></i></label>
                                </div>
                                <div>
                                    <label for="comment">Comment:</label>
                                    <textarea id="comment" name="comment" rows="4" required></textarea>
                                </div>
                                <div>
                                    <input type="file" id="image" name="image" accept="image/*">
                                    <label for="image" class="upload-btn">Select File</label>
                                    <span class="file-name"></span>
                                    <img id="preview" src="#" alt="Preview" style="display:none; max-width: 200px;">
                                </div>
                                <button type="submit">Submit</button>
                            </form>
                        </div>
                    </c:if>
                </c:if>
            </c:if>
            <c:forEach items="${ListF}" var="f">
                <div class="people">
                    <div class="avatar">
                        <img src="images/${f.img}" alt="">
                    </div>
                    <h4>${f.firstName} ${f.lastName}</h4>    
                    <div class="container">
                        <c:forEach begin="1" end="5" step="1" var="rating">
                            <c:if test="${f.rankStar >= rating}">
                                <i class="fas fa-star"></i>
                            </c:if>
                            <c:if test="${f.rankStar < rating}">
                                <i class="fas fa-star" id="notstar"></i>
                            </c:if>
                        </c:forEach>
                    </div>
                    <p class="time">${f.dateFeedBack}</p>
                    <p class="Evaluate"> ${f.describes} </p>
                    <div class="img">
                        <img src="images/${f.fimg}" alt="">
                    </div>
                </div>
            </c:forEach>
        </div>
        <!-- ====== Footer ====== -->
        <jsp:include page="Footer.jsp"></jsp:include>
        <!-- ====== SwiperJs ====== -->
        <script src="./js/swiper-bundle.min.js"></script>
        <script src="js/productDetail.js"></script>
        <script src="js/app.js"></script>
        <script src="js/product.js"></script>
        <style>
            /* Style for the feedback form */
            .feedback {
                margin-bottom: 20px;
            }

            .feedback label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }

            .feedback input,
            .feedback textarea {
                display: block;
                width: 100%;
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ddd;
                border-radius: 5px;
                margin-bottom: 10px;
            }

            .feedback input[type="file"] {
                display: none;
            }

            .feedback .upload-btn {
                background-color: #3498db;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
                display: inline-block;
                margin-bottom: 10px;
            }

            .feedback .file-name {
                margin-left: 10px;
            }

            .feedback button[type="submit"] {
                background-color: #3498db;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
                display: block;
                margin-top: 10px;
            }

            /* Style for the rating stars */
            .rating {
                display: flex;
                flex-direction: row;
                align-items: center;
                justify-content: center;
                font-size: 24px;
            }
            .rating label:before {
                font-family: "Font Awesome 5 Free";
                font-weight: 900;
                content: "\f005";
                margin-right: 5px;
            }
            .rating input {
                display: none;
            }

            .rating label {
                color: #ddd;
                cursor: pointer;
                padding: 5px;
            }
            .rating label:before {
                display: none;
                color: #ddd;
                cursor: pointer;
                padding: 5px;
            }

            .rating label:hover,
            .rating label:hover ~ label,
            .rating input:checked ~ label {
                color: #f1c40f;
            }

            .rating label:before {
                content: "\f005";
                font-family: FontAwesome;
                font-weight: normal;
                font-style: normal;
                margin-right: 5px;
            }

            .rating input:checked ~ label:before {
                content: "\f005";
                font-family: FontAwesome;
                font-weight: normal;
                font-style: normal;
                margin-right: 5px;
            }
            /* Style for the people section */
            .people {
                background-color: #f9f9f9;
                padding: 20px;
                margin-bottom: 20px;
            }

            .people h4 {
                margin-top: 0;
            }

            .people .container {
                display: inline-block;
            }

            .people .container i {
                font-size: 24px;
                color: #f1c40f;
                margin-right: 5px;
            }

            .people .time {
                font-size: 14px;
                color: #999;
                margin-bottom: 10px;
            }

            .people .Evaluate {
                font-size: 16px;
                line-height: 1.5;
                margin-bottom: 10px;
            }

            .people .img {
                margin-top: 10px;
            }

            .people .img img {
                width: 100px;
                height: 100px;
                object-fit: cover;
                border-radius: 5px;
                margin-right: 10px;
                margin-bottom: 10px;
                cursor: pointer;
            }

            .people .img img:last-child {
                margin-right: 0;
            }
            .avatar {
                display: flex;
                align-items: center;
                justify-content: center;
                border-radius: 50%;
                width: 100px;
                height: 100px;
                overflow: hidden; /* để ảnh không bị tràn qua khung */
            }

            .avatar img {
                width: 100%; /* để ảnh vừa đủ tràn khung */
                height: auto;
            }
            #notstar {
                color: #e4e4e4;
            }
        </style>
        <script>
                                            // JavaScript code for file upload preview
                                            const fileInput = document.getElementById('image');
                                            const fileDisplay = document.querySelector('.file-name');
                                            const previewImage = document.getElementById('preview');

                                            fileInput.addEventListener('change', function () {
                                                const file = this.files[0];
                                                const reader = new FileReader();

                                                reader.addEventListener('load', function () {
                                                    previewImage.src = reader.result;
                                                    previewImage.style.display = 'block';
                                                });

                                                if (file) {
                                                    reader.readAsDataURL(file);
                                                    fileDisplay.textContent = file.name;
                                                } else {
                                                    previewImage.src = '';
                                                    previewImage.style.display = 'none';
                                                    fileDisplay.textContent = '';
                                                }
                                            });
        </script>
    </body>
</html>
