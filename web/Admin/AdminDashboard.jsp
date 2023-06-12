
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
                                    </span> Dashboard
                                </h3>
                            </div>
                            <div class="row d-flex justify-content-center">
                                <div class="col-md-5 stretch-card grid-margin">
                                    <div class="card bg-gradient-danger card-img-holder text-white">
                                        <div class="card-body">
                                            <img src="assets/images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image" />
                                            <h4 class="font-weight-normal mb-3">Newly Registered <i class="mdi mdi-chart-line mdi-24px float-right"></i>
                                            </h4>
                                            <h2 class="mb-5">${newRegistered}</h2>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-5 stretch-card grid-margin">
                                <div class="card bg-gradient-info card-img-holder text-white">
                                    <div class="card-body">
                                        <img src="assets/images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image" />
                                        <h4 class="font-weight-normal mb-3">Newly Bought <i class="mdi mdi-bookmark-outline mdi-24px float-right"></i>
                                        </h4>
                                        <h2 class="mb-5">${newBought}</h2>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="container-search col-md-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <form action="dashboard" class="filter-shop" method="post">
                                            <div class="item-search">
                                                <label for="">Start Date</label>
                                                <input type="date" name="startD">
                                            </div>
                                            <div class="item-search">
                                                <label for="">End Date</label>
                                                <input type="date" name="endD">
                                            </div>
                                            <div class="item-search"></div>
                                            <div class="item-search btn-search">
                                                <button type="submit">Search</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="clearfix">
                                            <h4 class="card-title float-left">Revenues by product categories</h4>
                                            <div id="visit-sale-chart-legend" class="rounded-legend legend-horizontal legend-top-right float-right"></div>
                                        </div>
                                        <div id="columnchart_material" style="width: 800px; height: 500px;"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Amount order follow date</h4>
                                        <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Average star of feedbacks follow date</h4>
                                        <div id="donutchart" style="width: 900px; height: 500px;"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Top most ordered products</h4>
                                        <div id="chart_div" style="width: 900px; height: 500px;"></div>
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
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load("current", {packages: ["corechart"]});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Status', 'Amount of status'],
            <c:forEach items="${orderAmount}" var="o">
                    ['${o.status_Order}', ${o.count}],
            </c:forEach>
                ]);

                var options = {
                    is3D: true,
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load("current", {packages: ["corechart"]});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Task', 'Hours per Day'],
            <c:forEach items="${aveStar}" var="ave">
                    ['${ave.nameCategory}', ${ave.averageRankStar}],
            </c:forEach>

                ]);

                var options = {
                    pieHole: 0.4,
                };

                var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['bar']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Product Name', 'Revenues'],
            <c:forEach items="${RproductCategories}" var="r">
                    ['${r.nameCategory}', ${r.total_cost}],
            </c:forEach>
                ]);

                var options = {
                };

                var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

                chart.draw(data, google.charts.Bar.convertOptions(options));
            }
        </script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawVisualization);

            function drawVisualization() {
                // Some raw data (not necessarily accurate)
                var data = google.visualization.arrayToDataTable([
                    ['Name Product', 'Amount'],
            <c:forEach items="${topOrder}" var="top">
                    ['${top.nameProduct}', ${top.count}],
            </c:forEach>
                ]);

                var options = {
                    vAxis: {title: 'Amount'},
                    hAxis: {title: 'Product Name'},
                    seriesType: 'bars',
                    series: {5: {type: 'line'}}
                };

                var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
                chart.draw(data, options);
            }
        </script>
    </body>
</html>
