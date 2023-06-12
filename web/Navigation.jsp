<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar">
    <div class="row container d-flex">
        <div class="logo">
            <img src="images/logoShop.png" width="80" height="80" alt="" />
        </div>

        <div class="nav-list nav-collapse d-flex"> 
            <a href="HomePage">Home</a>
            <a href="aboutController">About Us</a>
            <a href="ShopController">Shop</a>
            <a href="BlogController">Blog</a>          
        </div>

        <div class="icons nav-collapse d-flex">  
            <div class="icon d-flex"><i class="bx bx-search"></i></div>
            <a href="CartContact" class="icon d-flex"><i class='bx bx-shopping-bag'></i></a>
            <c:if test="${sessionScope.account != null}">
                <div class="icon profile-dropdown">
                    <img src="images/${sessionScope.customer.img}" class="user-pic" alt="">
                    <div class="sub-menu-wrap" id="subMenu">
                        <div class="sub-menu">
                            <div class="user-info">
                                <img src="images/${sessionScope.customer.img}" alt="">
                                <h3>${sessionScope.customer.firstName} ${sessionScope.customer.lastName}</h3>
                            </div>
                            <hr>

                            <a href="CustomerProfile?accountId=${sessionScope.account.accountId}" class="sub-menu-link">
                                <i class='icon-setting bx bxs-user'></i>
                                <p>Profile</p>
                                <span><i class='bx bx-chevron-right'></i></span>
                            </a>
                            <a href="MyOrder" class="sub-menu-link">
                                <i class='icon-setting bx bxs-cart-alt' ></i>
                                <p>MyOrder</p>
                                <span><i class='bx bx-chevron-right'></i></span>
                            </a>
                            <a href="Logout" class="sub-menu-link">
                                <i class='icon-setting bx bx-log-out'></i>
                                <p>Logout</p>
                                <span><i class='bx bx-chevron-right'></i></span>
                            </a>
                        </div>
                    </div>           
                </div> 
            </c:if>
            <c:if test="${sessionScope.account == null}">
                <a href="Login" class="icon d-flex text-icons">Login</a>
                <a href="register" class="icon d-flex text-icons">Register</a>
            </c:if>
        </div>

        <!-- Hamburger -->
        <div class="hamburger">
            <i class="bx bx-menu-alt-right"></i>
        </div>
    </div>
</nav>