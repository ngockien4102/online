
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--     Fonts and icons     -->
        <title>Online Shop</title>
        <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />
        <!-- plugins:css -->
        <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">

        <link rel="stylesheet" href="assets/css/style.css">
        <!-- ====== Boxicons ====== -->
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container-scroller">
            <!-- partial:partials/_navbar.html -->
            <jsp:include page="headerAdmin.jsp"></jsp:include>
                <!-- partial -->
                <div class="container-fluid page-body-wrapper">
                    <!-- partial:partials/_sidebar.html -->
                <jsp:include page="NavigationAdmin.jsp"></jsp:include>
                    <!-- partial -->
                    <div class="main-panel">
                        <div class="content-wrapper">
                            <div class="page-header">
                                <h3 class="page-title">
                                    <span class="page-title-icon bg-gradient-primary text-white me-2">
                                        <i class="mdi mdi-clipboard-outline"></i>
                                    </span> User List
                                </h3>
                            </div>
                            <div class="row">
                                <div class="container-search col-md-12 grid-margin stretch-card">
                                    <div class="card">
                                        <div class="card-body">
                                            <form action="UserListAdmin" class="filter-shop-OrderSale" method="post">
                                                <div class="item-search">
                                                    <label for="">Gender</label>
                                                    <select name="gender">
                                                        <option value="2">All</option>
                                                        <option value="0">MALE</option>
                                                        <option value="1">FEMALE</option>
                                                    </select>
                                                </div>
                                                <div class="item-search">
                                                    <label for="">Role</label>
                                                    <select name="role">
                                                        <option value="0">All</option>
                                                        <option value="3">USER</option>
                                                        <option value="2">SALESMAN</option>
                                                    </select>
                                                </div>
                                                <div class="item-search">
                                                    <label for="">Status</label>
                                                    <select name="statusP">
                                                        <option value="2">All</option>
                                                        <option value="0">DISABLE</option>
                                                        <option value="1">ACTIVE</option>
                                                    </select>
                                                </div>
                                                <div class="item-search">
                                                    <label for="">Full Name</label>
                                                    <input type="text" name="name">
                                                </div>
                                                <div class="item-search">
                                                    <label for="">Email</label>
                                                    <input type="text" name="email">
                                                </div>
                                                <div class="item-search">
                                                    <label for="">Phone</label>
                                                    <input type="text" name="phone">
                                                </div>
                                                <div class="item-search btn-search">
                                                    <button type="submit">Search</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 grid-margin">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="row d-flex justify-content-between mb-4">
                                                <div class="col-md-6"><h4 class="card-title">User List</h4></div>
                                                <div class="col-md-6 d-flex align-items-end flex-column">
                                                    <a href="AddNewUserAdmin">
                                                        <button type="button" class="btn btn-gradient-success btn-icon-text">
                                                            <i class="mdi mdi-plus-circle-outline"></i> Add new user </button>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="table-responsive table-user-list">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>
                                                                <a href="UserListAdmin?sortOrder=${sort == "Id_asc" ? "Id_desc" : "Id_asc"}">
                                                                ID 
                                                                <i class="${sort == "Id_asc" ? "bx bx-down-arrow-alt" : "bx bx-up-arrow-alt"}" ></i>
                                                            </a>
                                                        </th>
                                                        <th>
                                                            <a href="UserListAdmin?sortOrder=${sort == "name_asc" ? "name_desc" : "name_asc"}">
                                                                Full Name 
                                                                <i class="${sort == "name_asc" ? "bx bx-down-arrow-alt" : "bx bx-up-arrow-alt"}" ></i>
                                                            </a>
                                                        </th>
                                                        <th>
                                                            <a href="UserListAdmin?sortOrder=${sort == "gender_asc" ? "gender_desc" : "gender_asc"}">
                                                                Gender 
                                                                <i class="${sort == "gender_asc" ? "bx bx-down-arrow-alt" : "bx bx-up-arrow-alt"}" ></i>
                                                            </a>
                                                        </th>
                                                        <th>
                                                            <a href="UserListAdmin?sortOrder=${sort == "email_asc" ? "email_desc" : "email_asc"}">
                                                                Email 
                                                                <i class="${sort == "email_asc" ? "bx bx-down-arrow-alt" : "bx bx-up-arrow-alt"}" ></i>
                                                            </a>
                                                        </th>
                                                        <th>
                                                            <a href="UserListAdmin?sortOrder=${sort == "phone_asc" ? "phone_desc" : "phone_asc"}">
                                                                Phone 
                                                                <i class="${sort == "phone_asc" ? "bx bx-down-arrow-alt" : "bx bx-up-arrow-alt"}" ></i>
                                                            </a>
                                                        </th>
                                                        <th>
                                                            <a href="UserListAdmin?sortOrder=${sort == "role_asc" ? "role_desc" : "role_asc"}">
                                                                Role 
                                                                <i class="${sort == "role_asc" ? "bx bx-down-arrow-alt" : "bx bx-up-arrow-alt"}" ></i>
                                                            </a>
                                                        </th>
                                                        <th>
                                                            <a href="UserListAdmin?sortOrder=${sort == "status_asc" ? "status_desc" : "status_asc"}">
                                                                Status 
                                                                <i class="${sort == "status_asc" ? "bx bx-down-arrow-alt" : "bx bx-up-arrow-alt"}" ></i>
                                                            </a>
                                                        </th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${persons}" var="p">
                                                        <tr>
                                                            <td>
                                                                ${p.personId}                                                               
                                                            </td>
                                                            <td>
                                                                <img src="images/${p.img}" class="me-2" alt="image"> ${p.lastName} ${p.firstName}
                                                            </td>
                                                            <td>
                                                                <c:if test="${p.gender == 0}">
                                                                    Male
                                                                </c:if>
                                                                <c:if test="${p.gender == 1}">
                                                                    Female
                                                                </c:if>
                                                            </td>
                                                            <td>
                                                                ${p.email}
                                                            </td>
                                                            <td> 
                                                                ${p.phone}
                                                            </td>
                                                            <td> 
                                                                <c:if test="${p.role == 2}">
                                                                    SALESMAN
                                                                </c:if>
                                                                <c:if test="${p.role == 3}">
                                                                    User
                                                                </c:if>
                                                            </td>
                                                            <td>
                                                                <c:if test="${p.status == 0}">
                                                                    <label class="badge badge-gradient-danger">DISABLE</label>
                                                                </c:if>
                                                                <c:if test="${p.status == 1}">
                                                                    <label class="badge badge-gradient-success">ACTIVE</label>
                                                                </c:if>                                                     
                                                            </td>  
                                                            <td>
                                                                <a href="VewUserDetailAdmin?userId=${p.personId}">
                                                                    <button type="button" class="btn btn-inverse-info btn-icon">
                                                                        <i class="mdi mdi-clipboard-outline"></i>
                                                                    </button>
                                                                </a>
                                                                <a href="EditUserAdmin?userId=${p.personId}">
                                                                    <button type="button" class="btn btn-inverse-dark btn-icon">
                                                                        <i class="mdi mdi-pen"></i>
                                                                    </button>
                                                                </a>                                                         
                                                            </td>
                                                        </tr>
                                                    </c:forEach> 
                                                </tbody>
                                            </table>
                                        </div>
                                        <ul class="listPage">
                                            <c:forEach begin="1" end="${endPageUserList}" var="i">
                                                <li class="${numPage == i ? "active":""}">
                                                    <a 
                                                        href="UserListAdmin?index=${i}&sortOrder=${sort}&gender=${genderU}&role=${roleU}&statusP=${statusU}&name=${name}&email=${email}&phone=${phone}">
                                                        ${i}
                                                    </a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- partial -->
                </div>
                <!-- main-panel ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
       
        <!-- plugins:js -->
        <script src="assets/vendors/js/vendor.bundle.base.js"></script>
        <script src="assets/js/jquery.cookie.js" type="text/javascript"></script>
        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="assets/js/off-canvas.js"></script>
        <script src="assets/js/hoverable-collapse.js"></script>
        <script src="assets/js/misc.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page -->
        <script src="assets/js/dashboard.js"></script>
        <script src="assets/js/todolist.js"></script>
        <!-- End custom js for this page -->
    </body>
</html>
