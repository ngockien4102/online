<%-- 
    Document   : ProfileCustomer
    Created on : 29-05-2023, 19:55:22
    Author     : MSII
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>User information</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" type="text/css"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/StyleCustomer.css">
    </head>

    <body>
        <section class="py-5 my-5">
            <div class="container">
                <h1 class="mb-5">Profile</h1>
                <div class="bg-white shadow rounded-lg d-block d-sm-flex">
                    <div class="profile-tab-nav border-right">
                        <div class="p-4">
                            <div class="avatar-wrapper">
                                <img class="profile-pic" src="images/${cus.img}" />
                            </div>
                            <h4 class="text-center">${cus.firstName} ${cus.lastName}</h4>
                        </div>
                        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                            <a class="nav-link active" id="account-tab" data-toggle="pill" href="#account" role="tab"
                               aria-controls="account" aria-selected="true">
                                <i class="fa fa-home text-center mr-1"></i>
                                Account
                            </a>
                            <a class="nav-link" id="password-tab" data-toggle="pill" href="#password" role="tab"
                               aria-controls="password" aria-selected="false">
                                <i class="fa fa-key text-center mr-1"></i>
                                Password
                            </a>
                            <a class="nav-link" id="security-tab" data-toggle="pill" href="#security" role="tab"
                               aria-controls="security" aria-selected="false">
                                <i class="fa fa-user text-center mr-1"></i>
                                Setting Profile
                            </a>
                        </div>
                    </div>
                    <div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
                        <div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
                            <h3 class="mb-4">Profile</h3>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>First Name</label>
                                        <input type="text" class="form-control" value="${cus.firstName}" readonly>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Last Name</label>
                                        <input type="text" class="form-control" value="${cus.lastName}"readonly>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="text" class="form-control" value="${cus.email}"readonly>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Phone number</label>
                                        <input type="text" class="form-control" value="${cus.phone}"readonly>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Birthdate</label>
                                        <input type="text" class="form-control" value="${cus.birthDate}"readonly>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Gender</label>
                                        <c:if test="${cus.gender == 0}">
                                            <input type="text" class="form-control" value="Male"readonly>
                                        </c:if>
                                        <c:if test="${cus.gender == 1}">
                                            <input type="text" class="form-control" value="FeMale"readonly>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <a href="HomePage" class="btn btn-light">Cancel</a>
                            </div>
                        </div>

                        <div class="tab-pane fade" id="password" role="tabpanel" aria-labelledby="password-tab">
                            <form action="ChangePass" method="POST">
                                <h3 class="mb-4">Password Settings</h3>
                                <p style="color: red">${repass}</p>
                                <p style="color: red">${oldPass}</p>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Old password</label>
                                            <input name="oldPass" type="password" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>New password</label>
                                            <input name="newPass" type="password" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Confirm new password</label>
                                            <input name="repass" type="password" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <button class="btn btn-primary">Update</button>
                                    <a href="HomePage" class="btn btn-light">Cancel</a>
                                </div>
                            </form>
                        </div>
                            <div class="tab-pane fade" id="security" role="tabpanel" aria-labelledby="security-tab">
                                <form action="UpdateProfileCustomer" method="Post">
                                <h3 class="mb-4">Profile Settings</h3>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="avatar-wrapper">
                                            <img class="profile-pic" src="images/${cus.img}" />
                                            <div class="upload-button">
                                                <i class="fa fa-arrow-circle-up" aria-hidden="true"></i>
                                            </div>
                                            <input name="img" class="file-upload" type="file" accept="image/*" value="${cus.img}"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input name="fname" type="text" class="form-control" value="${cus.firstName}">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Last Name</label>
                                            <input name="lname" type="text" class="form-control" value="${cus.lastName}">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input type="text" class="form-control" value="${cus.email}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Phone number</label>
                                            <input name="phone" type="number" class="form-control" value="${cus.phone}">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Birthdate</label>
                                            <input name="birthdate" type="date" class="form-control" value="${cus.birthDate}">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Gender</label>
                                            <c:if test="${cus.gender == 0}">
                                                <input type="text" class="form-control" value="Male"readonly>
                                            </c:if>
                                            <c:if test="${cus.gender == 1}">
                                                <input type="text" class="form-control" value="FeMale"readonly>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <button class="btn btn-primary">Update</button>
                                    <button class="btn btn-light">Cancel</button>
                                </div>
                                        </form>
                            </div>
                        <div class="tab-pane fade" id="application" role="tabpanel" aria-labelledby="application-tab">
                            <h3 class="mb-4">Application Settings</h3>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" value="" id="app-check">
                                            <label class="form-check-label" for="app-check">
                                                App check
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" value="" id="defaultCheck2">
                                            <label class="form-check-label" for="defaultCheck2">
                                                Lorem ipsum dolor sit.
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <button class="btn btn-primary">Update</button>
                                <button class="btn btn-light">Cancel</button>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="notification" role="tabpanel" aria-labelledby="notification-tab">
                            <h3 class="mb-4">Notification Settings</h3>
                            <div class="form-group">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="notification1">
                                    <label class="form-check-label" for="notification1">
                                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorum accusantium
                                        accusamus, neque cupiditate quis
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="notification2">
                                    <label class="form-check-label" for="notification2">
                                        hic nesciunt repellat perferendis voluptatum totam porro eligendi.
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="notification3">
                                    <label class="form-check-label" for="notification3">
                                        commodi fugiat molestiae tempora corporis. Sed dignissimos suscipit
                                    </label>
                                </div>
                            </div>
                            <div>
                                <button class="btn btn-primary">Update</button>
                                <button class="btn btn-light">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {

                var readURL = function (input) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            $('.profile-pic').attr('src', e.target.result);
                        }

                        reader.readAsDataURL(input.files[0]);
                    }
                }

                $(".file-upload").on('change', function () {
                    readURL(this);
                });

                $(".upload-button").on('click', function () {
                    $(".file-upload").click();
                });
            });
        </script>
    </body>

</html>