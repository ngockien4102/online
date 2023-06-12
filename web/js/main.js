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