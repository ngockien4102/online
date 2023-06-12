

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- ====== Favicon ====== -->
    <link rel="shortcut icon" href="images/logoShop.png" type="image/png" />
    <link rel="stylesheet" href="css/logincss.css">
    <title>Online Shop</title>
</head>

<body>

    <div class="login">
        <div class="title">
            <img src="images/logoShop.png" alt="">
        </div>
        <div class="des">
            Sign In
        </div>
        <form action="Login" method="Post">
            <p style="color: red">${mess}</p>
            <p style="color: red">${messRegist}</p>
        <div class="group">
            <input name="email" type="text" placeholder="Email">
        </div>
        <div class="group">
            <input name="pass" type="password" id="inputPassword" placeholder="Password">
            <span id="showPassword">
                <ion-icon name="eye-outline"></ion-icon>
                <ion-icon name="eye-off-outline"></ion-icon>
            </span>
        </div>
        <div class="recovery">
            <a href="forgotPassword">Recovery password</a>
        </div>
        <div class="signIn">
            <button name="submit">Sign In</button>
        </div>
        <div class="or">
            Or continue with
        </div>
        </form>
        <div class="list">
            <div class="item">
                <img src="https://cdn1.iconfinder.com/data/icons/google-s-logo/150/Google_Icons-09-512.png" alt="">
            </div>
            <div class="item">
                <img src="https://museumandgallery.org/wp-content/uploads/2020/03/Facebook-Icon-Facebook-Logo-Social-Media-Fb-Logo-Facebook-Logo-PNG-and-Vector-with-Transparent-Background-for-Free-Download.png"
                    alt="">
            </div>
            <div class="item">
                <img src="https://www.iconpacks.net/icons/2/free-twitter-logo-icon-2429-thumb.png" alt="">
            </div>
        </div>
        <div class="register">
            Not a member? <a href="register">Register now</a>
        </div>

    </div>

    <script src="js/app.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>

</html>
