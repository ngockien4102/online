<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- plugins:css -->
        <link rel="stylesheet" href="css/materialdesignicons.min.css">
        <link rel="stylesheet" href="css/vendor.bundle.base.css">

        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="container-scroller">
            <!-- partial:partials/_navbar.html -->
            <nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
                <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
                    <a class="navbar-brand brand-logo" href="index.html">
                        <img src="images/logoShop.png" alt="logo" style="height: 100px"/>
                    </a>
                </div>
                <div class="navbar-menu-wrapper d-flex align-items-stretch">
                    <ul class="navbar-nav navbar-nav-right">
                        <li class="nav-item nav-profile dropdown">
                            <c:if test="${sessionScope.account == null}">
                                <a class="nav-link dropdown-toggle" id="profileDropdown" href="Login" data-bs-toggle="dropdown" aria-expanded="false">
                                    <div class="nav-profile-img">
                                        <img src="images/logoShop.png" alt="logo" style="height: 40px"/>
                                        <span class="availability-status online"></span>
                                    </div>
                                    <div class="nav-profile-text">
                                        <p class="mb-1 text-black">Login</p>
                                    </div>
                                </a>
                            </c:if>
                            <c:if test="${sessionScope.account != null}">
                                <a class="nav-link dropdown-toggle" href="ProfileMKT" >
                                    <div class="nav-profile-img">
                                        <img src="images/logoShop.png" alt="logo" style="height: 40px"/>
                                        <span class="availability-status online"></span>
                                    </div>
                                    <div class="nav-profile-text">
                                        <p class="mb-1 text-black">${sessionScope.market.firstName} ${sessionScope.market.lastName}</p>
                                    </div>
                                </a>
                            </c:if>

                        </li>
                    </ul>
                    <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                        <span class="mdi mdi-menu"></span>
                    </button>
                </div>
            </nav>
            <!-- partial -->
            <div class="container-fluid page-body-wrapper">
                <!-- partial:partials/_sidebar.html -->
                <nav class="sidebar sidebar-offcanvas" id="sidebar">
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link" href="DashboardMKT">
                                <span class="menu-title">Dashboard</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Post">
                                <span class="menu-title">POST</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- partial -->

                <div class="main-panel">
                    <form action="DashboardMKT" method="POST">
                        <div class="content-wrapper">
                            <div class="page-header">
                                <h3 class="page-title">
                                    <span class="page-title-icon bg-gradient-primary text-white me-2">
                                        <i class="mdi mdi-home"></i>
                                    </span>
                                    Dashboard
                                </h3>
                                <input type="date" name="date" class="date-input" value="${d}">
                                <button type="submit">Search</button>
                            </div>
                            <div class="row">
                                <div class="col-md-3 stretch-card grid-margin">
                                    <div class="card bg-gradient-danger card-img-holder text-white">
                                        <div class="card-body">
                                            <img src="images/circle.svg" class="card-img-absolute" alt="circle-image" />
                                            <h4 class="font-weight-normal mb-3">CUSTOMER 
                                            </h4>
                                            <h2 class="mb-5">${c.count}</h2>
                                            <h6 class="card-text">Increased by 60%</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 stretch-card grid-margin">
                                    <div class="card bg-gradient-info card-img-holder text-white">
                                        <div class="card-body">
                                            <img src="images/circle.svg" class="card-img-absolute" alt="circle-image" />
                                            <h4 class="font-weight-normal mb-3">PRODUCT 
                                            </h4>
                                            <h2 class="mb-5">${pd.count}</h2>
                                            <h6 class="card-text">Decreased by 10%</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 stretch-card grid-margin">
                                    <div class="card bg-gradient-success card-img-holder text-white">
                                        <div class="card-body">
                                            <img src="images/circle.svg" class="card-img-absolute" alt="circle-image" />
                                            <h4 class="font-weight-normal mb-3">FEEDBACK 
                                            </h4>
                                            <h2 class="mb-5">${fb.count}</h2>
                                            <h6 class="card-text">Increased by 5%</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 stretch-card grid-margin">
                                    <div class="card bg-gradient-success card-img-holder text-white">
                                        <div class="card-body">
                                            <img src="images/circle.svg" class="card-img-absolute" alt="circle-image" />
                                            <h4 class="font-weight-normal mb-3">POSTS 
                                            </h4>
                                            <h2 class="mb-5">${p.count}</h2>
                                            <h6 class="card-text">Increased by 5%</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 grid-margin stretch-card">
                                    <div class="card">
                                        <div class="card-body" style="display: flex; justify-content: center; align-items: center;">
                                            <h4 class="card-title">TRENDING PRODUCT</h4>
                                            <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- content-wrapper ends -->
                        <!-- partial:partials/_footer.html -->
                        <footer class="footer">
                            <div class="container-fluid d-flex justify-content-between">
                                <span class="text-muted d-block text-center text-sm-start d-sm-inline-block">Copyright © bootstrapdash.com 2021</span>
                                <span class="float-none float-sm-end mt-1 mt-sm-0 text-end"> Free <a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Bootstrap admin template</a> from Bootstrapdash.com</span>
                            </div>
                        </footer>
                        <!-- partial -->
                    </form>
                </div>

                <!-- main-panel ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <script src="js/jquery.cookie.js" type="text/javascript"></script>
        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="js/off-canvas.js"></script>
        <script src="js/hoverable-collapse.js"></script>
        <script src="js/misc.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page -->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load("current", {packages: ["corechart"]});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['ProductName', 'Quantity'],
            <c:forEach items="${MKT}" var="m">
                    ['${m.nameProduct}', ${m.count}],
            </c:forEach>
                ]);

                var options = {
                    is3D: true,
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                chart.draw(data, options);
            }
        </script>
        <!-- End custom js for this page -->
        <style>
            .page-header {
                background-color: #f5f5f5;
                padding: 10px;
            }

            .page-title {
                display: flex;
                align-items: center;
            }

            .page-title-icon {
                font-size: 24px;
            }

            .date-input {
                border: 1px solid #ccc;
                border-radius: 4px;
                padding: 6px 10px;
                font-size: 16px;
                margin-left: 10px;
            }

        </style>
    </body>
</html>