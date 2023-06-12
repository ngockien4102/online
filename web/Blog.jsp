
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Font awesome icon -->
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
              integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
              crossorigin="anonymous" />
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
            <!-- design -->
            <section class="design" id="design">
                <div class="container">
                    <div class="title">
                        <h2>Latest Blog</h2>
                        <p>recent arts & designs on the blog</p>
                    </div>

                    <div class="design-content">
                        <!-- item -->
                    <c:forEach items="${topblogs}" var="bl">
                        <div class="design-item">
                            <a href="blogDetailsController?bid=${bl.blogId}">
                                <div class="design-img">
                                    <img src="images/${bl.img}" alt="">
                                    <span><i class="far fa-heart"></i> 22</span>
                                    <span>Art & Design</span>

                                </div>
                            </a>
                            <div class="design-title">
                                <a href="blogDetailsController?bid=${bl.blogId}">${bl.title}</a>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- end of item -->
                </div>
            </div>
        </section>
        <!-- end of design -->


        <!-- blog -->
        <section class="blog" id="blog">
            <div class="container">
                <div class="title">
                    <h2>Blog</h2>
                    <p>blogs about art & design</p>
                </div>
                <form class="form-blog" action="BlogController" id="form-blog1">
                    <label for="search">
                        <input type="number" value="${numPage}" name="indexPage" hidden>
                        <input class="input" onchange="changeText()" type="text" name="textSearch" required="" placeholder="Search twitter" id="search">
                        <div class="fancy-bg"></div>
                        <div class="search">
                            <svg viewBox="0 0 24 24" aria-hidden="true" class="r-14j79pv r-4qtqp9 r-yyyyoo r-1xvli5t r-dnmrzs r-4wgw6l r-f727ji r-bnwqim r-1plcrui r-lrvibr">
                            <g>
                            <path d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z"></path>
                            </g>
                            </svg>
                        </div>
                        <button class="close-btn" type="reset">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                            <path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path>
                            </svg>
                        </button>
                    </label>
                </form>
                <div class="blog-content">
                    <!-- item -->
                    <c:forEach items="${blogs}" var="b">
                        <div class="blog-item">
                            <div class="blog-img">
                                <img src="images/${b.img}" alt="">
                                <span><i class="far fa-heart"></i></span>
                            </div>
                            <div class="blog-text">
                                <span>${b.dateSubmit}</span>
                                <h2>${b.title}</h2>
                                <p class="sub-blog-descrip">${b.describes}</p>
                                <a href="blogDetailsController?bid=${b.blogId}">Read More</a>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- end of item -->

                </div>
                <ul class="listPage">
                    <c:forEach begin="1" end="${endPageBlog}" var="i">
                        <li class="${numPage == i ? "active":""}"><a href="BlogController?index=${i}">${i}</a></li>
                        </c:forEach>
                </ul>
            </div>
        </section>
        <!-- end of blog -->

        <!-- about -->
        <section class="about" id="about">
            <div class="container">
                <div class="about-content">
                    <div>
                        <img src="images/slider1.jpg" alt="">
                    </div>
                    <div class="about-text">
                        <div class="title">
                            <h2>Catherine Doe</h2>
                            <p>art & design is my passion</p>
                        </div>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Id totam voluptatem saepe eius ipsum nam
                            provident sapiente, natus et vel eligendi laboriosam odit eos temporibus impedit veritatis ut,
                            illo deserunt illum voluptate quis beatae quod. Necessitatibus provident dicta consectetur
                            labore!</p>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam corrupti natus, eos quia
                            recusandae voluptatem veniam modi officiis minima provident rem sint porro fuga quos tempora ea
                            suscipit vero velit sed laudantium eaque necessitatibus maxime!</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- end of about -->

        <!-- ====== Footer ====== -->
        <jsp:include page="Footer.jsp"></jsp:include>

        <script src="js/app.js"></script>
        <script type="text/javascript">
                            function changeText() {
                                document.getElementById("form-blog1").submit();
                            }
        </script>
    </body>
</html>
