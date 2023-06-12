/* ========== Show and hide password =========== */
let showPassword = document.getElementById('showPassword');
let inputPassword = document.getElementById('inputPassword');
if (showPassword) {
    showPassword.onclick = function () {
        if (inputPassword.type == 'password') {
            inputPassword.type = 'text';
            showPassword.classList.add('show');
        } else {
            inputPassword.type = 'password';
            showPassword.classList.remove('show');
        }
    }
}

const updateImg = document.getElementById("update-img");
const inputFile = document.getElementById("update-file")

if (inputFile) {
    inputFile.addEventListener("change", () => {
        updateImg.src = URL.createObjectURL(inputFile.files[0]);
        console.log(updateImg.src)
    });
}
/* ========== Navigation =========== */
const navList = document.querySelector(".nav-list");
if (document.querySelector(".hamburger")) {
    document.querySelector(".hamburger").onclick = () => {
        navList.classList.add("show");
    };
}
if (document.querySelector(".close")) {
    document.querySelector(".close").onclick = () => {
        navList.classList.remove("show");
    };
}

/* ========== Toggle Edit profile =========== */
const btnProfile = document.querySelector(".editProfile");
const closeProfile = document.querySelector("#modalEditP .close");

if (btnProfile) {
    btnProfile.onclick = () => {
        document.getElementById("modalEditP").classList.add("showModal");
        document.querySelector(".container").classList.add("active");
    };
}

if (closeProfile) {
    closeProfile.onclick = () => {
        document.getElementById("modalEditP").classList.remove("showModal");
        document.querySelector(".container").classList.remove("active");
    };
}
//============
const btnPost = document.getElementById("editPost");
const closePost = document.querySelector("#modalEditPost .close");

if (btnPost) {
    btnPost.onclick = () => {

        document.getElementById("modalEditPost").classList.add("showModal");
        document.querySelector(".container").classList.add("active");
    };
}

if (closePost) {
    closePost.onclick = () => {
        document.getElementById("modalEditPost").classList.remove("showModal");
        document.querySelector(".container").classList.remove("active");
    };
}
//======
const btnSlider = document.getElementById("editSlider");
const closeSlider = document.querySelector("#modalEditSlider .close");

if (btnSlider) {
    btnSlider.onclick = () => {
        document.getElementById("modalEditSlider").classList.add("showModal");
        document.querySelector(".container").classList.add("active");
    };
}

if (closeSlider) {
    closeSlider.onclick = () => {
        document.getElementById("modalEditSlider").classList.remove("showModal");
        document.querySelector(".container").classList.remove("active");
    };
}
/* ========== Products show icons =========== */
let view = document.querySelectorAll('.view');
let buy = document.querySelectorAll('.buy');
let wishlist = document.querySelectorAll('.wishlist');

setContent(view, 'View');
setContent(buy, 'Add to Cart');
setContent(wishlist, 'Save Item');

function setContent(list, text) {
    list.forEach((listItem) => {
        listItem.setAttribute('data-before', text);
    });
}
///* ========== Navigation bar effects on scroll =========== */
//window.addEventListener("scroll", function () {
//    const header = document.querySelector(".navbar");
//    header.classList.toggle("sticky", window.scrollY > 0);
//});

/* ========== Toggle setting user profile =========== */
let subMenu = document.getElementById("subMenu")
const user_pic = document.querySelector(".user-pic")

if (user_pic) {
    user_pic.addEventListener('click', function () {
        subMenu.classList.toggle("open-menu")
    });
}

/* ==========  Toast notification =========== */
// let toast = document.getElementById("toast-success");
// setTimeout(
//     () => toast.remove(), 5000
// )
// let toast_Error = document.getElementById("toast-error");
// setTimeout(
//     () => toast_Error.remove(), 5000
// )