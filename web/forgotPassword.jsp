
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />
        <link rel="stylesheet" href="css/styles.css">
        <!-- ====== Boxicons ====== -->
        <link href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css" rel="stylesheet" />
        <title>Online Shop</title>
    </head>
    <body>
        <div class="container padding-bottom-3x mb-2 mt-5 box-forgotpass">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-md-10">
                    <div class="forgot">
                        <a class="backhomeForget" href="Login"><i class='bx bx-left-arrow-alt'></i> Back to log in</a>
                    </div>
                    <form class="card mt-4" action="forgotPassword" method="POST" id="form-forgotPass">
                        <div class="subscribe-forgotpass form-group">
                            <p>Forgot your password?</p>
                            <input name="email" type="text" placeholder="Your e-mail" class="subscribe-input" id="email-for-pass">
                            <span class="form-mess" style="color: red;"></span>
                            <br>
                            <button class="submit-btn" type="submit">SEND</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="js/forgotPassjs.js"></script>
        <script>
            Validator({
                form: '#form-forgotPass',
                errorSelector: '.form-mess',
                rules: [
                    Validator.isRequired('#email-for-pass', 'Email cannot be blank'),
                    Validator.isEmail('#email-for-pass'),
                ],
            });
        </script>
    </body>
</html>