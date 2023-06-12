<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Online Shop</title>
        <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />
        <link rel="stylesheet" href="assets/css/orderDetailsale.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="container d-flex justify-content-center mt-50 mb-50">

            <div class="row">

                <div class="col-md-12">

                    <div class="card pagebillC">
                        <div class="card-header bg-transparent header-elements-inline">
                            <a href="#" class="text-headH">
                                <h6 class="card-title">Online Shop Invoice</h6>
                            </a>
                            <div class="header-elements">
                                <button type="button" class="btn btn-light btn-sm ml-3" onclick="window.print()"><i class="fa fa-print mr-2"></i> Print</button>
                            </div>
                        </div>

                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="mb-4 pull-left">
                                        <h6>Invoice From:</h6>
                                        <ul class="list list-unstyled mb-0 text-left">
                                            <li>- ${sessionScope.sale.lastName} ${sessionScope.sale.firstName}</li>
                                            <li>- Email: <a href="#" data-abc="true">${sessionScope.sale.email}</a></li>
                                            <li>- Phone: +${sessionScope.sale.phone}</li>
                                        </ul>
                                    </div>
                                </div>

                                <div class="col-sm-6">
                                    <div class="mb-4 ">
                                        <div class="text-sm-right">
                                            <h4 class="invoice-color mb-2 mt-md-2">Invoice #${orderSale.orderId}</h4>
                                            <ul class="list list-unstyled mb-0">
                                                <li>Date bill: <span class="font-weight-semibold">${orderSale.orderDate}</span></li>
                                                <li>Order Status: 
                                                    <c:if test="${orderSale.status == 1}">
                                                        <span class="font-weight-bold text-primary">ON HOLD</span>
                                                    </c:if>      
                                                    <c:if test="${orderSale.status == 2}">
                                                        <span class="font-weight-bold text-danger">CANCEL</span>
                                                    </c:if>  
                                                    <c:if test="${orderSale.status == 3}">
                                                        <span class="font-weight-bold text-warning">PROGRESS</span>
                                                    </c:if>  
                                                    <c:if test="${orderSale.status == 4}">
                                                        <span class="font-weight-bold text-success">Done</span>
                                                    </c:if>  
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="d-md-flex flex-md-wrap">
                                <div class="mb-4 mb-md-2 text-left">
                                    <span class="text-C">Invoice To:</span>
                                    <ul class="list list-unstyled mb-0">
                                        <li>- ${orderSale.lastName} ${orderSale.firstName}</li>
                                        <li>- Gender: 
                                            <c:if test="${orderSale.gender == 0}">
                                                Male
                                            </c:if>
                                            <c:if test="${orderSale.gender == 1}">
                                                Female
                                            </c:if>
                                        </li>
                                        <li><span class="font-weight-semibold">- ${orderSale.address}</span></li>
                                        <li>- Phone: +${orderSale.phone}</li>
                                        <li>- Email: <a href="#" data-abc="true">${orderSale.email}</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th class="per15 text-center">Product</th>
                                        <th class="per5 text-center">Category</th>
                                        <th class="per25 text-center">Unit Price</th>
                                        <th class="per25 text-center">Quantity</th>
                                        <th class="per25 text-center">Total Cost</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td style="text-align: center;">
                                            <img class="mr-3 img-fluid" src="images/${orderSale.img1}" width="100">
                                            <p class="m-0 text-muted" style="padding-top: 15px;">
                                                ${orderSale.nameProduct}
                                            </p>

                                        </td>
                                        <td class="text-center">${orderSale.nameCategory}</td>
                                        <td class="text-center">$${orderSale.price}</td>
                                        <td class="text-center">${orderSale.quantity}</td>
                                        <td class="text-center">$${orderSale.total_cost}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <div class="card-body">
                            <div class="d-md-flex flex-md-wrap">


                                <div class="pt-2 mb-3 wmin-md-400 ml-auto">                                    
                                    <div class="text-right mt-3 footer-bill">

                                        <button class="btn btn-gray-800 mt-2 animate-up-2" type="button" id="modalOpenOrderS">Edit</button>                                

                                        <a href="OrderListSale" class="btn btn-gray-800 mt-2 animate-up-2 btncancel">Back to home</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Edit-->
            <div class="col-12 grid-margin stretch-card" id="modalEditSale">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Edit Order Status</h4>
                        <form class="forms-sample" action="OrderDetailSale" method="post">
                            <input type="number" value="${orderSale.orderId}" name="orderId" hidden>
                            <div class="form-group">
                                <label for="exampleSelectGender">Status</label>
                                <select class="form-control" id="exampleSelectGender" name="status">
                                    <option ${orderSale.status == 1 ? 'selected':''} value="1">ON HOLD</option>
                                    <option ${orderSale.status == 2 ? 'selected':''} value="2">CANCEL</option>
                                    <option ${orderSale.status == 3 ? 'selected':''} value="3">PROGRESS</option>
                                    <option ${orderSale.status == 4 ? 'selected':''} value="4">DONE</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="exampleTextarea1">Note</label>
                                <textarea name="noteOrder" class="form-control" id="exampleTextarea1" rows="4">${orderSale.notes}</textarea>
                            </div>
                            <button type="submit" class="btn btn-gradient-primary me-2">Edit</button>
                            <button type="button" class="btn btn-light" id="modalCloseOrderS">Close</button>
                        </form>
                    </div>
                </div>
            </div>
    </body>
    <script src="assets/js/modalForm.js"></script>
</html>