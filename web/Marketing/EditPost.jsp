<%-- 
    Document   : ProfileMarket
    Created on : 10-06-2023, 13:39:03
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
        <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />
        <title>Online Shop</title>
        <!-- ====== Boxicons ====== -->
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet" />
        <!-- import font icon (fontawesome) -->
        <script src="https://kit.fontawesome.com/b8b432d7d3.js" crossorigin="anonymous"></script>
        <!-- import css file (style.css) -->
        <link rel="stylesheet" href="css/userProfile.css">
    </head>

    <body>
        <div class="container">

            <div class="profile-card">
                <div class="profile-header"><!-- profile header section -->
                    <a href="DashboardMKT" class="back-button">Online Shop</a>
                    <div class="main-profile">
                        <div class="profile-image"><img src="images/${m.img}" alt=""></div>
                        <div class="profile-names">
                            <h1 class="username">${m.firstName} ${m.lastName}</h1>
                            <small class="page-title">${m.birthdate}</small>
                        </div>
                    </div>
                </div>

                <div class="profile-body"><!-- profile body section -->
                    <div class="profile-actions">
                        <section class="bio">
                            <div class="bio-header">
                                <i class="fa fa-info-circle"></i>
                                Intro
                            </div>
                            <p class="bio-text">
                                Phone: ${m.phone}
                                Address: ${m.address}
                                Gender: 
                                <c:if test="${m.gender == 1}">
                                    FeMale
                                </c:if>
                                <c:if test="${m.gender == 0}">
                                    Male
                                </c:if>
                                CCCD: ${m.cccd}
                            </p>
                        </section>
                        <section class="bio">
                            <div class="bio-header">
                                <i class="fa fa-info-circle"></i>
                                Information
                            </div>
                            <p class="bio-text">
                                <i class='bx bxs-envelope'></i>
                                ${sessionScope.account.email}
                            </p>
                        </section>
                        <section class="bio" style="height: 150px">
                            <div class="bio-header">
                                <i class="fa fa-info-circle"></i>
                                OPTION
                            </div>
                            <ul class="page-list">
                                <li><a href="ProfileMKT?post=${sessionScope.market.marketingId}">POST</a></li>
                                <li><a href="ProfileMKT?slider=${sessionScope.market.marketingId}">SLIDER</a></li>
                            </ul>
                        </section>
                    </div>

                    <div class="card-container">
                        <form action="EditPost" class="card-row" method="POST">
                            <div class="card_picInfo">
                                <img src="images/${p.img}" id="update-img">
                                <div class="round-img">
                                    <input name="img" type="file" id="update-file">
                                    <i class='bx bx-camera'></i>
                                </div>
                            </div>
                            <div class="card_form">
                                <div class="card_header">
                                    <h1>Edit Post</h1>
                                </div>
                                <div class="form_item">
                                    <span class="form_item_icon bx bx-message-square-edit"></span>
                                    <input name="title" type="text" placeholder="Title" value="${p.title}">
                                    <input name="blogId" value="${p.blogId}" hidden>
                                </div>
                                <div class="form_item">
                                    <textarea name="describe" placeholder="Describe" >${p.describes}</textarea>
                                </div>
                                <div class="form_item">
                                    <span class="form_item_icon bx bx-message-square-edit"></span>
                                    <input name="codeproduct" type="text" placeholder="Code Product" value="${p.productId}">
                                </div>
                                <div class="form_item">
                                    <span class="form_item_icon bx bx-message-square-edit"></span>
                                    <input name="discount" type="text" placeholder="Discount" value="${p.discount}">
                                </div>
                                <div class="form_item">
                                    <span class="form_item_icon bx bx-message-square-edit"></span>
                                    <input name="codeslider" type="text" placeholder="Code Slider" value="${p.sliderId}">
                                </div>

                                <div class="btnEdit">
                                    <button>Submit</button>
                                    <a type="button" href="ProfileMKT">ComeBack</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>



    </body>
    <script src="js/app1.js"></script>
    <style>
        .back-button {
            display: inline-block;
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #ccc;
            color: #fff;
            text-decoration: none;
            position: relative;
        }

        .back-button:before {
            content: "\2190"; /* mã Unicode cho biểu tượng mũi tên quay lại */
            font-size: 20px;
            position: absolute;
            left: 10px;
        }
        .page-list {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .page-list li {
            display: inline-block;
        }

        .page-list li a {
            display: block;
            padding: 10px;
            color: #333;
            text-decoration: none;
            font-weight: bold;
        }

        .page-list li a:hover {
            background-color: #eee;
        }
        textarea {
            display: block;
            width: 100%;
            height: 70px;
            padding: 10px;
            font-size: 1rem;
            border: 1px solid #ccc;
            border-radius: 4px;
            transition: border-color 0.3s ease-in-out;
        }

        textarea:focus {
            border-color: #007bff;
            outline: none;
        }
        input[type="text"],
        textarea {
            background-color: #f5f5f5; /* màu nền */
            border: none; /* không có viền */
            border-radius: 5px; /* bo góc */
            padding: 10px; /* đệm bên trong */
            font-size: 16px; /* cỡ chữ */
            color: #333; /* màu chữ */
        }

        input[type="text"]:focus,
        textarea:focus {
            outline: none; /* loại bỏ đường viền khi đang tập trung */
            background-color: #fff; /* thay đổi màu nền khi đang tập trung */
        }
        .btnEdit button, .btnEdit a {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 12px 24px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }

        .btnEdit a {
            background-color: #555;
        }

        .btnEdit button:hover, .btnEdit a:hover {
            opacity: 0.8;
        }
    </style>
</html>