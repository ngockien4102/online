
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
        <title>Online Shop</title>
    </head>

    <body>
        <section>
            <div class="container1">
                <header class="navbar" id="navbar">
                    <a href="#" class="logo">Online Shop</a>
                    <ul>
                        <li>
                            <a href="DashboardMKT">Home</a>
                        </li>
                        <li>
                            <a href="Post" class="active">Post</a>
                        </li>
                        <li><a href="ListCart"><i class="fa fa-shopping-bag"></i> <span></span></a></li>
                    </ul>
                    <span class="menuIcon" onclick="toggleMenu();"></span>

                </header>
            </div>
        </section>
        <div class="container-blog-detail">
            <div class="hero-blog-detail" style="background: url('images/${p.img}') no-repeat center center / cover;"></div>
            <main>
                <h2>${p.title}</h2>
                <div class="profile-container">
                    <div class="profile">
                        <div class="img-container-blog">
                            <img src="images/${p.mimg}" alt="">
                        </div>
                        <div class="author-blog">
                            <h3>${p.firstName} ${p.lastName}</h3>
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
                            <p>${p.dateSubmit}</p>
                        </div>
                    </div>
                </div>
                <div class="content-blog">
                    <a href="SliderDetail?sliderId=${p.sliderId}">${p.stitle}</a>
                    <p>${p.describes}</p>
                </div>
                <c:if test="${p.marketingId == sessionScope.market.marketingId}">
                    <div>
                        <a href="EditPost?blogId=${p.blogId}">Edit</a>
                    </div>
                </c:if>
            </main>
        </div>
        <!-- end -->
        <!-- start -->
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
        <style>.container-blog-detail {
                width: 100%;
                max-width: 117rem;
                margin: 0 auto;
                padding: 20px;
            }

            .hero-blog-detail {
                max-width: 114rem;
                height: 40rem;
                margin: 5rem auto;
            }

            .container-blog-detail main {
                width: 100%;
                max-width: 80rem;
                background-color: var(--white-color);
                margin: 0 auto;
                padding: 3rem;
                border-radius: 1.5rem;
                margin-top: -15rem;
            }

            .container-blog-detail main h2 {
                font-family: var(--Playfair);
                font-size: 3rem;
                font-weight: 600;
                text-transform: uppercase;
                letter-spacing: 5px;
            }

            .container-blog-detail main .profile-container {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin: 3rem 0;
            }

            .container-blog-detail main .profile-container .profile {
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .container-blog-detail main .profile-container .profile .img-container-blog {
                width: 6rem;
                height: 6rem;
            }

            .container-blog-detail main .profile-container .profile .img-container-blog img {
                width: 100%;
                height: 100%;
                object-fit: cover;
                object-position: center;
                border-radius: 0.5rem;
            }

            .container-blog-detail main .profile-container .profile .author-blog {
                margin: 0 1rem;
                color: #5b5963;
                font-size: 1.2rem;
                font-weight: 400;
                letter-spacing: 1px;
            }

            .container-blog-detail main .profile-container .profile .author-blog h3 {
                text-transform: uppercase;
            }

            .container-blog-detail main p {
                color: #5b5963;
                margin: 1rem 0;
            }</style>
    </body>
</html>
