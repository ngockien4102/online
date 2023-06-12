
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
                                </span> Add New User
                            </h3>
                        </div>

                        <div class="row">
                            <div class="col-12 grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <form class="forms-sample" action="AddNewUserAdmin" method="post">
                                            <div class="form-group">
                                                <label for="exampleInputEmail3">Email</label>
                                                <input name="email" type="email" class="form-control" id="exampleInputEmail3" placeholder="Email">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleSelectRole">Role</label>
                                                <select class="form-control" id="exampleSelectRole" name="role">
                                                    <option value="3">USER</option>
                                                    <option value="2">SALESMAN</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>Avatar</label>
                                                <input type="file" name="img" class="file-upload-default">
                                                <div class="input-group col-xs-12">
                                                    <input type="text" class="form-control file-upload-info" disabled placeholder="Upload Image">
                                                    <span class="input-group-append">
                                                        <button class="file-upload-browse btn btn-gradient-primary" type="button">Upload</button>
                                                    </span>
                                                </div>
                                            </div>                                        
                                            <div class="form-group">
                                                <label for="exampleInputName1">First Name</label>
                                                <input name="firstName" type="text" class="form-control" id="exampleInputName1" placeholder="First Name">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputName2">Last Name</label>
                                                <input name="lastName" type="text" class="form-control" id="exampleInputName2" placeholder="Last Name">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputBirthDay">BirthDay</label>
                                                <input name="birthDay" type="date" class="form-control" id="exampleInputBirthDay">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputPhone">Phone</label>
                                                <input name="phone" type="text" class="form-control" id="exampleInputPhone" placeholder="Phone">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleTextarea1">Address</label>
                                                <textarea name="address" class="form-control" id="exampleTextarea1" rows="4"></textarea>
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleSelectGender">Gender</label>
                                                <select name="gender" class="form-control" id="exampleSelectGender">
                                                    <option value="0">MALE</option>
                                                    <option value="1">FEMALE</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputStartD">Start Day</label>
                                                <input name="startD" type="date" class="form-control" id="exampleInputStartD">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputEndD">End Day</label>
                                                <input name="endD" type="date" class="form-control" id="exampleInputEndD">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputCCCD">CCCD</label>
                                                <input name="cccd" type="text" class="form-control" id="exampleInputCCCD" placeholder="CCCD">
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
    <script src="assets/js/file-upload.js"></script>
    <!-- Custom js for this page -->
    <script src="assets/js/dashboard.js"></script>
    <script src="assets/js/todolist.js"></script>
    <!-- End custom js for this page -->

</body>
</html>
