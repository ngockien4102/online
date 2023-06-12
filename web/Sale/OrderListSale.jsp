
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
                                        <i class="mdi mdi-clipboard-outline"></i>
                                    </span> Orders List
                                </h3>
                            </div>
                            <div class="row">
                                <div class="container-search col-md-12 grid-margin stretch-card">
                                    <div class="card">
                                        <div class="card-body">
                                            <form action="OrderListSale" class="filter-shop-OrderSale" method="post">
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
                                                <div class="item-search">
                                                    <label for="">Order ID</label>
                                                    <input type="number" name="oid">
                                                </div>
                                                <div class="item-search">
                                                    <label for="">Customer Name</label>
                                                    <input type="text" name="name">
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
                                        <h4 class="card-title">Order List</h4>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th> ID </th>
                                                        <th> Customer Name </th>
                                                        <th> 
                                                            <a href="OrderListSale?sortOrder=${sort == "orderD_asc" ? "orderD_desc" : "orderD_asc"}">
                                                                Order Date 
                                                                <i class="${sort == "orderD_asc" ? "bx bx-down-arrow-alt" : "bx bx-up-arrow-alt"}" ></i>
                                                            </a>
                                                        </th>
                                                        <th> Product Name </th>
                                                        <th> Amount </th>
                                                        <th> Total Cost </th>
                                                        <th> 
                                                            <a href="OrderListSale?sortOrder=${sort == "status_asc" ? "status_desc" : "status_asc"}">
                                                                Status 
                                                                <i class="${sort == "status_asc" ? "bx bx-down-arrow-alt" : "bx bx-up-arrow-alt"}" ></i>                                                            
                                                            </a> 
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${orderSales}" var="o">
                                                        <tr>
                                                            <td>
                                                                <a href="OrderDetailSale?oid=${o.orderId}">${o.orderId}</a>                                                                
                                                            </td>
                                                            <td>
                                                                ${o.lastName} ${o.firstName}
                                                            </td>
                                                            <td>
                                                                ${o.orderDate}
                                                            </td>
                                                            <td>
                                                                <img src="images/${o.img1}" class="me-2" alt="image"> ${o.nameProduct}
                                                            </td>
                                                            <td> 
                                                                ${o.quantity}
                                                            </td>
                                                            <td> 
                                                                $${o.total_cost}
                                                            </td>
                                                            <td>
                                                                <c:if test="${o.status == 1}">
                                                                    <label class="badge badge-gradient-info">ON HOLD</label>
                                                                </c:if>
                                                                <c:if test="${o.status == 2}">
                                                                    <label class="badge badge-gradient-danger">CANCEL</label>
                                                                </c:if>
                                                                <c:if test="${o.status == 3}">
                                                                    <label class="badge badge-gradient-warning">PROGRESS</label>
                                                                </c:if>
                                                                <c:if test="${o.status == 4}">
                                                                    <label class="badge badge-gradient-success">DONE</label>
                                                                </c:if>                                                     
                                                            </td>                                                      
                                                        </tr>
                                                    </c:forEach> 
                                                </tbody>
                                            </table>
                                        </div>
                                        <ul class="listPage">
                                            <c:forEach begin="1" end="${endPageOrderList}" var="i">
                                                <li class="${numPage == i ? "active":""}">
                                                    <a 
                                                        href="OrderListSale?index=${i}&sortOrder=${sort}&oid=${oidO}&name=${nameO}&status=${statusO}&startD=${startDO}&endD=${endDO}">
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
