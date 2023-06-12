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

                    <div class="account-info">
                        <div class="data-to-button">
                            <button class="btn-account-info editProfile" id="editProfile">
                                <i class='bx bx-message-square-edit'></i> 
                                Edit profile
                            </button>
                            <button class="btn-account-info addPost" id="editPost"><i class='bx bx-comment-add'></i> Add to post</button>
                            <button class="btn-account-info" id="editSlider"><i class='bx bx-comment-add'></i> Add to Slider</button>
                        </div>
                        <c:if test="${not empty LPost}">
                            <div class="data">
                                <c:forEach items="${LPost}" var="p">
                                    <div class="post-container">
                                        <div class="user-profile">
                                            <img src="images/${m.img}" class="user-post-pic" alt="">
                                            <div>
                                                <p>${p.firstName} ${p.lastName}</p>
                                                <span>${p.dateSubmit}</span>
                                            </div>
                                        </div>
                                        <p>${p.title}</p>
                                        <p class="post-text">${p.describes}</p>
                                        <img src="images/${p.img}" class="post-img" alt="">
                                        <div>
                                            <a href="EditPost?blogId=${p.blogId}">Edit</a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                        <c:if test="${not empty LSlider}">
                            <div class="data">
                                <c:forEach items="${LSlider}" var="p">
                                    <div class="post-container">
                                        <div class="user-profile">
                                            <img src="images/${m.img}" class="user-post-pic" alt="">
                                            <div>
                                                <p>${p.firstName} ${p.lastName}</p>
                                                <span>${p.startDate} - ${p.endDate}</span>
                                            </div>
                                        </div>
                                        <p>${p.title}</p>
                                        <p class="post-text">${p.describes}</p>
                                        <img src="images/${p.img}" class="post-img" alt="">
                                        <div>
                                            <a href="EditSlider?sliderId=${p.sliderId}">Edit</a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>

        </div>

        <!-- Modal Edit profile-->
        <div id="modalEditP">
            <!-- Modal content-->
            <div class="close">
                <i class="bx bx-x"></i>
            </div>
            <div class="card-container">
                <form action="ProfileMKT" class="card-row" method="POST">
                    <div class="card_picInfo">
                        <img src="images/${m.img}" id="update-img">
                        <div class="round-img">
                            <input name="img" type="file" id="update-file" value="${m.img}">
                            <i class='bx bx-camera'></i>
                        </div>
                    </div>
                    <div class="card_form">
                        <div class="card_header">
                            <h1>Edit profile</h1>
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-user"></span>
                            <input name="firstname" type="text" placeholder="First Name" value="${m.firstName}">
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-user"></span>
                            <input name="lastname" type="text" placeholder="Last Name" value="${m.lastName}">
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-envelope"></span>
                            <input name="address" type="text" placeholder="Last Name" value="${m.address}">
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bxs-phone"></span>
                            <input name="phone" type="text" placeholder="Phone" value="${m.phone}">
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-calendar"></span>
                            <input name="date" type="date" placeholder="dd/mm/yyyy" value="${m.birthdate}">
                        </div>
                        <div class="gender-container">

                            <div><input type="radio" name="size" id="male" value="0" ${m.gender eq 0 ? '' : 'checked'} /> <label for="male">Male</label></div>
                            <div><input type="radio" name="size" id="female" value="1" ${m.gender eq 1 ? 'checked' : ''}/> <label for="female">Female</label></div>
                        </div>

                        <div class="btnEdit"><button>Edit</button></div>
                    </div>
                </form>
            </div>
        </div>
        <div id="modalEditPost">
            <!-- Modal content-->
            <div class="close">
                <i class="bx bx-x"></i>
            </div>
            <div class="card-container">
                <form action="AddPost" class="card-row" method="POST">
                    <div class="card_picInfo">
                        <img src="images/user.jpg" id="update-img">
                        <div class="round-img">
                            <input name="img" type="file" id="update-file">
                            <i class='bx bx-camera'></i>
                        </div>
                    </div>
                    <div class="card_form">
                        <div class="card_header">
                            <h1>Add Post</h1>
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-message-square-edit"></span>
                            <input name="title" type="text" placeholder="Title" ">
                        </div>
                        <div class="form_item">
                            <textarea name="describe" placeholder="Describe" ></textarea>
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-message-square-edit"></span>
                            <input name="codeproduct" type="text" placeholder="Code Product">
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-message-square-edit"></span>
                            <input name="discount" type="text" placeholder="Discount"">
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-message-square-edit"></span>
                            <input name="codeslider" type="text" placeholder="Code Slider" >
                        </div>

                        <div class="btnEdit"><button>Submit</button></div>
                    </div>
                </form>
            </div>
        </div>
        <div id="modalEditSlider">
            <!-- Modal content-->
            <div class="close">
                <i class="bx bx-x"></i>
            </div>
            <div class="card-container">
                <form action="AddPost" class="card-row" method="POST">
                    <div class="card_picInfo">
                        <img src="images/user.jpg" id="update-img">
                        <div class="round-img">
                            <input name="img" type="file" id="update-file">
                            <i class='bx bx-camera'></i>
                        </div>
                    </div>
                    <div class="card_form">
                        <div class="card_header">
                            <h1>Add Post</h1>
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-message-square-edit"></span>
                            <input name="title" type="text" placeholder="Title" ">
                        </div>
                        <div class="form_item">
                            <textarea name="describe" placeholder="Describe" ></textarea>
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-message-square-edit"></span>
                            <input name="codeproduct" type="text" placeholder="Code Product">
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-message-square-edit"></span>
                            <input name="discount" type="text" placeholder="Discount"">
                        </div>
                        <div class="form_item">
                            <span class="form_item_icon bx bx-message-square-edit"></span>
                            <input name="codeslider" type="text" placeholder="Code Slider" >
                        </div>

                        <div class="btnEdit"><button>Submit</button></div>
                    </div>
                </form>
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
    </style>
</html>