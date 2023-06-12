
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!--        <link rel="stylesheet" href="style.css">-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
              integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="css/marketing.css">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="css/userProfile.css">
        <title>SHOP ONLINE</title>
    </head>

    <body>
        <section>
            <div class="bannerVideo" id="slideshow">
                <img src="images/logoShop.png" alt="">
                <h2>Online Shop</h2>
            </div>
            <div class="container1">
                <header class="navbar" id="navbar">
                    <a href="#" class="logo">Online Shop</a>
                    <ul>
                        <li>
                            <a href="DashboardMKT">Home</a>
                        </li>
                        <li>
                            <a href="Post" class="">Post</a>
                        </li>
                        <li><a href="Slider" class="active">Slider</a></li>
                    </ul>
                    <span class="menuIcon" onclick="toggleMenu();"></span>

                </header>
            </div>
        </section>
        <div class="product-list container">
            <div class="row">

                <div class="col-12 col-sm-12 col-md-9 col-lg-9 col-xl-9 product-left1">
                    <h5></h5>
                    <div class="product-left container">
                        <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12" >
                            <div class="data">
                                <c:forEach items="${LSlider}" var="p">
                                    <div class="post-container">
                                        <div class="user-profile">
                                            <img src="images/${p.mimg}" class="user-post-pic" alt="">
                                            <div>
                                                <p>${p.firstName} ${p.lastName}</p>
                                                <span>${p.startDate} - ${p.endDate}</span>
                                                <c:if test="${p.statu == 1}">
                                                    <div class="status">
                                                        <span class="status-icon online"></span>
                                                        <span class="status-text">Online</span>
                                                    </div>
                                                </c:if>
                                                <c:if test="${p.statu == 0}">
                                                    <div class="status">
                                                        <span class="status-icon offline"></span>
                                                        <span class="status-text">Offline</span>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                        <p>${p.title}</p>
                                        <p class="post-text">${p.describes}</p>
                                        <img src="images/${p.img}" class="post-img" alt="">
                                        <c:if test="${p.marketingId == sessionScope.market.marketingId}">
                                            <div>
                                                <a href="SliderDetail?sliderId=${p.sliderId}">View</a>
                                                <a>Edit</a>
                                            </div>
                                        </c:if>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 product-list-right">
                    <form action="SelectOtherSlider" method="POST">
                        <div class="input-group col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                            <div class="form-outline">
                                <input name="title" type="text" id="form1" class="form-control" placeholder="search" />
                            </div>
                            <button type="submit" class="btn btn-primary">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                    </form>
                    <div class="product-categories">
                        <h1>Author</h1>
                        <ul class="list-group">
                            <c:forEach items="${Author}" var="c">
                                <li class="list-group-item text-white"><a href="SelectOtherSlider?Aname=${c.marketingId}">${c.firstName} ${c.lastName}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                    <div class="product-categories">
                        <h1>Status</h1>
                        <ul class="list-group">
                            <li class="list-group-item text-white"><a href="SelectOtherSlider?status=1">Activate</a></li>
                            <li class="list-group-item text-white"><a href="SelectOtherSlider?status=0">Expired</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <footer class=" text-lg-start bg-light text-muted">
            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 footer-texts-1">
                <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 footer-texts">
                    <h2>ABOUT THE SHOP</h2>
                    <p>Lorem ipsum dolor sit amet, conse ctetur adipisicing elit, sed do eiusmod mas.</p>
                </div>
                <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 footer-texts">
                    <h2>SUBSCRIBE TO VULADY_TECHNOLOGY</h2>
                </div>
                <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 footer-texts-2">
                    <h2>SHOP SYSTEM</h2>
                    <h5><i class="far fa-calendar-alt"></i>  ĐÀ NẴNG</h5>
                    <h5><i class="far fa-calendar-alt"></i>  HÀ NỘI</h5>
                    <h5><i class="far fa-calendar-alt"></i>  HỒ CHÍ MINH</h5>
                </div>
                <div class="col-12 col-sm-12 col-md-3 col-lg-3 col-xl-3 footer-texts">
                    <h2>INSTAGRAM FEED</h2>
                </div>
            </div>
            <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                © 2023 Copyright:
                <a class="text-white" href="https://fptshop.com.vn/">ONLINESHOP.COM</a>
            </div>
        </footer>
        <div class="login">
            <c:if test="${sessionScope.account != null}">
                <a class="nav-link" href="ProfileMKT" style="background: graytext">${sessionScope.market.firstName} ${sessionScope.market.lastName}</a>
                <a class="nav-link" href="Logout" style="background: graytext">Logout</a>
            </c:if>
            <c:if test="${sessionScope.account == null}">
                <a class="nav-link" href="Login" style="background: graytext">Login</a>
            </c:if>
        </div>
        <script>
            window.addEventListener("scroll", function () {
                var header = this.document.querySelector('header');
                header.classList.toggle('sticky', window.scrollY > 0);
            });
            function toggleMenu() {
                const menuIcon = document.querySelector('.menuIcon');
                const navbar = document.getElementById('navbar');
                menuIcon.classList.toggle('active');
                navbar.classList.toggle('active');
            }
        </script>
        <style>
            .status {
                display: inline-flex;
                align-items: center;
                padding: 5px;
                border-radius: 5px;
                background-color: #e6e6e6;
                font-size: 14px;
                color: #5a5a5a;
            }

            .status-icon {
                display: inline-block;
                width: 10px;
                height: 10px;
                border-radius: 50%;
                margin-right: 5px;
            }

            .status-icon.online {
                background-color: #00cc00;
            }

            .status-icon.offline {
                background-color: #ff0000;
            }

            .status-text {
                display: none;
            }
        </style>
    </body>
</html>
