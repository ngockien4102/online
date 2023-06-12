/* ========== Products Slider =========== */
const mySwiper = new Swiper(".mySwiper", {
    grabCursor: true,
    slidesPerView: 1,
    spaceBetween: 70,
    autoplay: {
        delay: 5000,
      },
    speed: 800,
    pagination: {
        el: ".custom-pagination",
        clickable: true,
    },
    breakpoints: {
        567: {
            slidesPerView: 2,
        },
        996: {
            slidesPerView: 3,
        },
    },
});

/* ========== Silder swiper =========== */

var swiper = new Swiper(".bg-slider-thumbs", {
    loop: true,
    spaceBetween: 0,
    slidesPerView: 0,
  });
  var swiper2 = new Swiper(".bg-slider", {
    loop: true,
    autoplay: {
      delay: 5000,
    },
    speed: 800,
    spaceBetween: 0,
    thumbs: {
      swiper: swiper,
    },
  });
  