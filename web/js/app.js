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
const navList = document.querySelectorAll(".nav-collapse");
if (document.querySelector(".hamburger")) {
    document.querySelector(".hamburger").onclick = () => {
        navList.forEach(col => col.classList.toggle("show"))
        subMenu.classList.remove("open-menu")
    };
}
/* ========== Navigation bar effects on scroll =========== */
if(window){
    window.addEventListener("scroll", function () {
        document.querySelector(".navbar").classList.toggle("sticky", window.scrollY > 0);
    });
}

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

// /* ==========  button quanlity =========== */
const myInput = document.getElementById("my-inputQuanlity");
function stepper(btn){
    let id = btn.getAttribute("id");
    let min = myInput.getAttribute("min");
    let max = myInput.getAttribute("max");
    let step = myInput.getAttribute("step");
    let val = myInput.getAttribute("value");

    let calcStep = (id == "minus") ? (step*-1):(step*1);
    let newValue = parseInt(val) + calcStep;

    if(newValue >= min && newValue <= max){
        myInput.setAttribute("value", newValue);
    }
}
// /* ==========  SubString blog detail =========== */
const subBlogDetails = document.querySelectorAll(".sub-blog-descrip");
if(subBlogDetails){
    subBlogDetails.forEach(b => b.textContent = b.textContent.trim().substring(0,30).concat("..."));
}