
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
        <link rel="stylesheet" type="text/css" href="css/StyleCustomer.css">
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
                                        <i class="mdi mdi-home"></i>
                                    </span> User Detail
                                </h3>
                            </div>

                            <div class="row">
                                <div class="col-12 grid-margin">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="avatar-wrapper">
                                                        <img class="profile-pic" src="images/${person.img}" />
                                                    <div class="upload-button">
                                                        <i class="fa fa-arrow-circle-up" aria-hidden="true"></i>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>First Name</label>
                                                    <input type="text" class="form-control" value="${person.firstName}" readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Last Name</label>
                                                    <input type="text" class="form-control" value="${person.lastName}" readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Gender</label>
                                                    <c:if test="${person.gender == 0}">
                                                        <input type="text" class="form-control" value="Male"readonly>
                                                    </c:if>
                                                    <c:if test="${person.gender == 1}">
                                                        <input type="text" class="form-control" value="Female"readonly>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Email</label>
                                                    <input type="text" class="form-control" value="${person.email}" readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Phone number</label>
                                                    <input type="number" class="form-control" value="${person.phone}" readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Role</label>
                                                    <c:if test="${person.role == 3}">
                                                        <input type="text" class="form-control" value="USER"readonly>
                                                    </c:if>
                                                    <c:if test="${person.role == 2}">
                                                        <input type="text" class="form-control" value="SALESMAN"readonly>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Address</label>
                                                    <input type="text" class="form-control" value="${person.address}" readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Status</label>
                                                    <c:if test="${person.status == 0}">
                                                        <input type="text" class="form-control" value="DISABLE"readonly>
                                                    </c:if>
                                                    <c:if test="${person.status == 1}">
                                                        <input type="text" class="form-control" value="ACTIVE"readonly>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <div class="col-md-12 d-flex justify-content-center mt-5">
                                                <a href="EditUserAdmin?userId=${person.personId}"><button type="button" class="btn btn-gradient-primary btn-fw">Edit</button></a>
                                                <a href="AddNewUserAdmin"><button type="button" class="btn btn-gradient-success btn-fw">Add</button></a>
                                            </div>
                                        </div>
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
