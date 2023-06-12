
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- ====== Favicon ====== -->
        <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />
        <link rel="stylesheet" type="text/css"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/StyleCustomer.css">
        <title>Online Shop</title>
    </head>

    <body>
        <form action="register" method="Post">
            <section class="py-5 my-5">
                <div class="container">
                    <h1 class="mb-5">Sign Up</h1>
                    <p style="color: red">${repass}</p>
                    <div class="bg-white shadow rounded-lg d-block d-sm-flex">
                        <div class="profile-tab-nav border-right">
                            <div class="p-4">
                                <div class="avatar-wrapper">
                                    <img class="profile-pic" src="" />
                                </div>
                            </div>
                        </div>
                        <div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
                            <div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
                                <h3 class="mb-4">Sign Up</h3>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input name="email" type="text" class="form-control" placeholder="Email">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input name="pass" type="password" class="form-control" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Re-Password</label>
                                            <input name="repass" type="password" class="form-control" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input name="fname" type="text" class="form-control" placeholder="First Name">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Last Name</label>
                                            <input name="lname" type="text" class="form-control" placeholder="Last Name">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Phone number</label>
                                            <input name="phone" type="number" class="form-control" placeholder="Phone number">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Birthdate</label>
                                            <input name="birthdate" type="date" class="form-control" placeholder="Birthdate">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Gender</label>
                                            <select name="gender" class="form-control">
                                                <option value="0">Male</option>
                                                <option value="1">FaMale</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <button class="btn btn-primary">Save</button>
                                    <a href="HomePage" class="btn btn-light">Cancel</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

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
