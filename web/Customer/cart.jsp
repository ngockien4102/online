<%-- 
    Document   : cart
    Created on : 31-05-2023, 20:47:31
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
        <!-- ====== Boxicons ====== -->
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet" />
        <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
              integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Online Shop</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>

    <body>
        <!-- ====== Header ====== -->
        <header class="header">
            <!-- ====== Navigation ====== -->
            <jsp:include page="../Navigation.jsp"></jsp:include>

            </header>

            <section class="common-banner-section">
                <div class="container">
                    <h2 class="heading text-left">Shopping Cart</h2>
                    <div class="row collection-content">
                        <div class="col-12  collection-text"></div>
                    </div>
                </div>
            </section>
            <!-- Cart  -->
            <form action="CartContact" method="POST">
                <section id="cart" class="section cart_Shop">
                    <div class="title">
                        <span>COLLECTION</span>
                        <h2>Shopping Cart</h2>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <td>Remove</td>
                                <td>Image</td>
                                <td>Product</td>
                                <td>Price</td>
                                <td>Quantity</td>
                                <td>Subtotal</td>
                            </tr>
                        </thead>
                        <tbody>
                        <c:set var="totalr" value="0"/>
                        <c:forEach items="${Lcart}" var="c">
                            <tr>
                                <td><a href="DeleteOrder?id=${c.orderId}"><i class='bx bx-trash'></i></a></td>
                                <td><img src="images/${c.img1}" alt=""></td>
                                <td><a type="button" class="text-decoration" href="CartDetail?pid=${c.orderId}">${c.nameProduct}</a></td>
                                <td> <c:if test="${c.isOnDiscount == 1}">
                                        $${c.price - (c.price * c.discount)/100}
                                    </c:if>
                                    <c:if test="${c.isOnDiscount == 0}">
                                        $${c.price}
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${c.isOnDiscount == 1}">
                                        <input class="quantity__input" type="number" name="quantity" id="my-inputQuanlity" min="1" value="${c.quantity}"
                                               max="${c.pquantity}" step="1" onchange="updateSubtotal(this, ${c.price - (c.price * c.discount)/100})">
                                    </c:if>
                                    <c:if test="${c.isOnDiscount == 0}">
                                        <input class="quantity__input" type="number" name="quantity" id="my-inputQuanlity" min="1" value="${c.quantity}"
                                               max="${c.pquantity}" step="1" onchange="updateSubtotal(this, ${c.price})">
                                    </c:if>
                                </td>
                                <td>
                                    <input value="${c.orderId}" name="orderId" hidden>
                                    <c:if test="${c.isOnDiscount == 1}">
                                        <c:set var="total" value="${c.quantity * (c.price - (c.price * c.discount)/100)}"/>
                                        <c:set var="totalr" value="${totalr + total}"/>
                                        <strong>$<span class="subtotal" data-price="${(c.price - (c.price * c.discount)/100) * c.quantity}">${total}</span></strong>
                                        </c:if>
                                        <c:if test="${c.isOnDiscount == 0}">
                                            <c:set var="total" value="${c.quantity * c.price}"/>
                                            <c:set var="totalr" value="${totalr + total}"/>
                                        <strong>$<span class="subtotal" data-price="${c.price * c.quantity}">${total}</span></strong>
                                        </c:if>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>

            <section id="cart-add" class="cart_Shop">
                <div class="coupon">
                    <h3>Infor Customer</h3>
                    <table>
                        <tr>
                            <td>Full Name: ${sessionScope.customer.firstName} ${sessionScope.customer.lastName}</td>
                        </tr>
                        <tr>
                            <c:if test="${sessionScope.customer.gender == 0}">
                                <td>Gender: Male</td>
                            </c:if>
                            <c:if test="${sessionScope.customer.gender == 1}">
                                <td>Gender: Female</td>
                            </c:if>
                        </tr>
                        <tr>
                            <td>Email: ${sessionScope.customer.email}</td>
                        </tr>
                        <tr>
                            <td>Phone: ${sessionScope.customer.phone}</td>
                        </tr>
                        <tr>
                            <td>
                                Address:
                                <div>
                                    <textarea name="address" style="background: lightcyan" id="address" type="text" >${a.address}</textarea>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Notes: 
                                <textarea style="background: lightcyan" name="note"></textarea>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="subtotal">
                    <h3>Cart Totals</h3>
                    <table>
                        <tr>
                            <td><strong>Total:</strong></td>
                            <td><strong>$<span id="total-price">${totalr}</span></strong></td>
                        </tr>
                    </table>
                        <button type="submit" class="checkout">Check out</button>

                </div>
            </section>
        </form>
        <!-- ====== Footer ====== -->
        <footer>
            <div class="row">
                <div class="col">
                    <img src="/images/logoShop.png" class="logo" alt="">
                    <p class="des-detail">The best way to find yourself is to lose yourself in the service of others.</p>
                </div>

                <div class="col">
                    <h3>Contact Us <div class="underline"><span></span></div>
                    </h3>
                    <p>9 W 53rd, New York, NY 10519, USA</p>
                    <p class="email-id">jamecolor@gmail.com</p>
                    <h3>+91 212-123-0987</h3>
                </div>
                <div class="col">
                    <h3>Links <div class="underline"><span></span></div>
                    </h3>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Shop</a></li>
                        <li><a href="#">Blog</a></li>
                        <li><a href="#">Gallery</a></li>
                    </ul>
                </div>
                <div class="col">
                    <h3>Newsletter <div class="underline"><span></span></div>
                    </h3>
                    <form>
                        <i class='bx bx-envelope'></i>
                        <input type="email" placeholder="Enter your email" required>
                        <button type="submit"><i class='bx bx-right-arrow-alt'></i></button>
                    </form>
                    <div class="social-icons">
                        <i class="bx bxl-facebook"></i>
                        <i class="bx bxl-twitter"></i>
                        <i class="bx bxl-instagram"></i>
                        <i class="bx bxl-youtube"></i>
                    </div>
                </div>
            </div>
            <hr>
        </footer>
        <!-- ====== SwiperJs ====== -->
        <script src="js/swiper-bundle.min.js"></script>
        <script src="js/app.js"></script>
        <script>
                                                   function updateSubtotal(input, price) {
                                                       const quantity = input.value;
                                                       const subtotal = quantity * price;
                                                       const subtotalElement = input.parentNode.parentNode.querySelector('.subtotal');
                                                       subtotalElement.setAttribute('data-price', subtotal);
                                                       subtotalElement.innerHTML = subtotal;
                                                       updateTotal();
                                                   }

                                                   function updateTotal() {
                                                       const subtotalElements = document.querySelectorAll('.subtotal');
                                                       let total = 0;
                                                       subtotalElements.forEach(element => {
                                                           const subtotal = parseInt(element.getAttribute('data-price'));
                                                           if (!isNaN(subtotal)) {
                                                               total += subtotal;
                                                           }
                                                       });
                                                       document.getElementById('total-price').innerHTML = total;
                                                   }
                                                   const form = document.querySelector('form');
                                                   const nameInput = document.querySelector('#address');

                                                   form.addEventListener('submit', (event) => {
                                                       event.preventDefault();

                                                       const nameValue = nameInput.value.trim();

                                                       if (nameValue === '') {
                                                           alert('Vui lòng nhập địa chỉ của bạn');
                                                       } else {
                                                           alert('Địa chỉ của bạn là: ' + nameValue);
                                                           form.submit();
                                                       }
                                                   })
        </script>
        <style>
            textarea {
                display: block;
                width: 100%;
                height: 100px;
                padding: 10px;
                font-size: 16px;
                line-height: 1.5;
                color: #555;
                border: 1px solid #ccc;
                border-radius: 4px;
                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            }

            textarea:focus {
                outline: none;
                border-color: #007bff;
                box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
            }
            table .text-decoration:hover{
                text-decoration: underline;
            }
        </style>
    </body>

</html>