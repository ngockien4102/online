
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
                                </span> Edit User
                            </h3>
                        </div>

                        <div class="row">
                            <div class="col-12 grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <form class="forms-sample" action="EditUserAdmin" method="post">
                                            <input type="text" name="personid" value="${person.personId}" hidden>
                                            <input type="text" name="accountid" value="${person.accountId}" hidden>
                                            <div class="form-group">
                                                <label for="exampleSelectRole">Role</label>
                                                <select class="form-control" id="exampleSelectRole" name="role">
                                                    <option ${person.role == 3 ? 'selected':''} value="3">USER</option>
                                                    <option ${person.role == 2 ? 'selected':''} value="2">SALESMAN</option>
                                                </select>
                                            </div>

                                            <div class="form-group">
                                                <label for="exampleSelectStatus">Status</label>
                                                <select name="status" class="form-control" id="exampleSelectStatus">
                                                    <option ${person.status == 0 ? 'selected':''} value="0">DISABLE</option>
                                                    <option ${person.status == 1 ? 'selected':''} value="1">ACTIVE</option>
                                                </select>
                                            </div>


                                            <button type="submit" class="btn btn-gradient-primary me-2">Submit</button>
                                        </form>
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
