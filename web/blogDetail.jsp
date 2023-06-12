
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Font awesome icon -->
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/styles.css">
        <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />

        <title>Online Shop</title>
    </head>
    <body>
        <!-- ====== Header ====== -->
        <header class="header">
            <!-- ====== Navigation ====== -->
            <jsp:include page="Navigation.jsp"></jsp:include>

            </header>
            <!-- ====== Blog Detail ====== -->
            <div class="container-blog-detail">
                <div class="hero-blog-detail" style="background: url('images/${blog.img}') no-repeat center center / cover;"></div>
            <main>
                <h2>${blog.title}</h2>
                <div class="profile-container">
                    <div class="profile">
                        <div class="img-container-blog">
                            <img src="images/${blog.imgMarketing}" alt="">
                        </div>
                        <div class="author-blog">
                            <h3>${blog.lastName} ${blog.firstName}</h3>
                            <p>${blog.dateSubmit}</p>
                        </div>
                    </div>
                </div>
                <div class="content-blog">
                    <p>${blog.describes}</p>
                </div>
            </main>
        </div>
        <!-- ====== Recent Blog ====== -->
        <section class="section blog">
            <div class="title">
                <span>BLOGS</span>
                <h2>Recent News</h2>
            </div>

            <div class="row container">
                <c:forEach items="${topblog}" var="b">
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
        <!-- ====== Js ====== -->
        <script src="js/app.js"></script>
    </body>
</html>
