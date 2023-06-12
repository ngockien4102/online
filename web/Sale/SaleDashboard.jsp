
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
            <jsp:include page="headerSale.jsp"></jsp:include>
                <!-- partial -->
                <div class="container-fluid page-body-wrapper">
                    <!-- partial:partials/_sidebar.html -->
                <jsp:include page="NavigationSale.jsp"></jsp:include>
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
                            <div class="row">
                                <div class="container-search col-md-12 grid-margin stretch-card">
                                    <div class="card">
                                        <div class="card-body">
                                            <form action="SaleDashboard" class="filter-shop" method="post">
                                                <div class="item-search">
                                                    <label for="">Order Status</label>
                                                    <select name="status">
                                                        <option value="0">All</option>
                                                        <option value="4">DONE</option>
                                                        <option value="3">PROGRESS</option>
                                                        <option value="2">CANCEL</option>
                                                        <option value="1">ON HOLD</option>
                                                    </select>
                                                </div>
                                                <div class="item-search">
                                                    <label for="">Start Date</label>
                                                    <input type="date" name="startD">
                                                </div>
                                                <div class="item-search">
                                                    <label for="">End Date</label>
                                                    <input type="date" name="endD">
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
                                <div class="col-md-12 grid-margin stretch-card">
                                    <div class="card">
                                        <div class="card-body">
                                            <div id="columnchart_material" style="width: 800px; height: 500px;"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12 grid-margin">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Top Selling</h4>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th> STT </th>
                                                            <th> Product Name </th>
                                                            <th> Amount </th>
                                                            <th> Price </th>
                                                            <th> Status </th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:set var="stt" value="0" />
                                                    <c:forEach items="${revenuesTrendses}" var="r">
                                                        <c:set var="stt" value="${stt + 1}"/>
                                                        <tr>
                                                            <td>
                                                                ${stt}
                                                            </td>
                                                            <td>
                                                                <img src="images/${r.img1}" class="me-2" alt="image"> ${r.nameProduct}
                                                            </td>
                                                            <td> 
                                                                ${r.quantity}
                                                            </td>
                                                            <td> 
                                                                $${r.total_cost}
                                                            </td>
                                                            <td>
                                                                <c:if test="${r.status == 1}">
                                                                    <label class="badge badge-gradient-info">ON HOLD</label>
                                                                </c:if>
                                                                <c:if test="${r.status == 2}">
                                                                    <label class="badge badge-gradient-danger">CANCEL</label>
                                                                </c:if>
                                                                <c:if test="${r.status == 3}">
                                                                    <label class="badge badge-gradient-warning">PROGRESS</label>
                                                                </c:if>
                                                                <c:if test="${r.status == 4}">
                                                                    <label class="badge badge-gradient-success">DONE</label>
                                                                </c:if>                                                     
                                                            </td>                                                      
                                                        </tr>
                                                    </c:forEach>                                                
                                                </tbody>
                                            </table>
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
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['bar']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Product Name', 'Revenues'],
            <c:forEach items="${revenuesTrendses}" var="r">
                    ["${r.nameProduct}", ${r.total_cost}],
            </c:forEach>
                ]);

                var options = {
                    chart: {
                        title: 'Revenues of Shop',
                        subtitle: 'Top selling products',
                    }
                };

                var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

                chart.draw(data, google.charts.Bar.convertOptions(options));
            }
        </script>
    </body>
</html>
