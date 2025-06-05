
let button = document.querySelector(".btn");
let modal = document.querySelector(".modal_wrap");
let close = document.querySelector(".close_btn");

button.addEventListener("click", function() {
    modal.classList.toggle("open");
});

close.addEventListener("click", function() {
    modal.classList.toggle("open");
});